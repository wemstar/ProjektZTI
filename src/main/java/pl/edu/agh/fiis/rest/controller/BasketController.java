package pl.edu.agh.fiis.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.fiis.annotation.DomainUser;
import pl.edu.agh.fiis.rest.dto.builder.BasketDTOBuilder;
import pl.edu.agh.fiis.rest.dto.BasketDTO;
import pl.edu.agh.fiis.bussines.services.BasketService;
import pl.edu.agh.fiis.utils.StringConstants;


/**
 * Created by wemstar on 2016-01-04.
 */
@RestController
@RequestMapping(path = "/basket")
@DomainUser
public class BasketController {

    @Autowired
    private BasketService basketService;

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public BasketDTO getBasket(@RequestHeader(StringConstants.TOKEN_HEADER) String token) {
        return new BasketDTOBuilder(basketService.getBasket(token)).build();
    }

    @RequestMapping(path = "/{productId}/{amount}")
    public void addToBasket(@PathVariable Long productId,@PathVariable Integer amount) {
        //basketService.addToBasket(productId,amount);
    }


}
