package com.mycompany.miniprojetjava;

public class Caissier extends Personne {
    public int idcaissier;
    public int idpointvente;//la ou il la caissier travaille 
    public String numerobadge;
    public int supprime;
    
    public Caissier(String caissier){
        super(caissier.split("_")[2], caissier.split("_")[3]);
        
        String tab_attributs[] = caissier.split("_");
        
        this.idcaissier = Integer.parseInt(tab_attributs[0]);
        this.numerobadge = tab_attributs[1];
        this.supprime = Integer.parseInt(tab_attributs[4]);
        this.idpointvente = Integer.parseInt(tab_attributs[5]);
    }
    
    public void afficherCaissier(){
        System.out.println(
                this.idcaissier + " " + this.numerobadge + " " + this.nom + " " + this.prenom + " " + this.supprime + " " + this.idpointvente
        );
    }
    
    @Override
    public String toString(){
        return this.idcaissier + "_" + this.numerobadge + "_" + this.nom + "_" + this.prenom + "_" + this.supprime + "_" + this.idpointvente ;
    } 
}
