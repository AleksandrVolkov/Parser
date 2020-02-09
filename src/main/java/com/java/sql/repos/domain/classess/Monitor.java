package com.java.sql.repos.domain.classess;

import com.java.sql.repos.domain.product.Product;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "MONITOR_DATA")
public class Monitor extends Product {
    private String screen;
    private String screen_resolution;
    private String screen_frequency;
    private String aspect_ratio;
    private String brightness;
    private String response_time;
    private String connector;
    private String matrix_type;


    public Monitor() {
    }

    public Monitor(String product_type, String shop, String short_image, String name, String short_description, String link_on_full_description, BigDecimal price) {
        super(product_type, shop, short_image, name, short_description, link_on_full_description, price);
    }

    public Monitor(String product_type, String shop, String short_image, String name, String short_description, String link_on_full_description, BigDecimal price,
                   String screen, String screen_resolution, String screen_frequency, String aspect_ratio, String brightness, String response_time, String connector, String matrix_type) {
        super(product_type, shop, short_image, name, short_description, link_on_full_description, price);
        this.screen = screen;
        this.screen_resolution = screen_resolution;
        this.screen_frequency = screen_frequency;
        this.aspect_ratio = aspect_ratio;
        this.brightness = brightness;
        this.response_time = response_time;
        this.connector = connector;
        this.matrix_type = matrix_type;
    }

//    public Monitor(String screen, String screen_resolution, String screen_frequency, String aspect_ratio, String brightness, String response_time, String connector, String matrix_type) {
//        this.screen = screen;
//        this.screen_resolution = screen_resolution;
//        this.screen_frequency = screen_frequency;
//        this.aspect_ratio = aspect_ratio;
//        this.brightness = brightness;
//        this.response_time = response_time;
//        this.connector = connector;
//        this.matrix_type = matrix_type;
//    }

    public String getScreen_frequency() {
        return screen_frequency;
    }

    public void setScreen_frequency(String screen_frequency) {
        this.screen_frequency = screen_frequency;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getScreen_resolution() {
        return screen_resolution;
    }

    public void setScreen_resolution(String screen_resolution) {
        this.screen_resolution = screen_resolution;
    }

    public String getAspect_ratio() {
        return aspect_ratio;
    }

    public void setAspect_ratio(String aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    public String getResponse_time() {
        return response_time;
    }

    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getMatrix_type() {
        return matrix_type;
    }

    public void setMatrix_type(String matrix_type) {
        this.matrix_type = matrix_type;
    }
}
