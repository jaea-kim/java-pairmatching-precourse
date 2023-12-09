package pairmatching.controller;

import pairmatching.domain.Function;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMission;
import pairmatching.dto.InputDTO;
import pairmatching.service.CrewService;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairController {
    private final CrewService crewService;
    private final PairService pairService;
    private final InputView inputView;
    private final OutputView outputView;

    public PairController(CrewService crewService, PairService pairService, InputView inputView, OutputView outputView) {
        this.crewService = crewService;
        this.pairService = pairService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        while (true) {
            Function function = inputFunction();
            if (function.equals(Function.EXIT)) {
                break;
            }
            if (function.equals(Function.INITIALIZATION)) {
                pairService.initialization();
                continue;
            }
            if (function.equals(Function.MATCHING)) {
                PairMission pairMission = inputPairInformation();
                matching(pairMission);
                continue;
            }
            if (function.equals(Function.INQUIRY)) {
                PairMission pairMission = inputPairInformation();
                inquiry(pairMission);
            }
        }
    }

    private void matching(PairMission pairMission) {
        List<String> crewMembers = crewService.getCrewMemberBy(pairMission.getCourse());
        pairService.matching(pairMission, crewMembers);
        List<Pair> pairs = pairService.inquiry(pairMission);
        outputView.printPairs(pairs);
    }

    private void inquiry(PairMission pairMission) {
        try {
            List<Pair> pairs = pairService.inquiry(pairMission);
            outputView.printPairs(pairs);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private PairMission inputPairInformation() {
        outputView.printCourseAndLevelInformation();
        while (true) {
            try {
                InputDTO inputDTO = inputView.askInformation();
                return PairMission.toDomain(inputDTO);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void printInformation(Function function) {
        if (function.isWatchingOrInquiry()) {
            outputView.printCourseAndLevelInformation();
        }
    }

    private Function inputFunction() {
        while (true) {
            try {
                String functionNumber = inputView.askFunction();
                return Function.of(functionNumber);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
