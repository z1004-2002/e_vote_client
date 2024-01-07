package com.abel.e_vote.models;

import javafx.beans.property.Property;

public class Region {
    private Integer id_region;
    private String nom;
    private Integer electeurs;
    private Integer votants;
    public Region(Integer id_region, String nom, Integer electeurs) {
        this.id_region = id_region;
        this.nom = nom;
        this.electeurs = electeurs;
    }

    public Region(Integer id_region, String nom, Integer electeurs, Integer votants) {
        this.id_region = id_region;
        this.nom = nom;
        this.electeurs = electeurs;
        this.votants = votants;
    }

    public Integer getId_region() {
        return id_region;
    }

    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(Integer electeurs) {
        this.electeurs = electeurs;
    }

    public Integer getVotants() {
        return votants;
    }

    public void setVotants(Integer votants) {
        this.votants = votants;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id_region=" + id_region +
                ", nom='" + nom + '\'' +
                ", electeurs=" + electeurs +
                ", votants=" + votants +
                '}';
    }
}
