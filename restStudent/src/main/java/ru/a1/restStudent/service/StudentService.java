package ru.a1.restStudent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.a1.restStudent.entity.Student;
import ru.a1.restStudent.repo.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list () {
        return studentRepository.findAll();
    }

    public void add ( Student student){
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);

    }
/** Correct change from DB :
 * First you need to derive data from DB to change the values.
 * Otherwise it'll  write  a new data with new ID.
 */

    public void update(Student student) {
        Optional<Student> row = studentRepository.findById(student.getId());
        if (row.isPresent()) {
            Student item = row.get();
            if (!student.getName().isEmpty()) {
                item.setName(student.getName());
            }
            if (student.getDob() != null) {
                item.setDob(student.getDob());
            }
            studentRepository.save(item);
        }

    }
}
