package com.example.carshowroam;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class listFrag extends Fragment {
    View v;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CarAdapter carAdapter;
    public listFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = v.findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        carAdapter = new CarAdapter(getContext(), ApplicationClass.cars);
        recyclerView.setAdapter(carAdapter);
    }

    public void notifyDataChanged()
    {
        carAdapter.notifyDataSetChanged();
    }
}
