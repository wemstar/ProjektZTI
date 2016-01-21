package pl.edu.agh.fiis.bussines.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.fiis.bussines.entity.UserEntity;

import java.util.List;

/**
 * Created by wemstar on 2016-01-02.
 * Obiekt wtciagający z bazy {@link pl.edu.agh.fiis.bussines.entity.UserEntity}
 */
public interface UserDAO extends CrudRepository<UserEntity,Long> {

    List<UserEntity> findByLogin(String login);
}
