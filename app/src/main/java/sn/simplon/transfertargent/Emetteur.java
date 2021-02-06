  package sn.simplon.transfertargent;

import android.widget.EditText;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Emetteur implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nomE")
    private String nomE;
    @JsonProperty("prenomE")
    private String  prenomE;
    @JsonProperty("telE")
    private String  telE;
    @JsonProperty("cinE")
    private String cinE;
    @JsonProperty("envoies")
    private List<Envoie> envoies = new ArrayList<>();

    public Emetteur() {
    }

    public Emetteur(Long id, String nomE, String prenomE, String telE, String cinE, List<Envoie> envoies) {
        this.id = id;
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.telE = telE;
        this.cinE = cinE;
        this.envoies = envoies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getTelE() {
        return telE;
    }

    public void setTelE(String telE) {
        this.telE = telE;
    }

    public String getCinE() {
        return cinE;
    }

    public void setCinE(String cinE) {
        this.cinE = cinE;
    }

    public List<Envoie> getEnvoies() {
        return envoies;
    }

    public void setEnvoies(List<Envoie> envoies) {
        this.envoies = envoies;
    }
}
