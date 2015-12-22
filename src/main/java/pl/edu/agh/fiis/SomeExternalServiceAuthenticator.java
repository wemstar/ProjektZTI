package pl.edu.agh.fiis;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by wemstar on 2015-12-22.
 */
public class SomeExternalServiceAuthenticator implements ExternalServiceAuthenticator{
    @Override
    public AuthenticationWithToken authenticate(String username, String password) {
        AuthenticatedExternalWebService authenticatedExternalWebService = new AuthenticatedExternalWebService(new DomainUser(username), null,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DOMAIN_USER"));
        return authenticatedExternalWebService;
    }
}
