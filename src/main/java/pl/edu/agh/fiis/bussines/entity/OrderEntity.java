package pl.edu.agh.fiis.bussines.entity;



import pl.edu.agh.fiis.bussines.entity.enums.OrderEntityState;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-07.
 */
@Entity
@Table(name = "ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<ProductCountEntity> products;

    @Column(name = "ORDER_STATE")
    private OrderEntityState state;

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
}
