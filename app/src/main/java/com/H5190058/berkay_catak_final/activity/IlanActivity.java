package com.H5190058.berkay_catak_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.H5190058.berkay_catak_final.R;
import com.H5190058.berkay_catak_final.model.KayipModel;
import com.H5190058.berkay_catak_final.util.Constants;
import com.H5190058.berkay_catak_final.util.GlideUtil;
import com.H5190058.berkay_catak_final.util.ObjectUtil;

public class IlanActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtTur, txtAdi, txtTarih, txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan);

        String tasinanIlanString = getIntent().getStringExtra(Constants.TASINAN_BASLIK);
        KayipModel kayipModel = ObjectUtil.jsonStringToKayip(tasinanIlanString);

        imgKapak = findViewById(R.id.imgDetayKapakFoto);
        txtAdi   = findViewById(R.id.txtDetayAdi);
        txtTur   = findViewById(R.id.txtDetayTuru);
        txtTarih = findViewById(R.id.txtDetayTarih);

        txtAdi.setText(kayipModel.getAdi());
        txtTur.setText(kayipModel.getTuru());
        txtTarih.setText(kayipModel.getTarihi());

        GlideUtil.resmiIndiripGoster(getApplicationContext(), kayipModel.getBuyukFotografi(), imgKapak);
    }
}