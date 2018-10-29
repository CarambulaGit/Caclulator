package com.example.carambula.caclulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements IMainActivity, View.OnClickListener {
    private TextView tvResult;
    private TextView tvTempResult;
    private Button bBackspace;
    private Button bClear;
    private Button bRemoveCurrentNumber;

    private Button bDivision;
    private Button bDifference;
    private Button bMultiply;
    private Button bSum;
    private Button bPercent;
    private Button bReverse;
    private Button bSquare;
    private Button bRadical;
    private Button bSignChanger;

    private Button bOne;
    private Button bTwo;
    private Button bThree;
    private Button bFour;
    private Button bFive;
    private Button bSix;
    private Button bSeven;
    private Button bEight;
    private Button bNine;
    private Button bZero;

    private Button bDot;
    private Button bResult;

    private MainActivityPresenter presenter;
    private boolean isResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewElements();
        presenter = new MainActivityPresenter(this);
        addOnClickListenerForButton();
    }

    private void addOnClickListenerForButton() {
        bBackspace.setOnClickListener(this);
        bClear.setOnClickListener(this);
        bOne.setOnClickListener(this);
        bTwo.setOnClickListener(this);
        bThree.setOnClickListener(this);
        bSum.setOnClickListener(this);
        bFour.setOnClickListener(this);
        bFive.setOnClickListener(this);
        bSix.setOnClickListener(this);
        bDifference.setOnClickListener(this);
        bSeven.setOnClickListener(this);
        bEight.setOnClickListener(this);
        bNine.setOnClickListener(this);
        bDivision.setOnClickListener(this);
        bZero.setOnClickListener(this);
        bDot.setOnClickListener(this);
        bResult.setOnClickListener(this);
        bPercent.setOnClickListener(this);
        bReverse.setOnClickListener(this);
        bSquare.setOnClickListener(this);
        bRadical.setOnClickListener(this);
        bRemoveCurrentNumber.setOnClickListener(this);
        bSignChanger.setOnClickListener(this);
        bMultiply.setOnClickListener(this);
    }


    private void initViewElements() {
        tvResult = findViewById(R.id.tvResult);
        tvTempResult = findViewById(R.id.tvTempResult);
        bBackspace = findViewById(R.id.bBackspace);
        bClear = findViewById(R.id.bClear);
        bRemoveCurrentNumber = findViewById(R.id.bRemoveCurrentNumber);
        bOne = findViewById(R.id.bOne);
        bTwo = findViewById(R.id.bTwo);
        bThree = findViewById(R.id.bThree);
        bSum = findViewById(R.id.bSum);
        bFour = findViewById(R.id.bFour);
        bFive = findViewById(R.id.bFive);
        bSix = findViewById(R.id.bSix);
        bDifference = findViewById(R.id.bDifference);
        bSeven = findViewById(R.id.bSeven);
        bEight = findViewById(R.id.bEight);
        bNine = findViewById(R.id.bNine);
        bDivision = findViewById(R.id.bDivision);
        bZero = findViewById(R.id.bZero);
        bDot = findViewById(R.id.bDot);
        bResult = findViewById(R.id.bResult);
        bMultiply = findViewById(R.id.bMultiply);
        bPercent = findViewById(R.id.bPercent);
        bReverse = findViewById(R.id.bReverse);
        bSquare = findViewById(R.id.bSquare);
        bRadical = findViewById(R.id.bRadical);
        bSignChanger = findViewById(R.id.bSignChanger);
    }

    @Override
    public void setTempResult(String tempResult) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        tvTempResult.setText(tempResult);
    }

    @Override
    public void setResult(String result) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        tvResult.setText(result);
    }

    @Override
    public void clearResult() {
        setResult("");
        setTempResult("");
    }

    @Override
    public void log(String log) {
        Log.wtf("myTAG", log);
    }

    @Override
    public void onClick(View v) {
        String textOnFieldOfResult = tvResult.getText().toString();
        switch (v.getId()) {
            case R.id.bBackspace:
                if (textOnFieldOfResult.length() != 0 && textOnFieldOfResult.charAt(tvResult.getText().toString().length() - 1) == '.') {
                    presenter.backspace(tvResult.getText().toString());
                } else {
                    presenter.backspace(tvResult.getText().toString());
                }
                break;
            case R.id.bClear:
                presenter.clear();
                break;
            case R.id.bRemoveCurrentNumber:
                presenter.remove();
                break;
            case R.id.bSum:
                presenter.sum(tvResult.getText().toString());
                break;
            case R.id.bDivision:
                presenter.division(tvResult.getText().toString());
                break;
            case R.id.bDifference:
                presenter.difference(tvResult.getText().toString());
                break;
            case R.id.bMultiply:
                presenter.multiply(tvResult.getText().toString());
                break;
            case R.id.bReverse:
                presenter.reverse(tvResult.getText().toString());
                break;
            case R.id.bSquare:
                presenter.square(tvResult.getText().toString());
                break;
            case R.id.bRadical:
                presenter.radical(tvResult.getText().toString());
                break;
            case R.id.bPercent:
                presenter.percent(tvResult.getText().toString());
                break;
            case R.id.bSignChanger:
                presenter.signChanger(tvResult.getText().toString());
                break;
            case R.id.bOne:
                clickOnNumber("1");
                break;
            case R.id.bTwo:
                clickOnNumber("2");
                break;
            case R.id.bThree:
                clickOnNumber("3");
                break;
            case R.id.bFour:
                clickOnNumber("4");
                break;
            case R.id.bFive:
                clickOnNumber("5");
                break;
            case R.id.bSix:
                clickOnNumber("6");
                break;
            case R.id.bSeven:
                clickOnNumber("7");
                break;
            case R.id.bEight:
                clickOnNumber("8");
                break;
            case R.id.bNine:
                clickOnNumber("9");
                break;
            case R.id.bZero:
                clickOnNumber("0");
                break;
            case R.id.bDot:
                if (isResult) {
                    clearResult();
                    isResult = false;
                }
                if (tvResult.getText().toString().contains(".")) return;
                tvResult.setText(tvResult.getText() + ".");
                break;
            case R.id.bResult:
                presenter.result(tvResult.getText().toString());
                isResult = true;
                break;
        }
    }

    private void clickOnNumber(String number) {
        log("isResult " + isResult);
        if (isResult) {
            clearResult();
            presenter.clear();
            isResult = false;
            tvResult.setText(number);
        } else {
            tvResult.setText(tvResult.getText() + number);
        }
    }
}
