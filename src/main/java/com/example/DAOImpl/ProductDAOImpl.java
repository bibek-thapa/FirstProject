
package com.example.DAOImpl;

import com.example.DAOService.ProductDAO;
import com.example.data.Product;
import com.example.repository.ProductRepository;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private ProductRepository productRepository;
    
    Logger logger = Logger.getLogger(ProductDAOImpl.class);
    
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product insert(Product product) {
        logger.info("In the insert part of the ProductDAO Implementation");
         Product product1 = productRepository.findByproductCode(product.getProductCode());
        if(product1!=null)
        {
            logger.info("Product code already exists in the database");
        }
        else{
          product = productRepository.save(product);
          logger.info("Product "+product.getProductName()+" is successfully created");
        }
        
        return product;
     
        
        
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
