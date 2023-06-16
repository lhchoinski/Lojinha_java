package com.luiz.modelos;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "alcoolica")
public class Alcoolica extends Produto {
    
    protected int percentAlcool;


     public Alcoolica(){

    }

    public Alcoolica(String nomeProduto, int litros, int percentAlcool, int preco) {
        super(nomeProduto, litros,preco);
        this.percentAlcool = percentAlcool;
    }

    public int getPercentAlcool() {
        return percentAlcool;
    }

    public void setPercentAlcool(int percentAlcool) {
        this.percentAlcool = percentAlcool;
    }

    @Override
    public String toString() {
        return "Alcoolica [percentAlcool=" + percentAlcool + "]";
    }

    public void setComprador(Cliente c1) {
    }

    
    
    
}

