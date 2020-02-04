package com.customdrawer.app.adpater;

import android.content.Context;
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

public class MenuAdapterWOM extends RecyclerView.Adapter<MenuAdapterWOM.MyViewHolder> {

    private List<MenuItems> expenseListFilter;
    Context mContext;
    GetIdFromMenuAdapter getIdFromMenuAdapter;

    public interface GetIdFromMenuAdapter {
        void returnedID(String id);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMenuText;
        ImageView ivIcon;
        RelativeLayout child_container;

        public MyViewHolder(View view) {
            super(view);
            tvMenuText = view.findViewById(R.id.tvMenuText);
            ivIcon = view.findViewById(R.id.ivIcon);
            child_container = view.findViewById(R.id.child_container);
        }
    }

    public MenuAdapterWOM(Context mContext, List<MenuItems> expenseList, GetIdFromMenuAdapter getIdFromMenuAdapter) {
        this.mContext = mContext;
        this.getIdFromMenuAdapter = getIdFromMenuAdapter;
        this.expenseListFilter = expenseList;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final MenuItems c = expenseListFilter.get(position);
        holder.tvMenuText.setText(c.getItemName());
        holder.child_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIdFromMenuAdapter.returnedID(c.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenseListFilter.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(v);
    }

}
