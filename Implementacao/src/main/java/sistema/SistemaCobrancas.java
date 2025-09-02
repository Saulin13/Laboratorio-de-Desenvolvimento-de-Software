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
        double valorTotal = 0.0;
        for (Disciplina d : disciplinas) {
            valorTotal += d.getCreditos() * 150.0; 
        }
        System.out.println("Cobrança gerada para " + aluno.getNome() + ": R$" + valorTotal);
    }
    
    
    public boolean processarPagamento(Aluno aluno, double valor) {
        return false;
    }
    
    public double consultarDebitos(Aluno aluno) {
        return 0.0;
    }
}
