package pl.pawelec.springdatascopetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawelec.springdatascopetest.model.Student;
import pl.pawelec.springdatascopetest.service.StudentService;

@RestController
@RequestMapping(path = "students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getById(id);
    }

}
