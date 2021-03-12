package com.example.addressbook_prof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------------------------
    private final boolean D = true;
    private final String TAG = "CustomListActivity";

    private ListView dataLST;

    private ArrayList<ItemData> dataArrays;
    private ItemDataAdapter adapter;

    // Member Method - Override --------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        init();
    }

    // Member Method - Custom ----------------------------------------------------------------------
    private void init() {
        dataLST = findViewById(R.id.dataLST);

        dataArrays = new ArrayList<ItemData>();
        dataArrays.add(new ItemData("Test", "010", "test@gmail.com", R.drawable.dog));
        dataArrays.add(new ItemData("Test2", "011", "test2@gmail.com", R.drawable.kitty));

        adapter = new ItemDataAdapter(CustomListActivity.this, R.layout.item_data, dataArrays);

        dataLST.setAdapter(adapter);

        dataLST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListActivity.this,
                        "Click => " + ((TextView)view.findViewById(R.id.nameTXT)).getText() + " position : " + position + " id : " + id,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v) {
        if(D) Log.i(TAG, "onClick()");
        switch (v.getId()) {
            case R.id.nameTXT:
            case R.id.phoneTXT:
            case R.id.emailTXT:
                Log.i(TAG, "TEXT => " + ((TextView)v).getText());
                break;
            case R.id.iconIMG:
                Log.i(TAG, "IMAGE");
                break;
        }
    }
}