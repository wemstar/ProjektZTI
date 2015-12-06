package pl.edu.agh.fiis.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.fiis.entity.ProductEntity;

/**
 * Created by wemstar on 2015-12-06.
 */
public interface ProductDAO extends CrudRepository<ProductEntity,Long> {
}
