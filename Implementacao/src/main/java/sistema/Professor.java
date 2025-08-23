package sistema;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private String titulacao;
    private List<Disciplina> disciplinasLecionadas;
    
    public Professor(String login, String senha, String nome, String email, String titulacao) {
        super(login, senha, nome, email);
        this.titulacao = titulacao;
        this.disciplinasLecionadas = new ArrayList<>();
    }
    
    public List<Aluno> consultarAlunosMatriculados(Disciplina disciplina) {
        return new ArrayList<>();
    }
    
    public List<Disciplina> visualizarDisciplinasLecionadas() {
        return new ArrayList<>(disciplinasLecionadas);
    }
    
    public void adicionarDisciplinaLecionada(Disciplina disciplina) {
        if (disciplina != null && !disciplinasLecionadas.contains(disciplina)) {
            disciplinasLecionadas.add(disciplina);
        }
    }
    
    public void removerDisciplinaLecionada(Disciplina disciplina) {
        disciplinasLecionadas.remove(disciplina);
    }
    
    public String getTitulacao() {
        return titulacao;
    }
    
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    public List<Disciplina> getDisciplinasLecionadas() {
        return new ArrayList<>(disciplinasLecionadas);
    }
    
    @Override
    public String toString() {
        return "Professor{" +
                "titulacao='" + titulacao + '\'' +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", disciplinasLecionadas=" + disciplinasLecionadas.size() +
                '}';
    }
}
