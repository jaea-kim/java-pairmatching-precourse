package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> names;

    public Pair(List<String> names) {
        this.names = new ArrayList<>(names);
    }

    public void addPair(String name) {
        names.add(name);
    }

    public List<String> getNames() {
        return names;
    }
}
