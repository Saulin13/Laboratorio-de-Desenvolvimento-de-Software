package sistema;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private int creditos;
    private Professor professor;
    private Curso curso;
    private boolean ativa;
    private int maxAlunos;
    private List<Matricula> matriculas;
    
    public Disciplina(String codigo, String nome, int creditos, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.creditos = creditos;
        this.curso = curso;
        this.ativa = false;
        this.maxAlunos = 60;
        this.matriculas = new ArrayList<>();
    }
    
    public boolean adicionarMatricula(Matricula matricula) {
        if (matricula != null && !matriculas.contains(matricula) && verificarCapacidade()) {
            matriculas.add(matricula);
            return true;
        }
        return false;
    }
    
    public void removerMatricula(Matricula matricula) {
        matriculas.remove(matricula);
    }
    
    public boolean verificarCapacidade() {
        return matriculas.size() < maxAlunos;
    }
    
    public boolean verificarMinimoAlunos() {
        return matriculas.stream().filter(Matricula::isAtiva).count() >= 3;
    }
    
    
    public void ativar() {
        this.ativa = true;
    }
    
    public void desativar() {
        this.ativa = false;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getCreditos() {
        return creditos;
    }
    
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public boolean isAtiva() {
        return ativa;
    }
    
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
    public int getMaxAlunos() {
        return maxAlunos;
    }
    
    public void setMaxAlunos(int maxAlunos) {
        this.maxAlunos = maxAlunos;
    }
    
    public List<Matricula> getMatriculas() {
        return new ArrayList<>(matriculas);
    }
    
    public int getNumeroAlunos() {
        return matriculas.size();
    }
    
    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", creditos=" + creditos +
                ", ativa=" + ativa +
                ", alunos=" + matriculas.size() + "/" + maxAlunos +
                '}';
    }
}
