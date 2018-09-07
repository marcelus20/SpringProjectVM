package persistence.entityManager;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Function;


public interface MyEntityManager {


    public <A > A execute(Function<EntityManager, A> f);

    public void  insertOrUpdate(Function<EntityManager, Void> f);
}
