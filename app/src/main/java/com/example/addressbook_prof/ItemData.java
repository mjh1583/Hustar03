package com.example.addressbook_prof;

// ListView 표시 될 한 개의 Item
public class ItemData {
    // Member Variable -----------------------------------------------------------------------------
    private String name;
    private String phone;
    private String email;
    private int    imgResId;

    // Constructor Method --------------------------------------------------------------------------
    public ItemData(String name, String phone, String email, int imgResId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.imgResId = imgResId;
    }

    // Member Variable 제어 메서드 ------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
