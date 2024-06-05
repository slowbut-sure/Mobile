package com.example.lap5;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {
    private List<Tech> techs;

    public TechAdapter(List<Tech> phones) {
        this.techs = phones;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userView = inflater.inflate(R.layout.row_tech, parent, false);
        ViewHolder viewHolder = new ViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tech phone = techs.get(position);
        holder.imageTech.setImageResource(phone.getImage());
        holder.tvTechName.setText(phone.getName());
        holder.tvBrandValue.setText(phone.getBrand());
        holder.tvYearValue.setText(String.valueOf(phone.getReleaseYear()));
        holder.tvPrice.setText("$" + phone.getPrice());
    }

    @Override
    public int getItemCount() {
        return techs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageTech;
        TextView tvTechName;
        TextView tvBrandValue;
        TextView tvYearValue;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTech = itemView.findViewById(R.id.imageTech);
            tvTechName = itemView.findViewById(R.id.tvTechName);
            tvBrandValue = itemView.findViewById(R.id.tvBrandValue);
            tvYearValue = itemView.findViewById(R.id.tvYearValue);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
