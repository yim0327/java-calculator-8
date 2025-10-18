package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public NumberList parsingNumbers(String inputString) {
        List<ParsedNumber> parsedNumbers = new ArrayList<>();
        String splliter = "[,:]";

        if (inputString.contains("//") && inputString.contains("\\n")) {
            splliter = "["+customSplit(inputString)+",:]";
        }

        for (String parsedString : parsedString(inputString, splliter)) {
            validateWrongInput(parsedString);
            parsedNumbers.add(ParsedNumber.from(parsedString));
        }

        return new NumberList(parsedNumbers);
    }

    private String customSplit(String inputString) {
        int startSplitterIdx = inputString.indexOf("//");
        int endSplitterIdx = inputString.indexOf("\\n");
        return inputString.substring(startSplitterIdx + 2, endSplitterIdx);
    }

    private List<String> parsedString(String inputString, String splitter) {
        int endSplitterIdx = 0;

        if (inputString.contains("//") && inputString.contains("\\n")) {
            endSplitterIdx = inputString.indexOf("\\n") + 2;
        }

        String rawNumString = inputString.substring(endSplitterIdx);

        return Arrays.stream(rawNumString.split(splitter))
                .map(String::trim)
                .toList();
    }

    private void validateWrongInput(String parsedString) {
        if (!parsedString.matches("[0-9]+")) {
            throw new IllegalArgumentException("정해진 구분자/양수 외의 잘못된 값이 감지되었습니다.");
        }
    }

}
