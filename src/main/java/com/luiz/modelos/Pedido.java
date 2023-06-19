package com.luiz.modelos;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nomeProduto;

    protected String nomeCliente;

    protected String nomeFuncionario;

    public Pedido() {
        // Construtor padrão exigido pelo Hibernate
    }

    public Pedido(String nomeProduto, String nomeCliente, String nomeFuncionario) {
        this.nomeProduto = nomeProduto;
        this.nomeCliente = nomeCliente;
        this.nomeFuncionario = nomeFuncionario;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String novoProduto) {
        this.nomeProduto = novoProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String novoCliente) {
        this.nomeCliente = novoCliente;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", nomeProduto=" + nomeProduto + ", nomeCliente=" + nomeCliente + "]";
    }
}
