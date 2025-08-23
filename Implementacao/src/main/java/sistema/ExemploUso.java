package sistema;

import java.util.Date;
import java.util.List;

public class ExemploUso {
    
    public static void main(String[] args) {
        System.out.println("=== Sistema de Matrículas Universitário ===\n");
        
        SistemaMatriculas sistema = new SistemaMatriculas();
        
        Curso cursoEngenharia = new Curso("Engenharia de Software", 240);
        sistema.adicionarCurso(cursoEngenharia);
        System.out.println("✅ Curso criado: " + cursoEngenharia.getNome());
        
        Disciplina disciplinaPOO = new Disciplina("POO001", "Programação Orientada a Objetos", 4, cursoEngenharia);
        Disciplina disciplinaBD = new Disciplina("BD001", "Banco de Dados", 4, cursoEngenharia);
        Disciplina disciplinaES = new Disciplina("ES001", "Engenharia de Software", 4, cursoEngenharia);
        
        sistema.adicionarDisciplina(disciplinaPOO);
        sistema.adicionarDisciplina(disciplinaBD);
        sistema.adicionarDisciplina(disciplinaES);
        
        System.out.println("✅ Disciplinas criadas:");
        System.out.println("   - " + disciplinaPOO.getNome() + " (" + disciplinaPOO.getCodigo() + ")");
        System.out.println("   - " + disciplinaBD.getNome() + " (" + disciplinaBD.getCodigo() + ")");
        System.out.println("   - " + disciplinaES.getNome() + " (" + disciplinaES.getCodigo() + ")");
        
        Professor professorJoao = new Professor("joao.prof", "senha123", "João Silva", "joao@universidade.edu", "Doutor");
        sistema.adicionarUsuario(professorJoao);
        
        disciplinaPOO.setProfessor(professorJoao);
        disciplinaBD.setProfessor(professorJoao);
        professorJoao.adicionarDisciplinaLecionada(disciplinaPOO);
        professorJoao.adicionarDisciplinaLecionada(disciplinaBD);
        
        System.out.println("✅ Professor criado: " + professorJoao.getNome() + " (" + professorJoao.getTitulacao() + ")");
        
        Aluno alunoMaria = new Aluno("maria.aluno", "senha456", "Maria Santos", "maria@email.com", "2023001", cursoEngenharia);
        Aluno alunoPedro = new Aluno("pedro.aluno", "senha789", "Pedro Costa", "pedro@email.com", "2023002", cursoEngenharia);
        Aluno alunoAna = new Aluno("ana.aluno", "senha012", "Ana Oliveira", "ana@email.com", "2023003", cursoEngenharia);
        
        sistema.adicionarUsuario(alunoMaria);
        sistema.adicionarUsuario(alunoPedro);
        sistema.adicionarUsuario(alunoAna);
        
        cursoEngenharia.adicionarAluno(alunoMaria);
        cursoEngenharia.adicionarAluno(alunoPedro);
        cursoEngenharia.adicionarAluno(alunoAna);
        
        System.out.println("✅ Alunos criados:");
        System.out.println("   - " + alunoMaria.getNome() + " (Matrícula: " + alunoMaria.getMatricula() + ")");
        System.out.println("   - " + alunoPedro.getNome() + " (Matrícula: " + alunoPedro.getMatricula() + ")");
        System.out.println("   - " + alunoAna.getNome() + " (Matrícula: " + alunoAna.getMatricula() + ")");
        
        Date dataInicio = new Date();
        Date dataFim = new Date(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000));
        PeriodoMatriculas periodo = new PeriodoMatriculas(dataInicio, dataFim);
        periodo.ativar();
        sistema.definirPeriodoMatriculas(periodo);
        
        System.out.println("✅ Período de matrículas criado e ativado");
        
        disciplinaPOO.ativar();
        disciplinaBD.ativar();
        disciplinaES.ativar();
        
        System.out.println("✅ Disciplinas ativadas para matrícula");
        
        System.out.println("\n=== Demonstração de Funcionalidades (Stubs) ===");
        
        Usuario usuarioLogado = sistema.validarCredenciais("maria.aluno", "senha456");
        if (usuarioLogado != null) {
            System.out.println("✅ Login realizado com sucesso: " + usuarioLogado.getNome());
        } else {
            System.out.println("❌ Falha no login (método ainda não implementado)");
        }
        
        boolean periodoAtivo = sistema.validarPeriodoMatriculas();
        System.out.println("📅 Período de matrículas ativo: " + periodoAtivo);
        
        System.out.println("📊 Capacidade das disciplinas:");
        System.out.println("   - " + disciplinaPOO.getNome() + ": " + disciplinaPOO.getNumeroAlunos() + "/" + disciplinaPOO.getMaxAlunos() + " alunos");
        System.out.println("   - " + disciplinaBD.getNome() + ": " + disciplinaBD.getNumeroAlunos() + "/" + disciplinaBD.getMaxAlunos() + " alunos");
        System.out.println("   - " + disciplinaES.getNome() + ": " + disciplinaES.getNumeroAlunos() + "/" + disciplinaES.getMaxAlunos() + " alunos");
        
        System.out.println("📈 Verificação de mínimo de alunos:");
        System.out.println("   - " + disciplinaPOO.getNome() + " atende mínimo: " + disciplinaPOO.verificarMinimoAlunos());
        System.out.println("   - " + disciplinaBD.getNome() + " atende mínimo: " + disciplinaBD.verificarMinimoAlunos());
        System.out.println("   - " + disciplinaES.getNome() + " atende mínimo: " + disciplinaES.verificarMinimoAlunos());
        
        System.out.println("\n=== Resumo do Sistema ===");
        System.out.println("👥 Total de usuários: " + sistema.getUsuarios().size());
        System.out.println("📚 Total de cursos: " + sistema.getCursos().size());
        System.out.println("📖 Total de disciplinas: " + sistema.getDisciplinas().size());
        System.out.println("🎓 Alunos no curso de Engenharia: " + cursoEngenharia.getAlunos().size());
        
        System.out.println("\n=== Próximos Passos ===");
        System.out.println("Para completar o sistema, implemente os métodos marcados com TODO:");
        System.out.println("1. Lógica de validação de credenciais");
        System.out.println("2. Lógica de matrícula e cancelamento");
        System.out.println("3. Lógica de verificação de limites");
        System.out.println("4. Interface de usuário");
        System.out.println("5. Persistência de dados");
        
        System.out.println("\n🎉 Sistema de Matrículas - Estrutura Base Criada com Sucesso!");
    }
}
