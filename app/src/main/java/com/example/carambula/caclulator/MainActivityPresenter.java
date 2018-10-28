package com.example.carambula.caclulator;


import android.util.Log;

import java.util.Spliterator;

public class MainActivityPresenter {
    private IMainActivity activity;
    private double currentResult;
    private double currentTempResult;
    private boolean lastActionIsSum;
    private boolean lastActionIsDifference;
    private boolean lastActionIsMultiply;
    private boolean lastActionIsDivision;
    private boolean lastActionIsResult;
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
        currentResult = 0;
        currentTempResult = 0;
        sbTempResult = new StringBuilder();
    }

    public void sum(String currentNumber) {
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" + ");
            currentTempResult += Double.valueOf(currentNumber);
            updateUI(sbTempResult.toString(), "");
            operation = Operation.SUM;
        }
    }

//    public void sum(String currentNumber) {
//        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
//        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
//            if (lastActionIsMultiply) {
//                currentResult *= Double.valueOf(currentNumber);
//                currentTempResult = currentResult;
//                activity.setResult("");
//                activity.setTempResult("= " + String.valueOf(currentTempResult));
//            } else {
//                if (lastActionIsDifference) {
//                    currentResult -= Double.valueOf(currentNumber);
//                    currentTempResult = currentResult;
//                    activity.setResult("");
//                    activity.setTempResult("= " + String.valueOf(currentTempResult));
//                } else {
//                    if (lastActionIsSum) {
//                        currentResult += Double.valueOf(currentNumber);
//                        currentTempResult = currentResult;
//                        activity.setResult("");
//                        activity.setTempResult("= " + String.valueOf(currentTempResult));
//                    } else {
//                        if (lastActionIsDivision) {
//                            currentResult /= Double.valueOf(currentNumber);
//                            currentTempResult = currentResult;
//                            activity.setResult("");
//                            activity.setTempResult("= " + String.valueOf(currentTempResult));
//                        } else {
//                            if (lastActionIsResult) {
//                                currentTempResult = currentResult;
//                                activity.setResult("");
//                                activity.setTempResult("= " + String.valueOf(currentTempResult));
//                            } else {
//                                currentResult += Double.valueOf(currentNumber);
//                                currentTempResult = currentResult;
//                                activity.setResult("");
//                                activity.setTempResult("= " + String.valueOf(currentTempResult));
//                            }
//                        }
//                    }
//                }
//            }
//            lastActionIsSum = true;
//            lastActionIsDifference = false;
//            lastActionIsDivision = false;
//            lastActionIsMultiply = false;
//            lastActionIsResult = false;
//        }
//    }

    public void division(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult /= Double.valueOf(currentNumber);
            updateUI(sbTempResult.toString(), "");
            operation = Operation.DIVISION;
        }
    }

    public void difference(String currentNumber) {
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult -= Double.valueOf(currentNumber);
            updateUI(sbTempResult.toString(), "");
            operation = Operation.DIFFERENCE;
        }
    }

    public void multiply(String currentNumber) {
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
            sbTempResult.append(currentNumber).append(" / ");
            currentTempResult *= Double.valueOf(currentNumber);
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
        currentResult = 0;
        currentTempResult = 0;
    }

    public void result(String currentNumber) {

        Log.wtf("myTAG","" + currentTempResult +"   " + currentNumber);
        currentTempResult = operation.action(currentTempResult, Double.valueOf(currentNumber));
        sbTempResult.append(currentNumber + " = " + currentTempResult);
        updateUI(sbTempResult.toString(), String.valueOf(currentTempResult - (int) currentTempResult < 0.00000000001 ? (int) currentTempResult : currentTempResult));
    }

    private void updateUI(String tempResult, String result) {
        activity.setTempResult(tempResult);
        activity.setResult(result);
    }


//    public void result(String currentNumber) {
//        Log.wtf("myTag", String.valueOf(lastActionIsDivision) + " division");
//        Log.wtf("myTag", String.valueOf(lastActionIsDifference) + " difference");
//        Log.wtf("myTag", String.valueOf(lastActionIsMultiply) + " multiply");
//        Log.wtf("myTag", String.valueOf(lastActionIsSum) + " sum");
//        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
//            if (lastActionIsSum) {
//                currentResult += Double.valueOf(currentNumber);
//                currentTempResult = currentResult;
//                activity.setResult("");
//                activity.setTempResult("= " + String.valueOf(currentTempResult));
//            } else {
//                if (lastActionIsDivision) {
//                    currentResult /= Double.valueOf(currentNumber);
//                    currentTempResult = currentResult;
//                    activity.setResult("");
//                    activity.setTempResult("= " + String.valueOf(currentTempResult));
//                } else {
//                    if (lastActionIsDifference) {
//                        currentResult -= Double.valueOf(currentNumber);
//                        currentTempResult = currentResult;
//                        activity.setResult("");
//                        activity.setTempResult("= " + String.valueOf(currentTempResult));
//                    } else {
//                        if (lastActionIsMultiply) {
//                            currentResult *= Double.valueOf(currentNumber);
//                            currentTempResult = currentResult;
//                            activity.setResult("");
//                            activity.setTempResult("= " + String.valueOf(currentTempResult));
//                        }
//                    }
//                }
//            }
//        }
//        activity.setResult(String.valueOf(currentTempResult));
//        activity.setTempResult("");
//        lastActionIsResult = true;
//        lastActionIsMultiply = false;
//        lastActionIsDifference = false;
//        lastActionIsDivision = false;
//        lastActionIsSum = false;
//    }
}



