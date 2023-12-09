package pairmatching.domain;

import pairmatching.config.ErrorMessage;

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

    public static Level of(String name) {
        for (Level level : Level.values()) {
            if (level.name.equals(name)) {
                return level;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
    }

    public static boolean isLevelInMission(String level, String mission) {
        return Level.valueOf(level).getMissionNames().contains(mission);
    }

    public boolean isInMission(String mission) {
        return missionNames.contains(mission);
    }

    public String getName() {
        return name;
    }

    public List<String> getMissionNames() {
        return missionNames;
    }
}
