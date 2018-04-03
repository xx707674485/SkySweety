package com.xjst.skysweety.util.attacher;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.WeakHashMap;

public class Factory {

    private static WeakHashMap<Class<?>, WeakHashMap<Object, Object>> cache = new WeakHashMap<>();

    /**
     * 创建class的单例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public synchronized static <T> T single(Class<T> clazz) {
        return factory(clazz, clazz, false);
    }

    public synchronized static <T> T newInstance(Class<T> clazz) {
        if (clazz == null) return null;
        Constructor<T> constructor;
        try {
            constructor = clazz.getDeclaredConstructor();
            if (constructor != null) {
                return constructor.newInstance();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized static <T> T newInstance(Class<T> clazz, Object args) {
        if (clazz == null) return null;
        if (args == null) return newInstance(clazz);
        Constructor<T> constructor;
        try {
            constructor = clazz.getDeclaredConstructor(args.getClass());
            if (constructor != null) {
                return constructor.newInstance(args);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized static <T> T factory(Class<T> clazz, Object args) {
        return factory(clazz, args, false);
    }

    public synchronized static <T> T factory(Class<T> clazz, Object flag, boolean isArgs) {
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
            map.put(flag, result);
            return result;
        }
        return result;
    }


}
