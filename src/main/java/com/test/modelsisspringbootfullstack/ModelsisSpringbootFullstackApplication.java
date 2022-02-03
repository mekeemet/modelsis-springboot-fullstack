package com.test.modelsisspringbootfullstack;

import com.test.modelsisspringbootfullstack.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class ModelsisSpringbootFullstackApplication {
//    @Autowired
//    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(ModelsisSpringbootFullstackApplication.class, args);
    }
//    @Bean
//    CommandLineRunner start(AccountService accountService){
//        repositoryRestConfiguration.exposeIdsFor(ModelsisSpringbootFullstackApplication.class);
//        return args -> {
//              Stream.of("admin").forEach(u->{
//        if(accountService.loadUserByUsername(u)==null) {
//            accountService.saveUser(u, "admin1234", "admin1234");
//        }
//    });
//        };
//    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}
