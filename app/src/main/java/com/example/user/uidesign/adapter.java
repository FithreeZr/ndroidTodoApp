package com.example.user.uidesign;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    private List<homelist> homelists;
    private Context context;

    public adapter(List<homelist> homelists, Context context) {
        this.homelists = homelists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homelist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        homelist homelist = homelists.get(position);

        holder.textViewHead.setText(homelist.getHead());
        holder.textViewDesc.setText(homelist.getDesc());


    }

    @Override
    public int getItemCount() {
        return homelists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);

        }
    }
}
