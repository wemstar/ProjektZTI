package pl.edu.agh.fiis.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.fiis.bussines.services.OrderService;
import pl.edu.agh.fiis.utils.StringConstants;

/**
 * Created by wemstar on 2016-01-05.
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.PUT)
    public void  placeOrder(@RequestHeader(StringConstants.TOKEN_HEADER) String token) {
        orderService.placeOrder(token);
    }
}
