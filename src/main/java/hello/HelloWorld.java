package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controllers"})
public class HelloWorld {
    public static void main(String... args){
        SpringApplication.run(HelloWorld.class, args);
    }
}