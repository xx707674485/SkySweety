package com.xjst.publiclibrary.adapter;

import java.util.ArrayList;
import java.util.List;

public class BaseItemWrapper<T> implements BaseItem {
    private LayoutProvider<T> provider;
    private AdapterDataBinder<T> binder;

    private T data;

    private BaseItemWrapper(LayoutProvider<T> provider, AdapterDataBinder<T> binder, T data) {
        this.provider = provider;
        this.binder = binder;
        this.data = data;
    }

    @Override
    public void bind(BinderAdapter adapter, BaseItem data, BinderViewHolder holder, int index) {
        binder.bind(adapter, this.data, holder, index);
    }

    @Override
    public int getLayoutId(BaseItem data) {
        return provider.getLayoutId(this.data);
    }

    public static <T> BaseItemWrapper<T> wrap(T data, LayoutProvider<T> provider, AdapterDataBinder<T> binder) {
        return new BaseItemWrapper<>(provider, binder, data);
    }

    public static <T> List<BaseItemWrapper<T>> wrapList(List<T> data, LayoutProvider<T> provider, AdapterDataBinder<T> binder) {
        if (data == null) return new ArrayList<>();
        List<BaseItemWrapper<T>> result = new ArrayList<>();
        for (T temp : data
                ) {
            result.add(wrap(temp, provider, binder));
        }
        return result;
    }

    public static <T>List<BaseItem> toBaseItem(List<T> data,LayoutProvider<T> provider, AdapterDataBinder<T> binder){
        if (data == null) return new ArrayList<>();
        List<BaseItem> result = new ArrayList<>();
        for (T temp : data
                ) {
            result.add(wrap(temp, provider, binder));
        }
        return result;
    }
}
