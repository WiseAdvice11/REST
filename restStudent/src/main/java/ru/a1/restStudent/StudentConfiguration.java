package ru.a1.restStudent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.a1.restStudent.entity.Student;
import ru.a1.restStudent.repo.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

        return args -> {
            studentRepository.saveAll(List.of(
                    new Student("Roman", LocalDate.of(1987, Month.SEPTEMBER,23)),
                    new Student("Sara", LocalDate.of(1997, Month.APRIL,11))
            ));
        };
    }   
}
