package com.example.addressbook_prof;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// ListView item 표시해주는 XML Layout => Java Object로 저장
public class ItemDataHolder {
    public ImageView iconIMG;
    public TextView nameTXT;
    public TextView phoneTXT;
    public TextView emailTXT;

    public ItemDataHolder(View root) {
        this.iconIMG = root.findViewById(R.id.iconIMG);
        this.nameTXT = root.findViewById(R.id.nameTXT);
        this.phoneTXT = root.findViewById(R.id.phoneTXT);
        this.emailTXT = root.findViewById(R.id.emailTXT);
    }
}
