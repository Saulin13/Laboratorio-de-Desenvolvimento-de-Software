package sistema;

import java.util.Date;

public class Secretaria extends Usuario {
    private String departamento;
    
    public Secretaria(String login, String senha, String nome, String email, String departamento) {
        super(login, senha, nome, email);
        this.departamento = departamento;
    }
    
    public void gerenciarCursos() {
    }
    
    public void gerenciarDisciplinas() {
    }
    
    public void gerenciarAlunos() {
    }
    
    public void gerenciarProfessores() {
    }
    
    public void definirPeriodoMatriculas(Date dataInicio, Date dataFim) {
    }
    
    public void gerarCurriculoSemestre() {
    }
    
    public void ativarDesativarDisciplina(Disciplina disciplina, boolean ativa) {
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        return "Secretaria{" +
                "departamento='" + departamento + '\'' +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
