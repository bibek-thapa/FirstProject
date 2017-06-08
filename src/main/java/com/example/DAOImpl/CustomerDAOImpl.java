package com.example.DAOImpl;

import com.example.data.Customer;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.repository.CustomerRepository;
import com.example.DAOService.CustomerDAO;

@Service
public class CustomerDAOImpl implements CustomerDAO {

    @Resource
    private CustomerRepository customerRepository;
   
    
    
    public Customer findById(long id) {
        
       return customerRepository.findOne(id);
       
    }

    public List<Customer> getAll() {
           return customerRepository.findAll();
 }

    public Customer insert(Customer customer) {
        
        return customerRepository.save(customer);
        
    }

    public Customer getById(Long id) {
        return customerRepository.findOne(id);
    }

    public Customer delete(Long id) {
   
        Customer deletedCustomer = customerRepository.findOne(id);
        customerRepository.delete(deletedCustomer);
        return deletedCustomer; }

    public Customer getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Customer update(Customer c, Long id) {
        Customer toUpdate = customerRepository.findOne(id);
        toUpdate.setFirstName(c.getFirstName());
        toUpdate.setCompanyName(c.getCompanyName());
        toUpdate.setLastName(c.getLastName());
        toUpdate.setJobPosition(c.getJobPosition());
        toUpdate.setContactNumber(c.getContactNumber());
        return customerRepository.save(toUpdate);
        
    }

}
