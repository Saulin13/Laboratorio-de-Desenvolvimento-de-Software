package sistema;

import java.util.List;

public class SistemaCobrancas {
    
    public SistemaCobrancas() {
    }
    
    public void receberNotificacaoMatricula(Matricula matricula) {
        if (matricula != null && matricula.isAtiva()) {
            gerarCobranca(matricula.getAluno(), java.util.Arrays.asList(matricula.getDisciplina()));
        }
    }
    
    public void gerarCobranca(Aluno aluno, List<Disciplina> disciplinas) {
        if (aluno != null && disciplinas != null && !disciplinas.isEmpty()) {
        }
    }
    
    public boolean processarPagamento(Aluno aluno, double valor) {
        return false;
    }
    
    public double consultarDebitos(Aluno aluno) {
        return 0.0;
    }
}
