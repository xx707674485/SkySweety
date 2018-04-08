package com.xjst.skysweety.util.proxy;

import java.lang.reflect.Method;

/**
 * <pre>
 *     author : zhangke
 *     e-mail : zhangke3016@gmail.com
 *     time   : 2017/05/07
 *     desc   :
 * </pre>
 */
public interface MethodFilter {
    /**
     * 过滤方法
     *
     * @param method
     * @return
     */
    boolean accept(MethodInterceptor interceptor, Method method, MethodProxy methodProxy, Object resultMaybe);
}
