package fr.tse.architecture.service.impl;

import fr.tse.architecture.dao.MobilityRepository;
import fr.tse.architecture.dao.StudentRepository;
import fr.tse.architecture.domain.Mobility;
import fr.tse.architecture.domain.Student;
import fr.tse.architecture.service.MobilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MobilityServiceImpl implements MobilityService {

    @Autowired
    private MobilityRepository mobilityRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    @Transactional
    public List<Mobility> findAllMobility() {
        return this.mobilityRepository.findAll();
    }

    @Override
    @Transactional
    public Mobility findMobility(Long id) {
        return this.mobilityRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Mobility createMobility(Mobility mobility) {
        Mobility mobilityCreated = null;

        Student studentCreated = null;
        studentCreated = studentRepository.save(mobility.getStudent());
        mobilityCreated = mobilityRepository.save(mobility);
        return mobilityCreated;
    }

    @Override
    @Transactional
    public void deleteMobility(Mobility mobility) {

        this.mobilityRepository.delete(mobility);
    }
}
