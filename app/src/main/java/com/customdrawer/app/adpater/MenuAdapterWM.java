package com.customdrawer.app.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.customdrawer.app.MenuItems;
import com.customdrawer.app.R;

import java.util.List;

public class MenuAdapterWM extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MenuItems> menuList;
    Context mContext;
    GetIdFromMenuAdapter getIdFromMenuAdapter;

    //C=> Category not clickable
    //L=> Draws only separator
    //I=> Items

    public static final int ITEM_TYPE_CATEGORY = 0;
    public static final int ITEM_TYPE_LINE = 1;
    public static final int ITEM_TYPE_ITEMS = 2;

    public interface GetIdFromMenuAdapter {
        void returnedID(String id);
    }



    public MenuAdapterWM(Context mContext, List<MenuItems> expenseList, GetIdFromMenuAdapter getIdFromMenuAdapter) {
        //C=> Category not clickable
        //L=> Draws only separator
        //I=> Items
        this.mContext = mContext;
        this.getIdFromMenuAdapter = getIdFromMenuAdapter;
        this.menuList = expenseList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case ITEM_TYPE_CATEGORY:
                view = inflater.inflate(R.layout.row_category, parent, false);
                holder = new CategoryViewHolder(view);
                break;

            case ITEM_TYPE_ITEMS:
                view = inflater.inflate(R.layout.row_item, parent, false);
                holder = new ItemViewHolder(view);
                break;

            case ITEM_TYPE_LINE:
                view = inflater.inflate(R.layout.row_line, parent, false);
                holder = new DividerViewHolder(view);
                break;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (holder.getItemViewType() == ITEM_TYPE_CATEGORY) {
            CategoryViewHolder userviewViewHolder = (CategoryViewHolder) holder;
            CategoryDataSetter(userviewViewHolder, i);
        } else if (holder.getItemViewType() == ITEM_TYPE_ITEMS) {
            ItemViewHolder ItemViewHolder = (ItemViewHolder) holder;
            ItemDataSetter(ItemViewHolder, i);
        }
    }

    private void CategoryDataSetter(CategoryViewHolder userviewViewHolder, int i) {
        userviewViewHolder.tvMenuCategory.setText(menuList.get(i).getItemName());
    }

    private void ItemDataSetter(ItemViewHolder ItemViewHolder, final int i) {
        ItemViewHolder.tvMenuText.setText(menuList.get(i).getItemName());
        ItemViewHolder.child_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIdFromMenuAdapter.returnedID(menuList.get(i).getId());
            }
        });
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvMenuCategory;

        public CategoryViewHolder(View view) {
            super(view);
            tvMenuCategory = view.findViewById(R.id.tvMenuCategory);
        }
    }

    private class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View itemView) {
            super(itemView);
        }
    }


    private class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvMenuText;
        ImageView ivIcon;
        RelativeLayout child_container;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvMenuText = itemView.findViewById(R.id.tvMenuText);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            child_container = itemView.findViewById(R.id.child_container);
        }
    }


    @Override
    public int getItemViewType(int position) {
        //C=> Category not clickable
        //L=> Draws only separator
        //I=> Items
        if (menuList.get(position).getType().equalsIgnoreCase("C")) {
            return ITEM_TYPE_CATEGORY;
        } else if (menuList.get(position).getType().equalsIgnoreCase("L")) {
            return ITEM_TYPE_LINE;
        } else if (menuList.get(position).getType().equalsIgnoreCase("I")) {
            return ITEM_TYPE_ITEMS;
        } else {
            return ITEM_TYPE_ITEMS;
        }
    }

}
