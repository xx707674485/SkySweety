package com.xjst.publiclibrary.adapter;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class BinderAdapter<T> extends RecyclerView.Adapter<BinderViewHolder> {

    private ArrayMap<T, LayoutProvider<T>> providers = new ArrayMap<>();
    private ArrayMap<T, AdapterDataBinder<T>> binders = new ArrayMap<>();
    private LayoutProvider<T> provider;
    private AdapterDataBinder<T> binder;


    public void addLayout(T data, LayoutProvider<T> provider) {
        providers.put(data, provider);
    }

    public void addBinder(T data, AdapterDataBinder<T> binder) {
        binders.put(data, binder);
    }

    private List<T> data;

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setProvider(LayoutProvider<T> provider) {
        this.provider = provider;
    }

    public void setBinder(AdapterDataBinder<T> binder) {
        this.binder = binder;
    }

    @Override
    public int getItemViewType(int position) {
        T item = data.get(position);
        LayoutProvider<T> provider = providers.get(item);
        provider = provider == null ? this.provider : provider;
        return provider == null ? -1 : provider.getLayoutId(item);
    }

    @Override
    public BinderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == -1) throw new RuntimeException("there is no view provided");
        return new BinderViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(BinderViewHolder holder, int position) {
        T item = data.get(position);
        if (item == null) return;
        AdapterDataBinder<T> temp = binders.get(item);
        temp = temp == null ? binder : temp;
        if (temp == null) return;
        temp.bind(this, item, holder, position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


}
