package miu.edu.AlumniTrackingSystem.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

//    @Around(value = "execution(* miu.edu.AlumniTrackingSystem.service.Impl..*(..)))")
//    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("firstAround");
//        ObjectMapper mapper = new ObjectMapper();
//        String methodName = pjp.getSignature().getName();
//        String className = pjp.getTarget().getClass().toString();
//        Object[] array = pjp.getArgs();
//        System.out.println("secondAround");
//        log.info("method invoked " + className + " : " + methodName + "()"
//                + "arguments : "
//                + mapper.writeValueAsString(array));
//        Object object  = pjp.proceed();
//        log.info(className + " : " + methodName + "()" + "Response : "
//            );
//        return null;
//    }
}
