package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.builder.ProductCountEntityBuilder;

/**
 * Created by wemstar on 2016-01-04.
 */
@Service
public class BasketService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public BasketEntity getBasket(String token) {
        return userService.getUserByToken(token).getBasket();
    }

    public void addToBasket(String token,Long productId, Integer amount) {
        getBasket(token).getProducts().add(new ProductCountEntityBuilder()
                .product(productService.getProduct(productId))
                .count(amount)
                .build());
    }
}
