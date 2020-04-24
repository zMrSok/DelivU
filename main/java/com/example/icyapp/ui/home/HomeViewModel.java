package com.example.icyapp.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.icyapp.CallBack.PopularCallbackListener;
import com.example.icyapp.Common.Common;
import com.example.icyapp.Model.CategoriePrincipaliModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements onPopularLoad, onBotteghinoload {

    private MutableLiveData<List<CategoriePrincipaliModel>> principaliList;
    private MutableLiveData<String> messageError; 
    private PopularCallbackListener popularCallbackListener;


    public HomeViewModel(){
    popularCallbackListener = (PopularCallbackListener) this;
    }

    public MutableLiveData<List<CategoriePrincipaliModel>> getPrincipaliList() {
        if (principaliList == null)
        {
            popularCallbackListener = (PopularCallbackListener) new MutableLiveData<>();

            messageError = new MutableLiveData<>();
            loadPopularList();
        }
        return principaliList;
    }

    private void loadPopularList() {
        final List<CategoriePrincipaliModel> tempList = new ArrayList<>();
        DatabaseReference popularRef = FirebaseDatabase.getInstance().getReference(Common.POPULAR_CATEGORY_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapShot:dataSnapshot.getChildren()){

                    CategoriePrincipaliModel model = itemSnapShot.getValue(CategoriePrincipaliModel.class);
                    tempList.add(model);
                }
                popularCallbackListener.onCategoriePrincipaliLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                 popularCallbackListener.onCategoriePrincipaliLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
   public void  onPopularLoadSuccess(List<CategoriePrincipaliModel> categoriePrincipali){
        principaliList.setValue(categoriePrincipali);
   }

    @Override
    public void onPopularLoadFailed(String messagge){
        messageError.setValue(messagge);
  }
}