package pl.edu.agh.fiis.rest.controller.user;


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

    @RequestMapping(method = RequestMethod.GET)
    public BasketDTO getBasket(@RequestHeader(StringConstants.TOKEN_HEADER) String token) {
        return new BasketDTOBuilder(basketService.getBasket(token)).build();
    }

    @RequestMapping(path = "/{productId}/{amount}",method = RequestMethod.POST)
    public void addToBasket(@RequestHeader(StringConstants.TOKEN_HEADER) String token,@PathVariable Long productId,@PathVariable Integer amount) {
        basketService.addToBasket(token,productId,amount);
    }

    @RequestMapping(path = "/{productId}",method = RequestMethod.DELETE)
    public void removeFromBasket(@RequestHeader(StringConstants.TOKEN_HEADER) String token,@PathVariable Long productId){
        basketService.removeFromBasket(token,productId);
    }


}
