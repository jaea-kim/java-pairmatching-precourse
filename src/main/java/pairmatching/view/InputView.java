package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;
import pairmatching.dto.InputDTO;

import java.util.Arrays;

public class InputView {
    private static final String DELIMITER = ",";

    public String askFunction() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.printf("%s. %s\n", function.getNumber(), function.getMessage());
        }
        return Console.readLine();
    }

    public InputDTO askInformation() {
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        return inputToDTO(input);
    }

    private InputDTO inputToDTO(String input) {
        String[] inputParts = input.split(DELIMITER);
        validatePartsNumber(inputParts.length);
        return new InputDTO(inputParts[0], inputParts[1], inputParts[2]);
    }

    private void validatePartsNumber(int number) {
        if (number != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
