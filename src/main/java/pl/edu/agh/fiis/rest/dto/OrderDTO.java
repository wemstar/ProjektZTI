package pl.edu.agh.fiis.rest.dto;

import pl.edu.agh.fiis.bussines.entity.enums.OrderEntityState;

import java.util.List;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-16.
 * Klasa transportująca zlecenie
 */
public class OrderDTO {

    private Long id;

    private List<ProductCountDTO> products;

    private OrderEntityState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductCountDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCountDTO> products) {
        this.products = products;
    }

    public OrderEntityState getState() {
        return state;
    }

    public void setState(OrderEntityState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", products=" + products +
                ", state=" + state +
                '}';
    }
}
