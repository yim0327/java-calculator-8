package calculator;

import calculator.controller.CalculateManager;
import calculator.domain.AdditionOperation;
import calculator.domain.ArithmeticOperation;
import calculator.domain.Parser;
import calculator.service.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        ArithmeticOperation operation = new AdditionOperation();
        Calculator calculator = new Calculator(parser, operation);
        CalculateManager calculateManager = new CalculateManager(inputView, outputView, calculator);

        calculateManager.start();
    }
}
