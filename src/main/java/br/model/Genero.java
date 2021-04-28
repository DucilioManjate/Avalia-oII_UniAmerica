package br.model;

public class Genero {
    private Integer id;
    private String nome;

    public Genero() {
    }

    public Genero(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
