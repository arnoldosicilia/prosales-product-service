package com.ironhack.erp.productservice.model.entities;

import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String provRef;
    private String ean;
    private String img;
    private BigDecimal pvd;
    private BigDecimal pvp;
    private Integer stock;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Product(String name, String provRef, String ean, String img, BigDecimal pvd, BigDecimal pvp, Integer stock) {
        this.name = name;
        this.provRef = provRef;
        this.ean = ean;
        this.img = img;
        this.pvd = pvd;
        this.pvp = pvp;
        this.stock = stock;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvRef() {
        return provRef;
    }

    public void setProvRef(String provRef) {
        this.provRef = provRef;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getPvd() {
        return pvd;
    }

    public void setPvd(BigDecimal pvd) {
        this.pvd = pvd;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
