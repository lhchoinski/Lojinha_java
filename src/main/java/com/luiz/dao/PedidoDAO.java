package com.luiz.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.luiz.modelos.Pedido;

import java.util.List;

public class PedidoDAO {
    private EntityManagerFactory emf;

    public PedidoDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void adicionarPedido(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public Pedido buscarPedidoPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Pedido pedido = em.find(Pedido.class, id);
        em.close();
        return pedido;
    }

    public List<Pedido> buscarTodosPedidos() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Pedido p");
        List<Pedido> pedidos = query.getResultList();
        em.close();
        return pedidos;
    }

    public void atualizarPedido(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirPedido(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        pedido = em.merge(pedido);
        em.remove(pedido);
        em.getTransaction().commit();
        em.close();
    }
}
