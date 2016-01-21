package pl.edu.agh.fiis.bussines.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.fiis.bussines.entity.ProductEntity;

import java.util.List;

/**
 * Created by wemstar on 2015-12-06.
 * Obiekt wtciagający z bazy {@link pl.edu.agh.fiis.bussines.entity.ProductEntity}
 */
public interface ProductDAO extends CrudRepository<ProductEntity,Long> {
    List<ProductEntity> findByName(String name);
}
