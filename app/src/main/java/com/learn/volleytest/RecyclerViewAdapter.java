package com.learn.volleytest;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    List<HeroModel.Hero> list ;

    public  RecyclerViewAdapter(List<HeroModel.Hero> list)
    {
        this.list=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItem= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row,viewGroup,false);

        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        HeroModel.Hero hero=list.get(i);
        myViewHolder.title.setText(hero.getName());
       // Glide.with(myViewHolder.image.getContext()).load(hero.getImageurl()).into(myViewHolder.image);
        GlideUtility.showCircularImageView(myViewHolder.image.getContext(),"",myViewHolder.image,hero.getImageurl(),android.R.drawable.btn_default);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);

        }
    }
}
