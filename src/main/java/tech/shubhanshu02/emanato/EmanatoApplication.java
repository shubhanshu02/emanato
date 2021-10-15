package tech.shubhanshu02.emanato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmanatoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EmanatoApplication.class, args);
    }

}
