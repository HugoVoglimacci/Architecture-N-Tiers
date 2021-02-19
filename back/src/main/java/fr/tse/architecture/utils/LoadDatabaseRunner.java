package fr.tse.architecture.utils;

import fr.tse.architecture.dao.*;
import fr.tse.architecture.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Slf4j
@Configuration
public class LoadDatabaseRunner implements CommandLineRunner {

    // Logger initialization
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabaseRunner.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MobilityRepository mobilityRepository;


    @Override
    @Profile("!test")
    public void run(String... args) throws Exception {
        logger.info("LOAD DATABASE RUNNER : Starting runner");

        initStudents(studentRepository);

        initMobilities(mobilityRepository);

        logger.info("Display all students");
        studentRepository.findAll().forEach((student) -> {
            logger.info("Created {}", student);
        });

        logger.info("Display all mobilities");
        mobilityRepository.findAll().forEach((mobility) -> {
            logger.info("Created {}", mobility);
        });

        logger.info("LOAD DATABASE RUNNER : Ending runner");
    }

    /**
     * Initialization of {@link fr.tse.architecture.dao.StudentRepository} with 5 {@link fr.tse.architecture.domain.Student}
     *
     *
     * @param studentRepository repository of {@link fr.tse.architecture.domain.Student}
     */
    private void initStudents(StudentRepository studentRepository) {

        Student student1 = new Student();
        student1.setFirstname("Hugo");
        student1.setLastname("Voglimacci");
        student1.setPromotion("FISE3");
        student1 = studentRepository.save(student1);
        log.info(student1 + " saved to database !");

        Student student2 = new Student();
        student2.setFirstname("Eric");
        student2.setLastname("Yammine");
        student2.setPromotion("FISE3");
        student2 = studentRepository.save(student2);
        log.info(student2 + " saved to database !");

        Student student3 = new Student();
        student3.setFirstname("Cedric");
        student3.setLastname("Gormond");
        student3.setPromotion("FISE3");
        student3 = studentRepository.save(student3);
        log.info(student3 + " saved to database !");

        Student student4 = new Student();
        student4.setFirstname("Erwan");
        student4.setLastname("Saliou");
        student4.setPromotion("FISE2");
        student4 = studentRepository.save(student4);
        log.info(student4 + " saved to database !");

        Student student5 = new Student();
        student5.setFirstname("Vincent");
        student5.setLastname("Ortolano");
        student5.setPromotion("FISE3");
        student5 = studentRepository.save(student5);
        log.info(student5 + " saved to database !");


    }

    /**
     * Initialization of {@link fr.tse.architecture.dao.MobilityRepository} with 2 {@link fr.tse.architecture.domain.Mobility}
     *
     * @param mobilityRepository repository of {@link Mobility}
     */
    private void initMobilities(MobilityRepository mobilityRepository) {

        Mobility mobility1 = new Mobility();
        mobility1.setCountry("England");
        mobility1.setCity("London");
        mobility1.setStartDate(LocalDate.of(2021,3,1));
        mobility1.setEndDate(LocalDate.of(2021,8,27));
        mobility1.setStudent(studentRepository.findById(1L).orElse(null));
        mobilityRepository.save(mobility1);
        log.info(mobility1 + " saved to database !");

        Mobility mobility2 = new Mobility();
        mobility2.setCountry("France");
        mobility2.setCity("Paris");
        mobility2.setStartDate(LocalDate.of(2021,6,5));
        mobility2.setEndDate(LocalDate.of(2021,12,21));
        mobility2.setStudent(studentRepository.findById(2L).orElse(null));
        mobilityRepository.save(mobility2);
        log.info(mobility2 + " saved to database !");

        Mobility mobility3 = new Mobility();
        mobility3.setCountry("Spain");
        mobility3.setCity("Madrid");
        mobility3.setStartDate(LocalDate.of(2021,5,7));
        mobility3.setEndDate(LocalDate.of(2021,9,26));
        mobility3.setStudent(studentRepository.findById(3L).orElse(null));
        mobilityRepository.save(mobility3);
        log.info(mobility3 + " saved to database !");

        Mobility mobility4 = new Mobility();
        mobility4.setCountry("China");
        mobility4.setCity("Pekin");
        mobility4.setStartDate(LocalDate.of(2021,3,18));
        mobility4.setEndDate(LocalDate.of(2021,9,24));
        mobility4.setStudent(studentRepository.findById(4L).orElse(null));
        mobilityRepository.save(mobility4);
        log.info(mobility4 + " saved to database !");

        Mobility mobility5 = new Mobility();
        mobility5.setCountry("Canada");
        mobility5.setCity("Montreal");
        mobility5.setStartDate(LocalDate.of(2021,4,8));
        mobility5.setEndDate(LocalDate.of(2021,10,16));
        mobility5.setStudent(studentRepository.findById(5L).orElse(null));
        mobilityRepository.save(mobility5);
        log.info(mobility5 + " saved to database !");

    }

}
