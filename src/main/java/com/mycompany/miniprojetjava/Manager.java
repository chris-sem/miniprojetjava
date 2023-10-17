package com.mycompany.miniprojetjava;

public class Manager extends Personnel {
    
    public String codemanager;
    
    public Manager(String manager){
        super(manager);
        
        String tab_attributs[] = manager.split("_");
        this.codemanager = tab_attributs[9];
    }
    
    public void afficherManager(){
        System.out.println(
                this.idpersonnel + " " + this.idsuperieur+ " " + this.adresse + " " + this.adresselieutravail + " " + this.poste + " " + this.numerobadge + " " + this.nom + " " + this.prenom + " " + this.supprime + " " + this.codemanager
        );
    }
    
    @Override
    public String toString(){
        return this.idpersonnel + "_" + this.idsuperieur+ "_" + this.adresse + "_" + this.adresselieutravail + "_" + this.poste + "_" + this.numerobadge + "_" + this.nom + "_" + this.prenom + "_" + this.supprime + "_" + this.codemanager ;
    } 
}
