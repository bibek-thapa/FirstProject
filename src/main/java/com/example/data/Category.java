package com.example.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY_TBL")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="CATEGORY_NAME")
    private String categoryName;
    
    
    @ManyToMany(cascade = CascadeType.PERSIST,targetEntity = Product.class)
    @JoinTable(name = "CATEGORY_TBL_PRODUCT_TBL",joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns =@JoinColumn(name = "PRODUCT_ID"))
    private Set<Product> productSet = new HashSet<Product>();

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
    
    
    
}
