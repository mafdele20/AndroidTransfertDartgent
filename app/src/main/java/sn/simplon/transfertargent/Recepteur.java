package sn.simplon.transfertargent;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recepteur implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nomR")
    private String nomR;
    @JsonProperty("prenomR")
    private String  prenomR;
    @JsonProperty("telR")
    private String  telR;
    @JsonProperty("envoies")
    private List<Envoie> envoies = new ArrayList<>();

    public Recepteur(Long id, String nomR, String prenomR, String telR, List<Envoie> envoies) {
        this.id = id;
        this.nomR = nomR;
        this.prenomR = prenomR;
        this.telR = telR;
        this.envoies = envoies;
    }

    public Recepteur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getPrenomR() {
        return prenomR;
    }

    public void setPrenomR(String prenomR) {
        this.prenomR = prenomR;
    }

    public String getTelR() {
        return telR;
    }

    public void setTelR(String telR) {
        this.telR = telR;
    }

    public List<Envoie> getEnvoies() {
        return envoies;
    }

    public void setEnvoies(List<Envoie> envoies) {
        this.envoies = envoies;
    }
}
