/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOImpl;

import com.example.data.Company;
import com.example.repository.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DAOService.CompanyDAO;

@Service

public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company insert(Company c) {
       
        c.setCompanyName(c.getCompanyName());
        return companyRepository.save(c);

    }

    public Company getById(Long id) {
        Company comp = companyRepository.findOne(id);

        return comp;
    }

    public Company delete(Long id) {
        Company toDelete = companyRepository.findOne(id);
        companyRepository.delete(toDelete);
        return toDelete;

    }

    public Company getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Company update(Company c, Long id) {

        Company toUpdate = companyRepository.findOne(id);
        toUpdate.setCompanyName(c.getCompanyName());
        return companyRepository.save(toUpdate);

    }

}
