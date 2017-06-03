
package com.example.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ProductInfo {
    
    private String code;
    private String name;
    private Double price;
    
    private CommonsMultipartFile fileData;

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
        
    
}
