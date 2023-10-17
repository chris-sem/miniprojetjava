package com.mycompany.miniprojetjava;

public class Type {
    public int idtype;
    public String type;
    public int supprime;
    
    public Type(String type){
        String tab_attributs[] = type.split("_");
        this.idtype = Integer.parseInt(tab_attributs[0]);
        this.type = tab_attributs[1];
        this.supprime = Integer.parseInt(tab_attributs[2]);
    }
    
    public void afficherType(){
        System.out.println(
                this.idtype + " " + this.type + " " + this.supprime
        );
    }
    
    @Override
    public String toString(){
        return this.idtype + " " + this.type + "_" + this.supprime;
    }
}
