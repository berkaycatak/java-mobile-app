package com.H5190058.berkay_catak_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
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
        init();
    }

    private void init(){
        String tasinanIlanString = getIntent().getStringExtra(Constants.TASINAN_BASLIK);
        KayipModel kayipModel = ObjectUtil.jsonStringToKayip(tasinanIlanString);

        imgKapak = findViewById(R.id.imgDetayKapakFoto);
        txtAdi   = findViewById(R.id.txtDetayAdi);
        txtTur   = findViewById(R.id.txtDetayTuru);
        txtTarih = findViewById(R.id.txtDetayTarih);
        txtDetay = findViewById(R.id.txtDetay);

        txtAdi.setText(kayipModel.getAdi());
        txtTur.setText(kayipModel.getTuru());
        txtTarih.setText(kayipModel.getTarihi());
        html(kayipModel);
        GlideUtil.resmiIndiripGoster(getApplicationContext(), kayipModel.getBuyukFotografi(), imgKapak);
    }


    private void html(KayipModel kayipModel) {
        String htmlData = kayipModel.getDetay();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
            txtDetay.setText(Html.fromHtml(htmlData, Html.FROM_HTML_MODE_LEGACY));
         else
            txtDetay.setText(Html.fromHtml(htmlData));
    }

}