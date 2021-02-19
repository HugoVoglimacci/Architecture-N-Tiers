package fr.tse.architecture.service;

import fr.tse.architecture.domain.Mobility;

import java.util.List;

public interface MobilityService {

    public List<Mobility> findAllMobility();

    public Mobility findMobility(Long id);

    public Mobility createMobility(Mobility mobility);

    public void deleteMobility(Mobility mobility);

}
