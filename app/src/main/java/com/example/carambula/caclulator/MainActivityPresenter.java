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


    public MainActivityPresenter(IMainActivity activity) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        this.activity = activity;
        currentTempResult = 0;
        operation = Operation.SUM;
        sbTempResult = new StringBuilder();
    }

    public void sum(String currentNumber) {
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" + ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.SUM;
        }
    }

    public void division(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.DIVISION;
        }
    }

    public void difference(String currentNumber) {
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.DIFFERENCE;
        }
    }

    public void multiply(String currentNumber) {
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.MULTIPLY;
        }
    }

    public void backspace(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("")) {
            activity.setResult(currentNumber.substring(0, currentNumber.length() - 1));
        }
    }

    public void clear() {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        sbTempResult = new StringBuilder();
        activity.setResult("");
        activity.setTempResult("");
        currentTempResult = 0;
    }

    public void result(String currentNumber) {
        if (!currentNumber.equals(".")) {
            Log.wtf("myTAG", "" + currentTempResult + "   " + currentNumber);
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            sbTempResult.append(currentNumber + " = " + currentTempResult);
            updateUI(sbTempResult.toString(), String.valueOf(currentTempResult - (int) currentTempResult < 0.00000000001 ? (int) currentTempResult : currentTempResult));
        }
    }

    private void updateUI(String tempResult, String result) {
        activity.setTempResult(tempResult);
        activity.setResult(result);
    }
}



