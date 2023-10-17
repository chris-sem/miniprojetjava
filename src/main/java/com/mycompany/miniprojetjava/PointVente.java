package com.mycompany.miniprojetjava;

public class PointVente {
    public int idpointvente;
    public String nom;
    public int supprime;
    
    public PointVente(String pointvente){
        
        String tab_attributs[] = pointvente.split("_");
        
        this.idpointvente = Integer.parseInt(tab_attributs[0]);
        this.nom = tab_attributs[1];
        this.supprime = Integer.parseInt(tab_attributs[2]);
    }
    
    public void afficherPointvente(){
        System.out.println(
                this.idpointvente + " " + this.nom + " " + this.supprime
        );
    }
    
    @Override
    public String toString(){
        return this.idpointvente + "_" + this.nom + "_" + this.supprime ;
    } 
}
