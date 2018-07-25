package com.example.user.uidesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

public class adaptercheck extends RecyclerView.Adapter<adaptercheck.ViewHolder> {

    private List<checklist> checklists;
    private Context context;

    public adaptercheck(List<checklist> checklists, Context context) {
        this.checklists = checklists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.checklist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        checklist checklist = checklists.get(position);

        holder.editTextCheck.setText(checklist.getChecklist());

    }

    @Override
    public int getItemCount() {
        return checklists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public EditText editTextCheck;

        public ViewHolder(View itemView) {
            super(itemView);

            editTextCheck = (EditText) itemView.findViewById(R.id.editTextCheck);
        }
    }
}
