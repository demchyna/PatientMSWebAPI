package demchyna.patientms.auditor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuditLoggerAspect {

    @Pointcut("@annotation(AuditLogger)")
    private void auditLoggerPointcut() {
        // by the contract the method has an empty body
    }

    @AfterReturning("auditLoggerPointcut()")
    public void afterSussesMethodExecution() {
        final HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        System.out.println(request.getRequestURL());
        System.out.println("Susses Method Execution");
    }

    @AfterThrowing("auditLoggerPointcut()")
    public void afterFailureMethodExecution() {
        final HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        System.out.println(request.getRequestURL());
        System.out.println("Failure Method Execution");
    }
}
