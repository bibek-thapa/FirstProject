package com.example.DAOImpl;

import com.example.DAOService.CategoryDAO;
import com.example.data.Category;
import com.example.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAOImpl implements CategoryDAO {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {

        return categoryRepository.findAll();
        
    }

    public Category insert(Category c) {

        return categoryRepository.save(c);
    }

    public Category getById(Long id) {
        return categoryRepository.findOne(id);
        
    }

    public Category delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Category update(Category c, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Category getByName(String name) {
        Category category = categoryRepository.findByCategoryName(name);
        return category;
                

    }
    
    public Object getRelation()
    {
        Object object = categoryRepository.findRelation();
        return object;
    
    }
    
}
