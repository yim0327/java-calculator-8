package calculator.domain;

import java.util.List;

public class ArithmeticOperation {

    public int addOperation(NumberList list) {
        List<ParsedNumber> numberList = list.getNumberList();
        int total = 0;

        for (ParsedNumber parsedNumber : numberList) {
            total += parsedNumber.getValue();
        }

        return total;
    }

}