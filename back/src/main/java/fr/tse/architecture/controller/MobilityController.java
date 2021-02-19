package fr.tse.architecture.controller;



import fr.tse.architecture.domain.Mobility;
import fr.tse.architecture.service.MobilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class MobilityController {

    @Autowired
    private MobilityService mobilityService;

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

        Mobility mobilityToCreate = mobilityService.createMobility(mobility);
        return mobilityToCreate;
    }

}
