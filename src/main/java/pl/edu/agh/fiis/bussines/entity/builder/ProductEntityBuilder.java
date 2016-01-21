package pl.edu.agh.fiis.bussines.entity.builder;

import pl.edu.agh.fiis.bussines.entity.ProductEntity;
import pl.edu.agh.fiis.rest.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-06.
 * Builder dla {@link pl.edu.agh.fiis.bussines.entity.ProductEntity}
 */
public class ProductEntityBuilder {

    private Long id;
    private String name;
    private Double value;
    private String description;

    public ProductEntityBuilder() {}

    public ProductEntityBuilder(ProductDTO dto) {
        id = dto.getId();
        name = dto.getName();
        value = dto.getValue();
        description = dto.getDescription();
    }

    public ProductEntityBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProductEntityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductEntityBuilder value(Double value) {
        this.value = value;
        return this;
    }

    public ProductEntityBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductEntity build() {
        ProductEntity item = new ProductEntity();
        item.setId(id);
        item.setName(name);
        item.setValue(value);
        item.setDescription(description);
        return item;
    }

    public static List<ProductEntity> convertEntities(Iterable<ProductDTO> entities) {
        List<ProductEntity> dtos = new ArrayList<ProductEntity>();
        for (ProductDTO entity : entities) {
            dtos.add(new ProductEntityBuilder(entity).build());
        }
        return  dtos;

    }
}
