package com.example.appli_fsi.model.BO;

import com.example.appli_fsi.model.BO.BilanDeux;
import com.example.appli_fsi.model.BO.BilanUn;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private int idEtu;
    private String nomEtu;
    private String preEtu;
    private String telEtu;
    private String mailEtu;
    private String etsEtu;
    private String tutEtsEtu;
    private String tutEtu;
    private String loginEtu;
    private String mdpEtu;
    private BilanUn monBilanUn;
    private BilanDeux monBilanDeux;

    public int getIdEtu() {
        return idEtu;
    }

    public void setIdEtu(int idEtu) {
        this.idEtu = idEtu;
    }

    public String getNomEtu() {
        return nomEtu;
    }

    public void setNomEtu(String nomEtu) {
        this.nomEtu = nomEtu;
    }

    public String getPreEtu() {
        return preEtu;
    }

    public void setPreEtu(String preEtu) {
        this.preEtu = preEtu;
    }

    public String getTelEtu() {
        return telEtu;
    }

    public void setTelEtu(String telEtu) {
        this.telEtu = telEtu;
    }

    public String getMailEtu() {
        return mailEtu;
    }

    public void setMailEtu(String mailEtu) {
        this.mailEtu = mailEtu;
    }

    public String getEtsEtu() {
        return etsEtu;
    }

    public void setEtsEtu(String etsEtu) {
        this.etsEtu = etsEtu;
    }

    public String getTutEtsEtu() {
        return tutEtsEtu;
    }

    public void setTutEtsEtu(String tutEtsEtu) {
        this.tutEtsEtu = tutEtsEtu;
    }

    public String getTutEtu() {
        return tutEtu;
    }

    public void setTutEtu(String tutEtu) {
        this.tutEtu = tutEtu;
    }

    public String getLoginEtu() {
        return loginEtu;
    }

    public void setLoginEtu(String loginEtu) {
        this.loginEtu = loginEtu;
    }

    public String getMdpEtu() {
        return mdpEtu;
    }

    public void setMdpEtu(String mdpEtu) {
        this.mdpEtu = mdpEtu;
    }


    public Etudiant(int id, String nom, String prenom,String tel, String mail, String entreprise, String tutEts, String tutEcole ){
        this.idEtu = id;
        this.preEtu = prenom;
        this.nomEtu = nom;
        this.telEtu = tel;
        this.mailEtu = mail;
        this.etsEtu = entreprise;
        this.tutEtsEtu = tutEts;
        this.tutEtu = tutEcole;
    }
    public Etudiant(){

    }

    public BilanUn getMonBilanUn() {
        return monBilanUn;
    }

    public void setMonBilanUn(BilanUn monBilanUn) {
        this.monBilanUn = monBilanUn;
    }

    public BilanDeux getMonBilanDeux() {
        return monBilanDeux;
    }

    public void setMonBilanDeux(BilanDeux monBilanDeux) {
        this.monBilanDeux = monBilanDeux;
    }
}
