package com.example.addressbook_prof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Member Variable --------------------------------------------------
    private final boolean D = true;
    private final String TAG = "MainActivity";

    // View
    private EditText nameETXT, phoneETXT, emailETXT;
    private ListView addressLST;

    // Adapter
    private SimpleAdapter adapter;

    // Data
    private ArrayList<HashMap<String, String>> addressesList = new ArrayList<>();

    private InputMethodManager imm;

    // Member Method - AppCompatActivity's Override ---------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Activity 화면 설정 필수!
        setContentView(R.layout.activity_main);

        init();

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
                    HashMap<String, String>  data = new HashMap<>();
                    data.put("name", nameETXT.getText().toString());
                    data.put("phone", phoneETXT.getText().toString());
                    data.put("email", emailETXT.getText().toString());
                    addressesList.add(data);

                    adapter.notifyDataSetChanged();

                    Log.i(TAG, "add => " + addressesList.size());
                    // 3개 입력 필드 초기화 (지우기)
                    initETXT();
                }
                else {
                    // 2-2 사용자에게 알림 띄우기
                    Toast.makeText(MainActivity.this, R.string.add_msg, Toast.LENGTH_SHORT).show();
                }

                // 입력 후 ADD 버튼 클릭 시 SoftKeyBoard 숨기기 설정
                imm.hideSoftInputFromWindow(nameETXT.getWindowToken(), 0);
                break;
            case R.id.delBTN :
                if(addressesList.size() > 0) {
                    // 모두 삭제 또는 가장 최근에 추가한 데이터 삭제
                    int lastIdx = addressesList.size() - 1;
                    addressesList.remove(lastIdx);

                    adapter.notifyDataSetChanged();
                }
                else {
                    // 사용자에게 알림 띄우기
                    Toast.makeText(MainActivity.this, R.string.del_msg, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // Member Method - Method ----------------------------------------------------
    private void init() {
        // XML View 객체 가져오기
        nameETXT = findViewById(R.id.nameETXT);
        phoneETXT = findViewById(R.id.phoneETXT);
        emailETXT = findViewById(R.id.emailETXT);

        addressLST = findViewById(R.id.addressLST);

        // adapter 객체 생성
        adapter = new SimpleAdapter(MainActivity.this, addressesList,
                R.layout.list_item,
                new String[] {"name", "phone", "email"},
                new int[] {R.id.nameTXT, R.id.phoneTXT, R.id.emailTXT});

        // ListView에 adapter 설정
        addressLST.setAdapter(adapter);

        // System 서비스 객체 가져오기
        imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        // EditText 이벤트 리스너 설정
        emailETXT.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i(TAG, "onEditorAction() actiondId : " + actionId);
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    imm.hideSoftInputFromWindow(emailETXT.getWindowToken(), 0);
                }
                return true;
            }
        });

        // ListView ClickListener 설정
        addressLST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    // 3개 입력 필드 초기화 --------------------------------------------------------
    private void initETXT() {
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }
}