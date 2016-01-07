package pl.edu.agh.fiis.rest.dto.builder;

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
public class ProductCountDTOBuilder {

    private ProductDTO product;
    private Integer count;

    public ProductCountDTOBuilder() {}

    public ProductCountDTOBuilder(ProductCountEntity entity) {
        product = new ProductDTOBuilder(entity.getProduct()).build();
        count = entity.getCount();
    }



    public ProductCountDTO build() {
        ProductCountDTO dto = new ProductCountDTO();
        dto.setCount(count);
        dto.setProduct(product);
        return dto;
    }

    public static List<ProductCountDTO> convertEntities(Iterable<ProductCountEntity> entities) {
        List<ProductCountDTO> dtos = new ArrayList<ProductCountDTO>();
        for (ProductCountEntity entity : entities) {
            dtos.add(new ProductCountDTOBuilder(entity).build());
        }
        return  dtos;

    }
}
