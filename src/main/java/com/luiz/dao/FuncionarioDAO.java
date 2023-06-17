package com.luiz.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.luiz.modelos.Funcionario;

import java.util.List;

public class FuncionarioDAO {
    private EntityManagerFactory emf;

    public FuncionarioDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarFuncionario(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    public List<Funcionario> buscarTodosFuncionario() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT f FROM Funcionario f");
        List<Funcionario> funcionarios = query.getResultList();
        em.close();
        return funcionarios;
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirFuncionario(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        funcionario = em.merge(funcionario);
        em.remove(funcionario);
        em.getTransaction().commit();
        em.close();
    }
}
