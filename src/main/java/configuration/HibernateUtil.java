package configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory factory = null;

    static {
        init();
    }

    private static void init() {

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
        }

    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager(); /*Prove a parte de persistencia*/
    }
}
