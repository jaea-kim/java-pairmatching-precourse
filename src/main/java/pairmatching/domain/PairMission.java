package pairmatching.domain;

import pairmatching.config.ErrorMessage;
import pairmatching.dto.InputDTO;

import java.util.Objects;

public class PairMission {
    private final Course course;
    private final Level level;
    private final String mission;

    private PairMission(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static PairMission toDomain(InputDTO inputDTO) {
        Level level = Level.of(inputDTO.level());
        Course course = Course.of(inputDTO.course());
        validateMission(level, inputDTO.mission());
        return new PairMission(course, level, inputDTO.mission());
    }

    private static void validateMission(Level level, String mission) {
        if (!level.isInMission(mission)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairMission that = (PairMission) o;
        return course == that.course && level == that.level && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
