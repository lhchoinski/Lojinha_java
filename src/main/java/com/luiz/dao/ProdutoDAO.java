package com.luiz.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.luiz.modelos.Produto;

import java.util.List;

public class ProdutoDAO {
    private EntityManagerFactory emf;

    public ProdutoDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarProduto(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    public Produto buscarProdutoPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    public List<Produto> buscarTodosProdutos() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p");
        List<Produto> produtos = query.getResultList();
        em.close();
        return produtos;
    }

    public List<Produto> buscarTodasAlcoolicas(){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.condicao = 'alcoolica'");
        List<Produto> produtos = query.getResultList();
        em.close();
        return produtos;
    }

    public List<Produto> buscarTodasNaoAlcoolicas(){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.condicao = 'NaoAlcoolica'");
        List<Produto> produtos = query.getResultList();
        em.close();
        return produtos;
    }

    public void atualizarProduto(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirProduto(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        produto = em.merge(produto);
        em.remove(produto);
        em.getTransaction().commit();
        em.close();
    }
}
