package pl.edu.agh.fiis.bussines.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.fiis.bussines.entity.OrderEntity;

/**
 * Created by wemstar on 2016-01-16.
 */
public interface OrderDAO extends CrudRepository<OrderEntity,Long> {
}
