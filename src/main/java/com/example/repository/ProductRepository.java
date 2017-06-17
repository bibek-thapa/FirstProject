/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.data.Category;
import com.example.data.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dell
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    
public Product findByproductCode(String productCode);

public List<Product> findByCategory(Category category);

//Page<Product> findAll(Pageable pageable);

}
