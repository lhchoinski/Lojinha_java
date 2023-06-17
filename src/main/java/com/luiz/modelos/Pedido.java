package com.luiz.modelos;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    protected Produto nomeProduto;

    @ManyToOne
    protected Cliente nome;

    @ManyToOne
    protected Funcionario nomeFuncionario;

    protected Pedido() {
        // Construtor padrão exigido pelo Hibernate
    }

    public Pedido(Produto nomeProduto, Cliente nome, Funcionario nomeFuncionario) {
        this.nomeProduto = nomeProduto;
        this.nome = nome;
        this.nomeFuncionario = nomeFuncionario;
    }

    public Long getId() {
        return id;
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

     public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(Funcionario nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", nomeProduto=" + nomeProduto + ", nome=" + nome + "]";
    }

}
