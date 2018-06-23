package com.example.aa.restaurantapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by aa on 26-02-2018.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private Context context;
    private List<Restaurant> restaurantDetails;

    public RestaurantAdapter(Context context, List<Restaurant> restaurantDetails) {
        this.context = context;
        this.restaurantDetails = restaurantDetails;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.itemView.setTag(restaurantDetails.get(position));
        Restaurant rt = restaurantDetails.get(position);
        holder.tv_prod.setText(rt.getProduct());
        holder.tv_vicinity.setText(rt.getVicinity());
       // holder.tv_custname.setText(rt.getCustomer());
        //holder.tv_open.setText(rt.getOpen());
       // holder.tv_rating.setText((int) Float.parseFloat(valueOf(rt.getRating())));

    }

    @Override
    public int getItemCount() {
        return restaurantDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_prod,tv_vicinity,tv_custname,tv_open,tv_rating;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_prod = (TextView)itemView.findViewById(R.id.tv_prod);
            tv_vicinity = (TextView)itemView.findViewById(R.id.tv_vicinity);
           /* tv_custname = (TextView)itemView.findViewById(R.id.tv_custname);
            tv_open = (TextView)itemView.findViewById(R.id.tv_open);
            tv_rating = (TextView)itemView.findViewById(R.id.tv_rating);*/

        }
    }
}
