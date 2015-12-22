package pl.edu.agh.fiis;

import pl.edu.agh.fiis.AuthenticationWithToken;

/**
 * Created by wemstar on 2015-12-22.
 */
public interface ExternalServiceAuthenticator {
    AuthenticationWithToken authenticate(String username, String password);
}
