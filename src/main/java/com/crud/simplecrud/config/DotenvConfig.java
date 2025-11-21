package com.crud.simplecrud.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {
    static {
        System.out.println("CARREGANDO .env DA RAIZ DO PROJETO...");
        Dotenv dotenv = Dotenv.configure()
                .directory("./")
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(entry -> {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
            System.setProperty(entry.getKey(), entry.getValue());
        });
    }
}
