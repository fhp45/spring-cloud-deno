package com.fhp.usercenter.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public SystemLogAspect(){
    }
    //本地异常日志记录对象
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("@annotation(com.fhp.usercenter.log.ServiceLogAccessor)")
    public void serviceAspect(){
    }

    @Pointcut("@annotation(com.fhp.usercenter.log.ControllerLogAccessor)")
    public void controllerAspect(){
    }

    @Before("controllerAspect()")
    public void doBeforeController(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Map<String,String[]> map = request.getParameterMap();
        //User user = (User) session.getAttribute("User");
        //请求的IP    
        String ip = request.getRemoteAddr();
        try {
            //*========控制台输出=========*//    
            System.out.println("=====control 前置通知开始=====");
            kafkaTemplate.send("test",joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人ID:" + request.getParameterMap().get("id"));
            System.out.println("请求IP:" + ip);
            System.out.println("=====前置通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志    
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLogAccessor.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
