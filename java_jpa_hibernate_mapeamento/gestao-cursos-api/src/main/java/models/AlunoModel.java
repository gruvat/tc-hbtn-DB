package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class AlunoModel {

    @Transactional
    public void create(Aluno aluno) {
        EntityManager em = EntitySingleton.get();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
            throw e;
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManager em = EntitySingleton.get();
        Aluno aluno = null;
        try {
            System.out.println("Buscando aluno!");
            aluno = em.find(Aluno.class, id);
            System.out.println("Aluno encontrado!!!");
        } catch (Exception e) {
            System.err.println("Erro ao buscar um aluno !!!" + e.getMessage());
        }
        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManager em = EntitySingleton.get();
        List<Aluno> alunos = null;
        try {
            System.out.println("Buscando alunos!");
            alunos = em.createQuery("FROM " + Aluno.class.getName(), Aluno.class).getResultList();
            System.out.println("Alunos encontrado!!!");
        } catch (Exception e) {
            System.err.println("Erro ao buscar os alunos !!!" + e.getMessage());
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManager em = EntitySingleton.get();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar um aluno !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        EntityManager em = EntitySingleton.get();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Aluno managedAluno = em.find(Aluno.class, aluno.getId());
            em.remove(managedAluno);
            em.getTransaction().commit();
            System.out.println("Aluno deletado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao deletar um aluno !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }
}
