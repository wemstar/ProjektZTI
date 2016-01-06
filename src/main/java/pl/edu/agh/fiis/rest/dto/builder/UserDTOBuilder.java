package pl.edu.agh.fiis.rest.dto.builder;

import pl.edu.agh.fiis.bussines.entity.UserEntity;
import pl.edu.agh.fiis.rest.dto.BasketDTO;
import pl.edu.agh.fiis.rest.dto.UserDTO;

import java.util.Set;

/**
 * Created by wemstar on 2016-01-06.
 */
public class UserDTOBuilder {

    private String login;
    private BasketDTO basket;
    private String password;
    private Set<String> roles;

    public UserDTOBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UserDTOBuilder basket(BasketDTO basket) {
        this.basket = basket;
        return this;
    }

    public UserDTOBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserDTOBuilder roles(Set<String> roles) {
        this.roles = roles;
        return this;
    }

    public UserDTOBuilder(){}

    public UserDTOBuilder(UserEntity entity){
        login = entity.getLogin();
        password = entity.getPassword();
        basket = new BasketDTOBuilder(entity.getBasket()).build();
        roles = entity.getRoles();
    }

    public UserDTO build(){
        UserDTO dto = new UserDTO();
        dto.setLogin(login);
        dto.setPassword(password);
        dto.setBasket(basket);
        dto.setRoles(roles);
        return dto;
    }
}
