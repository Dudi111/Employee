package com.example.nextadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemclickListener {

    private ArrayList<Employee> employeeList=new ArrayList<>();
    private RecyclerView recycle;
    private CardView mcrad;
    private EditText etname;
    private EditText etage;
    private EditText etaddress;
    private Button mbtndata;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ini();
        buildlist();
        recycleview();
    }

    private void ini(){
        recycle=findViewById(R.id.recyclerView);
        mcrad=findViewById(R.id.editCardView);
        etname=findViewById(R.id.etName);
        etaddress=findViewById(R.id.etAddress);
        etage=findViewById(R.id.etAge);
        mbtndata=findViewById(R.id.btnDone);

    }
    private void buildlist(){
        for(int i=0;i<50;i++){
            Employee employee=new Employee("praveen",25,"kulchander");
            employeeList.add(employee);
        }
    }
    private void recycleview(){
        employeeAdapter = new EmployeeAdapter(employeeList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(employeeAdapter);
    }

    @Override
    public void onitemclicked(int position, Employee employee) {
   mcrad.setVisibility(View.VISIBLE);
   etname.setText(employee.getName());
   etage.setText(employee.getAge()+"");
   etaddress.setText(employee.getAddress());

        mbtndata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcrad.setVisibility(View.GONE);
                Employee newemlpoyee=new Employee(etname.getText().toString(),Integer.parseInt(etage.getText().toString()),etaddress.getText().toString());
                employeeList.set(position, newemlpoyee);
                employeeAdapter.updateData(employeeList);
            }
        });

    }
}