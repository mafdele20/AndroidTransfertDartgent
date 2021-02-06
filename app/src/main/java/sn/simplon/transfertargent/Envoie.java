package sn.simplon.transfertargent;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

import java.io.Serializable;

public class Envoie implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("montant")
    private double montant;
    @JsonProperty("emetteur")
    private JSONObject emetteur;
    @JsonProperty("recepteur")
    private JSONObject recepteur;

    public Envoie() {
    }

    public Envoie(Long id, String date, double montant, JSONObject emetteur, JSONObject recepteur) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.emetteur = emetteur;
        this.recepteur = recepteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public JSONObject getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(JSONObject emetteur) {
        this.emetteur = emetteur;
    }

    public JSONObject getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(JSONObject recepteur) {
        this.recepteur = recepteur;
    }
}
