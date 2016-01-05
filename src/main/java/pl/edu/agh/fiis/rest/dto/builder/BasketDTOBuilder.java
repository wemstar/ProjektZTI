package pl.edu.agh.fiis.rest.dto.builder;

import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.rest.dto.BasketDTO;
import pl.edu.agh.fiis.rest.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-04.
 */
public class BasketDTOBuilder {

    private List<ProductDTO> products = new ArrayList<>();
    public BasketDTOBuilder() {}

    public BasketDTOBuilder(BasketEntity entity) {
        products = ProductDTOBuilder.convertEntities(entity.getProducts());
    }

    public BasketDTOBuilder products(List<ProductEntity> products) {
        this.products = ProductDTOBuilder.convertEntities(products);
        return this;
    }

    public BasketDTO build() {
        BasketDTO dto = new BasketDTO();
        dto.setProducts(products);
        return dto;

    }
}
