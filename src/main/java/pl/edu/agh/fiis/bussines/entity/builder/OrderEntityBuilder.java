package pl.edu.agh.fiis.bussines.entity.builder;

import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.OrderEntity;
import pl.edu.agh.fiis.bussines.entity.ProductCountEntity;
import pl.edu.agh.fiis.bussines.entity.UserEntity;
import pl.edu.agh.fiis.bussines.entity.enums.OrderEntityState;
import pl.edu.agh.fiis.rest.dto.OrderDTO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-16.
 */
public class OrderEntityBuilder {

    private Long id;

    private Set<ProductCountEntity> products;

    private OrderEntityState state;

    private UserEntity user;

    public OrderEntityBuilder(UserEntity user) {
        products = new HashSet<>(user.getBasket().getProducts());
        state = OrderEntityState.NEW;
        this.user = user;
    }

    public OrderEntityBuilder(OrderDTO order) {
        id = order.getId();
        products = new HashSet<>(ProductCountEntityBuilder.convertEntities(order.getProducts()));
        state = order.getState();
    }

    public OrderEntityBuilder id(Long id){
        this.id = id;
        return this;
    }

    public OrderEntityBuilder products(Set<ProductCountEntity> products){
        this.products = products;
        return this;
    }

    public OrderEntityBuilder state(OrderEntityState state){
        this.state = state;
        return this;
    }

    public OrderEntityBuilder user(UserEntity user) {
        this.user = user;
        return this;
    }

    public OrderEntity build() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProducts(this.products);
        orderEntity.setId(this.id);
        orderEntity.setState(this.state);
        HashSet<UserEntity> user = new HashSet<>();
        user.add(this.user);
        orderEntity.setUser(user);
        return orderEntity;
    }
}
