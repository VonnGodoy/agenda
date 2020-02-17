package br.gdtech.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AgendaAPP extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AgendaAPP.class, args);
    }
}
