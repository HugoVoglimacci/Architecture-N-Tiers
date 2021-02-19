package fr.tse.architecture.dao;

import fr.tse.architecture.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {

}
