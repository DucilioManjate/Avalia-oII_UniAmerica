package br.model;

public class Filme {
    private Integer id;
    private String nome;
    private int duracao;
    private Genero genero;

    public Filme() {
    }

    public Filme(Integer id, String nome, int duracao, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", genero=" + genero +
                '}';
    }
}
