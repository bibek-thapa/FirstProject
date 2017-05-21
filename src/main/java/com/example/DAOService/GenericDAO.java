/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOService;

import java.util.List;

/**
 *
 * @author HOME
 */
public interface GenericDAO <T>{
    
    public List<T> getAll();
   public T insert(T c);
    public T getById(Long id);
    public T delete(Long id);
    public T update(T c,Long id);
    public T getByName(String name);
    
}
