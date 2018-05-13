package com.xjst.publiclibrary.adapter;

public interface AdapterDataBinder<T> {
    void bind(BinderAdapter adapter, T data, BinderViewHolder holder, int index);
}
