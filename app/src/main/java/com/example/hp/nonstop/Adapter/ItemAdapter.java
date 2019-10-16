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

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<Example> examples;
    int rowLayout;
    Context context;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemLayout;
        RecyclerView recyclerView;
        TextView tittle_main;
        TextView tittle_sub;
        TextView sub;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
           recyclerView = (RecyclerView)itemView.findViewById(R.id.recycler_main);
            tittle_main = (TextView) itemView.findViewById(R.id.tittle_main);
//            tittle_sub = (TextView) itemView.findViewById(R.id.tittle_sub);
//            sub = (TextView) itemView.findViewById(R.id.sub);
        }
    }

    public ItemAdapter(List<Example> examples, int rowLayout, Context context) {
        this.examples = examples;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public ItemViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        List singleSectionItems = examples.get(i).getSubPaths();

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(context, singleSectionItems);
        itemViewHolder.recyclerView.setHasFixedSize(true);
        itemViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        if (examples.get(i).getTitle() != null) {
            itemViewHolder.tittle_main.setText(examples.get(i).getTitle());
        }
        itemViewHolder.recyclerView.setAdapter(itemListDataAdapter);
        if (examples.get(i).getSubPaths() != null){
            Log.e("Subpath","Present");
//            itemViewHolder.tittle_sub.setText(examples.get(i).getSubPaths().get(i).getTitle());
            //itemViewHolder.sub.setText(examples.get(i).getSubPaths().get(i).getTitle());
        }
//        itemViewHolder.tittle_sub.setText(examples.get(i).getSubPaths().get(i).getTitle());

     //       itemViewHolder.tittle_sub.setText(examples.get(i).getSubPaths().get(i).getId());


    }


    @Override
    public int getItemCount() {
        return examples.size();
    }
}
