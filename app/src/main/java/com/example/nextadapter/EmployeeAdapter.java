package com.example.nextadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmpoyeeviewHolder> {
    private ArrayList<Employee> employeeList;
    private  itemclickListener itemclickListener;

    public EmployeeAdapter(ArrayList<Employee> employeeList, itemclickListener itemclickListener) {
        this.employeeList = employeeList;
        this.itemclickListener=itemclickListener;
    }

    @NonNull

    @Override
    public EmpoyeeviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        return new EmpoyeeviewHolder(view,itemclickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpoyeeviewHolder holder, int position) {
        Employee employee=employeeList.get(position);
        holder.setdata(employee);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void updateData(ArrayList<Employee> newlist){
        this.employeeList=newlist;
        notifyDataSetChanged();
    }
}
