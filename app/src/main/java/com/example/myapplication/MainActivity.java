package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    List<product> product;
    product product2;
    product product3;
    product product4;
    AdapterRv adapterRv;
    Integer[] image={R.drawable.d1,R.drawable.d2,R.drawable.d3};
    ArrayList<Integer> listimg=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        product2=new product("dariush",image[0]);
        product3=new product("dariush2",image[1]);
        product4=new product("dariush3",image[2]);
        product=new ArrayList<>();
        product.add(product2);
        product.add(product3);
        product.add(product4);
        adapterRv=new AdapterRv(product);


        recyclerView=findViewById(R.id.rv_test);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterRv);



    }



}