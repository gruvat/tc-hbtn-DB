package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    private EntityManagerFactory factory;
    private EntityManager em;

    public PessoaModel() {
        this.factory = Persistence.createEntityManagerFactory("admin-jpa");
        this.em = this.factory.createEntityManager();
    }

    public void create(Pessoa p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o Pessoa !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o Pessoa !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Pessoa managedProduct = em.find(Pessoa.class, p.getId());
            em.remove(managedProduct);
            em.getTransaction().commit();
            System.out.println("Pessoa removido com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o Pessoa !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        Pessoa product = null;
        try {
            System.out.println("Procurando Pessoa.");
            product = em.find(Pessoa.class, p.getId());
            System.out.println("Busca concluida !!!");
        } catch (Exception e) {
            System.err.println("Erro na busca do Pessoa !!!" + e.getMessage());
        }
        return product;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> Pessoas = new ArrayList<Pessoa>();
        try {
            System.out.println("Procurando Pessoa.");
            Pessoas = em.createQuery("FROM " + Pessoa.class.getName(), Pessoa.class).getResultList();
            System.out.println("Busca concluida !!!");
        } catch (Exception e) {
            System.err.println("Erro na busca dos Pessoas !!!" + e.getMessage());
        }
        return Pessoas;
    }
}
