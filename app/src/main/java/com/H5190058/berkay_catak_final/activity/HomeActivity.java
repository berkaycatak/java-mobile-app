package com.H5190058.berkay_catak_final.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.H5190058.berkay_catak_final.R;
import com.H5190058.berkay_catak_final.adaptor.KayipAdaptor;
import com.H5190058.berkay_catak_final.model.KayipModel;
import com.H5190058.berkay_catak_final.network.Service;
import com.H5190058.berkay_catak_final.util.Constants;
import com.H5190058.berkay_catak_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }
    RecyclerView recyclerView;


    private void init() {
        kayiplariGetir();
    }

    void kayiplariGetir() {

        new Service().getServiceApi().kayiplariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KayipModel>>() {

                    List<KayipModel> kayiplar = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<KayipModel> kayipList) {
                        //Log.e("RETROFIT","onNext : ");
                        kayiplar = kayipList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        //Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        //Log.e("RETROFIT","onComplete : ");

                        if(kayiplar.size()>0) {
                            initRecycleView(kayiplar);
                        }
                    }
                });
    }


    private void initRecycleView(List<KayipModel> kayipList)
    {
        recyclerView = findViewById(R.id.rcvKayiplar);
        KayipAdaptor kayipAdaptor = new KayipAdaptor(kayipList, getApplicationContext(), new KayipAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                KayipModel tiklananIlan = kayipList.get(position);
                openActivity(tiklananIlan);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(kayipAdaptor);
    }

    private void openActivity(KayipModel tiklananIlan){
        Intent yeniIntent = new Intent(getBaseContext(), IlanActivity.class);
        String tiklananBurcString = ObjectUtil.kayipToJsonString(tiklananIlan);
        yeniIntent.putExtra(Constants.TASINAN_BASLIK, tiklananBurcString);
        startActivity(yeniIntent);
    }

}