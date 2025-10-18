package calculator.controller;

import calculator.service.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculateManager(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void start() {
        int result = calculator.calculate(inputView.inputString());
        outputView.printResult(result);
    }

}
