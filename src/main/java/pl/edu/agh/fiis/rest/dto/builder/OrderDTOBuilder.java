package pl.edu.agh.fiis.rest.dto.builder;

import pl.edu.agh.fiis.bussines.entity.OrderEntity;
import pl.edu.agh.fiis.bussines.entity.enums.OrderEntityState;
import pl.edu.agh.fiis.rest.dto.OrderDTO;
import pl.edu.agh.fiis.rest.dto.ProductCountDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-16.
 * Klasa budująca dla {@link pl.edu.agh.fiis.rest.dto.OrderDTO}
 */
public class OrderDTOBuilder {

    private Long id;

    private List<ProductCountDTO> products;

    private OrderEntityState state;

    public OrderDTOBuilder(OrderEntity order) {

        this.id = order.getId();
        this.products = ProductCountDTOBuilder.convertEntities(order.getProducts());
        this.state = order.getState();
    }

    public OrderDTO build() {
        OrderDTO dto = new OrderDTO();
        dto.setId(this.id);
        dto.setState(this.state);
        dto.setProducts(this.products);
        return dto;

    }

    public static List<OrderDTO> convertEntities(Iterable<OrderEntity> entities) {
        List<OrderDTO> dtos = new ArrayList<OrderDTO>();
        for (OrderEntity entity : entities) {
            dtos.add(new OrderDTOBuilder(entity).build());
        }
        return  dtos;

    }


}
