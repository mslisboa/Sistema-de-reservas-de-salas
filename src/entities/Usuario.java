package entities;

public class Usuario {
    private static Integer nextId = 1; // // Variável estática para controle do próximo ID
    private String nome;
    private Integer id;
    
    public Usuario(String nome) {
        this.nome = nome;
        this.id = nextId++;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", id=" + id + "]";
    }
}
