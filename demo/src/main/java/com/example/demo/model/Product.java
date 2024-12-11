package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
public Integer getProdID() {
        return prodID;
    }

    public void setProdID(Integer prodID) {
        this.prodID = prodID;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Double getFiyat() {
        return Fiyat;
    }

    public void setFiyat(Double fiyat) {
        Fiyat = fiyat;
    }

    public Integer getAdet() {
        return Adet;
    }

    public void setAdet(Integer adet) {
        Adet = adet;
    }

@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Integer prodID;
@Column(nullable = false)

private String Marka;
@Column(nullable = false)
private String Model;

@Column(nullable = false)
private Double Fiyat;

@Column(nullable = false)
private Integer Adet;


}
