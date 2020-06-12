package com.sbt.vap.application;

import com.sbt.vap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.sbt.vap.service.UserService;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.sbt.vap.service", "com.sbt.vap.controller", "com.sbt.vap.configure", "com.sbt.vap.filters"})

@EntityScan("com.sbt.vap.model")
@EnableJpaRepositories("com.sbt.vap.repository")
//public class Application implements CommandLineRunner {
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

//    @Autowired
//    private UserService userService;

    public static void main(String []args) {
        ApplicationContext ac = SpringApplication.run(Application.class, args);

//        String []beanNames = ac.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for(String name : beanNames) {
//            System.out.println(name);
//        }
    }

    @Override
    public void run(String... args) {

    }

}
