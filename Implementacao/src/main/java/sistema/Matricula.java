package sistema;

import java.util.Date;

public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private TipoMatricula tipo;
    private Date dataMatricula;
    private boolean ativa;
    
    public Matricula(Aluno aluno, Disciplina disciplina, TipoMatricula tipo) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.tipo = tipo;
        this.dataMatricula = new Date();
        this.ativa = true;
    }
    
    public void cancelar() {
        this.ativa = false;
    }
    
    public boolean isAtiva() {
        return ativa;
    }
    
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public TipoMatricula getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoMatricula tipo) {
        this.tipo = tipo;
    }
    
    public Date getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    @Override
    public String toString() {
        return "Matricula{" +
                "aluno=" + (aluno != null ? aluno.getNome() : "null") +
                ", disciplina=" + (disciplina != null ? disciplina.getNome() : "null") +
                ", tipo=" + tipo +
                ", dataMatricula=" + dataMatricula +
                ", ativa=" + ativa +
                '}';
    }
}
