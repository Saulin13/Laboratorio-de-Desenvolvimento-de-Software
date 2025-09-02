package sistema;

import java.util.*;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaMatriculas sistema = new SistemaMatriculas();

        carregarUsuarios(sistema);
        carregarDisciplinas(sistema);
        carregarMatriculas(sistema);

        // Restaurar período do arquivo (se existir)
        PeriodoMatriculas periodoRestaurado = Banco.carregarPeriodo("periodo.txt");
        if (periodoRestaurado != null) {
            sistema.definirPeriodoMatriculas(periodoRestaurado);
            System.out.println("Período restaurado de arquivo: " + periodoRestaurado);
        }

        System.out.println("\n=== Sistema de Matrículas ===");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = sistema.validarCredenciais(login, senha);

        if (usuario == null) {
            System.out.println("❌ Login inválido!");
            salvarTudo(sistema);
            return;
        }

        if (usuario instanceof Aluno) {
            Aluno aluno = (Aluno) usuario;
            menuAluno(sc, aluno, sistema);

        } else if (usuario instanceof Professor) {
            Professor professor = (Professor) usuario;
            menuProfessor(sc, professor, sistema);

        } else if (usuario instanceof Secretaria) {
            Secretaria secretaria = (Secretaria) usuario;
            menuSecretaria(sc, secretaria, sistema);
        }

        salvarTudo(sistema);
    }

    // ================= MENUS =================

    private static void menuAluno(Scanner sc, Aluno aluno, SistemaMatriculas sistema) {
        while (true) {
            System.out.println("\n=== MENU ALUNO ===");
            System.out.println("1 - Listar disciplinas");
            System.out.println("2 - Matricular-se");
            System.out.println("3 - Cancelar matrícula");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: {
                    for (Disciplina d : sistema.getDisciplinas()) {
                        System.out.println(d);
                    }
                }
                case 2: {
                    if (!sistema.validarPeriodoMatriculas()) {
                        System.out.println("Período de matrículas fechado.");
                        break;
                    }

                    System.out.print("Código da disciplina: ");
                    String cod = sc.nextLine().trim();
                    Disciplina d = sistema.buscarDisciplinaPorCodigo(cod);
                    if (d == null) {
                        System.out.println("Disciplina não encontrada.");
                        break;
                    }

                    System.out.print("Tipo [1=OBRIGATORIA, 2=OPTATIVA]: ");
                    String t = sc.nextLine().trim();
                    TipoMatricula tipo = "2".equals(t) ? TipoMatricula.OPTATIVA : TipoMatricula.OBRIGATORIA;

                    boolean ok = aluno.realizarMatricula(d, tipo);
                    if (ok) {
                        Matricula recem = null;
                        for (Matricula m : aluno.getMatriculas()) {
                            if (m.getDisciplina().equals(d) && m.isAtiva() && m.getTipo() == tipo) {
                                recem = m;
                                break;
                            }
                        }
                        if (recem != null) {
                            sistema.notificarCobrancas(recem);
                        }
                        System.out.println("Matrícula feita!");
                    } else {
                        System.out.println("Falhou (limites, capacidade ou período).");
                    }
                }
                case 3: {
                    System.out.print("Código da disciplina: ");
                    String cod = sc.nextLine();
                    Disciplina d = sistema.buscarDisciplinaPorCodigo(cod);
                    if (d != null) {
                        boolean ok = aluno.cancelarMatricula(d);
                        System.out.println(ok ? "Cancelado!" : "Não encontrado.");
                    }
                }
                case 0: {
                    return;
                }
            }
        }
    }

    private static void menuProfessor(Scanner sc, Professor professor, SistemaMatriculas sistema) {
        while (true) {
            System.out.println("\n=== MENU PROFESSOR ===");
            System.out.println("1 - Minhas disciplinas e alunos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(sc.nextLine());

            if (opcao == 1) {
                for (Disciplina d : sistema.getDisciplinas()) {
                    if (d.getProfessor() != null &&
                            d.getProfessor().getLogin() != null &&
                            d.getProfessor().getLogin().equalsIgnoreCase(professor.getLogin())) {

                        System.out.println("\n" + d.getNome());

                        List<Aluno> alunos = professor.consultarAlunosMatriculados(d);
                        if (alunos.isEmpty()) {
                            System.out.println("(sem alunos)");
                        } else {
                            for (Aluno a : alunos) {
                                System.out.println("- " + a.getNome());
                            }
                        }
                    }
                }
            } else if (opcao == 0) {
                return;
            }
        }
    }

    private static void menuSecretaria(Scanner sc, Secretaria secretaria, SistemaMatriculas sistema) {
        while (true) {
            System.out.println("\n=== MENU SECRETARIA ===");
            System.out.println("1 - Criar & abrir período de matrículas");
            System.out.println("2 - Fechar período de matrículas");
            System.out.println("3 - Finalizar período (ativa >=3, cancela demais)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: {
                    System.out.print("Dias até INÍCIO (ex 0): ");
                    int di = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Dias até FIM (ex 7): ");
                    int df = Integer.parseInt(sc.nextLine().trim());
                    Date inicio = new Date(System.currentTimeMillis() + di * 86400000L);
                    Date fim = new Date(System.currentTimeMillis() + df * 86400000L);
                    PeriodoMatriculas p = new PeriodoMatriculas(inicio, fim);
                    sistema.definirPeriodoMatriculas(p);
                    p.ativar();
                    System.out.println("Período criado e ABERTO: " + p);
                    Banco.salvarPeriodo(p, "periodo.txt");
                    break;
                }
                case 2: {
                    if (sistema.getPeriodoAtual() != null) {
                        sistema.getPeriodoAtual().desativar();
                        System.out.println("Matrículas FECHADAS.");
                        Banco.salvarPeriodo(sistema.getPeriodoAtual(), "periodo.txt");
                    } else {
                        System.out.println("Nenhum período definido.");
                    }
                    break;
                }
                case 3: {
                    sistema.finalizarPeriodoMatriculas();
                    PeriodoMatriculas pa = sistema.getPeriodoAtual();
                    if (pa != null) {
                        pa.desativar();
                        Banco.salvarPeriodo(pa, "periodo.txt");
                    }
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Opção inválida.");
                }
            }
        }
    }

    // ================= CARREGAR DADOS =================

    private static void carregarUsuarios(SistemaMatriculas sistema) {
        List<String> linhas = Banco.carregarTxt("usuarios.txt");
        for (String linha : linhas) {
            String[] p = linha.split(";");
            if (p.length >= 5) {
                String tipo = p[0];
                String login = p[1], senha = p[2], nome = p[3], email = p[4];
                if (tipo.equals("ALUNO")) {
                    sistema.adicionarUsuario(new Aluno(login, senha, nome, email, "MATRICULA", null));
                } else if (tipo.equals("PROF")) {
                    sistema.adicionarUsuario(new Professor(login, senha, nome, email, "TITULACAO"));
                } else if (tipo.equals("SEC")) {
                    sistema.adicionarUsuario(new Secretaria(login, senha, nome, email, "DEP"));
                }
            }
        }
    }

    private static void carregarDisciplinas(SistemaMatriculas sistema) {
        List<String> linhas = Banco.carregarTxt("disciplinas.txt");
        for (String linha : linhas) {
            String[] p = linha.split(";");
            if (p.length >= 4) {
                String codigo = p[0], nome = p[1];
                int creditos = Integer.parseInt(p[2]);
                String profLogin = p[3];
                Disciplina d = new Disciplina(codigo, nome, creditos, null);
                if (!profLogin.isEmpty()) {
                    Professor prof = (Professor) sistema.buscarUsuarioPorLogin(profLogin);
                    d.setProfessor(prof);
                }
                sistema.adicionarDisciplina(d);
            }
        }
    }

    private static void carregarMatriculas(SistemaMatriculas sistema) {
        List<String> linhas = Banco.carregarTxt("matriculas.txt");
        for (String linha : linhas) {
            String[] p = linha.split(";");
            if (p.length >= 4) {
                String alunoLogin = p[0].trim();
                String discCodigo = p[1].trim();
                String tipo = p[2].trim();
                boolean ativa = Boolean.parseBoolean(p[3].trim());

                Aluno aluno = (Aluno) sistema.buscarUsuarioPorLogin(alunoLogin);
                Disciplina disc = sistema.buscarDisciplinaPorCodigo(discCodigo);
                if (aluno != null && disc != null) {
                    TipoMatricula t = "OPTATIVA".equalsIgnoreCase(tipo) ? TipoMatricula.OPTATIVA
                            : TipoMatricula.OBRIGATORIA;
                    Matricula m = new Matricula(aluno, disc, t);
                    m.setAtiva(ativa);

                    aluno.getMatriculas().add(m);
                    disc.getMatriculas().add(m);
                }
            }
        }
    }

    // ================= SALVAR DADOS =================

    private static void salvarTudo(SistemaMatriculas sistema) {
        // Usuários
        List<String> usuariosTxt = new ArrayList<>();
        for (Usuario u : sistema.getUsuarios()) {
            String tipo = (u instanceof Aluno) ? "ALUNO" : (u instanceof Professor) ? "PROF" : "SEC";
            usuariosTxt.add(tipo + ";" + u.getLogin() + ";" + u.getSenha() + ";" + u.getNome() + ";" + u.getEmail());
        }
        Banco.salvarTxt(usuariosTxt, "usuarios.txt");

        // Disciplinas
        List<String> disciplinasTxt = new ArrayList<>();
        for (Disciplina d : sistema.getDisciplinas()) {
            String profLogin = (d.getProfessor() != null) ? d.getProfessor().getLogin() : "";
            disciplinasTxt.add(d.getCodigo() + ";" + d.getNome() + ";" + d.getCreditos() + ";" + profLogin);
        }
        Banco.salvarTxt(disciplinasTxt, "disciplinas.txt");

        // Matrículas
        List<String> matriculasTxt = new ArrayList<>();
        for (Usuario u : sistema.getUsuarios()) {
            if (u instanceof Aluno) {
                Aluno aluno = (Aluno) u;
                for (Matricula m : aluno.getMatriculas()) {
                    matriculasTxt.add(
                            aluno.getLogin() + ";" +
                                    m.getDisciplina().getCodigo() + ";" +
                                    m.getTipo() + ";" +
                                    m.isAtiva());
                }
            }
        }
        Banco.salvarTxt(matriculasTxt, "matriculas.txt");
    }
}
