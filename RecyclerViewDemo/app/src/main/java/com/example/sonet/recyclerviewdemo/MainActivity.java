package com.example.sonet.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DataProvider> dataProviders;

    /*String[] countryName = {"India",
            "Srilanka",
            "Pakistan",
            "Nepal",
            "Bhutan",
            "Afganistan",
            "China",
            "Japan",
             };

    String[] countryCapital = {"Delhi",
            "Sri Jayawardenepura Kotte",
            "Karachi",
            "Kathmundu",
            "Thimphu",
            "Kabul",
            "Beijing",
            "Tokyo",
             };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        DataProvider provider = new DataProvider();
        dataProviders = provider.getAllData();

        adapter = new RecyclerAdapter(dataProviders);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
