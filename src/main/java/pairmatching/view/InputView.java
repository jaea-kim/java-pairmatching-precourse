package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.config.Function;

public class InputView {
    public int askFunction() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.printf("%d. %s\n", function.getNumber(), function.getMessage());
        }
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
