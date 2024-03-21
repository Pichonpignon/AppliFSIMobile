package com.example.appli_fsi.model.BO;
import java.io.Serializable;
import java.util.Date;
public class BilanDeux implements Serializable {
    private int idBilanDeux;
    private float noteOralDeux;
    private float noteDossierDeux;
    private Date dateBilanDeux;
    private String rqBilanDeux;
    private String sujetMemoire;

    public int getIdBilanDeux() {
        return idBilanDeux;
    }

    public void setIdBilanDeux(int idBilanDeux) {
        this.idBilanDeux = idBilanDeux;
    }

    public float getNoteOralDeux() {
        return noteOralDeux;
    }

    public void setNoteOralDeux(float noteOralDeux) {
        this.noteOralDeux = noteOralDeux;
    }

    public float getNoteDossierDeux() {
        return noteDossierDeux;
    }

    public void setNoteDossierDeux(float noteDossierDeux) {
        this.noteDossierDeux = noteDossierDeux;
    }

    public Date getDateBilanDeux() {
        return dateBilanDeux;
    }

    public void setDateBilanDeux(Date dateBilanDeux) {
        this.dateBilanDeux = dateBilanDeux;
    }

    public String getRqBilanDeux() {
        return rqBilanDeux;
    }

    public void setRqBilanDeux(String rqBilanDeux) {
        this.rqBilanDeux = rqBilanDeux;
    }

    public String getSujetMemoire() {
        return sujetMemoire;
    }

    public void setSujetMemoire(String sujetMemoire) {
        this.sujetMemoire = sujetMemoire;
    }

    public BilanDeux(int id, float noteDossier, float noteOral, Date date, String remarque, String sujetMemoire){
        this.idBilanDeux = id;
        this.noteDossierDeux = noteDossier;
        this.noteOralDeux = noteOral;
        this.dateBilanDeux = date;
        this.rqBilanDeux = remarque;
        this.sujetMemoire = sujetMemoire;
    }
    public BilanDeux(){

    }
}
