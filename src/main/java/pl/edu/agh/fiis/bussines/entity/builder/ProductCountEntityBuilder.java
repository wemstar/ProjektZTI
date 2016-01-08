package pl.edu.agh.fiis.bussines.entity.builder;

import pl.edu.agh.fiis.bussines.entity.ProductCountEntity;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.rest.dto.ProductCountDTO;
import pl.edu.agh.fiis.rest.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wemstar on 2016-01-07.
 */
public class ProductCountEntityBuilder {

    private ProductEntity product;
    private Integer count;

    public ProductCountEntityBuilder() {}

    public ProductCountEntityBuilder(ProductCountDTO dto) {
        product = new ProductEntityBuilder(dto.getProduct()).build();
        count = dto.getCount();
    }

    public ProductCountEntityBuilder product(ProductDTO product) {
        this.product = new ProductEntityBuilder(product).build();
        return this;
    }

    public ProductCountEntityBuilder product(ProductEntity product) {
        this.product = product;
        return this;
    }

    public ProductCountEntityBuilder count(Integer count) {
        this.count = count;
        return this;
    }

    public ProductCountEntity build() {
        ProductCountEntity entity = new ProductCountEntity();
        entity.setCount(count);
        entity.setProduct(product);
        return entity;
    }

    public static List<ProductCountEntity> convertEntities(Iterable<ProductCountDTO> entities) {
        List<ProductCountEntity> dtos = new ArrayList<ProductCountEntity>();
        for (ProductCountDTO entity : entities) {
            dtos.add(new ProductCountEntityBuilder(entity).build());
        }
        return  dtos;

    }
}
