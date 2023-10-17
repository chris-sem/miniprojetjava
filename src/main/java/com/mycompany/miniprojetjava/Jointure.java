package com.mycompany.miniprojetjava;

public class Jointure {
    public Caissier cs;
    public Client cl;
    public PointVente pv;
    public Produit pd;
    public Type tp;
    public Vente vt;
    
    public Jointure(BD basededonnees, Vente vt){
        this.cs = basededonnees.getCaissierById(vt.idcaissier);
        this.cl = basededonnees.getClientById(vt.idclient);
        this.pv = basededonnees.getPointventeById(vt.idpointvente);
        this.pd = basededonnees.getProduitById(vt.idproduit);
        this.tp = basededonnees.getTypeById(vt.idtypeproduit);
        this.vt = vt ;
    }
    
    public void afficherJointure(){
        
        this.pd.afficherProduit();
        this.tp.afficherType();
        this.cl.afficherClient();
        this.pv.afficherPointvente();
        this.cs.afficherCaissier();
        this.vt.afficherVente();
        System.out.println("************************************************************\n");
    }
    
    @Override
    public String toString(){
        return this.pd.toString() + "_" + this.tp.toString() + "_" + this.cl.toString() + "_" + this.pv.toString() + "_" + this.cs.toString() + "_" +  this.vt.toString() ;
    }
}
