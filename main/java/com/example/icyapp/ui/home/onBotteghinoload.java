package com.example.icyapp.ui.home;

import com.example.icyapp.Model.CategoriePrincipaliModel;

import java.util.List;

interface onBotteghinoload {
    void  onPopularLoadSuccess(List<CategoriePrincipaliModel> categoriePrincipalis);

    void onPopularLoadFailed(String messagge);
}
