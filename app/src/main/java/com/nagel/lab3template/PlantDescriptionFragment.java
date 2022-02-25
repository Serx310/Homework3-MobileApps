package com.nagel.lab3template;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PlantDescriptionFragment extends Fragment {


    private static final String TAG = "Description";

    public PlantDescriptionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_description, container, false);
        Log.i(TAG, "!onBuild List: CreateDetails");

        String plantName = getArguments().getString("name");
        TextView name = view.findViewById(R.id.txtPlantName);
        name.setText(plantName);

        String plantNameLatin = getArguments().getString("latinName");
        TextView nameLatin = view.findViewById(R.id.txtPlantLatinName);
        nameLatin.setText(plantNameLatin);

        String plantNameDescription = getArguments().getString("description");
        TextView details = view.findViewById(R.id.txtPlantDescription);
        details.setText(plantNameDescription);


        //Button button = view.findViewById(R.id.btnClose);
        //button.setOnClickListener(view1 -> getBackToMain());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "!onDestroy Details: Destroyed");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "!onStop Details: Stopped");
    }
}