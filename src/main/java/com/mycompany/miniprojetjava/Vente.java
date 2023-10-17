package com.mycompany.miniprojetjava;

public class Vente {
    public int idproduit;
    public int idtypeproduit;
    public int idclient;
    public int idpointvente;
    public int idcaissier;
    public double quatite;
    public String date;
    public int supprime;
    
    public Vente(String vente){
        String tab_attributs[] = vente.split("_");
        this.idproduit = Integer.parseInt(tab_attributs[0]);
        this.idtypeproduit = Integer.parseInt(tab_attributs[1]);
        this.idclient = Integer.parseInt(tab_attributs[2]);
        this.idpointvente = Integer.parseInt(tab_attributs[3]);
        this.idcaissier = Integer.parseInt(tab_attributs[4]); 
        this.quatite = Double.parseDouble(tab_attributs[5]);
        this.date = tab_attributs[6];
        this.supprime = Integer.parseInt(tab_attributs[7]);
    }
    
    public void afficherVente(){
        System.out.println(
                this.idproduit + " " + this.idtypeproduit + " " + this.idclient+ " " + this.idpointvente + " " + this.idcaissier + " " + this.quatite + " " + this.date + " " + this.supprime
        );
    }
    
    @Override
    public String toString(){
        return this.idproduit + "_" + this.idtypeproduit + "_" + this.idclient+ "_" + this.idpointvente + "_" + this.idcaissier + "_" + this.quatite + "_" + this.date + "_" + this.supprime;
    }
}
