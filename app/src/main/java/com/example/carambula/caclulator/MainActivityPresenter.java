package com.example.carambula.caclulator;


import android.util.Log;

public class MainActivityPresenter {
    private IMainActivity activity;
    private double currentTempResult;
    private StringBuilder sbTempResult;
    private Operation operation;

    enum Operation {
        SUM {
            public double action(double x, double y) {
                return x + y;
            }
        },
        DIFFERENCE {
            public double action(double x, double y) {
                return x - y;
            }
        },
        MULTIPLY {
            public double action(double x, double y) {
                return x * y;
            }
        },
        DIVISION {
            public double action(double x, double y) {
                return x / y;
            }
        };

        public abstract double action(double x, double y);
    }


    MainActivityPresenter(IMainActivity activity) {
        this.activity = activity;
        currentTempResult = 0;
        operation = Operation.SUM;
        sbTempResult = new StringBuilder();
    }

    public void sum(String currentNumber) {
        sbTempResult.append(currentNumber).append(" + ");
        currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
        updateUI(sbTempResult.toString(), "");
        operation = Operation.SUM;

    }

    public void division(String currentNumber) {
        sbTempResult.append(currentNumber).append(" / ");
        currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
        updateUI(sbTempResult.toString(), "");
        operation = Operation.DIVISION;
    }

    public void difference(String currentNumber) {
        sbTempResult.append(currentNumber).append(" - ");
        currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
        updateUI(sbTempResult.toString(), "");
        operation = Operation.DIFFERENCE;
    }

    public void multiply(String currentNumber) {
        sbTempResult.append(currentNumber).append(" * ");
        currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
        updateUI(sbTempResult.toString(), "");
        operation = Operation.MULTIPLY;
    }

    public void reverse(String currentNumber) {
        updateUI(sbTempResult.toString(), String.valueOf(1 / Double.valueOf(currentNumber)));
    }

    public void square(String currentNumber) {
        updateUI(sbTempResult.toString(), String.valueOf(Math.pow(Double.valueOf(currentNumber), 2)));
    }

    public void radical(String currentNumber) {
        updateUI(sbTempResult.toString(), String.valueOf(Math.pow(Double.valueOf(currentNumber), 0.5)));
    }

    public void signChanger(String currentNumber) {
        updateUI(sbTempResult.toString(), String.valueOf(Double.valueOf(currentNumber) * -1));
    }


    public void percent(String currentNumber) {
        updateUI(sbTempResult.toString(), String.valueOf(Double.valueOf(currentNumber) * currentTempResult / 100));
    }

    public void backspace(String currentNumber) {
            activity.setResult(currentNumber.substring(0, currentNumber.length() - 1));
    }

    public void clear() {
        sbTempResult = new StringBuilder();
        activity.setResult("");
        activity.setTempResult("");
        currentTempResult = 0;
    }

    public void remove() {
        activity.setResult("");
    }

    public void result(String currentNumber) {
        currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
        sbTempResult.append(currentNumber).append(" = ").append(currentTempResult);
        operation = Operation.SUM;
        updateUI(sbTempResult.toString(), String.valueOf(currentTempResult - (int) currentTempResult < 0.00001 ? (int) currentTempResult : currentTempResult));
    }


    private void updateUI(String tempResult, String result) {
        activity.setTempResult(tempResult);
        activity.setResult(result);
    }
}



