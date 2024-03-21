package com.example.appli_fsi.model.BO;
import java.io.Serializable;
import java.util.Date;

public class BilanUn implements Serializable {
    private int idBilanUn;
    private float noteEts;
    private Date dateBilanUn;
    private float noteDossierUn;
    private float noteOralUn;
    private String rqBilanUn;

    public int getIdBilanUn() {
        return idBilanUn;
    }

    public void setIdBilanUn(int idBilanUn) {
        this.idBilanUn = idBilanUn;
    }

    public float getNoteEts() {
        return noteEts;
    }

    public void setNoteEts(float noteEts) {
        this.noteEts = noteEts;
    }

    public Date getDateBilanUn() {
        return dateBilanUn;
    }

    public void setDateBilanUn(Date dateBilanUn) {
        this.dateBilanUn = dateBilanUn;
    }

    public float getNoteDossierUn() {
        return noteDossierUn;
    }

    public void setNoteDossierUn(float noteDossierUn) {
        this.noteDossierUn = noteDossierUn;
    }

    public float getNoteOralUn() {
        return noteOralUn;
    }

    public void setNoteOralUn(float noteOralUn) {
        this.noteOralUn = noteOralUn;
    }

    public String getRqBilanUn() {
        return rqBilanUn;
    }

    public void setRqBilanUn(String rqBilanUn) {
        this.rqBilanUn = rqBilanUn;
    }
    public BilanUn(int id, float noteEts, Date date, float noteDossier, float noteOral,String remarque){
        this.idBilanUn = id;
        this.noteEts = noteEts;
        this.dateBilanUn = date;
        this.noteDossierUn = noteDossier;
        this.noteOralUn = noteOral;
        this.rqBilanUn = remarque;
    }
    public BilanUn(){

    }
}
