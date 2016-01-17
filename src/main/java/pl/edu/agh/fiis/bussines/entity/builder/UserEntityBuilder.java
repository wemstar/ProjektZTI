package pl.edu.agh.fiis.bussines.entity.builder;

import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.UserEntity;
import pl.edu.agh.fiis.rest.dto.UserDTO;

import java.util.Set;

/**
 * Created by wemstar on 2016-01-06.
 */
public class UserEntityBuilder {

    private Long id;
    private String login;
    private String password;
    private Set<String> role;
    private BasketEntity basket;
    private String email;
    private String city;
    private String street;

    public UserEntityBuilder() {

    }
    public UserEntityBuilder(UserDTO dto) {
        login = dto.getLogin();
        password = dto.getPassword();
        role = dto.getRoles();
        email = dto.getEmail();
        city = dto.getCity();
        street = dto.getStreet();
        basket = dto.getBasket() != null ? new BasketEntityBuilder(dto.getBasket()).build() : null;
    }
    public UserEntityBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserEntityBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UserEntityBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserEntityBuilder role(Set<String> role) {
        this.role = role;
        return this;
    }

    public UserEntityBuilder basket(BasketEntity basket) {
        this.basket = basket;
        return this;
    }

    public UserEntityBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserEntityBuilder city(String city) {
        this.city = city;
        return this;
    }

    public UserEntityBuilder street(String street) {
        this.street = street;
        return this;
    }

    public UserEntity build() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        userEntity.setRoles(role);
        //userEntity.setBasket(basket);
        userEntity.setEmail(email);
        userEntity.setCity(city);
        userEntity.setStreet(street);
        return userEntity;
    }
}
