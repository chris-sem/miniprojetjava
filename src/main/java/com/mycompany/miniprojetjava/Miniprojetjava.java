package com.mycompany.miniprojetjava;

import graphiquepackage.Home;

public class Miniprojetjava {
    
    public static BD baseDeDonnees = new BD();

    public static void main(String[] args) {
        /*
        System.out.println(baseDeDonnees.liste_Personnels_BD.get(baseDeDonnees.liste_Personnels_BD.size()-1).idpersonnel);
        
        Manager m = new Manager("2_1_12 rue des freres caudron_velizy villacoublay_ingenieur_12023_sem_jean christopher_0_sem124578");
        
        m.afficherManager();
        
        System.out.println(m.toString());
        
        
        System.out.println(baseDeDonnees.get_dernier_id_personne());
        */
        
        
        Home accueil = new Home();
        accueil.setVisible(true);
        accueil.setLocationRelativeTo(null);
        
    }
}
