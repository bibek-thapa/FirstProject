
package com.example.DAOImpl;

import com.example.DAOService.ProductDAO;
import com.example.data.Product;
import com.example.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product insert(Product product) {
        product.setProductName(product.getProductName());
        product.setPperUnit(product.getPperUnit());
        return productRepository.save(product);

    }

    public Product getById(Long id) {
        
        return productRepository.findOne(id);
    }

    public Product delete(Long id) {
        Product toDelete = productRepository.findOne(id);
        productRepository.delete(toDelete);
        return toDelete;    
    }

    public Product update(Product product, Long id) {
        Product toUpdate = productRepository.findOne(id);
        toUpdate.setProductName(product.getProductName());
        toUpdate.setPperUnit(product.getPperUnit());
        return productRepository.save(toUpdate);

    }

    public Product getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
