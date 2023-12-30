package com.abel.e_vote.models;

public class RegionParti {
    private Integer id_region;
    private Integer id_parti;
    private String nom_representant;
    private String nom_parti;
    private Integer vote;
    private float percent;

    public RegionParti(Integer id_region, Integer id_parti, String nom_representant, String nom_parti, Integer vote, float percent) {
        this.id_region = id_region;
        this.id_parti = id_parti;
        this.nom_representant = nom_representant;
        this.nom_parti = nom_parti;
        this.vote = vote;
        this.percent = percent;
    }

    public RegionParti(Integer id_region, Integer id_parti, String nom_representant, String nom_parti, Integer vote) {
        this.id_region = id_region;
        this.id_parti = id_parti;
        this.nom_representant = nom_representant;
        this.nom_parti = nom_parti;
        this.vote = vote;
    }

    public Integer getId_region() {
        return id_region;
    }

    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }

    public Integer getId_parti() {
        return id_parti;
    }

    public void setId_parti(Integer id_parti) {
        this.id_parti = id_parti;
    }

    public String getNom_representant() {
        return nom_representant;
    }

    public void setNom_representant(String nom_representant) {
        this.nom_representant = nom_representant;
    }

    public String getNom_parti() {
        return nom_parti;
    }

    public void setNom_parti(String nom_parti) {
        this.nom_parti = nom_parti;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "RegionParti{" +
                "id_region=" + id_region +
                ", id_parti=" + id_parti +
                ", nom_representant='" + nom_representant + '\'' +
                ", nom_parti='" + nom_parti + '\'' +
                ", vote=" + vote +
                '}';
    }
}
