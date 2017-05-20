/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOImpl;

import com.example.DAOService.EmployeeDAOService;
import com.example.data.Employee;
import com.example.repository.EmployeeRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeDAOService {

    @Resource
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee insert(Employee e) {
       
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setAddress(e.getAddress());
        e.setContactNumber(e.getContactNumber());
        return employeeRepository.save(e);
    }

    public Employee getById(Long id) {

        return employeeRepository.findOne(id);
    }

    public Employee delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Employee update(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Employee getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
