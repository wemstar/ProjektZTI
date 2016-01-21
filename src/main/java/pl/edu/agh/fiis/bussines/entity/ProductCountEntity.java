package pl.edu.agh.fiis.bussines.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-07.
 * Klasa encyjna dla ilości produktów
 */
@Entity
@Table(name = "PRODUCT_COUNT")
public class ProductCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_COUNT_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity product;

    @Column(name = "PRODUCT_COUNT_COUNT")
    private Integer count;

    @ManyToMany(mappedBy = "products")
    private Set<OrderEntity> orders;

    @ManyToMany(mappedBy = "products")
    private Set<BasketEntity> baskets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public Set<BasketEntity> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<BasketEntity> baskets) {
        this.baskets = baskets;
    }
}
