/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAOImpl;

import com.example.data.Employee;
import com.example.repository.EmployeeRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.DAOService.EmployeeDAO;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    @Resource
    private EmployeeRepository employeeRepository;
    
    

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee insert(Employee e) {
        return employeeRepository.save(e);
    }

    public Employee getById(Long id) {

        return employeeRepository.findOne(id);
    }

    public Employee delete(Long id) {
        Employee toDelete = employeeRepository.findOne(id);
        employeeRepository.delete(toDelete);
        return toDelete;
    }

    public Employee update(Employee e,Long id) {
        Employee toUpdate = employeeRepository.findOne(id);
        toUpdate.setFirstName(e.getFirstName());
        toUpdate.setLastName(e.getLastName());
        toUpdate.setAddress(e.getAddress());
        toUpdate.setContactNumber(e.getContactNumber());
        toUpdate.setEmployeeSalary(e.getEmployeeSalary());

        return employeeRepository.save(toUpdate);
    }

    public Employee getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
