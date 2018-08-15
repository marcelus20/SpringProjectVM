package controllers.backend;

import model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sirkleber on 25/05/16.
 */
@RestController
public class GreetingControllerRest {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetingJson")
    public Greeting greetingJson(@RequestParam(value="name", defaultValue="World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/helloWorld")
    public String helloMessage(@RequestParam(value="name", defaultValue="World") String name){
        return "Hello, " + name;
    }
}