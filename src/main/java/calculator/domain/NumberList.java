package calculator.domain;

import java.util.List;

public class NumberList {
    private final List<ParsedNumber> numberList;

    public NumberList(List<ParsedNumber> parsedList) {
        this.numberList = parsedList;
    }

    public List<ParsedNumber> getNumberList() {
        return List.copyOf(numberList);
    }

}
