package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class HabitatActivity extends BaseActivity {

    private ListView listView;
    private ArrayList<Habitat> habitats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitat);

        setupBackButton();

        listView = findViewById(R.id.listView);

        habitats = new ArrayList<>();
        habitats.add(new Habitat("Jean Dupont", "123 Rue A"));
        habitats.add(new Habitat("Marie Martin", "456 Rue B"));
        habitats.add(new Habitat("Paul Durand", "789 Rue C"));

        HabitatAdapter adapter = new HabitatAdapter(this, habitats);

        listView.setAdapter(adapter);

        // Ajouter un Listener pour afficher un Toast lors d'un clic sur un élément
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nomResident = habitats.get(position).getNomResident();

                Toast.makeText(HabitatActivity.this, "Nom du résident: " + nomResident, Toast.LENGTH_SHORT).show();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MyFragment())
                .commit();
    }
}
