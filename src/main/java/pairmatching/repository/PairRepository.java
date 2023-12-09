package pairmatching.repository;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PairRepository {
    private Map<PairMission, List<Pair>> pairRepository;

    public PairRepository() {
        this.pairRepository = new HashMap<>();
    }

    public void clear() {
        pairRepository.clear();
    }

    public boolean isPairMission(PairMission pairMission) {
        return pairRepository.containsKey(pairMission);
    }

    public void save(PairMission pairMission, List<Pair> pairs) {
        pairRepository.put(pairMission, pairs);
    }

    public Optional<List<Pair>> getPairWith(PairMission pairMission) {
        return Optional.ofNullable(pairRepository.get(pairMission));
    }
}
