package entities;

public class Sala {
    private String nome;
    private Integer capacidade;
    private boolean status;
    
    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.status = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sala [nome=" + nome + ", capacidade=" + capacidade + "]";
    }

}
