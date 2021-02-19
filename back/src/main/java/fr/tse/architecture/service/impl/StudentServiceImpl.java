package fr.tse.architecture.service.impl;

import fr.tse.architecture.dao.StudentRepository;
import fr.tse.architecture.domain.Student;
import fr.tse.architecture.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    @Transactional
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student findStudent(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {

        Student studentCreated = null;
        studentCreated = studentRepository.save(student);
        return studentCreated;
    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {

        this.studentRepository.delete(student);

    }
}
