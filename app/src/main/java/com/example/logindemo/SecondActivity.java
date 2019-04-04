package com.example.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private enum operator
    {
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
    }

    TextView txtCalculations;
    TextView txtResults;
    private String currentNumber;
    private String NumberAtLeft;
    private String NumberAtRight;
    private operator currentOPerator;
    private int calculationResults;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        currentNumber="";
        calculationResults=0;
        calculationsString="";
        txtCalculations=findViewById(R.id.txtcalculation);
        txtResults=findViewById(R.id.txtResults);
        findViewById(R.id.btnequal).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn7).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn8).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn9).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btnplus).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn4).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn5).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn6).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn1).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn2).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn3).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btndivide).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btnsubtract).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btncancel).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btn0).setOnClickListener(SecondActivity.this);
        findViewById(R.id.btnmultiply).setOnClickListener(SecondActivity.this);

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnequal:
                operatorIsTapped(operator.EQUAL);
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnmultiply:
                operatorIsTapped(operator.MULTIPLY);
                calculationsString+=" * ";
                break;
            case R.id.btncancel:
                clearTapped();
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnsubtract:
                operatorIsTapped(operator.SUBTRACT);
                calculationsString+=" - ";
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btndivide:
                operatorIsTapped(operator.DIVIDE);
                calculationsString+=" / ";
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnplus:
                operatorIsTapped(operator.PLUS);
                calculationsString+=" + ";
                break;


        }
        txtCalculations.setText(calculationsString);
    }
    private void numberIsTapped(int tappedNumber)
    {
        currentNumber=currentNumber+String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
        calculationsString=currentNumber;
        txtCalculations.setText(calculationsString);
    }
    private void operatorIsTapped(operator tappedOperator)
    {
        if(currentOPerator!=null) {
            if (currentNumber != "") {
                NumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOPerator) {
                    case PLUS:
                        calculationResults = Integer.parseInt(NumberAtLeft) + Integer.parseInt(NumberAtRight);

                        break;
                    case DIVIDE:
                        calculationResults = Integer.parseInt(NumberAtLeft) / Integer.parseInt(NumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResults = Integer.parseInt(NumberAtLeft) - Integer.parseInt(NumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResults = Integer.parseInt(NumberAtLeft) * Integer.parseInt(NumberAtRight);
                        break;


                }
                NumberAtLeft = String.valueOf(calculationResults);
                txtResults.setText(NumberAtLeft);
                calculationsString = NumberAtLeft;

            }
        }
        else
        {
            NumberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOPerator=tappedOperator;
    }
    private void clearTapped()
    {
        NumberAtLeft="";
        NumberAtRight="";
        calculationResults=0;
        currentNumber="";
        currentOPerator=null;
        txtResults.setText("0");
        calculationsString="";
        txtCalculations.setText("0");
    }
}
