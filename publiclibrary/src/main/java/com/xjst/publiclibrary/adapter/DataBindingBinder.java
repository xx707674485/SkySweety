package com.xjst.publiclibrary.adapter;

import android.databinding.ViewDataBinding;

import com.xjst.publiclibrary.recycleviewadapthelp.BaseViewHolder;

public interface DataBindingBinder<T> extends AdapterDataBinder<T> {
    default void bind(BinderAdapter adapter, T data, BinderViewHolder holder, int index) {
        ViewDataBinding binding=holder.getBinder();
        if (binding==null){
            throw new RuntimeException("please check view if is a binding layout");
        }
        bind(adapter, data, holder.getBinder(), holder,index);
    }

    void bind(BinderAdapter adapter, T data, ViewDataBinding dataBinding, BinderViewHolder holder, int index);
}
