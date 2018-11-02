package com.example.carambula.caclulator;


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

    public boolean sum(String currentNumber) {
        try {
            sbTempResult.append(currentNumber).append(" + ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.SUM;
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean division(String currentNumber) {
        try {
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.DIVISION;
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean difference(String currentNumber) {
        try {
            sbTempResult.append(currentNumber).append(" - ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.DIFFERENCE;
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean multiply(String currentNumber) {
        try {
            sbTempResult.append(currentNumber).append(" * ");
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            updateUI(sbTempResult.toString(), "");
            operation = Operation.MULTIPLY;
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean reverse(String currentNumber) {
        try {
            updateUI(sbTempResult.toString(), String.valueOf(1 / Double.valueOf(currentNumber)));
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean square(String currentNumber) {
        try {
            updateUI(sbTempResult.toString(), String.valueOf(Math.pow(Double.valueOf(currentNumber), 2)));
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean radical(String currentNumber) {
        try {
            updateUI(sbTempResult.toString(), String.valueOf(Math.pow(Double.valueOf(currentNumber), 0.5)));
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public boolean signChanger(String currentNumber) {
        try {
            updateUI(sbTempResult.toString(), String.valueOf(Double.valueOf(currentNumber) * -1));
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }


    public boolean percent(String currentNumber) {
        try {
            updateUI(sbTempResult.toString(), String.valueOf(Double.valueOf(currentNumber) * currentTempResult / 100));
            return false;
        } catch (Exception e) {
            activity.setResult("Error");
            return true;
        }
    }

    public void backspace(String currentNumber) {
        try {
            activity.setResult(currentNumber.substring(0, currentNumber.length() - 1));
        } catch (Exception e) {
        }
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
        try {
            currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
            sbTempResult.append(currentNumber).append(" = ").append(currentTempResult);
            operation = Operation.SUM;
            updateUI(sbTempResult.toString(), String.valueOf(currentTempResult));
        } catch (Exception e) {
            activity.setResult("Error");
        }
    }


    private void updateUI(String tempResult, String result) {
        activity.setTempResult(tempResult);
        activity.setResult(result);
    }
}



