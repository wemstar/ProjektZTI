package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.bussines.entity.BasketEntity;

/**
 * Created by wemstar on 2016-01-04.
 */
@Service
public class BasketService {

    @Autowired
    private UserServices userServices;

    public BasketEntity getBasket(String token) {

        return userServices.getUserByToken(token).getBasket();
    }
}
