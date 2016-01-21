package pl.edu.agh.fiis.rest.dto.builder;

import pl.edu.agh.fiis.bussines.entity.BasketEntity;
import pl.edu.agh.fiis.bussines.entity.ProductCountEntity;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.rest.dto.BasketDTO;
import pl.edu.agh.fiis.rest.dto.ProductCountDTO;
import pl.edu.agh.fiis.rest.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-04.
 * Klasa budująca dla {@link pl.edu.agh.fiis.rest.dto.BasketDTO}
 */
public class BasketDTOBuilder {

    private List<ProductCountDTO> products = new ArrayList<>();
    public BasketDTOBuilder() {}

    public BasketDTOBuilder(BasketEntity entity) {
        products = ProductCountDTOBuilder.convertEntities(entity.getProducts());
    }

    public BasketDTOBuilder products(List<ProductCountEntity> products) {
        this.products = ProductCountDTOBuilder.convertEntities(products);
        return this;
    }

    public BasketDTO build() {
        BasketDTO dto = new BasketDTO();
        dto.setProducts(products);
        return dto;

    }
}
