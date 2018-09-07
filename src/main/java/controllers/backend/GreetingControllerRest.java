package controllers.backend;

import model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import persistence.entity.AccUser;
import persistence.entity.AccountType;
import persistence.repositories.AccUserRepository;
import persistence.repositories.AccountTypeRepository;
import persistence.repositories.Repository;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sirkleber on 25/05/16.
 */
@RestController
public class GreetingControllerRest {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    @Qualifier(AccountTypeRepository.NAME)
    private Repository<AccountType> accountTypeRepository;

    @Autowired
    @Qualifier(AccUserRepository.NAME)
    private Repository<AccUser> accUserRepository;



    @RequestMapping("/greetingJson")
    public Greeting greetingJson(@RequestParam(value="name", defaultValue="World") String name){
        accUserRepository.insert(
                new AccUser(
                        null, "felipe@gmail.com", "12345", new HashSet<>()
                )
        );
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/helloWorld")
    public String helloMessage(@RequestParam(value="name", defaultValue="World") String name){

        AccUser user = new AccUser(null, "felipe@gmail.com", "12345", new HashSet<>());

        accountTypeRepository.insert(
                new AccountType(
                        null,
                        user,
                        "nao interessa o que eh",
                        "10",
                        "felipe",
                        new HashSet<>(),
                        new HashSet<>()
        ));
        return "Hello, " + name;
    }
}