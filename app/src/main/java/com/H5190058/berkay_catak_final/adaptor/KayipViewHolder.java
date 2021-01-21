package com.H5190058.berkay_catak_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.H5190058.berkay_catak_final.R;


public class KayipViewHolder extends RecyclerView.ViewHolder {

    ImageView imgGorsel;
    TextView txtAdi;
    TextView txtTuru;
    TextView txtTarih;
    public KayipViewHolder(@NonNull View itemView, KayipAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgGorsel = itemView.findViewById(R.id.imgGorsel);
        txtAdi    = itemView.findViewById(R.id.txtDetayAdi);
        txtTuru   = itemView.findViewById(R.id.txtDetayTuru);
        txtTarih  = itemView.findViewById(R.id.txtTarih);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
            }
        });

    }
}
