package pl.edu.agh.fiis.rest.dto;

import java.util.List;

/**
 * Created by wemstar on 2016-01-04.
 */
public class BasketDTO {

    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
