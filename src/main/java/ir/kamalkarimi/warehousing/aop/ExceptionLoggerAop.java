package ir.kamalkarimi.warehousing.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class ExceptionLoggerAop {

    private static  final Logger LOGGER = LoggerFactory.getLogger(ExceptionLoggerAop.class);

    @AfterThrowing(value = "execution(* ir.kamalkarimi.warehousing.controller.*.*(..)) || " +
            "execution(* ir.kamalkarimi.warehousing.service.*.*(..))",throwing = "ex")
    public void logException(Exception ex){
        LOGGER.error(ex.getMessage());
    }
}
