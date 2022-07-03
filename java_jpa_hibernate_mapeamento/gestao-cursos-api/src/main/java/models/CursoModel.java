package models;

import entities.Curso;

import javax.persistence.EntityManager;
import java.util.List;

public class CursoModel {

    public void create(Curso curso) {
        EntityManager em = EntitySingleton.get();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
//            em.getTransaction().rollback();
              throw e;
//            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        EntityManager em = EntitySingleton.get();
        Curso curso = null;
        try {
            System.out.println("Buscando curso!");
            curso = em.find(Curso.class, id);
            System.out.println("Curso encontrado!!!");
        } catch (Exception e) {
            System.err.println("Erro ao buscar um curso !!!" + e.getMessage());
        }
        return curso;
    }

    public List<Curso> findAll() {
        EntityManager em = EntitySingleton.get();
        List<Curso> cursos = null;
        try {
            System.out.println("Buscando Cursos!");
            cursos = em.createQuery("FROM " + Curso.class.getName(), Curso.class).getResultList();
            System.out.println("Cursos encontrado!!!");
        } catch (Exception e) {
            System.err.println("Erro ao buscar os cursos !!!" + e.getMessage());
        }
        return cursos;
    }

    public void update(Curso curso) {
        EntityManager em = EntitySingleton.get();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar um curso !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        EntityManager em = EntitySingleton.get();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Curso managedCurso = em.find(Curso.class, curso.getId());
            em.remove(managedCurso);
            em.getTransaction().commit();
            System.out.println("Curso deletado com sucesso !!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao deletar um curso !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }
}
