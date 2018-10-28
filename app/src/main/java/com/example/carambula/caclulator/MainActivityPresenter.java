package com.example.carambula.caclulator;


import android.util.Log;

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


    public MainActivityPresenter(IMainActivity activity) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        this.activity = activity;
        currentResult = 0;
        currentTempResult = 0;
        sbTempResult = new StringBuilder();
    }

    public void sum(String currentNumber) {
        Log.wtf("myTAG", "currentTempResult = " + currentTempResult);
        sbTempResult.append(currentNumber).append(" + ");
        currentTempResult += Double.valueOf(currentNumber);
        updateUI(sbTempResult.toString(), "");
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
            if (lastActionIsMultiply) {
                currentResult *= Double.valueOf(currentNumber);
                currentTempResult = currentResult;
                activity.setResult("");
                activity.setTempResult("= " + String.valueOf(currentTempResult));
            } else {
                if (lastActionIsDifference) {
                    currentResult -= Double.valueOf(currentNumber);
                    currentTempResult = currentResult;
                    activity.setResult("");
                    activity.setTempResult("= " + String.valueOf(currentTempResult));
                } else {
                    if (lastActionIsSum) {
                        currentResult += Double.valueOf(currentNumber);
                        currentTempResult = currentResult;
                        activity.setResult("");
                        activity.setTempResult("= " + String.valueOf(currentTempResult));
                    } else {
                        if (lastActionIsDivision) {
                            currentResult /= Double.valueOf(currentNumber);
                            currentTempResult = currentResult;
                            activity.setResult("");
                            activity.setTempResult("= " + String.valueOf(currentTempResult));
                        } else {
                            if (lastActionIsResult) {
                                currentTempResult = currentResult;
                                activity.setResult("");
                                activity.setTempResult("= " + String.valueOf(currentTempResult));
                            } else {
                                currentResult += Double.valueOf(currentNumber);
                                currentTempResult = currentResult;
                                activity.setResult("");
                                activity.setTempResult("= " + String.valueOf(currentTempResult));
                            }
                        }
                    }
                }
            }
            lastActionIsDivision = true;
            lastActionIsSum = false;
            lastActionIsDifference = false;
            lastActionIsMultiply = false;
            lastActionIsResult = false;
        }
    }

    public void difference(String currentNumber) {
        Log.wtf("Action", String.valueOf(lastActionIsDivision) + " division");
        Log.wtf("Action", String.valueOf(lastActionIsDifference) + " difference");
        Log.wtf("Action", String.valueOf(lastActionIsMultiply) + " multiply");
        Log.wtf("Action", String.valueOf(lastActionIsSum) + " sum");
        Log.wtf("Action", " ");
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            if (lastActionIsMultiply) {
                Log.wtf("Action", "Step 1");
                currentResult *= Double.valueOf(currentNumber);
                currentTempResult = currentResult;
                activity.setResult("");
                activity.setTempResult("= " + String.valueOf(currentTempResult));
            } else {
                if (lastActionIsDifference) {
                    Log.wtf("Action", "Step 2");
                    currentResult -= Double.valueOf(currentNumber);
                    currentTempResult = currentResult;
                    activity.setResult("");
                    activity.setTempResult("= " + String.valueOf(currentTempResult));
                } else {
                    if (lastActionIsSum) {
                        Log.wtf("Action", "Step 3");
                        currentResult += Double.valueOf(currentNumber);
                        currentTempResult = currentResult;
                        activity.setResult("");
                        activity.setTempResult("= " + String.valueOf(currentTempResult));
                    } else {
                        if (lastActionIsDivision) {
                            currentResult /= Double.valueOf(currentNumber);
                            currentTempResult = currentResult;
                            activity.setResult("");
                            activity.setTempResult("= " + String.valueOf(currentTempResult));
                        } else {
                            if (lastActionIsResult) {
                                currentTempResult = currentResult;
                                activity.setResult("");
                                activity.setTempResult("= " + String.valueOf(currentTempResult));
                            } else {
                                currentResult += Double.valueOf(currentNumber);
                                currentTempResult = currentResult;
                                activity.setResult("");
                                activity.setTempResult("= " + String.valueOf(currentTempResult));
                            }
                        }
                    }
                }
            }
            lastActionIsDifference = true;
            lastActionIsDivision = false;
            lastActionIsSum = false;
            lastActionIsMultiply = false;
            lastActionIsResult = false;
        }
    }

    public void multiply(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("") && !currentNumber.equals(".")) {
            if (lastActionIsMultiply) {
                currentResult *= Double.valueOf(currentNumber);
                currentTempResult = currentResult;
                activity.setResult("");
                activity.setTempResult("= " + String.valueOf(currentTempResult));
            } else {
                if (lastActionIsDifference) {
                    currentResult -= Double.valueOf(currentNumber);
                    currentTempResult = currentResult;
                    activity.setResult("");
                    activity.setTempResult("= " + String.valueOf(currentTempResult));
                } else {
                    if (lastActionIsSum) {
                        currentResult += Double.valueOf(currentNumber);
                        currentTempResult = currentResult;
                        activity.setResult("");
                        activity.setTempResult("= " + String.valueOf(currentTempResult));
                    } else {
                        if (lastActionIsDivision) {
                            currentResult /= Double.valueOf(currentNumber);
                            currentTempResult = currentResult;
                            activity.setResult("");
                            activity.setTempResult("= " + String.valueOf(currentTempResult));
                        } else {
                            if (lastActionIsResult) {
                                currentTempResult = currentResult;
                                activity.setResult("");
                                activity.setTempResult("= " + String.valueOf(currentTempResult));
                            } else {
                                currentResult += Double.valueOf(currentNumber);
                                currentTempResult = currentResult;
                                activity.setResult("");
                                activity.setTempResult("= " + String.valueOf(currentTempResult));
                            }
                        }
                    }
                }
            }
            lastActionIsMultiply = true;
            lastActionIsDifference = false;
            lastActionIsDivision = false;
            lastActionIsSum = false;
            lastActionIsResult = false;
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
        currentResult = 0;
        currentTempResult = 0;
        lastActionIsMultiply = false;
        lastActionIsDifference = false;
        lastActionIsDivision = false;
        lastActionIsSum = false;
    }

    public void result(String currentNumber) {
        sbTempResult.append(currentNumber);
        currentTempResult += Double.valueOf(currentNumber);
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



