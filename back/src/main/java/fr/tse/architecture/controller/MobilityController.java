package fr.tse.architecture.controller;



import fr.tse.architecture.domain.Mobility;
import fr.tse.architecture.domain.Student;
import fr.tse.architecture.service.MobilityService;
import fr.tse.architecture.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collection;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.DELETE})
public class MobilityController {

    @Autowired
    private MobilityService mobilityService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/mobilities")
    Collection<Mobility> findAllMobilities() {

        return this.mobilityService.findAllMobility();

    }

    @GetMapping("/mobilities/{id}")
    Mobility findUserById(@PathVariable Long id) {
        return this.mobilityService.findMobility(id);
    }



    @PostMapping("/mobilities")
    Mobility createMobility(@Valid @RequestBody Mobility mobility) {

        //Student studentToCreate = studentService.createStudent(mobility.getStudent());
        Mobility mobilityToCreate = mobilityService.createMobility(mobility);
        return mobilityToCreate;
    }

    @PostMapping("/mobilities/student")
    Mobility createMobilityStudent(@Valid @RequestBody Mobility mobility, @Valid @RequestBody Student student) {

        Student studentToCreate = studentService.createStudent(student);
        Mobility mobilityToCreate = mobilityService.createMobility(mobility);
        return mobilityToCreate;
    }

    @DeleteMapping("/mobilities/{id}")
    void deleteMobility(@PathVariable Long id, HttpServletResponse response) {
        Mobility mobility = mobilityService.findMobility(id);
        mobilityService.deleteMobility(mobility);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }

}
