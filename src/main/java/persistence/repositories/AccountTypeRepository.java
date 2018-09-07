package persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.entity.AccountType;
import persistence.entityManager.MyEntityManager;


@Component(AccountTypeRepository.NAME)
public class AccountTypeRepository implements Repository<AccountType> {


    public static final String NAME = "AccountTypeRepository";


    @Autowired
    private MyEntityManager entityManager;

    @Override
    public void insert(AccountType accountType) {
        entityManager.insertOrUpdate((em) -> {
            em.persist(accountType);
            return null;
        });
    }
}
