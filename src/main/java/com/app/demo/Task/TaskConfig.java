package com.app.demo.Task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository){
        return args -> {
            List<Task> tasks = new ArrayList<>();
            tasks.add(
                    new Task(
                            "Faire les courses",
                            "john.doe@example.com",
                            LocalDate.of(2023, Month.APRIL, 2),
                            false
                    )
            );
            tasks.add(
                    new Task(
                            "Faire les exercices",
                            "dob.doe@example.com",
                            LocalDate.of(2023, Month.MARCH, 20),
                            false
                    )
            );
            repository.saveAll(tasks);
        };
    }
}
