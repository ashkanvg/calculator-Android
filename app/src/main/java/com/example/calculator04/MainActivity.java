package com.example.calculator04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView display;
    TextView display2;
    int dotFlag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView btnAC = (TextView) findViewById(R.id.btnAC);
        btnAC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                display = (TextView) findViewById(R.id.display);
                display.setText("0");
                display2 = (TextView) findViewById(R.id.display2);
                display2.setText("");
                dotFlag=0;
                return false;
            }
        });


        TextView btnDelete = (TextView) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display = (TextView) findViewById(R.id.display);
                String str = (String)display.getText();
                if(str.length()!=1){
                    str = str.substring(0,str.length()-1);
                }
                else if(str.length()==1){
                    str = "0";
                }

                display.setText(str);
            }
        });
        btnDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                display = (TextView) findViewById(R.id.display);
                display.setText("0");
                dotFlag=0;
                return true;
            }
        });

        TextView btn0 = (TextView) findViewById(R.id.btn0);
        btn0.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('0');
                return false;
            }
        });

        TextView btn1 = (TextView) findViewById(R.id.btn1);
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('1');
                return false;
            }
        });

        TextView btn2 = (TextView) findViewById(R.id.btn2);
        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('2');
                return false;
            }
        });

        TextView btn3 = (TextView) findViewById(R.id.btn3);
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('3');
                return false;
            }
        });

        TextView btn4 = (TextView) findViewById(R.id.btn4);
        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('4');
                return false;
            }
        });

        TextView btn5 = (TextView) findViewById(R.id.btn5);
        btn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('5');
                return false;
            }
        });

        TextView btn6 = (TextView) findViewById(R.id.btn6);
        btn6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('6');
                return false;
            }
        });

        TextView btn7 = (TextView) findViewById(R.id.btn7);
        btn7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('7');
                return false;
            }
        });

        TextView btn8 = (TextView) findViewById(R.id.btn8);
        btn8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('8');
                return false;
            }
        });

        TextView btn9 = (TextView) findViewById(R.id.btn9);
        btn9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('9');
                return false;
            }
        });

        TextView btnDot = (TextView) findViewById(R.id.btnDot);
        btnDot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('.');
                return false;
            }
        });

        TextView btnResult = (TextView) findViewById(R.id.btnResult);
        btnResult.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        TextView btnSum = (TextView) findViewById(R.id.btnSum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplay('+');
            }
        });

        TextView btnTaqsim = (TextView) findViewById(R.id.btnTaqsim);
        btnTaqsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplay('/');
            }
        });
        TextView btnTafrigh = (TextView) findViewById(R.id.btnTafrigh);
        btnTafrigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplay('-');
            }
        });
        TextView btnZarb = (TextView) findViewById(R.id.btnZarb);
        btnZarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplay('*');
            }
        });

        TextView btnOpenP = (TextView) findViewById(R.id.btnParantez2);
        btnOpenP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay('(');
                return false;
            }
        });

        TextView btnCloseP = (TextView) findViewById(R.id.btnParantez);
        btnCloseP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setDisplay(')');
                return false;
            }
        });

        /*
        ScrollView sv = (ScrollView) findViewById(R.id.scrollView1);
        sv.fullScroll(View.FOCUS_DOWN);
        */



        TextView btnEqual = (TextView) findViewById(R.id.btnResult);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });


    }



    protected void setDisplay (char n){
        display = (TextView) findViewById(R.id.display);
        String str = (String) display.getText();
        if(str.equals("0") && !(n == '.')){
            str = "";
        }
        if(n == '+' || n == '-' || n == '*' || n == '/'){
            if(str.endsWith(".")){
                str = str.substring(0,str.length()-1);
                if(!str.endsWith("+") && !str.endsWith("*") && !str.endsWith("/") && !str.endsWith("-")){
                    str+=n;
                    dotFlag = 0;
                }
            } else{
                if(!str.endsWith("+") && !str.endsWith("*") && !str.endsWith("/") && !str.endsWith("-") && !str.isEmpty() && !str.endsWith("(")){
                    str+=n;
                    dotFlag = 0;
                }
            }
        } else if(n == '.') {
            if (dotFlag == 0) {
                if (str.endsWith("+") || str.endsWith("*") || str.endsWith("/") || str.endsWith("-")  || str.endsWith("(") )  {
                    str += "0" + n;
                } else {
                    str += n;
                }
                dotFlag++;
            }
        } else if(n == '(') {
            if(!str.endsWith("+") && !str.endsWith("*") && !str.endsWith("/") && !str.endsWith("-") && !str.endsWith(".") && !str.isEmpty() && !str.endsWith("(")){
                str+="*"+n;
            }
            else{
                str+=n;
            }
        } else if(n == ')') {
            if (!str.contains("(")){
                Toast.makeText(this, "You have not opened a parentheses.", Toast.LENGTH_SHORT).show();
            } else {
                int counterOpen = 0;
                int counterClose = 0;
                for(int i = 0 ; i<str.length() ; i++){
                    if(str.charAt(i) == '('){
                        counterOpen++;
                    }
                    if(str.charAt(i) == ')'){
                        counterClose++;
                    }
                }
                if(counterClose<counterOpen){
                    if (str.endsWith("(")){
                        Toast.makeText(this, "The parentheses is empty. ", Toast.LENGTH_SHORT).show();
                    } else {
                        str += n;
                    }
                }
                else{
                    Toast.makeText(this, "Please open a parentheses.", Toast.LENGTH_SHORT).show();
                }

            }


        } else {
            str += n;
        }

        display.setText(str);
    }

    protected void showResult(){
        String str = (String) display.getText();
        int countOpen = 0, countClose = 0;
        for(int i = 0; i < str.length() ; i++){
            if(str.charAt(i) == '('){
                countOpen++;
            }
            if(str.charAt(i) == ')'){
                countClose++;
            }
        }
        if (countClose < countOpen){
            for (int i = 0; i < (countOpen - countClose) ; i++){
                str += ')';
            }
        }
        dotFlag = 1;
        Expression e = new Expression(str);
        e.calculate();
        String str2 = e.calculate()+"";
        display.setText(str2);

        display2 = (TextView) findViewById(R.id.display2);
        display2.setText(str+" = "+str2);
    }

}

