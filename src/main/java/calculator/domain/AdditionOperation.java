package calculator.domain;

import java.util.List;

public class AdditionOperation implements ArithmeticOperation {

    public int operate(NumberList list) {
        List<ParsedNumber> numberList = list.getNumberList();
        int total = 0;

        for (ParsedNumber operand : numberList) {
            total += operand.getValue();
        }

        if (total < 0) {
            throw new ArithmeticException("연산 결과가 너무 큽니다.");
        }

        return total;
    }

}