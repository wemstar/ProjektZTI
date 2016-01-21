package pl.edu.agh.fiis.annotation;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.edu.agh.fiis.utils.StringConstants;

import java.lang.annotation.*;

/**
 * Created by wemstar on 2015-12-22.
 * Adnotacja zezwalający tylko zalogowanym użytkownikom wywoływanie metod
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize("hasAnyAuthority('"+ StringConstants.ROLE_DOMAIN_USER+"','"+StringConstants.ROLE_ADMIN_USER+"')")
public @interface DomainUser {
}
