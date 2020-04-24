package com.example.icyapp.CallBack;

import com.example.icyapp.Model.CategoriePrincipaliModel;

import java.util.List;

public interface PopularCallbackListener {
    void onCategoriePrincipaliLoadSuccess(List<CategoriePrincipaliModel> categoriePrincipali);
    void onCategoriePrincipaliLoadFailed(String messagge);

}
