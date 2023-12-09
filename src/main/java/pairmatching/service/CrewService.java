package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.PairMission;
import pairmatching.repository.CrewRepository;

import java.util.List;

public class CrewService {
    private CrewRepository crewRepository;

    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public List<String> getCrewMemberBy(Course course) {
        return crewRepository.getMembersBy(course);
    }

}
