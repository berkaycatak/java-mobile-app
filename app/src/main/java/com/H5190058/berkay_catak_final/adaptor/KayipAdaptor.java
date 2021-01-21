package com.H5190058.berkay_catak_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.H5190058.berkay_catak_final.util.GlideUtil;
import com.H5190058.berkay_catak_final.model.KayipModel;
import com.H5190058.berkay_catak_final.R;

import java.util.List;

public class KayipAdaptor extends RecyclerView.Adapter<KayipViewHolder> {


    List<KayipModel> kayiplar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public KayipAdaptor(List<KayipModel> kayiplar, Context context, OnItemClickListener listener) {
        this.kayiplar = kayiplar;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KayipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_kayip,parent,false);
        return new KayipViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull KayipViewHolder viewHolder, int position) {

        viewHolder.txtAdi.setText(kayiplar.get(position).getAdi());
        viewHolder.txtTarih.setText(kayiplar.get(position).getTarihi());
        viewHolder.txtTuru.setText(kayiplar.get(position).getTuru());
        GlideUtil.resmiIndiripGoster(context,kayiplar.get(position).getKucukFotografi(),viewHolder.imgGorsel);

    }

    @Override
    public int getItemCount() {
        return kayiplar.size();
    }
}
