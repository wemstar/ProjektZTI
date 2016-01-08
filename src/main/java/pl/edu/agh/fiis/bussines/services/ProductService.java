package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.bussines.dao.ProductDAO;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;

/**
 * Created by wemstar on 2016-01-07.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ProductEntity createProduct(ProductEntity productEntity) {
        return productDAO.save(productEntity);
    }

    public void updatePoduct(ProductEntity entity){
        ProductEntity stored = productDAO.findOne(entity.getId());
        stored.setName(entity.getName());
        stored.setDescription(entity.getDescription());
        stored.setValue(entity.getValue());
        productDAO.save(stored);
    }

    public ProductEntity getProduct(Long id) {
        return productDAO.findOne(id);
    }
}
