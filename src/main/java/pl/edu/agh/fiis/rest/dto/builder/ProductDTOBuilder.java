package pl.edu.agh.fiis.rest.dto.builder;

import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.rest.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2015-12-06.
 */
public class ProductDTOBuilder {

    private Long id;
    private String name;
    private Double value;
    private String description;

    public ProductDTOBuilder() {}

    public ProductDTOBuilder(ProductEntity entity) {
        id = entity.getId();
        name = entity.getName();
        value = entity.getValue();
        description = entity.getDescription();
    }

    public ProductDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProductDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductDTOBuilder value(Double value) {
        this.value = value;
        return this;
    }

    public ProductDTOBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductDTO build() {
        ProductDTO item = new ProductDTO();
        item.setId(id);
        item.setName(name);
        item.setValue(value);
        item.setDescription(description);
        return item;
    }

    public static List<ProductDTO> convertEntities(Iterable<ProductEntity> entities) {
        List<ProductDTO> dtos = new ArrayList<ProductDTO>();
        for (ProductEntity entity : entities) {
            dtos.add(new ProductDTOBuilder(entity).build());
        }
        return  dtos;

    }

}
