package pairmatching.config;

public enum Function {
    MATCHING(1, "페어 매칭"),
    INQUIRY(2, "페어 조회"),
    INITIALIZATION(3, "페어 초기화"),
    EXIT(4, "종료");

    private final int number;
    private final String message;

    Function(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public static Function of(int functionNumber) {
        for (Function function : Function.values()) {
            if (function.number == functionNumber) {
                return function;
            }
        }
        //todo: 예외처리 정리하기
        throw new IllegalArgumentException("잘못된 기능을 입력하였습니다.");
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
