//定義模型
package com.example.back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id //欄位ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //主建:紀錄是哪一筆
    private String name;
    private String description;
    private double price;

    public Long getId(){ //公有:回傳ID
        return id;
    }

    public String getName(){ //公有:回傳name
        return name;
    }

    public String getDescription(){ //公有:回傳description
        return description;
    }

    public double getPrice(){ //公有:回傳price
        return price;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
