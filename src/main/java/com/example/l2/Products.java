package com.example.l2;

import java.math.BigDecimal;

public class Products {
    public int id; //+
    public String name;//+
    public BigDecimal price;//+
    public int count;//
    public String type;//
    public String category;//+
    public String description;//+

    //public Products(int id, String good, double cena, String category) {
    public Products(int id, String name, String type, String category, String description, int count, BigDecimal price) {
        //  id |    name     |  type   | category |           description    | count |  price
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public Products() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
