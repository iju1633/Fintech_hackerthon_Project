package com.example.hackerthonproject;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackerthonproject.dto.ProductItem;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private ArrayList<ProductItem> productItem;

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(productItem.get(position));
    }

    public void setFriendList(ArrayList<ProductItem> list){
        this.productItem = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productItem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView type, price, pcr, pcp, volume;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            type = (TextView) itemView.findViewById(R.id.type);
            price = (TextView) itemView.findViewById(R.id.price);
            pcr = (TextView) itemView.findViewById(R.id.pcr);
            pcp = (TextView) itemView.findViewById(R.id.pcp);
            volume = (TextView) itemView.findViewById(R.id.volume);
        }

        void onBind(ProductItem item){

            type.setText(item.getType());
            price.setText(item.getPrice());
            pcr.setText(item.getPcr());
            pcp.setText(item.getPcp());
            volume.setText(item.getVolume());
        }
    }
}
