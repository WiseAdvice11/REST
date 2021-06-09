package ru.a1.restStudent.controller;

import org.springframework.web.bind.annotation.*;
import ru.a1.restStudent.entity.Student;
import ru.a1.restStudent.service.StudentService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping(path = "item")
    public List<Student> add(@RequestBody Student student) {
        studentService.add(student);
        return studentService.list();
    }

    @DeleteMapping(path = "item/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }

    @PutMapping(path = "item")
    public void delete(@RequestBody Student student) {
        studentService.update(student);
    }
}