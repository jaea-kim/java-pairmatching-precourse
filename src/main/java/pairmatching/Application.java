package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import pairmatching.service.CrewService;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CrewService crewService = new CrewService(new CrewRepository());
        PairService pairService = new PairService(new PairRepository());

        PairController pairController = new PairController(crewService, pairService, new InputView(), new OutputView());
        pairController.execute();
    }
}
