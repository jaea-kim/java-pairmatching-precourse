package pairmatching.domain;

public enum Function {
    MATCHING("1", "페어 매칭"),
    INQUIRY("2", "페어 조회"),
    INITIALIZATION("3", "페어 초기화"),
    EXIT("Q", "종료");

    private final String number;
    private final String message;

    Function(String number, String message) {
        this.number = number;
        this.message = message;
    }

    public static Function of(String functionNumber) {
        for (Function function : Function.values()) {
            if (function.number.equals(functionNumber)) {
                return function;
            }
        }
        //todo: 예외처리 정리하기
        throw new IllegalArgumentException("잘못된 기능을 입력하였습니다.");
    }

    public String getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

    public boolean isWatchingOrInquiry() {
        return this.equals(Function.MATCHING) || this.equals(Function.INQUIRY);
    }
}
