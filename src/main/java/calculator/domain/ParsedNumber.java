package calculator.domain;

public class ParsedNumber {
    private final int value;

    private ParsedNumber(int parsedInteger) {
        this.value = parsedInteger;
    }

    public static ParsedNumber from(String parsedString) {
        if (!parsedString.matches("[0-9]+")) {
            throw new NumberFormatException("문자열은 구분자를 제외하고 양수만 입력 가능합니다.");
        }

        return new ParsedNumber(Integer.parseInt(parsedString));
    }

    public int getValue() {
        return value;
    }

}
