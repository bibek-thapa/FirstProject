package com.example.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PRODUCT_TBL")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @NotNull
    @Column(name = "PRICE_PER_UNIT", nullable = false)
    private Double pperUnit;

    @NotEmpty
    @Pattern(regexp = "^S{1}[0-9]{5}+$")// ^ and $ are to avoid empty space at beginning and end
    //s{1} means only s ,not ss. [0-9]{5} means 0-9 values upto 5 characters, valid is s00001 ,s00002,etc 
    @Column(name = "PRODUCT_CODE", nullable = false)
    private String productCode;

    @Lob
    private byte[] productImage;

    @Embedded
    private ProductFeatures productFeatures;

    public ProductFeatures getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(ProductFeatures productFeatures) {
        this.productFeatures = productFeatures;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
