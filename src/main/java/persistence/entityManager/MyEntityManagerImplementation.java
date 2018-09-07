package persistence.entityManager;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Function;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyEntityManagerImplementation implements MyEntityManager{

    public final static String PU = "org.hibernate.tutorial.jpa";

    private final EntityManagerFactory emf;

    public MyEntityManagerImplementation() {
        this.emf =  Persistence.createEntityManagerFactory(PU);
    }

    public <A > A execute(Function<EntityManager, A> f){
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction et = em.getTransaction();

        et.begin();

        A res = f.apply(em);

        et.commit();

        em.close();
        emf.close();

        return res;
    }

    public void  insertOrUpdate(Function<EntityManager, Void> f){
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction et = em.getTransaction();

        et.begin();

        f.apply(em);

        et.commit();

        em.close();
        emf.close();
    }
}
