package com.example.carambula.caclulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.ViewDebug.trace;

public class MainActivity extends AppCompatActivity implements IMainActivity, View.OnClickListener {
    private TextView tvResult;
    private TextView tvTempResult;
    private Button bBackspace;
    private Button bClear;

    private Button bDivision;
    private Button bDifference;
    private Button bMultiply;
    private Button bSum;

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
    private boolean checkIfDouble;
    private String textOnFieldOfResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Log.wtf("myTag", Utils.trace(Thread.currentThread().getStackTrace()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewElements();
        checkIfDouble = false;
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
        bMultiply.setOnClickListener(this);
    }


    private void initViewElements() {
        tvResult = findViewById(R.id.tvResult);
        tvTempResult = findViewById(R.id.tvTempResult);
        bBackspace = findViewById(R.id.bBackspace);
        bClear = findViewById(R.id.bClear);
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
    public void onClick(View v) {
        textOnFieldOfResult = tvResult.getText().toString();
        switch (v.getId()) {
            case R.id.bBackspace:
                if (textOnFieldOfResult.length() != 0 && textOnFieldOfResult.charAt(tvResult.getText().toString().length() - 1) == '.') {
                    presenter.backspace(tvResult.getText().toString());
                    checkIfDouble = false;
                } else {
                    presenter.backspace(tvResult.getText().toString());
                }
                break;
            case R.id.bClear:
                presenter.clear();
                checkIfDouble = false;
                break;
            case R.id.bSum:
                presenter.sum(tvResult.getText().toString());
                checkIfDouble = false;
                break;
            case R.id.bDivision:
                presenter.division(tvResult.getText().toString());
                checkIfDouble = false;
                break;
            case R.id.bDifference:
                presenter.difference(tvResult.getText().toString());
                checkIfDouble = false;
                break;
            case R.id.bMultiply:
                presenter.multiply(tvResult.getText().toString());
                checkIfDouble = false;
                break;
            case R.id.bOne:
                tvResult.setText(tvResult.getText() + "1");
                break;
            case R.id.bTwo:
                tvResult.setText(tvResult.getText() + "2");
                break;
            case R.id.bThree:
                tvResult.setText(tvResult.getText() + "3");
                break;
            case R.id.bFour:
                tvResult.setText(tvResult.getText() + "4");
                break;
            case R.id.bFive:
                tvResult.setText(tvResult.getText() + "5");
                break;
            case R.id.bSix:
                tvResult.setText(tvResult.getText() + "6");
                break;
            case R.id.bSeven:
                tvResult.setText(tvResult.getText() + "7");
                break;
            case R.id.bEight:
                tvResult.setText(tvResult.getText() + "8");
                break;
            case R.id.bNine:
                tvResult.setText(tvResult.getText() + "9");
                break;
            case R.id.bZero:
                tvResult.setText(tvResult.getText() + "0");
                break;
            case R.id.bDot:
                if (checkIfDouble(textOnFieldOfResult) == false) {
                    tvResult.setText(tvResult.getText() + ".");
                    checkIfDouble = true;
                }
                break;
            case R.id.bResult:
                presenter.result(tvResult.getText().toString());
                break;
        }
    }

    private boolean checkIfDouble(String string) {
        for (int i = 0; i < string.length(); i++) {
            Log.wtf("Check_symbol", String.valueOf(textOnFieldOfResult.charAt(i)));
            /*switch (textOnFieldOfResult.charAt(i)) {
                case '.':
                    checkIfDouble = true;
                    break;
                default:
                    checkIfDouble = false;
            }*/
            if (textOnFieldOfResult.charAt(i) == '.') checkIfDouble = true;
        }
        Log.wtf("Check", String.valueOf(checkIfDouble));
        return checkIfDouble;
    }
}
