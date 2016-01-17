package pl.edu.agh.fiis.bussines.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-02.
 */
@Entity
@Table(name = "ZTI_USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN",unique = true)
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="USER_ROLE", joinColumns=@JoinColumn(name="USER_ID"))
    @Column(name = "ROLE")
    private Set<String> roles;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private BasketEntity basket;

    @ManyToMany(mappedBy = "user")
    private Set<OrderEntity> orders;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public BasketEntity getBasket() {
        return basket;
    }

    public void setBasket(BasketEntity basket) {
        this.basket = basket;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
