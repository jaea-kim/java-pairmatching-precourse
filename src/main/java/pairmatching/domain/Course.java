package pairmatching.domain;

import pairmatching.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private String name;
    private String filePath;

    Course(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public static List<String> getNames() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .toList();
    }

    public static Course of(String name) {
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return course;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }
}
