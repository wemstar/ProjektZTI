package pl.edu.agh.fiis.bussines.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.fiis.bussines.entity.BasketEntity;

/**
 * Created by wemstar on 2016-01-12.
 * Obiekt wtciagający z bazy {@link pl.edu.agh.fiis.bussines.entity.BasketEntity}
 */
public interface BasketDAO extends CrudRepository<BasketEntity,Long> {
}
