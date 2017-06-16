/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOImpl;

import com.example.data.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.AddressRepository;
import com.example.DAOService.AddressDAO;

@Service
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private AddressRepository addressRepository;
    public List<Address> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList;
        }

    public Address insert(Address c) {
       
        return addressRepository.save(c);
       }

    public Address getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Address delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Address update(Address c,Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Address getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
