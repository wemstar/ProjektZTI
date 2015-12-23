package pl.edu.agh.fiis.domain.authentication;

import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


/**
 * Created by wemstar on 2015-12-22.
 */
public class DomainUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private TokenService tokenService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<String> username = (Optional<String>) authentication.getPrincipal();
        Optional<String> password = (Optional<String>) authentication.getCredentials();

        if (!username.isPresent() || !password.isPresent()) {
            throw new BadCredentialsException("Invalid Domain User Credentials");
        }
        // TODO: Dodać poprawną authentykację
        AuthenticationWithToken resultOfAuthentication = new AuthenticationWithToken("user","user");//externalServiceAuthenticator.authenticate(username.get(), password.get());
        String newToken = tokenService.generateNewToken();
        resultOfAuthentication.setToken(newToken);
        tokenService.store(newToken, resultOfAuthentication);
        resultOfAuthentication.setAuthenticated(true);
        return resultOfAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
