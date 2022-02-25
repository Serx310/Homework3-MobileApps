package com.nagel.lab3template;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List plants;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plants = utils.getPlantsFormJsonFile((Context)this,"plants.json");
        displayPlants();
    }

    private void displayPlants() {
        Fragment listFragment = new PlantListFragment();
        if(getResources().getConfiguration().orientation == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).commit();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_plantlist, listFragment).commit();
        }
    }

    public void displayDescriptionFragment(String name, String latinName, String description){
        Fragment descriptionFragment = new PlantDescriptionFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("latinName", latinName);
        args.putString("description", description);
        descriptionFragment.setArguments(args);
        if(getResources().getConfiguration().orientation == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, descriptionFragment).
                    addToBackStack("tag").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_plantdescription, descriptionFragment).
                    addToBackStack("tag").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
        }

    }
}