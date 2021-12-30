package com.example.tp6exercice1;

public class Contact {

    private String nom;
    private  String tel;
    private int img;

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public int getImg() {
        return img;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Contact(String nom, String tel, int img) {
        this.nom = nom;
        this.tel = tel;
        this.img = img;
    }
}
