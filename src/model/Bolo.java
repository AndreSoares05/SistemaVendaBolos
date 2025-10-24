
package model;


public class Bolo {
    private String id;
    private String nome;
    private double preco;
    private int quantidade;

    public Bolo(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return "Bolo{id='" + id + "', nome='" + nome + "', preco=" + preco + ", quantidade=" + quantidade + "}";
    }
}