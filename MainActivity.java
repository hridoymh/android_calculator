package com.example.mymy;

import static java.lang.Math.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    String oldNum="";
    String newNum = "";
    String op ="";
    TextView ptv ;
    TextView stv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ptv = (TextView) findViewById(R.id.primary_viewId);
        stv = (TextView) findViewById(R.id.secondary_viewId);

    }
    public void number_clicked(View view) {
        switch (view.getId()){
            case R.id.b0:
                newNum+="0";
                break;
            case R.id.b1:
                newNum+="1";
                break;
            case R.id.b2:
                newNum+="2";
                break;
            case R.id.b3:
                newNum+="3";
                break;
            case R.id.b4:
                newNum+="4";
                break;
            case R.id.b5:
                newNum+="5";
                break;
            case R.id.b6:
                newNum+="6";
                break;
            case R.id.b7:
                newNum+="7";
                break;
            case R.id.b8:
                newNum+="8";
                break;
            case R.id.b9:
                newNum+="9";
                break;
            case R.id.point:
                newNum+=".";
                break;
            case R.id.plsmns:
                newNum = "-"+newNum;
                break;

        }
        ptv.setText(newNum);
    }
    public void op_clicked(View view) {
        oldNum = newNum;
        newNum = "";

        switch (view.getId()) {
            case R.id.plus:
                op = "+";
                break;
            case R.id.sub:
                op = "-";
                break;
            case R.id.mult:
                op = "*";
                break;
            case R.id.div:
                op = "/";
                break;
            case R.id.percent:
                op = "%";
                break;

        }
        stv.setText(op);
    }

    public void equalBtn(View view) {
        Double result=0.0;
        if(newNum=="" || oldNum=="" || op=="")
        {
            ptv.setText("error");
            newNum="";
            oldNum = "";
            op="";
        }
        else {
            switch (op) {
                case "+":
                    result = Double.parseDouble(oldNum) + Double.parseDouble(newNum);
                    break;
                case "-":
                    result = Double.parseDouble(oldNum) - Double.parseDouble(newNum);
                    break;
                case "*":
                    result = Double.parseDouble(oldNum) * Double.parseDouble(newNum);
                    break;
                case "/":
                    result = Double.parseDouble(oldNum) / Double.parseDouble(newNum);
                    break;
                case "%":
                    result = Double.parseDouble(oldNum) * Double.parseDouble(newNum) / 100.0;
                    break;

            }
            if(Double.toString(result).length()>10)
            {
                String temp = Double.toString(result);
                ptv.setText(temp.substring(0,10));
            }else {
                ptv.setText(Double.toString(result));
            }
        }
        stv.setText("");
        newNum = Double.toString(result);
        oldNum = "";
    }


    public void backspBtn(View view) {
        if(newNum.length()>0) {
            String temp = newNum.substring(0, newNum.length() - 1);
            newNum = temp;
            if(newNum.length()>10)
            {
                ptv.setText(newNum.substring(0,10));
            }
            else {
                ptv.setText(newNum);
            }
        }
    }

    public void ceBtn(View view) {
        newNum = "";
        ptv.setText(newNum);
    }

    public void cBtn(View view) {
        newNum="";
        oldNum="";
        ptv.setText(newNum);
        stv.setText("");
    }

    public void invBtn(View view) {
        if(newNum=="")
        {

        }
        else{
            Double res = 1.0/Double.parseDouble(newNum);
            newNum = Double.toString(res);
            if(newNum.length()>10)
            {
                ptv.setText(newNum.substring(0,10));
            }
            else {
                ptv.setText(newNum);
            }
        }
    }

    public void sqBtn(View view) {
        if(newNum=="")
        {

        }
        else{
            Double res = Math.pow(Double.parseDouble(newNum),2);
            newNum = Double.toString(res);
            if(newNum.length()>10)
            {
                ptv.setText(newNum.substring(0,10));
            }
            else {
                ptv.setText(newNum);
            }
        }
    }

    public void sqrtBtn(View view) {
        if(newNum=="")
        {

        }
        else{
            Double res = Math.sqrt(Double.parseDouble(newNum));
            newNum = Double.toString(res);
            if(newNum.length()>10)
            {
                ptv.setText(newNum.substring(0,10));
            }
            else {
                ptv.setText(newNum);
            }


        }
    }
}