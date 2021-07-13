package com.example.nextadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmpoyeeviewHolder extends RecyclerView.ViewHolder {
    private TextView tvage;
    private TextView tvname;
    private TextView tvaddress;
    private ImageView ivimage;
    private itemclickListener itemclickListener;

    public EmpoyeeviewHolder(@NonNull  View itemView,itemclickListener itemclickListener) {
        super(itemView);
        this.itemclickListener=itemclickListener;
        init(itemView);
    }
    private void init(View itemview){
        tvaddress=itemview.findViewById(R.id.tvAddress);
        tvname=itemview.findViewById(R.id.tvName);
        tvage=itemview.findViewById(R.id.tvAge);
        ivimage=itemview.findViewById(R.id.ivEdit);
    }

    public void setdata(Employee employee){
        tvname.setText(employee.getName());
        tvaddress.setText(employee.getAddress());
        tvage.setText(employee.getAge()+"");
        ivimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemclickListener.onitemclicked(getAdapterPosition(), employee);
            }
        });
    }
}
