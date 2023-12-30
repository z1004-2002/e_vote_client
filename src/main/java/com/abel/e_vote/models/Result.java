package com.abel.e_vote.models;

public class Result {
    private Integer id_region;
    private String nom_region;
    private String parti_gagnant;
    private Integer nombre_voie;
    private Float percent_result;
    private Integer electeurs;

    public Result(Integer id_region, String nom_region, String parti_gagnant, Integer nombre_voie, Float percent_result) {
        this.id_region = id_region;
        this.nom_region = nom_region;
        this.parti_gagnant = parti_gagnant;
        this.nombre_voie = nombre_voie;
        this.percent_result = percent_result;
    }
    public Result(Integer id_region, String nom_region, String parti_gagnant, Integer nombre_voie, Float percent_result, Integer electeurs) {
        this.id_region = id_region;
        this.nom_region = nom_region;
        this.parti_gagnant = parti_gagnant;
        this.nombre_voie = nombre_voie;
        this.percent_result = percent_result;
        this.electeurs = electeurs;
    }

    public Result() {
    }

    public Integer getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(Integer electeurs) {
        this.electeurs = electeurs;
    }

    public Integer getId_region() {
        return id_region;
    }

    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public String getParti_gagnant() {
        return parti_gagnant;
    }

    public void setParti_gagnant(String parti_gagnant) {
        this.parti_gagnant = parti_gagnant;
    }

    public Integer getNombre_voie() {
        return nombre_voie;
    }

    public void setNombre_voie(Integer nombre_voie) {
        this.nombre_voie = nombre_voie;
    }

    public Float getPercent_result() {
        return percent_result;
    }

    public void setPercent_result(Float percent_result) {
        this.percent_result = percent_result;
    }
}
