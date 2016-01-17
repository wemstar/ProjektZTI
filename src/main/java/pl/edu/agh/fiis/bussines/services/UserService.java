package pl.edu.agh.fiis.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.bussines.dao.UserDAO;
import pl.edu.agh.fiis.domain.authentication.AuthenticationWithToken;
import pl.edu.agh.fiis.domain.authentication.TokenService;
import pl.edu.agh.fiis.bussines.entity.UserEntity;

import java.util.List;

/**
 * Created by wemstar on 2016-01-02.
 */
@Service
public class UserService {

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TokenService tokenService;

    public AuthenticationWithToken authenticate(String login,String password) {
        List<UserEntity> userEntities = userDAO.findByLogin(login);

        if(userEntities.isEmpty())
            throw new UsernameNotFoundException("User " + login + " not found");
        UserEntity user = userEntities.get(0);
        if(!shaPasswordEncoder.isPasswordValid(user.getPassword(),password,login))
            throw new BadCredentialsException("User " + login + " bad password");

        return new AuthenticationWithToken(login,password, AuthorityUtils.createAuthorityList(user.getRoles().toArray(new String[0])));
    }

    public UserEntity getUserByToken(String token) {
        Authentication result = tokenService.retrieve(token);
        String login = String.class.cast(result.getPrincipal());

        return userDAO.findByLogin(login).get(0);
    }


    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(shaPasswordEncoder.encodePassword(userEntity.getPassword(),userEntity.getLogin()));
        return userDAO.save(userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        UserEntity stored = userDAO.findByLogin(userEntity.getLogin()).get(0);
        stored.setLogin(userEntity.getLogin());
        stored.setBasket(userEntity.getBasket());
        stored.setRoles(userEntity.getRoles());
        stored.setOrders(userEntity.getOrders());
        userDAO.save(stored);
    }

    public void deleteUserByLogin(String login) {
        userDAO.delete(userDAO.findByLogin(login));
    }
}
