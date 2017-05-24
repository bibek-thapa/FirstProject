
package com.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_TBL")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    
    @Column(name="PRODUCT_NAME",nullable =false)
    private String productName;
    
    @Column(name = "PRICE_PER_UNIT",nullable = false)
    private Double pperUnit;

    public Long getId() {
        return id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPperUnit() {
        return pperUnit;
    }

    public void setPperUnit(Double pperUnit) {
        this.pperUnit = pperUnit;
    }
    
    
    
    
    
}
