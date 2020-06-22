package com.learning.behtardemo;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    Context context;
    ArrayList<ProductListDataModel> models;


    public ItemAdapter(Context context, ArrayList<ProductListDataModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textview, parent, false);
            return new ItemAdapter.HeaderViewHolder(itemView);
        } else if (viewType == TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cards, parent, false);
            return new ItemAdapter.ItemViewHolder(itemView);
        } else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemAdapter.ItemViewHolder) {
            ItemAdapter.ItemViewHolder itemViewHolder = (ItemAdapter.ItemViewHolder) holder;

            ProductListDataModel data = models.get(position - 1);

            itemViewHolder.header.setText(data.getProduct_name());
            itemViewHolder.orgPrice.setText("₹ " + data.getPrice());
            itemViewHolder.discPrice.setText("₹ " + data.getMrp());
            itemViewHolder.discPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            if (data.getUnit() == null) {
                itemViewHolder.quantity.setVisibility(View.GONE);
            } else {
                itemViewHolder.quantity.setText(data.getUnit());
            }

            Glide.with(((ItemViewHolder) holder).imProduct.getContext())
                    .load(data.getProduct_image())
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(((ItemViewHolder) holder).imProduct);

        } else {
            ItemAdapter.HeaderViewHolder itemViewHolder = (ItemAdapter.HeaderViewHolder) holder;
            itemViewHolder.headerTitle.setText("Top selling");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return models.size() + 1;
    }


    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;

        public HeaderViewHolder(View view) {
            super(view);
            headerTitle = view.findViewById(R.id.tv_head);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        TextView quantity;
        TextView orgPrice;
        TextView discPrice;
        ImageView imProduct;

        public ItemViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.tv_header);
            quantity = itemView.findViewById(R.id.tv_weight);
            orgPrice = itemView.findViewById(R.id.tv_price);
            discPrice = itemView.findViewById(R.id.tv_fare_cut);
            imProduct = itemView.findViewById(R.id.im_prod_img);
        }
    }
}

