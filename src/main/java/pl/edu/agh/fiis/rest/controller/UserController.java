package pl.edu.agh.fiis.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.fiis.rest.dto.UserDTO;

/**
 * Created by wemstar on 2016-01-05.
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {


    @RequestMapping(method = RequestMethod.PUT)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {

        return userDTO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateUser() {

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public  void deleteUser() {

    }
}
