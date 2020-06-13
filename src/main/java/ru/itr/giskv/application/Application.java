package ru.itr.giskv.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"ru.itr.giskv.service", "ru.itr.giskv.controller", "ru.itr.giskv.configure", "ru.itr.giskv.filters"})

@EntityScan("ru.itr.giskv.model")
@EnableJpaRepositories("ru.itr.giskv.repository")
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
