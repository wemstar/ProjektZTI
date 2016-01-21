package pl.edu.agh.fiis.bussines.entity;



import pl.edu.agh.fiis.bussines.entity.enums.OrderEntityState;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-07.
 * Klasa encyjna dla zlecenia
 */
@Entity
@Table(name = "ORDER_TAB")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDER_COUNT_PRODUCT", joinColumns = {
            @JoinColumn(name = "ORDER_ID", nullable = true, updatable = true) },
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_COUNT_ID",
                    nullable = true, updatable = true) })
    private Set<ProductCountEntity> products;

    @Column(name = "ORDER_STATE")
    private OrderEntityState state;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ORDER_User", joinColumns = {
            @JoinColumn(name = "ORDER_ID", nullable = true, updatable = true) },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID",
                    nullable = true, updatable = true) })
    private Set<UserEntity> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductCountEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductCountEntity> products) {
        this.products = products;
    }

    public OrderEntityState getState() {
        return state;
    }

    public void setState(OrderEntityState state) {
        this.state = state;
    }

    public Set<UserEntity> getUser() {
        return user;
    }

    public void setUser(Set<UserEntity> user) {
        this.user = user;
    }
}
