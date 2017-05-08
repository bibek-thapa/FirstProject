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
import com.example.DAOService.AddressDAOService;
import com.example.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressDAOService {

    @Autowired
    private AddressRepository addressRepository;
    public List<Address> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList;
        }

    public Address insert(Address c) {
        Address address = new Address();
        address.setZone(c.getZone());
        address.setDistrict(c.getDistrict());
        address.setPermanentAddress(c.getPermanentAddress());
        address.setTempAddress(c.getTempAddress());
        return addressRepository.save(address);
       }

    public Address getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Address delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Address update(Address c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Address getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
