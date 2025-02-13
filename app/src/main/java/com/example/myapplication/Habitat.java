package com.example.myapplication;

public class Habitat {
    private String nomResident;
    private String adresse;  // Autres informations que vous pouvez ajouter

    public Habitat(String nomResident, String adresse) {
        this.nomResident = nomResident;
        this.adresse = adresse;
    }

    public String getNomResident() {
        return nomResident;
    }

    public void setNomResident(String nomResident) {
        this.nomResident = nomResident;
    }

    public String getAdresseResident() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
