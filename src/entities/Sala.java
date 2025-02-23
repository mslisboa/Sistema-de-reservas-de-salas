package entities;

public class Sala {
    private String nome;
    private Integer capacidade;
    
    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala [nome=" + nome + ", capacidade=" + capacidade + "]";
    }

}
