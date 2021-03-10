package com.example.addressbook_prof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    // Member Variable ----------------------------------------------------
    private final boolean D = true;
    private final String TAG = "SettingActivity";

    private EditText idETXT;

    private RadioGroup themeGroup;
    private RadioButton whiteRBTN;
    private RadioButton darkRBTN;
    private RadioButton blueRBTN;
    private RadioButton rBTN;

    private CheckBox asCBTN;
    private CheckBox wifiCBTN;

    private String userId = "";
    private String theme = "";
    private String select1 = "";
    private String select2 = "";

    // Member Method - Override -------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // 초기화
        init();

        if(D) Log.i(TAG, "onCreate()");
    }

    // Member Method - Custom ---------------------------------------------
    private void init() {
        idETXT = findViewById(R.id.idETXT);

        themeGroup = findViewById(R.id.themeGruop);
        whiteRBTN = findViewById(R.id.whiteRBTN);
        darkRBTN = findViewById(R.id.darkRBTN);
        blueRBTN = findViewById(R.id.blueRBTN);

        asCBTN = findViewById(R.id.asCBTN);
        wifiCBTN = findViewById(R.id.wifiCBTN);

        // 입력 막기
        idETXT.setEnabled(false);

        whiteRBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    theme = whiteRBTN.getText().toString();
                }
            }
        });

        darkRBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    theme = darkRBTN.getText().toString();
                }
            }
        });

        blueRBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    theme = blueRBTN.getText().toString();
                }
            }
        });

        asCBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    select1 = asCBTN.getText().toString();
                else
                    select1 = "";
            }
        });

        wifiCBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    select2 = buttonView.getText().toString();
                else
                    select2 = "";
            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.modBTN:
                // 타입 허용
                idETXT.setEnabled(true);
                break;
            case R.id.saveBTN:
                userId = idETXT.getText().toString();
                Log.i(TAG, "Save : " + userId + " - " + theme + " - " + select1 + " - " + select2);
                break;
            case R.id.cancelBTN:
                idETXT.setText("");
                idETXT.setEnabled(false);
                themeGroup.clearCheck();
                asCBTN.setChecked(false);
                wifiCBTN.setChecked(false);
                break;
            default:
                break;
        }
    }
}