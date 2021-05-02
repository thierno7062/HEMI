package com.example.stopcovid19.Model;

public class info_personnelles {
    String nom;
    String prenom;
    String mail;
    int age;
    String address;
    int phone;



    public info_personnelles(String nom, String prenom, String mail, int age, String address, int phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public info_personnelles() {
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }




}
