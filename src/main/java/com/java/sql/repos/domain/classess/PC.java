package com.java.sql.repos.domain.classess;

import com.java.sql.repos.domain.product.Product;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "PC_DATA")
public class PC extends Product {
    private String cpu_model;
    private Double cpu_frequency;
    private Integer cpu_cores_count;

    private String ram_model;
    private String ram_size;
    private String ram_frequency;

    private String gpu_discrete_model;
    private String gpu_discrete_size;
    private String gpu_integrated_model;

    private String hdd_data;
    private String ssd_data;

    public PC() {
    }

//    public PC(String product_type, String shop, String short_image, String name, String short_description, String link_on_full_description, BigDecimal price,
//              String cpu_model, Integer cpu_frequency, String ram_model, String ram_size, String ram_frequency, String gpu_discrete_model, String gpu_discrete_size,
//              String gpu_integrated_model, String hdd_data, String ssd_data) {
//        super(product_type, shop, short_image, name, short_description, link_on_full_description, price);
//        this.cpu_model = cpu_model;
//        this.cpu_frequency = cpu_frequency;
//        this.ram_model = ram_model;
//        this.ram_size = ram_size;
//        this.ram_frequency = ram_frequency;
//        this.gpu_discrete_model = gpu_discrete_model;
//        this.gpu_discrete_size = gpu_discrete_size;
//        this.gpu_integrated_model = gpu_integrated_model;
//        this.hdd_data = hdd_data;
//        this.ssd_data = ssd_data;
//    }

    public PC(String product_type, String shop, String short_image, String name, String short_description, String link_on_full_description, BigDecimal price) {
        super(product_type, shop, short_image, name, short_description, link_on_full_description, price);
    }


    public String getCpu_model() {
        return cpu_model;
    }

    public void setCpu_model(String cpu_model) {
        this.cpu_model = cpu_model;
    }

    public Double getCpu_frequency() {
        return cpu_frequency;
    }

    public void setCpu_frequency(Double cpu_frequency) {
        this.cpu_frequency = cpu_frequency;
    }

    public Integer getCpu_cores_count() {
        return cpu_cores_count;
    }

    public void setCpu_cores_count(Integer cpu_cores_count) {
        this.cpu_cores_count = cpu_cores_count;
    }

    public String getRam_model() {
        return ram_model;
    }

    public void setRam_model(String ram_model) {
        this.ram_model = ram_model;
    }

    public String getRam_size() {
        return ram_size;
    }

    public void setRam_size(String ram_size) {
        this.ram_size = ram_size;
    }

    public String getRam_frequency() {
        return ram_frequency;
    }

    public void setRam_frequency(String ram_frequency) {
        this.ram_frequency = ram_frequency;
    }

    public String getGpu_discrete_model() {
        return gpu_discrete_model;
    }

    public void setGpu_discrete_model(String gpu_discrete_model) {
        this.gpu_discrete_model = gpu_discrete_model;
    }

    public String getGpu_discrete_size() {
        return gpu_discrete_size;
    }

    public void setGpu_discrete_size(String gpu_discrete_size) {
        this.gpu_discrete_size = gpu_discrete_size;
    }

    public String getGpu_integrated_model() {
        return gpu_integrated_model;
    }

    public void setGpu_integrated_model(String gpu_integrated_model) {
        this.gpu_integrated_model = gpu_integrated_model;
    }

    public String getHdd_data() {
        return hdd_data;
    }

    public void setHdd_data(String hdd_data) {
        this.hdd_data = hdd_data;
    }

    public String getSsd_data() {
        return ssd_data;
    }

    public void setSsd_data(String ssd_data) {
        this.ssd_data = ssd_data;
    }
}
