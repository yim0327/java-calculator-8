package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public NumberList parsingNumbers(String inputString) {
        List<ParsedNumber> parsedNumbers = new ArrayList<>();
        String splliter = "[,:]";

        validateCustomFormat(inputString);
        if (existCustomSplitter(inputString)) {
            splliter = "["+customSplitter(inputString)+",:]";
        }

        for (String parsedString : parsedString(inputString, splliter)) {
            validateWrongInput(parsedString);
            parsedNumbers.add(ParsedNumber.from(parsedString));
        }

        return new NumberList(parsedNumbers);
    }

    private String customSplitter(String inputString) {
        int startSplitterIdx = inputString.indexOf("//");
        int endSplitterIdx = inputString.indexOf("\\n");

        String customSplitter = inputString.substring(startSplitterIdx+2, endSplitterIdx);
        validateWrongSplitter(customSplitter);

        return customSplitter;
    }

    private List<String> parsedString(String inputString, String splitter) {
        int endSplitterIdx = 0;

        if (existCustomSplitter(inputString)) {
            endSplitterIdx = inputString.indexOf("\\n") + 2;
        }

        String rawNumString = inputString.substring(endSplitterIdx);

        return Arrays.stream(rawNumString.split(splitter))
                .map(String::trim)
                .toList();
    }

    private boolean existCustomSplitter(String inputString) {
        return inputString.contains("//") && inputString.contains("\\n");
    }

    private void validateWrongInput(String parsedString) {
        if (!parsedString.matches("[0-9]+")) {
            throw new IllegalArgumentException("정해진 구분자/양수 외의 잘못된 값이 감지되었습니다.");
        }
    }

    private void validateWrongSplitter(String customSplitter) {
        if (customSplitter.matches("[0-9]+|\\s+")) {
            throw new IllegalArgumentException("공백이나 숫자는 커스텀 구분자로 사용할 수 없습니다.");
        }

        if (customSplitter.contains("//") || customSplitter.contains("\\n")) {
            throw new IllegalArgumentException("'//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.");
        }
    }

    private void validateCustomFormat(String inputString) {
        if ((inputString.contains("//") && !inputString.contains("\\n"))
        || (!inputString.contains("//") && inputString.contains("\\n"))) {
            throw new IllegalArgumentException("올바른 커스텀 구분자 형식이 아닙니다.");
        }
    }

}
