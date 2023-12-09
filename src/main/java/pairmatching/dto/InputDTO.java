package pairmatching.dto;

public record InputDTO(String course, String level, String mission) {
    public InputDTO(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }
}
