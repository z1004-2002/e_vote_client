package com.abel.e_vote.models;

public class Result {
    private Integer id_region;
    private String nom_region;
    private String parti_gagnant;
    private Integer nombre_votants;
    private Float percent_result;
    private Integer electeurs;
    private Integer votants;
    private String represantant;
    private Integer id_parti_gagnant;
    private Integer id_parti_perdant;
    private String parti_perdant;
    private String represantant_perdant;


    public Result(Integer id_region, String nom_region, String parti_gagnant, Integer nombre_votants, Float percent_result, Integer electeurs, Integer votants, String represantant) {
        this.id_region = id_region;
        this.nom_region = nom_region;
        this.parti_gagnant = parti_gagnant;
        this.nombre_votants = nombre_votants;
        this.percent_result = percent_result;
        this.electeurs = electeurs;
        this.votants = votants;
        this.represantant = represantant;
    }

    public Result(Integer id_region, String nom_region, String parti_gagnant, Integer nombre_votants, Float percent_result, Integer electeurs, Integer votants, String represantant, Integer id_parti_gagnant, Integer id_parti_perdant, String parti_perdant, String represantant_perdant) {
        this.id_region = id_region;
        this.nom_region = nom_region;
        this.parti_gagnant = parti_gagnant;
        this.nombre_votants = nombre_votants;
        this.percent_result = percent_result;
        this.electeurs = electeurs;
        this.votants = votants;
        this.represantant = represantant;
        this.id_parti_gagnant = id_parti_gagnant;
        this.id_parti_perdant = id_parti_perdant;
        this.parti_perdant = parti_perdant;
        this.represantant_perdant = represantant_perdant;
    }

    public Result(Integer id_region, String nom_region, String parti_gagnant, Integer nombre_votants, Float percent_result) {
        this.id_region = id_region;
        this.nom_region = nom_region;
        this.parti_gagnant = parti_gagnant;
        this.nombre_votants = nombre_votants;
        this.percent_result = percent_result;
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

    public Integer getNombre_votants() {
        return nombre_votants;
    }

    public void setNombre_votants(Integer nombre_votants) {
        this.nombre_votants = nombre_votants;
    }

    public Float getPercent_result() {
        return percent_result;
    }

    public void setPercent_result(Float percent_result) {
        this.percent_result = percent_result;
    }

    public Integer getVotants() {
        return votants;
    }

    public void setVotants(Integer votants) {
        this.votants = votants;
    }

    public String getRepresantant() {
        return represantant;
    }

    public void setRepresantant(String represantant) {
        this.represantant = represantant;
    }

    public Integer getId_parti_gagnant() {
        return id_parti_gagnant;
    }

    public void setId_parti_gagnant(Integer id_parti_gagnant) {
        this.id_parti_gagnant = id_parti_gagnant;
    }

    public Integer getId_parti_perdant() {
        return id_parti_perdant;
    }

    public void setId_parti_perdant(Integer id_parti_perdant) {
        this.id_parti_perdant = id_parti_perdant;
    }

    public String getParti_perdant() {
        return parti_perdant;
    }

    public void setParti_perdant(String parti_perdant) {
        this.parti_perdant = parti_perdant;
    }

    public String getRepresantant_perdant() {
        return represantant_perdant;
    }

    public void setRepresantant_perdant(String represantant_perdant) {
        this.represantant_perdant = represantant_perdant;
    }
}
