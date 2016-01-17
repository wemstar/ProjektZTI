package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.fiis.bussines.dao.OrderDAO;
import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.OrderEntity;
import pl.edu.agh.fiis.bussines.entity.UserEntity;
import pl.edu.agh.fiis.bussines.entity.builder.OrderEntityBuilder;

import java.util.Set;

/**
 * Created by wemstar on 2016-01-07.
 */
@Service
public class OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDAO orderDAO;


    @Transactional
    public OrderEntity placeOrder(String token) {
        UserEntity userEntity  = userService.getUserByToken(token);
        OrderEntity orderEntity = new OrderEntityBuilder(userEntity).build();
        orderEntity = orderDAO.save(orderEntity);
        userEntity.getBasket().getProducts().clear();
        userService.updateUser(userEntity);
        return orderEntity;
    }

    public Set<OrderEntity> getOrders(String token) {
        return userService.getUserByToken(token).getOrders();
    }

    public OrderEntity getOrder(String token, Long orderId) {
        return orderDAO.findOne(orderId);
    }

    public void cancelOrder(String token, Long orderId) {
        orderDAO.delete(orderId);
    }
}
