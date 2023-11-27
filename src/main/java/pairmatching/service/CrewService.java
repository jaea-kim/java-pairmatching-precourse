package pairmatching.service;

import pairmatching.repository.CrewRepository;

public class CrewService {
    private final CrewRepository crewRepository;

    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }
}
