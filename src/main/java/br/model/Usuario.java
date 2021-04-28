package br.model;

public class Usuario {
    private Integer id;
    private String email;
    private String senha;
    private Filme filme;

    public Usuario() {
    }

    public Usuario(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.filme = filme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", filme=" + filme +
                '}';
    }
}
