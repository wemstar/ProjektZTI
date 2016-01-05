package pl.edu.agh.fiis.bussines.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;

import java.util.List;

/**
 * Created by wemstar on 2015-12-06.
 */
public interface ProductDAO extends CrudRepository<ProductEntity,Long> {
    List<ProductEntity> findByName(String name);
}
