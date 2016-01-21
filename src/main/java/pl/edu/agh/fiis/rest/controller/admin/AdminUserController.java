package pl.edu.agh.fiis.rest.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.fiis.annotation.AdminUser;
import pl.edu.agh.fiis.bussines.entity.builder.UserEntityBuilder;
import pl.edu.agh.fiis.bussines.services.UserService;
import pl.edu.agh.fiis.rest.dto.UserDTO;
import pl.edu.agh.fiis.rest.dto.builder.UserDTOBuilder;

import java.util.List;

/**
 * Created by wemstar on 2016-01-19.
 * Klasa przetwarzająca zapytania administracyjne dla uzytkowników
 */
@RestController
@AdminUser
@RequestMapping(path = "/admin/user")
public class AdminUserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAllUser(){
        return UserDTOBuilder.converEntities(userService.getAllUsers());
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable  Long id){
        return new UserDTOBuilder(userService.getUserById(id)).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateUser(@RequestBody UserDTO user){
        userService.updateUser(new UserEntityBuilder(user).build());
    }
}
