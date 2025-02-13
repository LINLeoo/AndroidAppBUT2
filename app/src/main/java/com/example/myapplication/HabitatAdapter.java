package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class HabitatAdapter extends ArrayAdapter<Habitat> {
    private Context context;
    private List<Habitat> habitats;

    public HabitatAdapter(Context context, List<Habitat> habitats) {
        super(context, 0, habitats);
        this.context = context;
        this.habitats = habitats;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_habitat_adapter, parent, false);
        }

        Habitat habitat = habitats.get(position);

        TextView nomResidentTextView = convertView.findViewById(R.id.nomResident);
        nomResidentTextView.setText(habitat.getNomResident());

        TextView adresseResidentTextView = convertView.findViewById(R.id.adresseResident);
        adresseResidentTextView.setText(habitat.getAdresseResident());
        return convertView;
    }
}
