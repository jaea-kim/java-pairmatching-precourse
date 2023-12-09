package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.config.ErrorMessage;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMission;
import pairmatching.repository.PairRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PairService {
    private final PairRepository pairRepository;

    public PairService(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    public void initialization() {
        pairRepository.clear();
    }

    public void matching(PairMission pairMission, List<String> members) {
        List<String> shuffledCrew = Randoms.shuffle(members);

        List<Pair> pairs = matchingWith(shuffledCrew);
        pairRepository.save(pairMission, pairs);
    }

    private List<Pair> matchingWith(List<String> shuffledCrew) {
        List<Pair> pairs = new ArrayList<>();
        List<String> current = new ArrayList<>();
        for (String member : shuffledCrew) {
            current.add(member);
            if (current.size() == 2) {
                pairs.add(new Pair(current));
                current.clear();
            }
        }
        if (!current.isEmpty()) {
            pairs.get(pairs.size() - 1).addPair(current.get(0));
        }
        return pairs;
    }

    public List<Pair> inquiry(PairMission pairMission) {
        Optional<List<Pair>> pairs = pairRepository.getPairWith(pairMission);
        if (pairs.isPresent()) {

            return pairs.get();
        }
        throw new IllegalArgumentException(ErrorMessage.NO_MATCHING.getMessage());
    }
}
