package pairmatching.config;

public enum ErrorMessage {
    WRONG_INPUT("잘못된 입력입니다."),
    NO_MATCHING("매칭 이력이 없습니다.");

    private static final String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
