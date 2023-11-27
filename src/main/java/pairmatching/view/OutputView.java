package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String SEPARATOR = "#############################################";

    public void printCourseAndLevelInformation() {
        System.out.println(SEPARATOR);
        printCourse();
        printMission();
        System.out.println(SEPARATOR);
    }


    private void printCourse() {
        System.out.printf("과정: %s\n", listToString(Course.getNames()));
    }

    private void printMission() {
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.printf("\t- %s: %s\n", level.getName(), listToString(level.getMissionNames()));
        }
    }

    private String listToString(List<String> list) {
        return list.stream().collect(Collectors.joining(" | "));
    }

}
