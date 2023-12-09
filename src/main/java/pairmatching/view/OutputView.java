package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;

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
            System.out.printf("\t- %s: %s%n", level.getName(), listToString(level.getMissionNames()));
        }
    }

    private String listToString(List<String> list) {
        return String.join(" | ", list);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPairs(List<Pair> pairs) {
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : pairs) {
            System.out.println(String.join(" : ", pair.getNames()));
        }
    }
}
