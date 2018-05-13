package com.xjst.publiclibrary.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

public class BinderViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views = new SparseArray<>();

    private ViewDataBinding binding;

    @SuppressWarnings("unchecked")
    public <T extends View> T findById(@IdRes int id) {
        T view = (T) views.get(id);
        if (view != null) return view;
        else {
            view = itemView.findViewById(id);
            if (view != null) {
                views.put(id, view);
                return view;
            }
        }
        return null;
    }

    ViewDataBinding getBinder() {
        if (binding == null)
            binding = DataBindingUtil.bind(itemView);
        return binding;
    }

    BinderViewHolder(View itemView) {
        super(itemView);
    }


}
