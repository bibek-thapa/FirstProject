/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOService;

import com.example.data.Category;


/**
 *
 * @author Dell
 */
public interface CategoryDAO extends GenericDAO<Category>{
    
    public Object getRelation();
}
