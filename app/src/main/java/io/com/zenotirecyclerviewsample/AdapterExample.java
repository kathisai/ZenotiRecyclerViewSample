package io.com.zenotirecyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jhordan on 13/10/15.
 */
public class AdapterExample extends RecyclerView.Adapter<AdapterExample.ExampleHolder> {


    private ArrayList<String> pictureArrayList;
    private int itemLayout;


    public AdapterExample() {
    }

    public AdapterExample(ArrayList<String> pictureArrayList, int itemLayout) {
        this.pictureArrayList = pictureArrayList;
        this.itemLayout = itemLayout;
    }

    @Override
    public ExampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ExampleHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExampleHolder holder, final int position) {
        final String picture = pictureArrayList.get(position);
        holder.title.setText(picture);
    }


    @Override
    public int getItemCount() {
        return pictureArrayList.size();
    }


    public class ExampleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.txt_title)
        TextView title;


        public ExampleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }


}