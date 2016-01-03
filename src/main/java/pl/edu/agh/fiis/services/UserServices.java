package pl.edu.agh.fiis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.agh.fiis.dao.UserDAO;
import pl.edu.agh.fiis.domain.authentication.AuthenticationWithToken;
import pl.edu.agh.fiis.entity.UserEntity;

import java.util.List;

/**
 * Created by wemstar on 2016-01-02.
 */
@Service
public class UserServices {

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    public AuthenticationWithToken authenticate(String login,String password) {
        List<UserEntity> userEntities = userDAO.findByLogin(login);

        if(userEntities.isEmpty())
            throw new UsernameNotFoundException("User " + login + " not found");
        UserEntity user = userEntities.get(0);
        String pas = shaPasswordEncoder.encodePassword(password,login);
        if(!shaPasswordEncoder.isPasswordValid(user.getPassword(),password,login))
            throw new BadCredentialsException("User " + login + " bad password");

        return new AuthenticationWithToken(login,password, AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
    }


}
