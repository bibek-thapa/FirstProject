package com.example.DAOImpl;

import com.example.DAOService.OrderDAO;
import com.example.data.Order;
import com.example.repository.OrderRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAOImpl implements OrderDAO {

    @Resource
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order insert(Order c) {
        c.setOrderQuantity(c.getOrderQuantity());
        c.setCreatedTime(c.getCreatedTime());
//        c.setCustomer(c.getCustomer());
        return orderRepository.save(c);

    }

    public Order getById(Long id) {
        return orderRepository.findOne(id);
    }

    public Order delete(Long id) {
        Order toDelete = orderRepository.findOne(id);
        orderRepository.delete(toDelete);
        return toDelete;
    }

    public Order update(Order order, Long id) {
        Order toUpdate = orderRepository.findOne(id);
        toUpdate.setOrderQuantity(order.getOrderQuantity());
        toUpdate.setUpdatedTime(order.getUpdatedTime());
        return orderRepository.save(toUpdate);
    }

    public Order getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
