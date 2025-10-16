package calculator.controller;

import calculator.service.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateManager {
    private InputView inputView;
    private OutputView outputView;

    public CalculateManager(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        inputView.inputString();
    }

}
