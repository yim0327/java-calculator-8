package calculator.domain;

public class ParsedNumber {
    private final int value;

    private ParsedNumber(int parsedInteger) {
        this.value = parsedInteger;
    }

    public static ParsedNumber from(String parsedString) {
        try {
            Integer.parseInt(parsedString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력된 숫자의 크기가 너무 큽니다.");
        }

        return new ParsedNumber(Integer.parseInt(parsedString));
    }

    public int getValue() {
        return value;
    }

}
