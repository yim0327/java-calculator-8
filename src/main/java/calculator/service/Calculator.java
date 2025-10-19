package calculator.service;

import calculator.domain.operation.ArithmeticOperation;
import calculator.domain.NumberList;
import calculator.domain.Parser;

public class Calculator {
    private final Parser parser;
    private final ArithmeticOperation operation;

    public Calculator(Parser parser, ArithmeticOperation operation) {
        this.parser = parser;
        this.operation = operation;
    }

    public int calculate(String inputString) {
        NumberList numberList = parser.parsingNumbers(inputString);
        return operation.operate(numberList);
    }

}
