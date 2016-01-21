package pl.edu.agh.fiis.rest.dto;

import java.util.List;

/**
 * Created by wemstar on 2016-01-04.
 * Klasa trasportująca koszyk
 */
public class BasketDTO {

    private List<ProductCountDTO> products;

    public List<ProductCountDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCountDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "BasketDTO{" +
                "products=" + products +
                '}';
    }
}
