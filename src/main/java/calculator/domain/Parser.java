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

        for (String st : parsedString(inputString, splliter)) {
            parsedNumbers.add(ParsedNumber.from(st));
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

}
