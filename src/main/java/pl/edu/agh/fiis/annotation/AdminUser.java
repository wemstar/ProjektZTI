package pl.edu.agh.fiis.annotation;

import org.springframework.security.access.prepost.PreAuthorize;
import pl.edu.agh.fiis.utils.StringConstants;

import java.lang.annotation.*;

/**
 * Created by wemstar on 2016-01-05.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PreAuthorize("hasAuthority('"+ StringConstants.ROLE_ADMIN_USER+"')")
public @interface AdminUser {
}
