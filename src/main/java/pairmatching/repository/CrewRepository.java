package pairmatching.repository;

import pairmatching.domain.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrewRepository {
    private Map<Course, List<String>> crewRepository;

    public void init() {
        for (Course course : Course.values()) {
            try {
                List<String> crewNames = readCrewFile(course.getFilePath());
                crewRepository.put(course, crewNames);
            } catch (IOException e) {
                throw new IllegalArgumentException("크루 정보를 읽어올 수 없습니다.");
            }
        }
    }

    public List<String> readCrewFile(String filePath) throws IOException {
        List<String> crewList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                crewList.add(line);
            }
        }
        return crewList;
    }

}
