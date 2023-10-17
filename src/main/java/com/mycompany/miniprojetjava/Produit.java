package com.mycompany.miniprojetjava;

public class Produit {
    public int idproduit;
    public String nom;
    public String description;
    public double prix;
    public String paysorigine;
    public double tva;
    public String fournisseur;
    public double poids;
    public double quatitestock;
    public int supprime;
    
    public Produit(String produit){
        String tab_attributs[] = produit.split("_");
        this.idproduit = Integer.parseInt(tab_attributs[0]);
        this.nom = tab_attributs[1];
        this.description = tab_attributs[2];
        this.prix = Double.parseDouble(tab_attributs[3]);
        this.paysorigine = tab_attributs[4];
        this.tva = Double.parseDouble(tab_attributs[5]);
        this.fournisseur = tab_attributs[6];
        this.poids = Double.parseDouble(tab_attributs[7]);
        this.quatitestock = Double.parseDouble(tab_attributs[8]);
        this.supprime = Integer.parseInt(tab_attributs[9]);
    }
    
    public void afficherProduit(){
        System.out.println(
                this.idproduit + " " + this.nom + " " + this.description + " " + this.prix + " " + this.paysorigine + " " + this.tva + " " + this.fournisseur + " " + this.poids + " " + this.quatitestock + " " + this.supprime
        );
    }
    
    @Override
    public String toString(){
        return this.idproduit + "_" + this.nom + "_" + this.description + "_" + this.prix + "_" + this.paysorigine + "_" + this.tva + "_" + this.fournisseur + "_" + this.poids + "_" + this.quatitestock + "_" + this.supprime ;
    }
}
