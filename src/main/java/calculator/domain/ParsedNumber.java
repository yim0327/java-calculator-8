package calculator.domain;

public class ParsedNumber {
    private final int value;

    private ParsedNumber(int parsedInteger) {
        this.value = parsedInteger;
    }

    public static ParsedNumber from(String parsedString) {
        return new ParsedNumber(Integer.parseInt(parsedString));
    }

    public int getValue() {
        return value;
    }

}
