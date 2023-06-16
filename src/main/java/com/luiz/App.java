package com.luiz;

import java.util.ArrayList;
import java.util.Scanner;

import com.luiz.dao.ClienteDAO;  //alterar o caminho
import com.luiz.dao.ProdutoDAO; //alterar o caminho
import com.luiz.modelos.*; //Alterar o caminho da importação

public class App 
{
    public static void main( String[] args )
    {
       
        // Instanciação dos objetos DAO
        ClienteDAO cDao = new ClienteDAO();
        ProdutoDAO pDao = new ProdutoDAO();

        // Instanciar pessoas
         Cliente c1 = new Cliente("Luiz", 20);
         Cliente c2 = new Cliente("Valentina", 17);
         Cliente c3 = new Cliente("Mariana", 35);

         // Salva os objetos no banco
         cDao.salvarCliente(c1);
         cDao.salvarCliente(c2);
         cDao.salvarCliente(c3);

          // // Instanciar carros
        Alcoolica a1 = new Alcoolica("jackdaniels", 1, 40, 200);
        NaoAlcoolica na2 = new NaoAlcoolica("Tang", 2, "Uva", 15);

        // Observe que a1 e a2 são os adultos que foram criados nesta execução e foram salvos 
        // no banco. Caso não tivessem sido salvos, não seria possível salvar o carro pois
        // o ID do dono não estaria disponível.
        
        a1.setComprador(c1); 
        na2.setComprador(c2); 

        // Salva os objetos no banco
        pDao.salvarProduto(a1);
        pDao.salvarProduto(na2);
    }
}
