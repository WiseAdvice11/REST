package ru.a1.restStudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.a1.restStudent.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
