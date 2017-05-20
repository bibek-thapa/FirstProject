/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOService;

import com.example.data.Customer;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface CustomerDAOService {
    
    public Customer create(Customer customer);
    public Customer delete(long id);
    public List<Customer> findAll();
    public Customer update(Customer customer);
    public Customer findById(long id);
    
}
