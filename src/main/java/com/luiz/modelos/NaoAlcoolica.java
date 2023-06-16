package com.luiz.modelos;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "NaoAlcoolica")
public class NaoAlcoolica extends Produto{

    protected String sabor;


     public NaoAlcoolica(){

    }

    public NaoAlcoolica(String nomeProduto, int litros, String sabor, int preco) {
        super(nomeProduto, litros,preco);
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "NaoAlcoolica [sabor=" + sabor + "]";
    }

    public void setComprador(Cliente c2) {
    }
    
    
}
