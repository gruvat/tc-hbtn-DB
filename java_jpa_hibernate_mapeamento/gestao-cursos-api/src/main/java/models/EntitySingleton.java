package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntitySingleton {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private EntitySingleton() {};

    static {
        emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        em = emf.createEntityManager();
    }

    public static EntityManager get() {
        return em;
    }

}
