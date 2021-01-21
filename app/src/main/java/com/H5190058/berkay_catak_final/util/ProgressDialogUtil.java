package com.H5190058.berkay_catak_final.util;

import android.app.ProgressDialog;
import android.content.Context;


public class ProgressDialogUtil {

    private static ProgressDialog progressDialog;

    public static ProgressDialog createProgressDialog(Context context, String article) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(article);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        showProgressDialog();
        return progressDialog;
    }

    public static void destroyProgressDialog() {
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    private static void showProgressDialog(){
        if (!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

}
