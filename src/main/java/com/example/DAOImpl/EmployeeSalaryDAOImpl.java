/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOImpl;

import com.example.data.EmployeeSalary;
import com.example.repository.EmployeeSalaryRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.DAOService.EmployeeSalaryDAO;

@Service
public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO {

    @Resource
    private EmployeeSalaryRepository employeeSalaryRepository;
    
    

    public List<EmployeeSalary> getAll() {

        return employeeSalaryRepository.findAll();

    }

    public EmployeeSalary insert(EmployeeSalary es) {

        es.setEmployeePosition(es.getEmployeePosition());
        es.setPayRate(es.getPayRate());
        es.setBonus(es.getBonus());
        return employeeSalaryRepository.save(es);

    }

    public EmployeeSalary getById(Long id) {
        EmployeeSalary employeeSalary = employeeSalaryRepository.findOne(id);
        return employeeSalary;
    }

    public EmployeeSalary delete(Long id) {
        EmployeeSalary toDelete = employeeSalaryRepository.findOne(id);
        employeeSalaryRepository.delete(toDelete);
        return toDelete;
        

    }

    public EmployeeSalary update(EmployeeSalary es,Long id) {
        
        EmployeeSalary toUpdate = employeeSalaryRepository.findOne(id);
        toUpdate.setEmployeePosition(es.getEmployeePosition());
        toUpdate.setPayRate(es.getPayRate());
        toUpdate.setBonus(es.getBonus());
        employeeSalaryRepository.save(toUpdate);
        
        return toUpdate;
     }

    public EmployeeSalary getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
