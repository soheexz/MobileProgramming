package com.android.myapplication11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<Integer> items;

    String[] posterTitle={"토이스토리4","호빗3","제이슨 본","반지의 제왕3","정직한 후보","나쁜 녀석들",
            "겨울왕국2","알라딘","극한직업","스파이더맨","토이스토리4","호빗3","제이슨 본","반지의 제왕3","정직한 후보","나쁜 녀석들",
            "겨울왕국2","알라딘","극한직업","스파이더맨"};


    public  RecyclerViewAdapter(Context context, ArrayList<Integer> items){
        this.context= context;
        this.items=items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setImageResource(items.get(position));

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, posterTitle[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text= itemView.findViewById(R.id.text);
        }
    }
}