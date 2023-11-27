package pairmatching.domain;

import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private String name;
    private List<String> missionNames;

    Level(String name, List<String> missionNames) {
        this.name = name;
        this.missionNames = missionNames;
    }

    public String getName() {
        return name;
    }

    public List<String> getMissionNames() {
        return missionNames;
    }
}
