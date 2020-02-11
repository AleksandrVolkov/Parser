package com.java.sql.repos.domain.product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Product1")
public abstract class Product {
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long ID;
    @Id
    private Long product_id;
    private String product_type;
    private String shop;
    private String short_image;
    private String name;
    private String short_description;
    private String link_on_full_description;
    private BigDecimal price;

    public Product() {
    }

    public Product(Long product_id, String product_type, String shop, String short_image, String name, String short_description, String link_on_full_description, BigDecimal price) {
        this.product_id = product_id;
        this.product_type = product_type;
        this.shop = shop;
        this.short_image = short_image;
        this.name = name;
        this.short_description = short_description;
        this.link_on_full_description = link_on_full_description;
        this.price = price;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long id_product) {
        this.product_id = id_product;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

//    public Long getID() {
//        return ID;
//    }

//    public void setID(Long ID) {
//        this.ID = ID;
//    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getShort_image() {
        return short_image;
    }

    public void setShort_image(String short_image) {
        this.short_image = short_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLink_on_full_description() {
        return link_on_full_description;
    }

    public void setLink_on_full_description(String link_on_full_description) {
        this.link_on_full_description = link_on_full_description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
