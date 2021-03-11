package com.example.addressbook_prof;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemDataAdapter extends ArrayAdapter<ItemData> {
    // Member Variable -----------------------------------------------------------------------------
    private Context context;
    private int layoutResId;
    private ArrayList<ItemData> dataList;

    // Constructor Method --------------------------------------------------------------------------
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.dataList = objects;
    }

    // Override Method -----------------------------------------------------------------------------
    @Override
    public int getCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Data ==> XML Layout 넣어서 보이고 사용할 수 있도록 객체 생성 반환

        // 1. item layout xml ==> Java 객체로 변환
        // 항목 layout 초기화 => MainActivity의 setContentView()와 비슷한 역할
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResId, null);

            ItemDataHolder holder = new ItemDataHolder(convertView);
            convertView.setTag(holder);
        }

        ItemDataHolder holder = (ItemDataHolder) convertView.getTag();

        // 2. item layout's view 객체 가져오기  ==> ItemDataHolder 클래스에서 진행
        // View 획득
//        TextView nameTXT = convertView.findViewById(R.id.nameTXT);
//        TextView phoneTXT = convertView.findViewById(R.id.phoneTXT);
//        TextView emailTXT = convertView.findViewById(R.id.emailTXT);
//        ImageView iconIMG = convertView.findViewById(R.id.iconIMG);
        TextView nameTXT = holder.nameTXT;
        TextView phoneTXT = holder.phoneTXT;
        TextView emailTXT = holder.emailTXT;
        ImageView iconIMG =  holder.iconIMG;

        // 3. Data 준비
        // 항목 데이터 획득
        final ItemData item = dataList.get(position);

        // 4. Layout < --- > Data
        // View에 데이터 설정
        nameTXT.setText(item.getName());
        phoneTXT.setText(item.getPhone());
        emailTXT.setText(item.getEmail());

        // Image 크기 동일하게
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), item.getImgResId());
        bitmap = bitmap.createScaledBitmap(bitmap, 200, 200, true);
        iconIMG.setImageBitmap(bitmap);

        return convertView;
    }
}
