package com.xjst.skysweety.util.attacher;

public class Attacher<T> {
    protected T target;
    protected Attacher(T target){
        this.target=target;
    }

    public static <T extends Attacher> T attach(Class<T> clazz,Object args){
        return Factory.factory(clazz,args);
    }


}
