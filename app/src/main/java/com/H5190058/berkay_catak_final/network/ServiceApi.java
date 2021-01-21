package com.H5190058.berkay_catak_final.network;

import com.H5190058.berkay_catak_final.model.KayipModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("data/kayipHayvanlar.json")
    Observable<List<KayipModel>> kayiplariGetir();
}
