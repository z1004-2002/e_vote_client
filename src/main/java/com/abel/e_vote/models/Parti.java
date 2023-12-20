package com.abel.e_vote.models;

public class Parti {
    private Integer id_parti;
    private String nom;

    public Parti(Integer id_parti, String nom) {
        this.id_parti = id_parti;
        this.nom = nom;
    }

    public Integer getId_parti() {
        return id_parti;
    }

    public void setId_parti(Integer id_parti) {
        this.id_parti = id_parti;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Parti{" +
                "id_parti='" + id_parti + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
