package com.luiz.modelos;


import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pedido")
public class Pedido {
 
    protected Produto nomeProduto;
    protected Cliente nome;
    public Pedido(Produto nomeProduto, Cliente nome) {
        this.nomeProduto = nomeProduto;
        this.nome = nome;
    }
    public Produto getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(Produto nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Cliente getNome() {
        return nome;
    }
    public void setNome(Cliente nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Pedido [nomeProduto=" + nomeProduto + ", nome=" + nome + "]";
    }

    

}
