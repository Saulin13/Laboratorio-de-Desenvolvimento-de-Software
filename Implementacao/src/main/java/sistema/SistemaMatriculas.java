package sistema;

import java.util.ArrayList;
import java.util.List;

public class SistemaMatriculas {
    private List<Usuario> usuarios;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private PeriodoMatriculas periodoAtual;
    private SistemaCobrancas sistemaCobrancas;
    
    public SistemaMatriculas() {
        this.usuarios = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.sistemaCobrancas = new SistemaCobrancas();
    }
    
    public Usuario validarCredenciais(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.fazerLogin(login, senha)) {
                return usuario;
            }
        }
        return null;
    }
    
    
    public boolean validarPeriodoMatriculas() {
        if (periodoAtual == null) {
            return false;
        }
        return periodoAtual.verificarPeriodoAtivo();
    }
    
    public void notificarCobrancas(Matricula matricula) {
        if (matricula != null && matricula.isAtiva()) {
            sistemaCobrancas.receberNotificacaoMatricula(matricula);
        }
    }
    
    public boolean verificarCapacidadeTurma(Disciplina disciplina) {
        if (disciplina != null) {
            return disciplina.verificarCapacidade();
        }
        return false;
    }
    
    public boolean verificarMinimoAlunos(Disciplina disciplina) {
        if (disciplina != null) {
            return disciplina.verificarMinimoAlunos();
        }
        return false;
    }
    
    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }
    
    public void adicionarCurso(Curso curso) {
        if (curso != null && !cursos.contains(curso)) {
            cursos.add(curso);
        }
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }
    
    public void definirPeriodoMatriculas(PeriodoMatriculas periodo) {
        this.periodoAtual = periodo;
    }
    
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
    
    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }
    
    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas);
    }
    
    public PeriodoMatriculas getPeriodoAtual() {
        return periodoAtual;
    }
    
    public SistemaCobrancas getSistemaCobrancas() {
        return sistemaCobrancas;
    }
    
    public Usuario buscarUsuarioPorLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }
    
    public Curso buscarCursoPorNome(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) {
                return curso;
            }
        }
        return null;
    }
    
    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    public void finalizarPeriodoMatriculas() {
        if (periodoAtual == null) return;
        for (Disciplina d : disciplinas) {
            if (!d.verificarMinimoAlunos()) {
                d.setAtiva(false);
                System.out.println("Disciplina cancelada: " + d.getNome());
            }
        }
        periodoAtual.desativar();
        System.out.println("Período de matrículas finalizado.");
    }
    
}
