package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.bussines.dao.BasketDAO;
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

    @Autowired
    private BasketDAO basketDAO;

    public BasketEntity getBasket(String token) {
        return userService.getUserByToken(token).getBasket();
    }

    public void addToBasket(String token,Long productId, Integer amount) {
        BasketEntity basket = getBasket(token);
        basket.getProducts().add(new ProductCountEntityBuilder()
                .product(productService.getProduct(productId))
                .count(amount)
                .build());
        basketDAO.save(basket);

    }

    public void removeFromBasket(String token, final Long productId) {
        BasketEntity basket = getBasket(token);
        basket.getProducts().removeIf(productCountEntity -> productCountEntity.getProduct().getId().equals(productId));
        basketDAO.save(basket);
    }
}
