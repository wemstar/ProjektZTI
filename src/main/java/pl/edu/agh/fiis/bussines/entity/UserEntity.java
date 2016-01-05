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
    private Set<String> role;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private BasketEntity basket;

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

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public BasketEntity getBasket() {
        return basket;
    }

    public void setBasket(BasketEntity basket) {
        this.basket = basket;
    }
}
