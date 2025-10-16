package calculator;

import calculator.controller.CalculateManager;
import calculator.service.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        CalculateManager calculateManager = new CalculateManager(inputView, outputView, calculator);

        calculateManager.start();
    }
}
