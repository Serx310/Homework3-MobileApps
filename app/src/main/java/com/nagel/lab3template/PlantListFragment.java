package com.nagel.lab3template;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Iterator;
import java.util.List;



public class PlantListFragment extends Fragment {
    private static final String TAG = "List";
    private List plants;
    private Utils utils = new Utils();

    public PlantListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_list,container,false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_plantlist);
        plants = utils.getPlantsFormJsonFile(getContext(),"plants.json");


        Iterator iterator = plants.iterator();
        while (iterator.hasNext()){
            Plant plant = (Plant) iterator.next();
            Button plantButtons = new Button(getContext());
            String name = plant.getName();
            String latinName = plant.getLatinName();
            String description = plant.getDescription();
            plantButtons.setText(name);
            plantButtons.setOnClickListener(view1 -> {
                ((MainActivity)getActivity()).displayDescriptionFragment(name,latinName,description);
            });
            linearLayout.addView(plantButtons);
        }
        Log.i(TAG, "!onBuild List: CreateList");
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "!onDestroy List: Destroyed");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "!onStop List: Stopped");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "!onResume List: Resumed");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "!onPause List: Paused");
    }

}