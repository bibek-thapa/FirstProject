package com.example.DAOImpl;

import com.example.data.Customer;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.DAOService.CustomerDAOService;
import com.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerDAOService {

    @Resource
    private CustomerRepository customerRepository;
    
    public Customer create(Customer customer) {

        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setCompanyName(customer.getCompanyName());
        customer.setJobPosition(customer.getJobPosition());
        customer.setContactNumber(customer.getContactNumber());
        return (customerRepository.save(customer));

    }

    
    public Customer delete(long id) {

        Customer deletedCustomer = customerRepository.findOne(id);

        customerRepository.delete(deletedCustomer);
        return deletedCustomer;

    }
   
    public List<Customer> findAll() {

        return customerRepository.findAll();
    }
    
   
    public Customer update(Customer customer) {
        
        Customer updatedCustomer = customerRepository.findOne(customer.getId());
        updatedCustomer.setFirstName(customer.getFirstName());
//        updatedCustomer.setCompany(customer.getCompany());
        
        return customerRepository.save(updatedCustomer);
        
    }
    
    
    public Customer findById(long id) {
        
       return customerRepository.findOne(id);
       
    }

}
