package com.example.icyapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.icyapp.Model.CategoriePrincipaliModel;
import com.example.icyapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyCategoriePrincipaliAdapter extends RecyclerView.Adapter<MyCategoriePrincipaliAdapter.MyViewHolder> {

   private Context context;
    private List<CategoriePrincipaliModel> categoriePrincipaliModelList;
    public MyCategoriePrincipaliAdapter(Context context, List<CategoriePrincipaliModel> categoriePrincipaliList) {
        this.context = context;
        this.categoriePrincipaliModelList = categoriePrincipaliList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_principali_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(categoriePrincipaliModelList.get(position).getImage())
                .into(holder.category_image);
        holder.txt_category_name.setText(categoriePrincipaliModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return categoriePrincipaliModelList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        Unbinder unbinder;

        @BindView (R.id.txt_category_name)
        TextView txt_category_name;
        @BindView(R.id.category_image)
        CircleImageView category_image;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
        }
    }
}
