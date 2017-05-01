/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOService;

import com.example.data.Person;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface PersonDAOService {
    
    public Person create(Person person);
    public Person delete(long id);
    public List<Person> findAll();
    public Person update(Person person);
    public Person findById(long id);
    
}
