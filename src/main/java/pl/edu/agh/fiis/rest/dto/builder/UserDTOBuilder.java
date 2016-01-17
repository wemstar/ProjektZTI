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
    private String email;
    private String city;
    private String street;

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

    public UserDTOBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserDTOBuilder city(String city) {
        this.city = city;
        return this;
    }

    public UserDTOBuilder street(String street) {
        this.street = street;
        return this;
    }

    public UserDTOBuilder(){}

    public UserDTOBuilder(UserEntity entity){
        login = entity.getLogin();
        password = entity.getPassword();
        basket = new BasketDTOBuilder(entity.getBasket()).build();
        roles = entity.getRoles();
        email = entity.getEmail();
        city = entity.getCity();
        street = entity.getCity();
    }

    public UserDTO build(){
        UserDTO dto = new UserDTO();
        dto.setLogin(login);
        dto.setPassword(password);
        dto.setBasket(basket);
        dto.setRoles(roles);
        dto.setEmail(email);
        dto.setCity(city);
        dto.setStreet(street);
        return dto;
    }
}
