package pl.edu.agh.fiis.bussines.entity.builder;

import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.rest.dto.BasketDTO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-06.
 */
public class BasketEntityBuilder {

    private Set<ProductEntity> products;

    public BasketEntityBuilder() {}
    public BasketEntityBuilder(BasketDTO dto) {
        products = new HashSet<ProductEntity>( ProductEntityBuilder.convertEntities(dto.getProducts()));
    }

    public BasketEntity build() {
        BasketEntity entity = new BasketEntity();
        entity.setProducts(products);
        return entity;
    }
}
