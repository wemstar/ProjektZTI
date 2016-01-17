package pl.edu.agh.fiis.rest.dto;

/**
 * Created by wemstar on 2016-01-07.
 */
public class ProductCountDTO {

    private ProductDTO product;
    private Integer count;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProductCountDTO{" +
                "product=" + product +
                ", count=" + count +
                '}';
    }
}
