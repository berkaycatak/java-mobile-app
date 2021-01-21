package com.H5190058.berkay_catak_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KayipModel {
    @SerializedName("Turu")
    @Expose
    private String turu;
    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("Tarihi")
    @Expose
    private String tarihi;
    @SerializedName("Detay")
    @Expose
    private String detay;
    @SerializedName("KucukFotografi")
    @Expose
    private String kucukFotografi;
    @SerializedName("BuyukFotografi")
    @Expose
    private String buyukFotografi;

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getTarihi() {
        return tarihi;
    }

    public void setTarihi(String tarihi) {
        this.tarihi = tarihi;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getKucukFotografi() {
        return kucukFotografi;
    }

    public void setKucukFotografi(String kucukFotografi) {
        this.kucukFotografi = kucukFotografi;
    }

    public String getBuyukFotografi() {
        return buyukFotografi;
    }

    public void setBuyukFotografi(String buyukFotografi) {
        this.buyukFotografi = buyukFotografi;
    }


}
