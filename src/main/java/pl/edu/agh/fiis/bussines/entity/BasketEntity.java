package pl.edu.agh.fiis.bussines.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-04.
 */
@Entity
@Table(name = "BASKET")
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BASKET_ID")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_BASKET", joinColumns = {
            @JoinColumn(name = "BASKET_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID",
                    nullable = false, updatable = false) })
    private Set<ProductEntity> products;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BASKET_USER_ID", unique= true, nullable=true, insertable=false, updatable=true)
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
