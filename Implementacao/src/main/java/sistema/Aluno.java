package sistema;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private Curso curso;
    private List<Matricula> matriculas;
    private int creditosCursados;
    
    public Aluno(String login, String senha, String nome, String email, String matricula, Curso curso) {
        super(login, senha, nome, email);
        this.matricula = matricula;
        this.curso = curso;
        this.matriculas = new ArrayList<>();
        this.creditosCursados = 0;
    }
    
    public boolean realizarMatricula(Disciplina disciplina, TipoMatricula tipo) {
        if (disciplina != null && !jaMatriculado(disciplina)) {
            Matricula novaMatricula = new Matricula(this, disciplina, tipo);
            matriculas.add(novaMatricula);
            return true;
        }
        return false;
    }
    
    public boolean cancelarMatricula(Disciplina disciplina) {
        for (Matricula matricula : matriculas) {
            if (matricula.getDisciplina().equals(disciplina) && matricula.isAtiva()) {
                matricula.cancelar();
                return true;
            }
        }
        return false;
    }
    
    public List<Matricula> consultarMatriculas() {
        List<Matricula> matriculasAtivas = new ArrayList<>();
        for (Matricula matricula : matriculas) {
            if (matricula.isAtiva()) {
                matriculasAtivas.add(matricula);
            }
        }
        return matriculasAtivas;
    }
    
    public boolean jaMatriculado(Disciplina disciplina) {
        for (Matricula matricula : matriculas) {
            if (matricula.getDisciplina().equals(disciplina) && matricula.isAtiva()) {
                return true;
            }
        }
        return false;
    }
    
    public int contarMatriculasPorTipo(TipoMatricula tipo) {
        int count = 0;
        for (Matricula matricula : matriculas) {
            if (matricula.getTipo() == tipo && matricula.isAtiva()) {
                count++;
            }
        }
        return count;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<Matricula> getMatriculas() {
        return new ArrayList<>(matriculas);
    }
    
    public int getCreditosCursados() {
        return creditosCursados;
    }
    
    public void setCreditosCursados(int creditosCursados) {
        this.creditosCursados = creditosCursados;
    }
    
    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + getNome() + '\'' +
                ", curso=" + (curso != null ? curso.getNome() : "null") +
                ", matriculas=" + consultarMatriculas().size() +
                ", creditosCursados=" + creditosCursados +
                '}';
    }
}
