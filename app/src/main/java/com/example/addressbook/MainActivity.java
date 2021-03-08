package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Member 변수
    private Button addBTN;
    private Button deleteBTN;
    private Button nextBTN;

    private EditText nameETXT;
    private EditText phoneETXT;
    private EditText emailETXT;

    private TextView nameTXT;
    private TextView phoneTXT;
    private TextView emailTXT;

    private ArrayList<Address> addressArrayList = new ArrayList<>();
    private Address address;

    private int IDX = 0;  // ArrayList의 인덱스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 초기화
        addBTN = findViewById(R.id.addBTN);
        deleteBTN = findViewById(R.id.deleteBTN);
        nextBTN = findViewById(R.id.nextBTN);

        nameETXT = findViewById(R.id.nameETXT);
        phoneETXT = findViewById(R.id.phoneETXT);
        emailETXT = findViewById(R.id.emailETXT);

        nameTXT = findViewById(R.id.nameTXT);
        phoneTXT = findViewById(R.id.phoneTXT);
        emailTXT = findViewById(R.id.emailTXT);

        initTXT();
    }

    public void onClick(View v) {
        // 주소록 추가
        if(v.getId() == addBTN.getId()) {
            String name = nameETXT.getText().toString();
            String phone = phoneETXT.getText().toString();
            String email = emailETXT.getText().toString();

            if(name.length() == 0 || phone.length() == 0 || email.length() == 0) {  // editText의 모든 요소 입력해야 주소록 추가 가능
                Toast.makeText(MainActivity.this, "이름, 휴대폰 번호, 이메일 주소 모두 입력해야 합니다!", Toast.LENGTH_SHORT).show();
                return;
            }
            address = new Address(name, phone, email);
            addressArrayList.add(address);

            Toast.makeText(MainActivity.this, "주소가 추가되었습니다!", Toast.LENGTH_SHORT).show();
            initETXT();
            showAddress();
            IDX++;
        }
        // 주소록 삭제
        else if(v.getId() == deleteBTN.getId()) {
            if(addressArrayList.size() == 0) {
                Toast.makeText(MainActivity.this, "등록된 주소록이 없습니다!", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                if(addressArrayList.size() == 1) {  // 주소록이 하나만 있을 때
                    IDX = 0;
                    addressArrayList.remove(0);
                    initTXT();
                }
                else if(addressArrayList.size() == IDX) {  // ArrayList의 마지막 인덱스 요소 삭제
                    addressArrayList.remove(IDX - 1);
                    IDX = IDX - 2;
                    showAddress();
                }
                else {
                    addressArrayList.remove(IDX - 1);
                    IDX = IDX - 1;
                    showAddress();
                }
                IDX = IDX + 1;  // 삭제 후 바로 다음 것을 보기 위한
            }
            Toast.makeText(MainActivity.this, "주소가 삭제되었습니다!", Toast.LENGTH_SHORT).show();
        }
        // 주소록 나타내기
        else if(v.getId() == nextBTN.getId()) {
            if(addressArrayList.size() == 0) {
                Toast.makeText(MainActivity.this, "등록된 주소록이 없습니다!", Toast.LENGTH_SHORT).show();
                return;
            }
            if(addressArrayList.size() == IDX) {
                IDX = 0;
            }
            showAddress();
            IDX++;
        }
    }

    // 주소록을 textView에 보여주는 함수
    public void showAddress() {
        if(addressArrayList.size() != 0) {
            address = addressArrayList.get(IDX);
            nameTXT.setText(address.getName());
            phoneTXT.setText(address.getPhone());
            emailTXT.setText(address.getEmail());
        }
        else {
            Toast.makeText(MainActivity.this, "등록된 주소록이 없습니다!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    // textView를 초기화 하는 함수
    public void initTXT() {
        nameTXT.setText("");
        phoneTXT.setText("");
        emailTXT.setText("");
    }

    // EditText를 초기화 하는 함수
    public void initETXT() {
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }
}