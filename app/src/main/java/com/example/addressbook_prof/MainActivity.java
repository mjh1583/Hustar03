package com.example.addressbook_prof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Member Variable --------------------------------------------------
    private final boolean D = true;
    private final String TAG = "MainActivity";

    // View
    private EditText nameETXT, phoneETXT, emailETXT;
    private TextView addressTXT;

    // Data
    private ArrayList<Address> addressesList = new ArrayList<>();

    // Member Method - AppCompatActivity's Override ---------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Activity 화면 설정 필수!
        setContentView(R.layout.activity_main);

        // XML View 객체 가져오기
        nameETXT = findViewById(R.id.nameETXT);
        phoneETXT = findViewById(R.id.phoneETXT);
        emailETXT = findViewById(R.id.emailETXT);
        addressTXT = findViewById(R.id.addressTXT);

        if(D) Log.i(TAG, "onCreate()");
    }

    // Member Method - XML onClick---------------------------------------
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addBTN :
                // 3개의 EditText 값 읽어서 Address 객체 생성 및 추가
                // 1. 3개 EditText 값 입력 여부 체크
                if(nameETXT.getText().length() > 0 && phoneETXT.getText().length() > 0 && emailETXT.getText().length() > 0) {
                    // 2-1 Adress 객체 생성 및 ArrayList 추가
                    addressesList.add(new Address(nameETXT.getText().toString(),
                                                  phoneETXT.getText().toString(),
                                                  emailETXT.getText().toString()));
                    Log.i(TAG, "add => " + addressesList.size());
                    // 3개 입력 필드 초기화 (지우기)
                    initETXT();

                    // TextView에 데이터 출력
                    displayAddress();
                }
                else {
                    // 2-2 사용자에게 알림 띄우기
                    Toast.makeText(MainActivity.this, R.string.add_msg, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delBTN :
                if(addressesList.size() > 0) {
                    // 모두 삭제 또는 가장 최근에 추가한 데이터 삭제
                    int lastIdx = addressesList.size() - 1;
                    addressesList.remove(lastIdx);

                    // TextView에 데이터 출력
                    displayAddress();
                }
                else {
                    // 사용자에게 알림 띄우기
                    Toast.makeText(MainActivity.this, R.string.del_msg, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // Member Method - Method ----------------------------------------------------
    // 3개 입력 필드 초기화 --------------------------------------------------------
    private void initETXT() {
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }

    // AddressList 출력 메서드  ---------------------------------------------------
    private void displayAddress() {
        String datas = "";
        for(int idx = 0; idx < addressesList.size(); idx++)
            datas += addressesList.get(idx).getInfo() + "\n";

        if(datas.length() > 0)
            addressTXT.setText(datas);
        else
            addressTXT.setText(R.string.nothing);
    }

}