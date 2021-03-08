package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String record_str = "";
    private double result = 0;
    private ArrayList<String> equal = new ArrayList<>();

    // 멤버 메서드 - Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 멤버 메서드
    public void clickFunc(View v) {
        // 멤버 변수
        TextView record = findViewById(R.id.record);
        TextView current = findViewById(R.id.current);

        if(v.getId() == R.id.btn_del) {  //전체 삭제
            record_str = "";
            result = 0;
            current.setText("0");
            record.setText("");
        }
        else if(v.getId() == R.id.btn_plus) {  //덧셈
            if(record_str.length() == 0 || record_str.endsWith("+") || record_str.endsWith("-") || record_str.endsWith("*") || record_str.endsWith("/")) {
                Toast.makeText(MainActivity.this, "연산자를 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            current.setText("+");
            record_str += current.getText();
            record.setText(record_str);
        }
        else if(v.getId() == R.id.btn_minus) {  //뺄셈
            if(record_str.endsWith("+") || record_str.endsWith("-") || record_str.endsWith("*") || record_str.endsWith("/")) {  // 뺄셈은 음수값으로 시작하는 것들도 있기에 처음부터 올 수 있음
                Toast.makeText(MainActivity.this, "연산자를 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            current.setText("-");
            record_str += current.getText();
            record.setText(record_str);
        }
        else if(v.getId() == R.id.btn_multi) {  //곱셈
            if(record_str.length() == 0 || record_str.endsWith("+") || record_str.endsWith("-") || record_str.endsWith("*") || record_str.endsWith("/")) {
                Toast.makeText(MainActivity.this, "연산자를 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            current.setText("*");
            record_str += current.getText();
            record.setText(record_str);
        }
        else if(v.getId() == R.id.btn_divide) {  //나눗셈
            if(record_str.length() == 0 || record_str.endsWith("+") || record_str.endsWith("-") || record_str.endsWith("*") || record_str.endsWith("/")) {
                Toast.makeText(MainActivity.this, "연산자를 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            current.setText("/");
            record_str += current.getText();
            record.setText(record_str);
        }
        else if(v.getId() == R.id.btn_equal) {  //결과
            if(record_str.length() == 0 || record_str.endsWith("+") || record_str.endsWith("-") || record_str.endsWith("*") || record_str.endsWith("/")) {
                Toast.makeText(MainActivity.this, "연산 결과를 출력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            calculate();
            current.setText(Double.toString(result));
        }
        else {  //숫자 클릭(0~9)
            Button btn = (Button)v;
            String str = btn.getText().toString();

            current.setText(str);
            record_str += current.getText();
            record.setText(record_str);
        }
    }  // clickFunc()

    public void calculate() {
        equal.clear();
        String number = "";

        for(int i = 0; i < record_str.length(); i++) {
            char ch = record_str.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                equal.add(number);
                number = "";
                equal.add(ch + "");
            }
            else {
                number += ch;
            }
        }  // 계산식에서 연속된 숫자를 합쳐서 문자로 다시 저장
        equal.add(number);
        equal.remove("");  // 음수(-)로 시작하는 값도 계산할 수 있도록 함

        double prev = 0;
        double curr = 0;
        String mode = "";

        for(int i = 0; i < equal.size(); i++) {  // 곱셈 나눗셈을 먼저 계산
            String s = equal.get(i);

            if(s.equals("+")) {
                mode = "add";
            }
            else if(s.equals("-")) {
                mode = "minus";
            }
            else if(s.equals("*")) {
                mode = "multi";
            }
            else if(s.equals("/")) {
                mode = "divide";
            }
            else {
                if((mode.equals("multi") || mode.equals("divide")) && !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {  //현재 곱셈이나 나눗셈을 해야하면서 현재 꺼낸 문자열이 숫자
                    double one = Double.parseDouble(equal.get(i - 2));
                    double two = Double.parseDouble(equal.get(i));
                    double calc = 0;

                    if(mode.equals("multi")) {
                        calc = one * two;
                    }
                    else if(mode.equals("divide")) {
                        calc = one / two;
                    }

                    equal.add(i + 1, Double.toString(calc));  // 곱셈이나 나눗셈의 결과값 저장

                    for (int j = 0; j < 3; j++) {  // 곱셈과 나눗셈에 사용된 연산자와 숫자 제거
                        equal.remove(i - 2);
                    }
                    i -= 2;  //결과값이 생긴 인덱스로 이동
                }
            }
        }  // 곱셈 나눗셈을 먼저 계산

        mode = "";
        
        for(String s : equal) {
            if(s.equals("+")) {
                mode = "add";
            }
            else if(s.equals("-")) {
                mode = "minus";
            }
            /*else if(s.equals("*")) {
                mode = "multi";
            }
            else if(s.equals("/")) {
                mode = "divide";
            }*/
            else {
                curr = Double.parseDouble(s);

                if(mode.equals("add")) {
                    prev += curr;
                }
                else if(mode.equals("minus")) {
                    prev -= curr;
                }
                /* else if(mode.equals("multi")) {
                    prev *= curr;
                }
                else if(mode.equals("divide")) {
                    prev /= curr;
                }*/
                else {
                    prev = curr;
                }
            }
        }
        result = prev;
    }  // calculate()
}