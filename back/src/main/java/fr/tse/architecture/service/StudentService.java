package fr.tse.architecture.service;

import fr.tse.architecture.domain.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudents();

    public Student findStudent(Long id);

    public Student createStudent(Student student);

    public void deleteStudent(Student student);

}
