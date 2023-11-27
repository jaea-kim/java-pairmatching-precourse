package pairmatching.controller;

import pairmatching.config.Function;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final PairService pairService;
    private final InputView inputView;
    private final OutputView outputView;

    public PairController(PairService pairService, InputView inputView, OutputView outputView) {
        this.pairService = pairService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        Function function = inputFunction();
        if (function != Function.EXIT) {
            //todo: 종료 외 기능 완성
            outputView.printCourseAndLevelInformation();
        }
    }

    private Function inputFunction() {
        int functionNumber = inputView.askFunction();
        return Function.of(functionNumber);
    }
}
