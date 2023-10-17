package com.mycompany.miniprojetjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BD {
    public List<Personnel> liste_Personnels_BD ;
    public List<Manager> liste_Managers_BD ;
    public List<Client> liste_Clients_BD ;
    public List<Caissier> liste_Caissiers_BD ;
    
    public List<Produit> liste_Produits_BD ;
    public List<PointVente> liste_PointVentes_BD ;
    public List<Type> liste_Type_BD ;
    
    public List<Vente> liste_Ventes_BD ;
    public List<Jointure> liste_Jointures_BD ;
    
    public int dernier_id_personne;
    public int dernier_id_produit;
    public int dernier_id_pointvente;
    public int dernier_id_type;
    
    public BD(){
        this.liste_Personnels_BD = new ArrayList<>();
        this.liste_Clients_BD = new ArrayList<>();
        this.liste_Caissiers_BD = new ArrayList<>();
        this.liste_Produits_BD = new ArrayList<>();
        this.liste_PointVentes_BD = new ArrayList<>();
        this.liste_Ventes_BD = new ArrayList<>();
        this.liste_Type_BD = new ArrayList<>();
        this.liste_Jointures_BD = new ArrayList<>();
        this.liste_Managers_BD = new ArrayList<>();
        
        this.miseEnPlaceBD();
    }
    
    //Fonction a apppeller tout au debut du projet
    public void miseEnPlaceBD(){
        initialisation_fichier("caissier.txt", "1_123456_mamadou_louis_0_1", "2_789456_joul_martin_0_2");
        initialisation_fichier("client.txt", "1_0_@_0_anonyme_anonyme_0", "2_123456_jardin@gmail.com_78140_depaul_jardin joujou_0");
        initialisation_fichier("personnel.txt", "1_1_12 rue de la republique_paris_prof_48562_abuda_dekra_0", "2_1_12 rue des freres caudron_velizy villacoublay_ingenieur_12023_sem_jean christopher_0");
        initialisation_fichier("pointvente.txt", "1_westfield_0", "2_auchan_0");
        initialisation_fichier("produit.txt", "1_pain_croustillant_2.5_france_10.0_boulanger_0.2_10_0", "2_poulet_vif_11.5_france_2.5_auchan_5_30_0");
        initialisation_fichier("type.txt", "1_autre_0", "2_aliment_0");
        initialisation_fichier("vente.txt", "1_1_1_1_1_0_01/01/2000_0", "1_1_1_1_1_0_02/01/2000_0");
        initialisation_fichier("manager.txt", "3_1_12 rue des freres caudron_velizy villacoublay_ingenieur_12023_sem_jean christopher_0_sem124578", "4_1_12 rue des freres caudron_velizy villacoublay_ingenieur_12023_sem_jean christopher_0_sem124578");
        
        this.getListeCaissier_BD();
        this.getListeClient_BD();
        this.getListePersonnel_BD();
        this.getListePointevente_BD();
        this.getListeProduit_BD();
        this.getListeType_BD();
        this.getListeVente_BD();
        this.getListeManager_BD();
        
        this.dernier_id_personne = this.get_dernier_id_personne();
        this.dernier_id_produit = this.get_dernier_id_produit();
        this.dernier_id_pointvente = this.get_dernier_id_pointvente();
        this.dernier_id_type = this.get_dernier_id_type();
        
    }
    
    int get_dernier_id_personne(){
        
        List<Integer> listeEntiers = new ArrayList<Integer>();
        
        listeEntiers.add(this.liste_Personnels_BD.get(this.liste_Personnels_BD.size() - 1).idpersonnel) ;
        listeEntiers.add(this.liste_Caissiers_BD.get(this.liste_Caissiers_BD.size() - 1).idcaissier) ;
        listeEntiers.add(this.liste_Clients_BD.get(this.liste_Clients_BD.size() - 1).idclient) ;
        listeEntiers.add(this.liste_Managers_BD.get(this.liste_Managers_BD.size() - 1).idpersonnel) ;
        
        Collections.sort(listeEntiers);
        
        return listeEntiers.get(listeEntiers.size()-1) ;
    }
    
    int get_dernier_id_produit(){  
        return this.liste_Produits_BD.get(this.liste_Produits_BD.size() - 1).idproduit ;  
    }
    
    int get_dernier_id_type(){  
        return this.liste_Type_BD.get(this.liste_Type_BD.size() - 1).idtype ;  
    }
    
    int get_dernier_id_pointvente(){  
        return this.liste_PointVentes_BD.get(this.liste_PointVentes_BD.size() - 1).idpointvente ;  
    }
    
    
    //////////////////////////////////////////////////////////// Jointure //////////////////////////////////////////////////////////////////////////////////
    
    public void getListeJointure(){
        for(Vente v : this.liste_Ventes_BD){
            this.liste_Jointures_BD.add(new Jointure(this, v));
        }
    }
    
    public void afficherListeJointure_BD(){
        for(Jointure j : this.liste_Jointures_BD){
            j.afficherJointure();
        }
    }
    
    
    
     //////////////////////////////////////////////////////////// Manager //////////////////////////////////////////////////////////////////////////////////
    
    int getNombreManagerNonSupprimer(){
        
        int nbre = 0 ;
        
        Manager p ;
        for (int i=0; i < this.liste_Managers_BD.size(); i++){
            p = this.liste_Managers_BD.get(i);
            
            if(p.supprime == 0){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    int getNombreManagerSupprimer(){
        
        int nbre = 0 ;
        
        Manager p ;
        for (int i=0; i < this.liste_Managers_BD.size(); i++){
            p = this.liste_Managers_BD.get(i);
            
            if(p.supprime == 1){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    public String [][] getmanagerNonSupprimes(){
        
        String [][] tabpersonnelNonSupprimes = new String [getNombreManagerNonSupprimer()][ ];
        
        Manager p ;
        for (int i=0, j=0 ; i < this.liste_Managers_BD.size(); i++ ){
            p = this.liste_Managers_BD.get(i);
            
            if(p.supprime == 0){
                tabpersonnelNonSupprimes[j] = new String []{""+p.idpersonnel, p.nom, p.prenom,p.adresse, p.adresselieutravail, p.poste, p.numerobadge, ""+p.idsuperieur, p.codemanager} ;
                j++ ;
            }
        }
       
        return tabpersonnelNonSupprimes;
    }
    
    public String [][] getmanagerSupprimes(){
        
        String [][] tabpersonnelSupprimes = new String [getNombreManagerSupprimer()][ ];
        
        Manager p ;
        for (int i=0, j=0; i < this.liste_Managers_BD.size(); i++){
            p = this.liste_Managers_BD.get(i);
            
            if(p.supprime == 1){
                tabpersonnelSupprimes[j] = new String []{""+p.idpersonnel, p.nom, p.prenom,p.adresse, p.adresselieutravail, p.poste, p.numerobadge, ""+p.idsuperieur, p.codemanager} ;
                j++ ;
            }
        }
       
        return tabpersonnelSupprimes;
    }
    
    public void restaurerManagerSupprime(int idmanager){
        Manager p ; 
        
        for(int i=0 ; i < this.liste_Managers_BD.size() ; i++){
            
            p = this.liste_Managers_BD.get(i) ;
            
            if(p.idpersonnel == idmanager){
               
                p.supprime = 0;
                this.liste_Managers_BD.set(i, p);
                
            }
        }
        
        this.updateManager_BD();
    }
    
    public Manager authentificationManager(String nom, String codemanager){
        Manager c ;
        
        for (int i=0; i < this.liste_Managers_BD.size(); i++){
            c = this.liste_Managers_BD.get(i);
            
            if(c.nom.toLowerCase().equals(nom.toLowerCase()) && c.codemanager.toLowerCase().equals(codemanager.toLowerCase())){
                return c ;
            }
        }
        return null ;
    }
    
    
    public Manager getManagerById(int id){
        Manager m ;
        for (int i=0; i < this.liste_Managers_BD.size(); i++){
            m = this.liste_Managers_BD.get(i);
            
            if(m.idpersonnel == id){
                return m ;
            }
        }
        return null ;
    }
    
    public void ajouterManager_BD(Manager m){
        this.liste_Managers_BD.add(m);
        this.dernier_id_personne = this.dernier_id_personne + 1;
        this.updateManager_BD();
    }
    
    public void modifierManager_BD(int idpersonnel, Manager m_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_Managers_BD.size() && ok ; i++){
            
            if(this.liste_Managers_BD.get(i).idpersonnel == idpersonnel){
                
                this.liste_Managers_BD.set(i, m_modificateur);
                
                ok = false ;
            }
        }
        this.updateManager_BD();
    }
    
    public void supprimerManger_BD(int idpersonnel){
        
        boolean ok = true ;
        Manager p ; 
        
        for(int i=0 ; i < this.liste_Managers_BD.size() && ok ; i++){
            
            if(this.liste_Managers_BD.get(i).idpersonnel == idpersonnel){
                
                p = this.liste_Managers_BD.get(i) ;
                p.supprime = 1;
                this.liste_Managers_BD.set(i, p);
                
                ok = false ;
            }
        }
        this.updateManager_BD();
    }
    
    public void getListeManager_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("manager.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Managers_BD).add(new Manager(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateManager_BD(){
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("manager.txt"));
            for(Manager m : this.liste_Managers_BD){
                stylo.write(m.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void afficherListeManager_BD(){
        for(Manager p : this.liste_Managers_BD){
            p.afficherManager();
        }
    }
    
    
    
    //////////////////////////////////////////////////////////// Personnel //////////////////////////////////////////////////////////////////////////////////
    
    
    int getNombrePersonnelNonSupprimer(){
        
        int nbre = 0 ;
        
        Personnel p ;
        for (int i=0; i < this.liste_Personnels_BD.size(); i++){
            p = this.liste_Personnels_BD.get(i);
            
            if(p.supprime == 0){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    int getNombrePersonnelSupprimer(){
        
        int nbre = 0 ;
        
        Personnel p ;
        for (int i=0; i < this.liste_Personnels_BD.size(); i++){
            p = this.liste_Personnels_BD.get(i);
            
            if(p.supprime == 1){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    public String [][] getpersonnelNonSupprimes(){
        
        String [][] tabpersonnelNonSupprimes = new String [getNombrePersonnelNonSupprimer()][ ];
        
        Personnel p ;
        for (int i=0, j=0 ; i < this.liste_Personnels_BD.size(); i++ ){
            p = this.liste_Personnels_BD.get(i);
            
            if(p.supprime == 0){
                tabpersonnelNonSupprimes[j] = new String []{""+p.idpersonnel, p.nom, p.prenom,p.adresse, p.adresselieutravail, p.poste, p.numerobadge, ""+p.idsuperieur, ""+p.supprime} ;
                j++ ;
            }
        }
       
        return tabpersonnelNonSupprimes;
    }
    
    public String [][] getpersonnelSupprimes(){
        
        String [][] tabpersonnelSupprimes = new String [getNombrePersonnelSupprimer()][ ];
        
        Personnel p ;
        for (int i=0, j=0; i < this.liste_Personnels_BD.size(); i++){
            p = this.liste_Personnels_BD.get(i);
            
            if(p.supprime == 1){
                tabpersonnelSupprimes[j] = new String []{""+p.idpersonnel, p.nom, p.prenom,p.adresse, p.adresselieutravail, p.poste, p.numerobadge, ""+p.idsuperieur, ""+p.supprime} ;
                j++ ;
            }
        }
       
        return tabpersonnelSupprimes;
    }
    
    public void restaurerPersonnelSupprime(int idpersonnel){
        Personnel p ; 
        
        for(int i=0 ; i < this.liste_Personnels_BD.size() ; i++){
            
            p = this.liste_Personnels_BD.get(i) ;
            
            if(p.idpersonnel == idpersonnel){
               
                p.supprime = 0;
                this.liste_Personnels_BD.set(i, p);
                
            }
        }
        
        this.updatePersonnel_BD();
    }
    
    
    
    public Personnel getPersonnelById(int id){
        Personnel p ;
        for (int i=0; i < this.liste_Personnels_BD.size(); i++){
            p = this.liste_Personnels_BD.get(i);
            
            if(p.idpersonnel == id){
                return p ;
            }
        }
        return null ;
    }
    
    public void ajouterPersonnel_BD(Personnel p){
        this.liste_Personnels_BD.add(p);
        this.dernier_id_personne = this.dernier_id_personne + 1;
        this.updatePersonnel_BD();
    }
    
    public void modifierPersonnel_BD(int idpersonnel, Personnel p_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_Personnels_BD.size() && ok ; i++){
            
            if(this.liste_Personnels_BD.get(i).idpersonnel == idpersonnel){
                
                this.liste_Personnels_BD.set(i, p_modificateur);
                
                ok = false ;
            }
        }
        this.updatePersonnel_BD();
    }
    
    public void supprimerPersonnel_BD(int idpersonnel){
        
        Personnel p ; 
        
        for(int i=0 ; i < this.liste_Personnels_BD.size() ; i++){
            
            p = this.liste_Personnels_BD.get(i) ;
            
            if(p.idpersonnel == idpersonnel){
               
                p.supprime = 1;
                this.liste_Personnels_BD.set(i, p);
                
            }
        }
        
        this.updatePersonnel_BD();
    }
    
    public void getListePersonnel_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("personnel.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Personnels_BD).add(new Personnel(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updatePersonnel_BD(){
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("personnel.txt"));
            for(Personnel p : this.liste_Personnels_BD){
                stylo.write(p.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void afficherListePersonnel_BD(){
        for(Personnel p : this.liste_Personnels_BD){
            p.afficherPersonnel();
        }
    }
    
    
    //////////////////////////////////////////////////////////// Caissier //////////////////////////////////////////////////////////////////////////////////

    
    int getNombreCaissierNonSupprimer(){
        
        int nbre = 0 ;
        
        Caissier p ;
        for (int i=0; i < this.liste_Caissiers_BD.size(); i++){
            p = this.liste_Caissiers_BD.get(i);
            
            if(p.supprime == 0){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    int getNombreCaissierSupprimer(){
        
        int nbre = 0 ;
        
        Caissier p ;
        for (int i=0; i < this.liste_Caissiers_BD.size(); i++){
            p = this.liste_Caissiers_BD.get(i);
            
            if(p.supprime == 1){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    public String [][] getCaissierNonSupprimes(){
        
        String [][] tabclientNonSupprimes = new String [getNombreCaissierNonSupprimer()][ ];
        
        Caissier p ;
        for (int i=0, j=0 ; i < this.liste_Caissiers_BD.size(); i++ ){
            p = this.liste_Caissiers_BD.get(i);
            
            if(p.supprime == 0){
                tabclientNonSupprimes[j] = new String []{""+p.idcaissier, p.nom, p.prenom,p.numerobadge, ""+p.idpointvente} ;
                j++ ;
            }
        }
       
        return tabclientNonSupprimes;
    }
    
    public String [][] getCaissierSupprimes(){
        
        String [][] tabclientSupprimes = new String [getNombreCaissierSupprimer()][ ];
        
        Caissier p ;
        for (int i=0, j=0 ; i < this.liste_Caissiers_BD.size(); i++ ){
            p = this.liste_Caissiers_BD.get(i);
            
            if(p.supprime == 1){
                tabclientSupprimes[j] = new String []{""+p.idcaissier, p.nom, p.prenom,p.numerobadge, ""+p.idpointvente} ;
                j++ ;
            }
        }
       
        return tabclientSupprimes;
    }
   
    
    public void restaurerCaissierSupprime(int idcaissier){
        Caissier p ; 
        
        for(int i=0 ; i < this.liste_Caissiers_BD.size() ; i++){
            
            p = this.liste_Caissiers_BD.get(i) ;
            
            if(p.idcaissier == idcaissier){
               
                p.supprime = 0;
                this.liste_Caissiers_BD.set(i, p);
                
            }
        }
        
        this.updateCaissier_BD();
    }
    
    
    public Caissier authentificationCaissier(String nom, String numbadge, int id_pv){
        Caissier c ;
        
        for (int i=0; i < this.liste_Caissiers_BD.size(); i++){
            c = this.liste_Caissiers_BD.get(i);
            
            if(c.nom.toLowerCase().equals(nom.toLowerCase()) && c.numerobadge.toLowerCase().equals(numbadge.toLowerCase()) && c.idpointvente == id_pv){
                return c ;
            }
        }
        return null ;
    }
    
    public Caissier getCaissierById(int id){
        Caissier c ;
        
        for (int i=0; i < this.liste_Caissiers_BD.size(); i++){
            c = this.liste_Caissiers_BD.get(i);
            
            if(c.idcaissier == id){
                return c ;
            }
        }
        return null ;
    }
    
    public void updateCaissier_BD(){
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("caissier.txt"));
            for(Caissier c : this.liste_Caissiers_BD){
                stylo.write(c.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ajouterCaissier_BD(Caissier c){
        this.liste_Caissiers_BD.add(c);
        this.dernier_id_personne = this.dernier_id_personne + 1;
        this.updateCaissier_BD();
    }
    
    public void modifierCaissier_BD(int idcaissier, Caissier c_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_Caissiers_BD.size() && ok ; i++){
            
            if(this.liste_Caissiers_BD.get(i).idcaissier == idcaissier){
                
                this.liste_Caissiers_BD.set(i, c_modificateur);
                
                ok = false ;
            }
        }
        this.updateCaissier_BD();
    }
    
    public void supprimerCaissier_BD(int idcaissier){
        
        boolean ok = true ;
        Caissier c ; 
        
        for(int i=0 ; i < this.liste_Caissiers_BD.size() && ok ; i++){
            
            if(this.liste_Caissiers_BD.get(i).idcaissier == idcaissier){
                
                c = this.liste_Caissiers_BD.get(i) ;
                c.supprime = 1;
                this.liste_Caissiers_BD.set(i, c);
                
                ok = false ;
            }
        }
        
        this.updateCaissier_BD();
    }
    
    public void getListeCaissier_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("caissier.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Caissiers_BD).add(new Caissier(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void afficherListeCaissier_BD(){
        for(Caissier c : this.liste_Caissiers_BD){
            c.afficherCaissier();
        }
    }
    
    
    //////////////////////////////////////////////////////////// Client //////////////////////////////////////////////////////////////////////////////////

    
    int getNombreClientNonSupprimer(){
        
        int nbre = 0 ;
        
        Client p ;
        for (int i=0; i < this.liste_Clients_BD.size(); i++){
            p = this.liste_Clients_BD.get(i);
            
            if(p.supprime == 0){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    int getNombreClientSupprimer(){
        
        int nbre = 0 ;
        
        Client p ;
        for (int i=0; i < this.liste_Clients_BD.size(); i++){
            p = this.liste_Clients_BD.get(i);
            
            if(p.supprime == 1){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    public String [][] getClientNonSupprimes(){
        
        String [][] tabclientNonSupprimes = new String [getNombreClientNonSupprimer()][ ];
        
        Client p ;
        for (int i=0, j=0 ; i < this.liste_Clients_BD.size(); i++ ){
            p = this.liste_Clients_BD.get(i);
            
            if(p.supprime == 0){
                tabclientNonSupprimes[j] = new String []{""+p.idclient, p.nom, p.prenom,p.numerocartefidelite, p.mail, p.codepostal, ""+p.supprime} ;
                j++ ;
            }
        }
       
        return tabclientNonSupprimes;
    }
    
    public String [][] getClientSupprimes(){
        
        String [][] tabclientSupprimes = new String [getNombreClientSupprimer()][ ];
        
        Client p ;
        for (int i=0, j=0 ; i < this.liste_Clients_BD.size(); i++ ){
            p = this.liste_Clients_BD.get(i);
            
            if(p.supprime == 1){
                tabclientSupprimes[j] = new String []{""+p.idclient, p.nom, p.prenom,p.numerocartefidelite, p.mail, p.codepostal, ""+p.supprime} ;
                j++ ;
            }
        }
       
        return tabclientSupprimes;
    }
   
    
    public void restaurerClientSupprime(int idclient){
        Client p ; 
        
        for(int i=0 ; i < this.liste_Clients_BD.size() ; i++){
            
            p = this.liste_Clients_BD.get(i) ;
            
            if(p.idclient == idclient){
               
                p.supprime = 0;
                this.liste_Clients_BD.set(i, p);
                
            }
        }
        
        this.updateClient_BD();
    }
 
    public Client getClientById(int id){
        
        Client c ;
        
        for (int i=0; i < this.liste_Clients_BD.size(); i++){
            c = this.liste_Clients_BD.get(i);
            
            if(c.idclient == id){
                return c ;
            }
        }
        return null ;
    }
    
    public void updateClient_BD(){
        
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("client.txt"));
            for(Client c : this.liste_Clients_BD){
                stylo.write(c.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ajouterClient_BD(Client c){
        this.liste_Clients_BD.add(c);
        this.dernier_id_personne = this.dernier_id_personne + 1;
        this.updateClient_BD();
    }
    
    public void modifierClient_BD(int idclient, Client c_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_Clients_BD.size() && ok ; i++){
            
            if(this.liste_Clients_BD.get(i).idclient == idclient){
                
                this.liste_Clients_BD.set(i, c_modificateur);
                
                ok = false ;
            }
        }
        this.updateClient_BD();
    }
    
    public void supprimerClient_BD(int idclient){
        
        boolean ok = true ;
        Client c ; 
        
        for(int i=0 ; i < this.liste_Clients_BD.size() && ok ; i++){
            
            if(this.liste_Clients_BD.get(i).idclient == idclient){
                
                c = this.liste_Clients_BD.get(i) ;
                c.supprime = 1;
                this.liste_Clients_BD.set(i, c);
                
                ok = false ;
            }
        }
        
        this.updateClient_BD();
    }
    
    public void getListeClient_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("client.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Clients_BD).add(new Client(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void afficherListeClient_BD(){
        for(Client c : this.liste_Clients_BD){
            c.afficherClient();
        }
    }
    
    
    //////////////////////////////////////////////////////////// Pointvente //////////////////////////////////////////////////////////////////////////////////

    
    int getNombrePointventeNonSupprimer(){
        
        int nbre = 0 ;
        
        PointVente p ;
        for (int i=0; i < this.liste_PointVentes_BD.size(); i++){
            p = this.liste_PointVentes_BD.get(i);
            
            if(p.supprime == 0){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    int getNombrePointventeSupprimer(){
        
        int nbre = 0 ;
        
        PointVente p ;
        for (int i=0; i < this.liste_PointVentes_BD.size(); i++){
            p = this.liste_PointVentes_BD.get(i);
            
            if(p.supprime == 1){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    public String [][] getpointventeNonSupprimes(){
        
        String [][] tabpersonnelNonSupprimes = new String [getNombrePointventeNonSupprimer()][ ];
        
        PointVente p ;
        for (int i=0, j=0 ; i < this.liste_PointVentes_BD.size(); i++ ){
            p = this.liste_PointVentes_BD.get(i);
            
            if(p.supprime == 0){
                tabpersonnelNonSupprimes[j] = new String []{""+p.idpointvente, p.nom} ;
                j++ ;
            }
        }
       
        return tabpersonnelNonSupprimes;
    }
    
    public String [][] getpointventeSupprimes(){
        
        String [][] tabpersonnelSupprimes = new String [getNombreManagerSupprimer()][ ];
        
        PointVente p ;
        for (int i=0, j=0; i < this.liste_PointVentes_BD.size(); i++){
            p = this.liste_PointVentes_BD.get(i);
            
            if(p.supprime == 1){
                tabpersonnelSupprimes[j] = new String []{""+p.idpointvente, p.nom} ;
                j++ ;
            }
        }
       
        return tabpersonnelSupprimes;
    }
    
    public void restaurerPointventeSupprime(int idpoinvente){
        PointVente p ; 
        
        for(int i=0 ; i < this.liste_PointVentes_BD.size() ; i++){
            
            p = this.liste_PointVentes_BD.get(i) ;
            
            if(p.idpointvente == idpoinvente){
               
                p.supprime = 0;
                this.liste_PointVentes_BD.set(i, p);
                
            }
        }
        
        this.updatePointvente_BD();
    }
 
    public PointVente getPointventeById(int id){
        
        PointVente p ;
        
        for (int i=0; i < this.liste_PointVentes_BD.size(); i++){
            p = this.liste_PointVentes_BD.get(i);
            
            if(p.idpointvente == id){
                return p ;
            }
        }
        return null ;
    }
    
    public PointVente getPointventeByNom(String nom){
        
        PointVente p ;
        
        for (int i=0; i < this.liste_PointVentes_BD.size(); i++){
            p = this.liste_PointVentes_BD.get(i);
            
            if(p.nom.equals(nom)){
                return p ;
            }
        }
        return null ;
    }
    
    public void updatePointvente_BD(){
        
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("pointvente.txt"));
            for(PointVente p : this.liste_PointVentes_BD){
                stylo.write(p.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ajouterPointvente_BD(PointVente p){
        this.liste_PointVentes_BD.add(p);
        this.dernier_id_pointvente = this.dernier_id_pointvente + 1;
        this.updatePointvente_BD();
    }
    
    public void modifierPointvente_BD(int idpointvente, PointVente p_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_PointVentes_BD.size() && ok ; i++){
            
            if(this.liste_PointVentes_BD.get(i).idpointvente == idpointvente){
                
                this.liste_PointVentes_BD.set(i, p_modificateur);
                
                ok = false ;
            }
        }
        this.updatePointvente_BD();
    }
    
    public void supprimerPointvente_BD(int idpointvente){
        
        boolean ok = true ;
        PointVente p ; 
        
        for(int i=0 ; i < this.liste_PointVentes_BD.size() && ok ; i++){
            
            if(this.liste_PointVentes_BD.get(i).idpointvente == idpointvente){
                
                p = this.liste_PointVentes_BD.get(i) ;
                p.supprime = 1;
                this.liste_PointVentes_BD.set(i, p);
                
                ok = false ;
            }
        }
        
        this.updatePointvente_BD();
    }
    
    public void getListePointevente_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("pointvente.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_PointVentes_BD).add(new PointVente(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void afficherListePointvente_BD(){
        for(PointVente p : this.liste_PointVentes_BD){
            p.afficherPointvente();
        }
    }
    
    
    //////////////////////////////////////////////////////////// Produit //////////////////////////////////////////////////////////////////////////////////

    
    int getNombreProduitNonSupprimer(){
        
        int nbre = 0 ;
        
        Produit p ;
        for (int i=0; i < this.liste_Produits_BD.size(); i++){
            p = this.liste_Produits_BD.get(i);
            
            if(p.supprime == 0){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    int getNombreProduitSupprimer(){
        
        int nbre = 0 ;
        
        Produit p ;
        for (int i=0; i < this.liste_Produits_BD.size(); i++){
            p = this.liste_Produits_BD.get(i);
            
            if(p.supprime == 1){
                nbre ++ ;
            }
        }
        return nbre ;
    }
    
    public String [][] getproduitNonSupprimes(){
        
        String [][] tabproduitNonSupprimes = new String [getNombreProduitNonSupprimer()][ ];
        
        Produit p ;
        for (int i=0, j=0 ; i < this.liste_Produits_BD.size(); i++ ){
            p = this.liste_Produits_BD.get(i);
            
            if(p.supprime == 0){
                tabproduitNonSupprimes[j] = new String []{""+p.idproduit, p.nom, p.description, ""+p.prix, p.paysorigine, ""+p.tva, p.fournisseur, ""+p.poids, ""+p.quatitestock, ""+p.supprime} ;
                j++ ;
            }
        }
       
        return tabproduitNonSupprimes;
    }
    
    public String [][] getproduitSupprimes(){
        
        String [][] tabproduitSupprimes = new String [getNombreProduitSupprimer()][ ];
        
        Produit p ;
        for (int i=0, j=0 ; i < this.liste_Produits_BD.size(); i++ ){
            p = this.liste_Produits_BD.get(i);
            
            if(p.supprime == 1){
                tabproduitSupprimes[j] = new String []{""+p.idproduit, p.nom, p.description, ""+p.prix, p.paysorigine, ""+p.tva, p.fournisseur, ""+p.poids, ""+p.quatitestock, ""+p.supprime} ;
                j++ ;
            }
        }
       
        return tabproduitSupprimes;
    }
    
    public void restaurerProduitSupprime(int idproduit){
        
        Produit p ; 
        
        for(int i=0 ; i < this.liste_Produits_BD.size() ; i++){
            
            p = this.liste_Produits_BD.get(i) ;
            
            if(p.idproduit == idproduit){
               
                p.supprime = 0;
                this.liste_Produits_BD.set(i, p);
                
            }
        }
        
        this.updateProduit_BD();
    }
    
 
    public Produit getProduitById(int id){
        
        Produit p ;
        
        for (int i=0; i < this.liste_Produits_BD.size(); i++){
            p = this.liste_Produits_BD.get(i);
            
            if(p.idproduit == id){
                return p ; 
            }
        }
        return null ;
    }
    
    public void updateProduit_BD(){
        
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("produit.txt"));
            for(Produit p : this.liste_Produits_BD){
                stylo.write(p.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ajouterProduit_BD(Produit p){
        this.liste_Produits_BD.add(p);
        this.dernier_id_produit = this.dernier_id_produit + 1;
        this.updateProduit_BD();
    }
    
    public void modifierProduit_BD(int idproduit, Produit p_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_Produits_BD.size() && ok ; i++){
            
            if(this.liste_Produits_BD.get(i).idproduit == idproduit){
                
                this.liste_Produits_BD.set(i, p_modificateur);
                
                ok = false ;
            }
        }
        this.updateProduit_BD();
    }
    
    
    public void supprimerProduit_BD(int idproduit){
        
        Produit p ; 
        
        for(int i=0 ; i < this.liste_Produits_BD.size() ; i++){
            
            p = this.liste_Produits_BD.get(i) ;
            
            if(p.idproduit == idproduit){
               
                p.supprime = 1;
                this.liste_Produits_BD.set(i, p);
                
            }
        }
        
        this.updateProduit_BD();
    }
    
    public void getListeProduit_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("produit.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Produits_BD).add(new Produit(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void afficherListeProduit_BD(){
        for(Produit p : this.liste_Produits_BD){
            p.afficherProduit();
        }
    }
    
    public void miseajourquantitestock(int idproduit, double quantite_vendue){
        
        Produit p ; 
        
        for(int i=0 ; i < this.liste_Produits_BD.size() ; i++){
            
            p = this.liste_Produits_BD.get(i) ;
            
            if(p.idproduit == idproduit){
               
                p.quatitestock = p.quatitestock - quantite_vendue;
                this.liste_Produits_BD.set(i, p);
                
            }
        }
        
        this.updateProduit_BD();
    }
    
    
    //////////////////////////////////////////////////////////// Type //////////////////////////////////////////////////////////////////////////////////

 
    public int getIdType(String nom){
        
        Type t ;
        
        for (int i=0; i < this.liste_Type_BD.size(); i++){
            t = this.liste_Type_BD.get(i);
            
            if(t.type.equals(nom)){
                return t.idtype ; 
            }
        }
        return 0 ;
    }
    
    public Type getTypeById(int id){
        
        Type t ;
        
        for (int i=0; i < this.liste_Type_BD.size(); i++){
            t = this.liste_Type_BD.get(i);
            
            if(t.idtype == id){
                return t ; 
            }
        }
        return null ;
    }
    
    public void updateType_BD(){
        
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("type.txt"));
            for(Type t : this.liste_Type_BD){
                stylo.write(t.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ajouterType_BD(Type t){
        this.liste_Type_BD.add(t);
        this.dernier_id_type = this.dernier_id_type + 1;
        this.updateType_BD();
    }
    
    public void modifierType_BD(int idtype, Type t_modificateur){
        
        boolean ok = true ;
        for(int i=0 ; i < this.liste_Type_BD.size() && ok ; i++){
            
            if(this.liste_Type_BD.get(i).idtype == idtype){
                
                this.liste_Type_BD.set(i, t_modificateur);
                
                ok = false ;
            }
        }
        this.updateType_BD();
    }
    
    public void supprimerType_BD(int idtype){
        
        boolean ok = true ;
        Type t ; 
        
        for(int i=0 ; i < this.liste_Type_BD.size() && ok ; i++){
            
            if(this.liste_Type_BD.get(i).idtype == idtype){
                
                t = this.liste_Type_BD.get(i) ;
                t.supprime = 1;
                this.liste_Type_BD.set(i, t);
                
                ok = false ;
            }
        }
        
        this.updateType_BD();
    }
    
    public void getListeType_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("type.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Type_BD).add(new Type(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void afficherListeType_BD(){
        for(Type t : this.liste_Type_BD){
            t.afficherType();
        }
    }
    
    
    //////////////////////////////////////////////////////////// Vente //////////////////////////////////////////////////////////////////////////////////

 
    
    public void updateVente_BD(){
        
        try {
            BufferedWriter stylo = new BufferedWriter( new FileWriter("vente.txt"));
            for(Vente v : this.liste_Ventes_BD){
                stylo.write(v.toString() + "\n");
            }
            stylo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ajouterVente_BD(Vente v){
        this.liste_Ventes_BD.add(v);
        this.updateVente_BD();
    }
    
    public void getListeVente_BD(){   
        try {
            BufferedReader lecteur = new BufferedReader( new FileReader("vente.txt"));
            String ligne ;
            while((ligne = lecteur.readLine()) != null){
                (this.liste_Ventes_BD).add(new Vente(ligne));
            }
            lecteur.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void afficherListeVente_BD(){
        for(Vente v : this.liste_Ventes_BD){
            v.afficherVente();
        }
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public static void initialisation_fichier(String nomFichier, String ligne1, String ligne2){
        File f1 = new File(nomFichier);
        if(f1.isFile())
        { 
            //System.out.println("Le fichier existe effectivement !");
        }
        else{
            //System.out.println("Ce fichier n'existe pas !");
            
            try {
                BufferedWriter stylo = new BufferedWriter( new FileWriter(nomFichier));
                stylo.write(ligne1 + "\n");
                stylo.write(ligne2 + "\n");
                stylo.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
   
    
