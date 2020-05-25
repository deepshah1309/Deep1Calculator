package com.example.deepcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView e1;
    private TextView text;
    private double val1=Double.NaN;
    private double val2;
    private final char ADDITION='+';
    private final char MUL='x';
    private final char SUB='-';
    private final char DIVISION='/';
    private char action;
    private final char EQ='0';
    private Button ac,delete1,division1,t7,t8,t9,multiply,t4,t5,t6,subtraction,t1,t2,t3,add,zero,dot,answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(TextView) findViewById(R.id.edit1);
        text=(TextView)findViewById(R.id.text1);
        setupUIViews();
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(null);
                e1.setText(null);
            }
        });
        division1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                action=DIVISION;
                e1.setText(String.valueOf(val1)+'/');
                text.setText(null);
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'7');
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'8');
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'9');
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                action=MUL;
                e1.setText(String.valueOf(val1)+'x');
                text.setText(null);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'4');
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'5');
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'6');
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                action=SUB;
                e1.setText(String.valueOf(val1)+'-');
                text.setText("");
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'1');
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'2');
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'3');
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                action=ADDITION;
                e1.setText(String.valueOf(val1)+'+');
                text.setText(null);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'0');
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                action=EQ;
                e1.setText(e1.getText().toString()+String.valueOf(val2)+'='+String.valueOf(val1));

            }
        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().length()>0){
                    CharSequence name=text.getText().toString();
                    text.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1=Double.NaN;
                    val2=Double.NaN;
                    text.setText(null);
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString()+'.');
            }
        });
    }
    public void setupUIViews(){
        ac=(Button)findViewById(R.id.c1);
        delete1=(Button)findViewById(R.id.delete);
        division1=(Button)findViewById(R.id.division);
        t7=(Button)findViewById(R.id.b7);
        t8=(Button)findViewById(R.id.b8);
        t9=(Button)findViewById(R.id.b9);
        multiply=(Button)findViewById(R.id.mul);
        t4=(Button)findViewById(R.id.b4);
        t5=(Button)findViewById(R.id.b5);
        t6=(Button)findViewById(R.id.b6);
        subtraction=(Button)findViewById(R.id.sub);
        t1=(Button)findViewById(R.id.b1);
        t2=(Button)findViewById(R.id.b2);
        t3=(Button)findViewById(R.id.b3);
        add=(Button)findViewById(R.id.sum);
        zero=(Button)findViewById(R.id.b0);
        dot=(Button)findViewById(R.id.dot);
        answer=(Button)findViewById(R.id.result);
    }
    private void calculate(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(text.getText().toString());

            switch(action){
                case ADDITION:
                    val1=val1+val2;
                    break;
                case MUL:
                    val1=val1*val2;
                    break;
                case SUB:
                    val1=val1-val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                case EQ:
                    break;
            }
        }
        else{

            val1=Double.parseDouble(text.getText().toString());
            text.setText(text.getText().toString()+"");
        }
    }
}
