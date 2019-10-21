package com.example.hp.nonstop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hp.nonstop.Model.Example;
import com.example.hp.nonstop.Model.SubPath;
import com.example.hp.nonstop.R;

import java.util.List;

import retrofit2.Callback;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<Example> paths;
    Context context;

//    public ItemAdapter(Context context, List<Example> paths) {
//        this.context = context;
//        this.paths= paths;
//    }

    public ItemAdapter(List<Example> paths, Context applicationContext) {

        this.context = context;
        this.paths = paths;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView tittle_main;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_first);
            tittle_main = (TextView) itemView.findViewById(R.id.tittle_main);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        List singleSectionItems = paths.get(i).getSubPaths();

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(context, singleSectionItems);
        itemViewHolder.recyclerView.setHasFixedSize(true);
        itemViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        itemViewHolder.tittle_main.setText(paths.get(i).getTitle());
        itemViewHolder.recyclerView.setAdapter(itemListDataAdapter);
        if (paths.get(i).getSubPaths() != null) {
            Log.e("Subpath", "Present");
        }
    }

    @Override
    public int getItemCount() {
        return paths.size();
    }
}
