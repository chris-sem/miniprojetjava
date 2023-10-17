package com.mycompany.miniprojetjava;

public class Client extends Personne {
    public int idclient;
    public String numerocartefidelite;
    public String mail;
    public String codepostal;
    public int supprime;
    
    public Client(String client){
        super(client.split("_")[4],client.split("_")[5]);
        
        String tab_attributs[] = client.split("_");
        
        this.idclient = Integer.parseInt(tab_attributs[0]);
        this.numerocartefidelite = tab_attributs[1];
        this.mail = tab_attributs[2];
        this.codepostal = tab_attributs[3];
        this.supprime = Integer.parseInt(tab_attributs[6]);
    }
    
    public void afficherClient(){
        System.out.println(
                this.idclient + " " + this.numerocartefidelite + " " + this.mail + " " + this.codepostal + " " + this.nom + " " + this.prenom + " " + this.supprime
        );
    }
    
    @Override
    public String toString(){
        return this.idclient + "_" + this.numerocartefidelite + "_" + this.mail + "_" + this.codepostal + "_" + this.nom + "_" + this.prenom + "_" + this.supprime ;
    } 
}
