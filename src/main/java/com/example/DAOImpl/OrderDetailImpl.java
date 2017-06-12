
package com.example.DAOImpl;

import com.example.DAOService.OrderDetailDAO;
import com.example.data.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailImpl implements OrderDetailDAO {
    
    @Resource
    private OrderDetailRepository orderDetailRepository;
    
    public List<OrderDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OrderDetail insert(OrderDetail o) {
    
        if( o == null)
        {
          /*TODO*/  //throw exception
        }
        return orderDetailRepository.save(o);
    }

    public OrderDetail getById(Long id) {
        if(id == null)
        {
            //TODO throw the null id exception
        
        }
        return orderDetailRepository.findOne(id);
        
    }

    public OrderDetail delete(Long id) {
        OrderDetail toDelete = orderDetailRepository.findOne(id);
        orderDetailRepository.delete(toDelete);
        return toDelete;
    }

    public OrderDetail update(OrderDetail c, Long id) {
        OrderDetail toUpdate = orderDetailRepository.findOne(id);
        toUpdate.setProduct(c.getProduct());
        toUpdate.setOrder(c.getOrder());
        toUpdate.setOrderQuantity(c.getOrderQuantity());
        return toUpdate;

    }

    public OrderDetail getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
