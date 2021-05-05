package com.example.carshowroam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.OnItemSelected {

    Button btnCarInfo, btnOwnerInfo, btnAdd;
    ImageView ivMaker;
    TextView tvModelForCarInfo;
    TextView tvModel1, tvOwner, tvTel;
    Fragment carInfoFrag;
    Fragment OwnerInfoFrag;
    Fragment ListFrag1;
    Fragment buttonFrag, newCarFragment;
    listFrag datachanged;
    AutoCompleteTextView company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // connecting with xml file
        company = findViewById(R.id.company);
        String[] company_names = {"Company1", "Company2","Honda","Mercedes", "Nissan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,company_names);
        company.setThreshold(1);
        company.setAdapter(adapter);

        btnCarInfo = findViewById(R.id.brnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);
        ivMaker = findViewById(R.id.ivMaker);
        tvModelForCarInfo = findViewById(R.id.tvModelForCarInfo);
        tvModel1 = findViewById(R.id.tvModel);
        tvOwner = findViewById(R.id.tvOwner);
        tvTel = findViewById(R.id.tvTel);
        btnAdd = findViewById(R.id.btnAdd);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        OwnerInfoFrag = fragmentManager.findFragmentById(R.id.OwnerInfoFrag);
        ListFrag1  = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        newCarFragment = fragmentManager.findFragmentById(R.id.addnewcar);
        datachanged = (listFrag) fragmentManager.findFragmentById(R.id.listFrag);


        fragmentManager.beginTransaction()
                .hide(carInfoFrag)
                .show(buttonFrag)
                .show(ListFrag1)
                .show(newCarFragment)
                .hide(OwnerInfoFrag)
                .commit();

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(newCarFragment)
                        .show(carInfoFrag)
                        .hide(OwnerInfoFrag)
                        .commit();
            }
        });

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(newCarFragment)
                        .hide(carInfoFrag)
                        .show(OwnerInfoFrag)
                        .commit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(newCarFragment)
                        .hide(carInfoFrag)
                        .hide(OwnerInfoFrag)
                        .commit();
            }
        });
    }

    @Override
    public void onItemClicked(int index) {
        if(ApplicationClass.cars.get(index).getMaker().equals("Mercedes"))
        {
            ivMaker.setImageResource(R.drawable.mercedes);
        }
        else if(ApplicationClass.cars.get(index).getMaker().equals("Nissan"))
        {
            ivMaker.setImageResource(R.drawable.nissan);
        }
        else if(ApplicationClass.cars.get(index).getMaker().equals("Volkswagen"))
        {
            ivMaker.setImageResource(R.drawable.volkswagen);
        }

        tvTel.setText(ApplicationClass.cars.get(index).getTel());
        tvOwner.setText(ApplicationClass.cars.get(index).getOwner());
        tvModel1.setText(ApplicationClass.cars.get(index).getModel());
        tvModelForCarInfo.setText(ApplicationClass.cars.get(index).getModel());
    }
}
