package pl.edu.agh.fiis.rest.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.fiis.annotation.AdminUser;
import pl.edu.agh.fiis.bussines.entity.builder.OrderEntityBuilder;
import pl.edu.agh.fiis.bussines.services.OrderService;
import pl.edu.agh.fiis.rest.dto.OrderDTO;
import pl.edu.agh.fiis.rest.dto.builder.OrderDTOBuilder;

import java.util.List;

/**
 * Created by wemstar on 2016-01-18.
 * Klasa przetwarzająca zapytania administracyjne dla zleceń
 */
@AdminUser
@RestController
@RequestMapping(path = "/admin/order")
public class AdminOrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderDTO> getAllOrder(){
        return OrderDTOBuilder.convertEntities(orderService.getAllOrder());
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public OrderDTO getOrderById(@PathVariable  Long id){
        return new OrderDTOBuilder(orderService.getOrders(id)).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrder(@RequestBody OrderDTO order) {
        orderService.updateOrder(new OrderEntityBuilder(order).build());
    }
}
