package com.example.carambula.caclulator;

import android.util.Log;

public class MainActivityPresenter {
    private IMainActivity activity;
    private double currentResult;
    private double currentTempResult;


    public MainActivityPresenter(IMainActivity activity) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        this.activity = activity;
        currentResult = 0;
        currentTempResult = 0;
    }

    public void sum(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("")) {
            currentResult += Double.valueOf(currentNumber);
            currentTempResult = currentResult;
            activity.setResult("");
            activity.setTempResult("= " + String.valueOf(currentTempResult));
            //todo 2.2 + 1.1 = 3.3000003 WTF????
        }
    }

    public void division(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("")) {
            currentResult /= Double.valueOf(currentNumber);
            currentTempResult = currentResult;
            activity.setResult("");
            activity.setTempResult("= " + String.valueOf(currentTempResult));
            //todo need to check for bugs
        }
    }

    public void difference(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("")) {
            currentResult -= Double.valueOf(currentNumber);
            currentTempResult = currentResult;
            activity.setResult("");
            activity.setTempResult("= " + String.valueOf(currentTempResult));
        }
    }

    public void multiply(String currentNumber) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        if (!currentNumber.equals("")) {
            currentResult *= Double.valueOf(currentNumber);
            currentTempResult = currentResult;
            activity.setResult("");
            activity.setTempResult("= " + String.valueOf(currentTempResult));
            //todo need to check for bugs
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
        activity.setResult("");
        activity.setTempResult("0");
        currentResult = 0;
        currentTempResult = 0;
    }

    public void result() {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        activity.setResult(String.valueOf(currentTempResult));
        activity.setTempResult("");
    }
}



