package com.example.icyapp.CallBack;

import com.example.icyapp.Model.IlBotteghino;

import java.util.List;

public interface IlBotteghinoCallbackListener {
    void onGelateriaLoadSuccess(List<IlBotteghino> ilBotteghino);
    void onGelateriaLoadFailed(String messagge);
}
