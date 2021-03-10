package com.example.addressbook_prof;

public class Address {
    // Member Variable  ----------------------------
    private String name;
    private String phone;
    private String email;

    // Constructor  --------------------------------

    public Address(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter / Setter Method  ---------------------
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

    // Custom Method  ---------------------------
    public String getInfo() {
        return this.name + "-" + this.phone + "-" + this.email;
    }

}
