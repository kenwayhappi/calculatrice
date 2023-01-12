package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdiv,bplus,bmin,bequal,bdot,bsin,btan,bcos,bmul,bln,blog,bc,bac,bb1,bb2,bfact,bsquare,bsqrt,binv,bpi;
    TextView tvmain,tvsec;
    String pi = "3,14159265";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bsin = findViewById(R.id.bsin);
        bcos = findViewById(R.id.bcos);
        btan = findViewById(R.id.btan);
        bln = findViewById(R.id.bln);
        blog = findViewById(R.id.blog);
        bsqrt = findViewById(R.id.bsqrt);
        bsquare = findViewById(R.id.bsquare);
        bdiv = findViewById(R.id.bdiv);
        bplus = findViewById(R.id.bplus);
        bmin = findViewById(R.id.bmin);
        bdot = findViewById(R.id.bdot);
        bequal = findViewById(R.id.bequal);
        bmul = findViewById(R.id.bmul);
        binv = findViewById(R.id.binv);
        bfact = findViewById(R.id.bfact);
        bac = findViewById(R.id.bac);
        bc = findViewById(R.id.bc);
        bb1 = findViewById(R.id.bb1);
        bpi =findViewById(R.id.bpi);
        bb2 = findViewById(R.id.bb2);

        tvmain = findViewById(R.id.tvmain);
        tvsec = findViewById(R.id.tvsec);

        //onclick listenners
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"0");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+".");
            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText("");
                tvsec.setText("");
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val= tvmain.getText().toString();
                val = val.substring(0,val.length() - 1);
                tvmain.setText(val);
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"+");
            }
        });
        bmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"-");
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"*");
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+":");
            }
        });
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val= tvmain.getText().toString();
                double r = Math.sqrt(Double.parseDouble(val));
                tvmain.setText(String.valueOf(r));
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"(");
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+")");
            }
        });
        bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvsec.setText(bpi.getText());
                tvmain.setText(tvmain.getText()+pi);
            }
        });
        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"sin");
            }
        });
        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"cos");
            }
        });
        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"tan");
            }
        });
        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"^"+"(-1)");
            }
        });
        bfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(tvmain.getText().toString());
                int fact = fac(val);
                tvmain.setText(String.valueOf(fact));
                tvsec.setText(val+"!");
            }
        });
        bsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d = Double.parseDouble(tvmain.getText().toString());
                double square = d*d;
                tvmain.setText(String.valueOf(square));
                tvsec.setText(d+"²");
            }
        });
        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"ln");
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"log");
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                String replaces = val.replace(':','/');
                double result = eval(replaces);
                tvmain.setText(String.valueOf(result));
                tvsec.setText(val);

            }
        });
    }

    //factoriel fonction
    int fac(int n){
        return (n==1 || n==0) ? 1 : n*fac(n-1);
    }
    //autre fonction
    public static double eval(final String str){
        return new Object(){
            int pos = -1,ch;

            void nextChar(){
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
            boolean eat(int charToEat){
                while (ch ==' ')nextChar();
                if (ch == charToEat){
                    nextChar();

                    return true;
                }

                return false;
            }

            double parse(){
                nextChar();
                double x = parseExpresion();
                if(pos<str.length()) throw new RuntimeException("impossible :" + (char)ch);
                return x;
            }

            //a
            // a
            //a
            //a
            //a
            //a
            double parseExpresion(){
                double x = parseTerm();
                for(;;){
                    if(eat('+')) x += parseTerm();
                    else if(eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm(){
                double x = parseFactor();
                for(;;){
                    if(eat('*')) x *= parseFactor();
                    else if(eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor(){
                if(eat('+')) return parseFactor();
                if(eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if(eat('(')) {
                    x = parseExpresion();
                    eat(')');
                }else if ((ch >= '0' && ch<='9') || ch == '.'){
                    while ((ch >= '0' && ch<='9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }else if (ch >= 'a' && ch<='z'){
                    while (ch >= 'a' && ch<='z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if(func.equals("sqrt")) x = Math.sqrt(x);
                    else if(func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if(func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if(func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if(func.equals("log")) x = Math.log10(x);
                    else if(func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("fonction non definie : " + func);
                }else{
                    throw new RuntimeException("indefinie : " +(char)ch);
                }

                if(eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }
}