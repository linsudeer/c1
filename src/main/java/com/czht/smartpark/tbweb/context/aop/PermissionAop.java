package com.czht.smartpark.tbweb.context.aop;

import com.czht.smartpark.tbweb.context.aop.annotation.Permission;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.naming.NoPermissionException;
import java.lang.reflect.Method;

@Aspect
@Component
public class PermissionAop {

    @Pointcut(value = "@annotation(com.czht.smartpark.tbweb.context.aop.annotation.Permission)")
    private void cutPermission() {

    }

    @Around("cutPermission()")
    public Object doPermission(ProceedingJoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        Permission permission = method.getAnnotation(Permission.class);
        String permissions = permission.value();
        if (StringUtils.isBlank(permissions)) {
            throw new NoPermissionException();
        } else {
            //检查指定角色

            System.out.println(permissions);
            return point.proceed();
        }

    }
}

