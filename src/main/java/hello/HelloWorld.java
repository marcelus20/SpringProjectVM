package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import persistence.entity.AccUser;
import persistence.entity.TransactionType;
import persistence.entityManager.MyEntityManager;

import java.util.List;

@SpringBootApplication
@ComponentScan({"controllers", "persistence"})
public class HelloWorld {

    public static void main(String... args){

        SpringApplication.run(HelloWorld.class, args);


    }

}