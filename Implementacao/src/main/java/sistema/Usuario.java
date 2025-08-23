package sistema;

import java.util.Objects;

public abstract class Usuario {
    private String login;
    private String senha;
    private String nome;
    private String email;
    
    public Usuario(String login, String senha, String nome, String email) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }
    
    public boolean fazerLogin(String login, String senha) {
        return false;
    }
    
    public void alterarSenha(String novaSenha) {
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(login, usuario.login);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
