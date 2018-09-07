package persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.entity.AccUser;
import persistence.entityManager.MyEntityManager;

@Component(AccUserRepository.NAME)
public class AccUserRepository implements Repository <AccUser> {

    public static final String NAME = "AccountUserRepository";

    @Autowired
    private MyEntityManager entityManager;

    @Override
    public void insert(AccUser accUser) {
        entityManager.insertOrUpdate(em -> {
            em.persist(accUser);
            return null;
        });
    }
}
