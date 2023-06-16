package com.luiz.modelos;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto")
public class Produto {


    // Declaração dos atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    protected Long id;
    
    protected String nomeProduto;

    protected int litros;

    protected int preco;
    
    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Produto comprador;

    // Construtor vazio
    public Produto(){

    }

    public Produto(String nomeProduto, int litros, int preco) {
        this.nomeProduto = nomeProduto;
        this.litros = litros;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

     public Produto getComprador() {
        return comprador;
    }

    public void setComprador(Produto comprador) {
        this.comprador = comprador;
    }

      public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }


    @Override
    public String toString() {
        return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", litros=" + litros + "]";
    }


    
}
