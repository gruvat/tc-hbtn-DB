package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    private EntityManagerFactory factory;
    private EntityManager em;

    public ProdutoModel() {
        this.factory = Persistence.createEntityManagerFactory("admin-jpa");
        this.em = this.factory.createEntityManager();
    }

    public void create(Produto p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Produto managedProduct = em.find(Produto.class, p.getId());
            em.remove(managedProduct);
            em.getTransaction().commit();
            System.out.println("Produto removido com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {
        Produto product = null;
        try {
            System.out.println("Procurando produto.");
            product = em.find(Produto.class, p.getId());
            System.out.println("Busca concluida !!!");
        } catch (Exception e) {
            System.err.println("Erro na busca do produto !!!" + e.getMessage());
        }
        return product;
    }

    public List<Produto> findAll() {

        List<Produto> produtos = new ArrayList<Produto>();
        try {
            System.out.println("Procurando produto.");
            produtos = em.createQuery("FROM " + Produto.class.getName(), Produto.class).getResultList();
            System.out.println("Busca concluida !!!");
        } catch (Exception e) {
            System.err.println("Erro na busca dos produtos !!!" + e.getMessage());
        }
        return produtos;
    }
}
