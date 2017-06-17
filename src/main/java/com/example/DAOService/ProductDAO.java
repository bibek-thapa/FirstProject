
package com.example.DAOService;

import com.example.data.Category;
import com.example.data.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public interface ProductDAO extends GenericDAO<Product>{
    public List<Product> getByCategory(Category category);
    public List<Product> getByPages(Pageable pageable);
}
