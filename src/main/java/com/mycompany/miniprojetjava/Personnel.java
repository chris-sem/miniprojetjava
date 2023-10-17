package com.mycompany.miniprojetjava;

public class Personnel extends Personne {
    public int idpersonnel;
    public int idsuperieur;
    public String adresse;
    public String adresselieutravail;
    public String poste;
    public String numerobadge;
    public int supprime;
    
    public Personnel(String personnel){
        super(personnel.split("_")[6],personnel.split("_")[7]);
        
        String tab_attributs[] = personnel.split("_");
        
        this.idpersonnel = Integer.parseInt(tab_attributs[0]);
        this.idsuperieur = Integer.parseInt(tab_attributs[1]);
        this.adresse = tab_attributs[2];
        this.adresselieutravail = tab_attributs[3];
        this.poste = tab_attributs[4];
        this.numerobadge = tab_attributs[5];
        this.supprime = Integer.parseInt(tab_attributs[8]);
    }
    
    public void afficherPersonnel(){
        System.out.println(
                this.idpersonnel + " " + this.idsuperieur+ " " + this.adresse + " " + this.adresselieutravail + " " + this.poste + " " + this.numerobadge + " " + this.nom + " " + this.prenom + " " + this.supprime
        );
    }
    
    @Override
    public String toString(){
        return this.idpersonnel + "_" + this.idsuperieur+ "_" + this.adresse + "_" + this.adresselieutravail + "_" + this.poste + "_" + this.numerobadge + "_" + this.nom + "_" + this.prenom + "_" + this.supprime ;
    } 
}
