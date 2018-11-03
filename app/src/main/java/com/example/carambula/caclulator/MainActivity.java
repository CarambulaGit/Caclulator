package com.example.carambula.caclulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements IMainActivity {
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.tvTempResult)
    TextView tvTempResult;
    @BindView(R.id.sType)
    Switch sType;

    private MainActivityPresenter presenter;
    public boolean isResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this);
    }

    @Override
    public void setTempResult(String tempResult) {
        tvTempResult.setText(tempResult);
    }

    @Override
    public void setResult(String result) {
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

    @OnClick(R.id.bBackspace)
    public void bBackspaceOnClick(View view) {
        presenter.backspace(tvResult.getText().toString());
    }

    @OnClick(R.id.bClear)
    public void bClearOnClick(View view) {
        presenter.clear();
    }

    @OnClick(R.id.bRemoveCurrentNumber)
    public void bRemoveCurrentNumberOnClick(View view) {
        presenter.remove();
    }

    @OnClick(R.id.bSum)
    public void bSumOnClick(View view) {
        isResult = presenter.sum(tvResult.getText().toString());
    }

    @OnClick(R.id.bDivision)
    public void bDivisionOnClick(View view) {
        isResult = presenter.division(tvResult.getText().toString());
    }

    @OnClick(R.id.bDifference)
    public void bDifferenceOnClick(View view) {
        isResult = presenter.difference(tvResult.getText().toString());
    }

    @OnClick(R.id.bMultiply)
    public void bMultiplyOnClick(View view) {
        isResult = presenter.multiply(tvResult.getText().toString());
    }

    @OnClick(R.id.bReverse)
    public void bReverseOnClick(View view) {
        isResult = presenter.reverse(tvResult.getText().toString());
    }

    @OnClick(R.id.bSquare)
    public void bSquareOnClick(View view) {
        isResult = presenter.square(tvResult.getText().toString());
    }

    @OnClick(R.id.bRadical)
    public void bRadicalOnClick(View view) {
        isResult = presenter.radical(tvResult.getText().toString());
    }

    @OnClick(R.id.bPercent)
    public void bPercentOnClick(View view) {
        isResult = presenter.percent(tvResult.getText().toString());
    }

    @OnClick(R.id.bSignChanger)
    public void bSignChangerOnClick(View view) {
        isResult = presenter.signChanger(tvResult.getText().toString());
    }

    @OnClick(R.id.bOne)
    public void bOneOnClick(View view) {
        clickOnNumber("1");
    }

    @OnClick(R.id.bTwo)
    public void bTwoOnClick(View view) {
        clickOnNumber("2");
    }

    @OnClick(R.id.bThree)
    public void bThreeOnClick(View view) {
        clickOnNumber("3");
    }

    @OnClick(R.id.bFour)
    public void bFourOnClick(View view) {
        clickOnNumber("4");
    }

    @OnClick(R.id.bFive)
    public void bFiveOnClick(View view) {
        clickOnNumber("5");
    }

    @OnClick(R.id.bSix)
    public void bSixOnClick(View view) {
        clickOnNumber("6");
    }

    @OnClick(R.id.bSeven)
    public void bSevenOnClick(View view) {
        clickOnNumber("7");
    }

    @OnClick(R.id.bEight)
    public void bEightOnClick(View view) {
        clickOnNumber("8");
    }

    @OnClick(R.id.bNine)
    public void bNineOnClick(View view) {
        clickOnNumber("9");
    }

    @OnClick(R.id.bZero)
    public void bZeroOnClick(View view) {
        clickOnNumber("0");
    }

    @OnClick(R.id.bDot)
    public void bDotOnClick(View view) {
        if (isResult) {
            clearResult();
            isResult = false;
        }
        if (tvResult.getText().toString().contains(".")) return;
        tvResult.setText(tvResult.getText() + ".");
    }

    @OnClick(R.id.bResult)
    public void bResultOnClick(View view) {
        presenter.result(tvResult.getText().toString());
        isResult = true;
    }

    @OnClick(R.id.sType)
    public void sTypeOnClick(View view) {
        if (sType.isChecked()) {
            setContentView(R.layout.advanced_caclulator_linearlayout);
            presenter = new MainActivityPresenter(this);
        } else {
            setContentView(R.layout.activity_main);
            presenter = new MainActivityPresenter(this);
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
