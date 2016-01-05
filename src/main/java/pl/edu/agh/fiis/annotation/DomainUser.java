package pl.edu.agh.fiis.annotation;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.edu.agh.fiis.utils.StringConstants;

import java.lang.annotation.*;

/**
 * Created by wemstar on 2015-12-22.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize("hasAuthority('"+ StringConstants.ROLE_DOMAIN_USER+"')")
public @interface DomainUser {
}
