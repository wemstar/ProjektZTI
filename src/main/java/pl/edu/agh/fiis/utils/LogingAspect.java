package pl.edu.agh.fiis.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 2016-01-17.
 * Aspekt odpowiadający za tworzenie logów z wywołań usług restowych
 */
@Aspect
@Component
public class LogingAspect {

    private final Log log = LogFactory.getLog(this.getClass());

    @Around("execution(* pl.edu.agh.fiis.rest.controller..*.*(..))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {



        Object retVal = joinPoint.proceed();

        StringBuffer logMessage = new StringBuffer();
        logMessage.append(joinPoint.getTarget().getClass().getName());
        logMessage.append(".");
        logMessage.append(joinPoint.getSignature().getName());
        logMessage.append("(");
        // append args
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }

        logMessage.append(")");
        if(retVal != null) {
            logMessage.append("return (");
            logMessage.append(retVal.toString());
            logMessage.append(")");
        }
        log.info(logMessage.toString());
        return retVal;
    }

}

