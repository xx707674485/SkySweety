package com.xjst.skysweety.util.proxy;

import java.lang.reflect.Method;

public class MethodProxyExecuter {

    @SuppressWarnings({"rawtypes"})
    public static Object executeInterceptor(MethodInterceptor[] interceptors, MethodFilter methodFilter, MethodInterceptor interceptor, Class superClass, String methodName,
                                            Class[] argsType, Object[] argsValue, Object object) {
        MethodProxy methodProxy = new MethodProxy(superClass, methodName, argsType);
        if (interceptor == null && interceptors == null && methodFilter == null) {
//			throw new ProxyException("Did not set method interceptor !");

            return methodProxy.invokeSuper(object, argsValue);
        }
        try {
            if (interceptors != null) {
                Object result = null;
                for (MethodInterceptor temp : interceptors
                        ) {
                    if (methodFilter != null && methodFilter.accept(temp, object.getClass().getDeclaredMethod(methodName, argsType), methodProxy, result))
                        result = temp.intercept(object, argsValue, methodProxy);
                }
                return result;
            }
            if (interceptor != null) {
                return interceptor.intercept(object, argsValue, methodProxy);
            }
            return methodProxy.invokeSuper(object, argsValue);
        } catch (Exception e) {
            throw new ProxyException(e.getMessage());
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object executeMethod(Class subClass, String methodName, Class[] argsType, Object[] argsValue, Object object) {
        try {
            Method method = subClass.getDeclaredMethod(methodName + Const.SUBCLASS_INVOKE_SUPER_SUFFIX, argsType);
            return method.invoke(object, argsValue);
        } catch (Exception e) {
            throw new ProxyException(e.getMessage());
        }
    }

}
