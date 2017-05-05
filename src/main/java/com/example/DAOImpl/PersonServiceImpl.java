package com.example.DAOImpl;

import com.example.DAOService.PersonDAOService;
import com.example.data.Person;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import com.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonDAOService {

    @Resource
    private PersonRepository personRepository;
    
    
    
    

    @Override
    @Transactional
    public Person create(Person person) {

        person.setFirstName(person.getFirstName());
        person.setCompany(person.getCompany());
        return (personRepository.save(person));

    }

    @Override
    @Transactional
    public Person delete(long id) {

        Person deletedPerson = personRepository.findOne(id);

        personRepository.delete(deletedPerson);
        return deletedPerson;

    }
    
    @Override
    @Transactional
    public List<Person> findAll() {

        return personRepository.findAll();
    }
    
    @Override
    @Transactional
    public Person update(Person person) {
        
        Person updatedPerson = personRepository.findOne(person.getId());
        updatedPerson.setFirstName(person.getFirstName());
        updatedPerson.setCompany(person.getCompany());
        
        return updatedPerson;
        
    }
    
    @Override
    @Transactional
    public Person findById(long id) {
        
       return personRepository.findOne(id);
       
    }

}
