package fr.tse.architecture.controller;



import fr.tse.architecture.domain.Student;
import fr.tse.architecture.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


/**
 * Controllers that use {@link StudentService}.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    Collection<Student> findAllUsers() {

        return this.studentService.findAllStudents();

    }

    @GetMapping("/students/{id}")
    Student findUserById(@PathVariable Long id) {
        return this.studentService.findStudent(id);
    }



    @PostMapping("/students")
    Student createStudent(@Valid @RequestBody Student student) {

        Student studentToCreate = studentService.createStudent(student);
        return studentToCreate;
    }

}
