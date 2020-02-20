/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyride.Entite;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author suare
 */
public class Produit {
     private int id;
    private String nom;
    private String description;
    private String couleur;
   private int Prix;

    public Produit() {
    }

    public Produit(int id, String nom, String description, String couleur, int Prix) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.Prix = Prix;
    }

    public Produit(String nom, String description, String couleur, int Prix) {
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.Prix = Prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getPrix() {
        return Prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", couleur=" + couleur + ", Prix=" + Prix + '}';
    }


    
}
