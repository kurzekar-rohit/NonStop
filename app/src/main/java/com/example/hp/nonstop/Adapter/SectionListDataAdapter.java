package com.example.hp.nonstop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.nonstop.Model.Example;
import com.example.hp.nonstop.R;

import java.util.List;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {
    List<Example> examples;
    int rowLayout;
    Context context;

//    public SectionListDataAdapter(List<Example> examples, int rowLayout, Context context) {
//        this.examples = examples;
//        this.rowLayout = rowLayout;
//        this.context = context;
//    }

    public SectionListDataAdapter(Context context, List<Example> examples) {
        this.examples = examples;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        TextView sub;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            sub = (TextView) itemView.findViewById(R.id.sub);
        }
    }


//    @NonNull
//    @Override
//    public SectionListDataAdapter.SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
//    }
    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_item, null);
        return new SingleItemRowHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull SectionListDataAdapter.SingleItemRowHolder singleItemRowHolder, int i) {
        singleItemRowHolder.sub.setText(examples.get(i).getSubPaths().get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
