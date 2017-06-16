/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.data.Category;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dell
 */
public interface CategoryRepository  extends JpaRepository<Category, Long>{
    
public Category findByCategoryName(String name);

@Query("Select p from Product p")
public Object findRelation();

//select pr.id,ct.CATEGORY_NAME from
//  product_tbl pr 
//  inner join
//  category_tbl_product_tbl ctpt 
//  on(ctpt.PRODUCT_ID = pr.id)
//  inner join category_tbl ct 
//  on(ct.id = ctpt.CATEGORY_ID) where pr.PRODUCT_NAME="MOUSE";



}
