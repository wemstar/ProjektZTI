package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.bussines.entity.UserEntity;

/**
 * Created by wemstar on 2016-01-07.
 */
@Service
public class OrderService {
    @Autowired
    private UserService userService;


    public void placeOrder(String token) {
        UserEntity userEntity = userService.getUserByToken(token);

    }
}
