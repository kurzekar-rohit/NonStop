package com.example.hp.nonstop.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.nonstop.Model.Example;
import com.example.hp.nonstop.Model.SubPath;
import com.example.hp.nonstop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {
    List<SubPath> subPathList;
    Context context;

    public SectionListDataAdapter(Context context, List<SubPath> subPathList) {
        this.subPathList = subPathList;
        this.context = context;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        TextView sub;
        ImageView imageView;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            sub = (TextView) itemView.findViewById(R.id.sub);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_item, null);
        return new SingleItemRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionListDataAdapter.SingleItemRowHolder singleItemRowHolder, int i) {
        Log.e("hero", "Done");
        String imgUrl = subPathList.get(i).getImage();
        singleItemRowHolder.sub.setText(subPathList.get(i).getTitle());


        // singleItemRowHolder.img.setImageResource(Integer.parseInt(subPathList.get(i).getImage()));
        Glide.with(context)
                .load(imgUrl)
                .into(singleItemRowHolder.imageView);

//        Picasso.with(context).load(imgUrl).resize(120, 60).into(singleItemRowHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return (null != subPathList ? subPathList.size() : 0);
//        return subPathList.size();
    }


}
