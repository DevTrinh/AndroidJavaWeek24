package com.example.week24.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week24.interfacee.InterfaceSelection;
import com.example.week24.item.ItemStudent;
import com.example.week24.R;
import com.example.week24.WebServiceReturnJSON;

import java.util.List;

public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.StudentViewHolder> {

    private List<ItemStudent> list;
    private InterfaceSelection interfaceSelection;
    private WebServiceReturnJSON context;

    public AdapterStudent(List<ItemStudent> list, InterfaceSelection interfaceSelection) {
        this.list = list;
        this.interfaceSelection = interfaceSelection;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        ItemStudent itemStudent = list.get(position);
        if (itemStudent == null) {
            return;
        }
        holder.tvItemAge.setText(itemStudent.getAge());
        holder.tvAddress.setText(itemStudent.getAddress());
        holder.tvItemId.setText(itemStudent.getId() + "");
        holder.tvItemName.setText(itemStudent.getName());
        holder.ivItemAvt.setImageResource(R.drawable.iv_avt_rc);
        holder.ivItemMenu.setImageResource(R.drawable.ic_menu);
        holder.ivItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceSelection.onClickInsertData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemAvt, ivItemMenu;
        TextView tvItemName, tvItemAge, tvAddress, tvItemId;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItemAvt = itemView.findViewById(R.id.iv_item_avt);
            ivItemMenu = itemView.findViewById(R.id.iv_item_menu);
            tvAddress = itemView.findViewById(R.id.tv_item_address);
            tvItemAge = itemView.findViewById(R.id.tv_item_age);
            tvItemId = itemView.findViewById(R.id.tv_item_id);
            tvItemName = itemView.findViewById(R.id.tv_item_name);
        }


    }
}
