package pl.edu.agh.fiis.rest.dto;

import java.util.Set;

/**
 * Created by wemstar on 2016-01-05.
 */
public class UserDTO {
    private String name;
    private BasketDTO basket;
    private String password;
    private Set<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasketDTO getBasket() {
        return basket;
    }

    public void setBasket(BasketDTO basket) {
        this.basket = basket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}