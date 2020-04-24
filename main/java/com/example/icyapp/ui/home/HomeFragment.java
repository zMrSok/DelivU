package com.example.icyapp.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.example.icyapp.Adapter.MyCategoriePrincipaliAdapter;
import com.example.icyapp.Model.CategoriePrincipaliModel;
import com.example.icyapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

    @BindView(R.id.recycler_principali)
    RecyclerView recycler_principali;
    @BindView(R.id.viewpager)
    LoopingViewPager viewPager;
    LayoutAnimationController layoutAnimationController;

    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //noinspection deprecation
        HomeViewModel homeViewModel=ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Unbinder unbinder=ButterKnife.bind(this, root);
        init ();


        homeViewModel.getPrincipaliList().observe(getViewLifecycleOwner(), categoriePrincipaliModel ->{
            //Create Adapter
            MyCategoriePrincipaliAdapter adapter = new MyCategoriePrincipaliAdapter(getContext(),categoriePrincipaliModel);
            recycler_principali.setAdapter(adapter);


        });
        return root;
    }

    private void init() {
        recycler_principali.setHasFixedSize(true);
        recycler_principali.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
    }
}
