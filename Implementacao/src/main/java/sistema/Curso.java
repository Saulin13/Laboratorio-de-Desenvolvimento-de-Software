package sistema;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private int creditos;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;
    
    public Curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinas = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }
    
    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }
    
    public void adicionarAluno(Aluno aluno) {
        if (aluno != null && !alunos.contains(aluno)) {
            alunos.add(aluno);
        }
    }
    
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
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
    
    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas);
    }
    
    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }
    
    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", creditos=" + creditos +
                ", disciplinas=" + disciplinas.size() +
                ", alunos=" + alunos.size() +
                '}';
    }
}
