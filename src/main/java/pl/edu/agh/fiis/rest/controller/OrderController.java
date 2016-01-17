package pl.edu.agh.fiis.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.fiis.annotation.DomainUser;
import pl.edu.agh.fiis.bussines.services.OrderService;
import pl.edu.agh.fiis.rest.dto.OrderDTO;
import pl.edu.agh.fiis.rest.dto.builder.OrderDTOBuilder;
import pl.edu.agh.fiis.utils.StringConstants;

import java.util.List;

/**
 * Created by wemstar on 2016-01-05.
 */
@RestController
@RequestMapping(path = "/order")
@DomainUser
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.PUT)
    public OrderDTO  placeOrder(@RequestHeader(StringConstants.TOKEN_HEADER) String token) {
        return new OrderDTOBuilder(orderService.placeOrder(token)).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderDTO> getOrders(@RequestHeader(StringConstants.TOKEN_HEADER) String token) {
        return OrderDTOBuilder.convertEntities(orderService.getOrders(token));
    }

    @RequestMapping(path = "/{orderId}",method = RequestMethod.GET)
    public OrderDTO getOrder(@RequestHeader(StringConstants.TOKEN_HEADER) String token, @PathVariable Long orderId){
        return new OrderDTOBuilder(orderService.getOrder(token,orderId)).build();
    }

    @RequestMapping(path = "/{orderId}",method = RequestMethod.DELETE)
    public void cancelOrder(@RequestHeader(StringConstants.TOKEN_HEADER) String token,@PathVariable Long orderId){
        orderService.cancelOrder(token,orderId);
    }

}
