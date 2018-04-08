package com.xjst.skysweety.util.attacher;

import android.support.annotation.Nullable;

import com.xjst.skysweety.util.proxy.Enhancer;
import com.xjst.skysweety.util.proxy.MethodFilter;
import com.xjst.skysweety.util.proxy.MethodInterceptor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class Factory {

    private static final String TAG = "Factory";
    private static WeakHashMap<Class<?>, WeakHashMap<Object, Object>> cache = new WeakHashMap<>();
    private static ArrayList<Class> PrimitiveClassArray = new ArrayList<>();

    static {
        PrimitiveClassArray.add(int.class);
        PrimitiveClassArray.add(Integer.class);
        PrimitiveClassArray.add(boolean.class);
        PrimitiveClassArray.add(Boolean.class);
        PrimitiveClassArray.add(char.class);
        PrimitiveClassArray.add(Character.class);
        PrimitiveClassArray.add(Long.class);
        PrimitiveClassArray.add(short.class);
        PrimitiveClassArray.add(Short.class);
        PrimitiveClassArray.add(double.class);
        PrimitiveClassArray.add(Double.class);
        PrimitiveClassArray.add(float.class);
        PrimitiveClassArray.add(Float.class);
        PrimitiveClassArray.add(byte.class);
        PrimitiveClassArray.add(Byte.class);
    }

    /**
     * 创建class的单例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    @Nullable
    public synchronized static <T> T single(Class<T> clazz) {
        return factory(clazz, clazz, false);
    }

    /**
     * 用class对象创建对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    @Nullable
    public synchronized static <T> T newInstance(Class<T> clazz) {
        if (clazz == null) return null;
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized static <T> T newInstanceProxy(Class<T> clazz, MethodFilter filter, MethodInterceptor... interceptor) {
        Enhancer<T> enhancer = Enhancer.get(clazz);
        enhancer.setFilter(filter);
        enhancer.setInterceptor(interceptor);
        return enhancer.create();
    }
    public synchronized static <T> T newInstanceProxy(Class<T> clazz,MethodInterceptor... interceptor) {
        Enhancer<T> enhancer = Enhancer.get(clazz);
        enhancer.setInterceptor(interceptor);
        return enhancer.create();
    }


    /**
     * 通过参数构建对象
     *
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    @Nullable
    public synchronized static <T> T newInstance(Class<T> clazz, Object... args) {
        if (clazz == null) return null;
        if (args == null || args.length == 0) return newInstance(clazz);
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getDeclaredConstructors();

        if (constructors == null) return null;
        Class<?>[] types;
        Constructor<T> constructor = null;
        for (Constructor<T> temp : constructors
                ) {
            if (temp == null) continue;
            types = temp.getParameterTypes();
            if (types == null || types.length == 0) continue;
            if (types.length != args.length) continue;
            boolean flag = true;
            Object arg;
            Class<?> type;
            for (int i = 0; i < types.length; i++) {
                arg = args[i];
                type = types[i];
                if (type == null) {
                    flag = false;
                    continue;
                }
                flag = flag && (type.isInstance(arg) || checkPrimitive(type, arg));
            }
            if (flag) constructor = temp;
        }
        if (constructor != null) {
            try {
                return constructor.newInstance(args);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    private static boolean checkPrimitive(Class<?> type, Object arg) {
        if (type == null || arg == null) return false;
        Class<?> argsType = arg.getClass();
        if (argsType == type) return true;
        int argsIndex = PrimitiveClassArray.indexOf(argsType);
        int typeIndex = PrimitiveClassArray.indexOf(type);
        return argsIndex >= 0 && typeIndex >= 0 && argsIndex / 2 == typeIndex / 2;
    }


    /**
     * 对象构建工厂
     *
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    @Nullable
    public synchronized static <T> T factory(Class<T> clazz, Object... args) {
        return factory(clazz, true, args);
    }

    /**
     * 对象构建工厂
     *
     * @param clazz
     * @param isArgs
     * @param flag
     * @param <T>
     * @return
     */
    @Nullable
    public synchronized static <T> T factory(Class<T> clazz, boolean isArgs, Object... flag) {
        if (clazz == null) return null;
        if (flag == null) {
            return newInstance(clazz);
        }
        WeakHashMap<Object, Object> map = cache.get(clazz);
        if (map == null) {
            map = new WeakHashMap<>();
            cache.put(clazz, map);
        }
        T result = (T) map.get(flag);
        if (result == null) {
            if (isArgs) {
                result = newInstance(clazz, flag);
            } else {
                result = newInstance(clazz);
            }
            if (result != null)
                map.put(flag, result);
            return result;
        }
        return result;
    }


}
