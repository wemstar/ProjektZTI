package pl.edu.agh.fiis.rest.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.fiis.annotation.AdminUser;
import pl.edu.agh.fiis.annotation.DomainUser;
import pl.edu.agh.fiis.bussines.entity.builder.UserEntityBuilder;
import pl.edu.agh.fiis.bussines.services.UserService;
import pl.edu.agh.fiis.rest.dto.UserDTO;
import pl.edu.agh.fiis.rest.dto.builder.UserDTOBuilder;
import pl.edu.agh.fiis.utils.StringConstants;

/**
 * Created by wemstar on 2016-01-05.
 * Klasa przetwarzająca zapytanie dla użytkowników
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.PUT)
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(new UserEntityBuilder(userDTO).build());
    }

    @RequestMapping(method = RequestMethod.POST)
    @DomainUser
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(new UserEntityBuilder(userDTO).build());
    }

    @RequestMapping(path ="/{login}",method = RequestMethod.DELETE)
    @AdminUser
    public  void deleteUser(@PathVariable String login) {
        userService.deleteUserByLogin(login);;
    }

    @RequestMapping(method = RequestMethod.GET)
    @DomainUser
    public UserDTO getCurrentUser(@RequestHeader(StringConstants.TOKEN_HEADER) String token) {
        return new UserDTOBuilder(userService.getUserByToken(token)).build();
    }
}
