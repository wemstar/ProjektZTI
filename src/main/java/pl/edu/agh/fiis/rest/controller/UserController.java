package pl.edu.agh.fiis.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.fiis.bussines.entity.builder.UserEntityBuilder;
import pl.edu.agh.fiis.bussines.services.UserService;
import pl.edu.agh.fiis.rest.dto.UserDTO;
import pl.edu.agh.fiis.rest.dto.builder.UserDTOBuilder;

/**
 * Created by wemstar on 2016-01-05.
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.PUT)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        userDTO = new UserDTOBuilder(
                userService.createUser(
                        new UserEntityBuilder(userDTO).build()))
                .build();
        return userDTO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(new UserEntityBuilder(userDTO).build());
    }

    @RequestMapping(path ="/{login}",method = RequestMethod.DELETE)
    public  void deleteUser(@PathVariable String login) {
        userService.deleteUserByLogin(login);;
    }
}
