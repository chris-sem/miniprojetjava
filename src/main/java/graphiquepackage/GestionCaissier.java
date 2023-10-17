package graphiquepackage;

import com.mycompany.miniprojetjava.Caissier;
import com.mycompany.miniprojetjava.Client;
import com.mycompany.miniprojetjava.Miniprojetjava;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author semje
 */
public class GestionCaissier extends javax.swing.JPanel {

    /**
     * Creates new form GestionCaissier
     */
    
    boolean desactivationbouton = false ;
    
    public GestionCaissier() {
        initComponents();
        
        jT_idcaissier.setVisible(false);
       
       
        boutonRestaurer.setVisible(false);
        
        message.setForeground( new Color(0,102,0));
        message.setText("Vous pouvez cliquez sur les entetes des colonnes, pour trier la table suivant cette colonne");
        
        
        
        DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();
        
        String[][] tabclients = Miniprojetjava.baseDeDonnees.getCaissierNonSupprimes();
        
        for(int i=0 ; i < tabclients.length ; i++ ){
            model.addRow(tabclients[i]);
        }
        
        jT_caissier.setAutoCreateRowSorter(true);
    }
    
    public static void rechercheAutomatique(JTable jt, JTextField jtf, JLabel jl){
        DefaultTableModel dtm = (DefaultTableModel) jt.getModel();
        String mot = jtf.getText().trim();
        
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
        jt.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(mot));
        
        int nbre = jt.getRowCount();
        
        if(nbre == 0){
            jl.setForeground(Color.red);
            jl.setText("Aucun item corrspond à ce nom");
        }
        
        if(nbre > 0){
            jl.setForeground( new Color(0,102,0));
            jl.setText("Resultats correspondants : " + nbre);
        }
        
        if(mot.equals("")){
            jl.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_caissier = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ajouter = new javax.swing.JButton();
        miseajour = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        voircaissierssupprimes = new javax.swing.JButton();
        boutonRestaurer = new javax.swing.JButton();
        jT_idcaissier = new javax.swing.JTextField();
        jT_recherche = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        jT_nom = new javax.swing.JTextField();
        jT_prenom = new javax.swing.JTextField();
        jT_numerobadge = new javax.swing.JTextField();
        jT_idpointvente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion des caissiers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 650));

        jT_caissier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id caissier", "Nom", "Prenom", "Numero badge", "Id point vente"
            }
        ));
        jT_caissier.setGridColor(new java.awt.Color(255, 255, 255));
        jT_caissier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_caissierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jT_caissier);

        jLabel1.setText("Nom :");

        jLabel2.setText("Prenom : ");

        jLabel3.setText("Numero badge :");

        ajouter.setBackground(new java.awt.Color(0, 204, 204));
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        miseajour.setBackground(new java.awt.Color(0, 204, 204));
        miseajour.setText("Mettre à jour");
        miseajour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miseajourActionPerformed(evt);
            }
        });

        supprimer.setBackground(new java.awt.Color(0, 204, 204));
        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        voircaissierssupprimes.setBackground(new java.awt.Color(255, 153, 153));
        voircaissierssupprimes.setText("Voir les caissiers supprimés");
        voircaissierssupprimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voircaissierssupprimesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voircaissierssupprimes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(miseajour, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouter)
                    .addComponent(miseajour)
                    .addComponent(supprimer))
                .addGap(18, 18, 18)
                .addComponent(voircaissierssupprimes)
                .addGap(30, 30, 30))
        );

        boutonRestaurer.setBackground(new java.awt.Color(153, 204, 255));
        boutonRestaurer.setText("Restaurer le caissier");
        boutonRestaurer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonRestaurerActionPerformed(evt);
            }
        });

        jT_idcaissier.setText("0");
        jT_idcaissier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_idcaissierActionPerformed(evt);
            }
        });

        jT_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_rechercheKeyReleased(evt);
            }
        });

        jLabel8.setText("Rechercher caissiers : ");

        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("message");

        jLabel4.setText("Id point de vente :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutonRestaurer, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jT_idcaissier, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(jT_prenom)
                                    .addComponent(jT_nom)
                                    .addComponent(jT_numerobadge)
                                    .addComponent(jT_idpointvente))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jT_recherche)))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(message)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jT_idcaissier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jT_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_numerobadge, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_idpointvente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(boutonRestaurer)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        
        int id_caissier = Integer.parseInt(jT_idcaissier.getText());
        
        
        DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();
        
        if(jT_caissier.getSelectedRow() == -1){
            if(jT_caissier.getRowCount() == 0){
                message.setText("La table est encore vide !");
            }
            else{
                message.setText("Vous devriez d'abord selectionner un item de la table");
            }
        }
        
        else{
            
            int j = jT_caissier.getSelectedRow(); 
            int i = jT_caissier.convertRowIndexToModel(j);
            
            
            Miniprojetjava.baseDeDonnees.supprimerCaissier_BD(id_caissier);
            model.removeRow(i);
                    
            jT_idcaissier.setText("0");
            jT_nom.setText("");
            jT_prenom.setText("");
            jT_numerobadge.setText("");
            jT_idpointvente.setText("0");

            message.setText("Vous pouvez cliquez sur les entetes des colonnes, pour trier la table suivant cette colonne");
            
        }
        
    }//GEN-LAST:event_supprimerActionPerformed

    private void boutonRestaurerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonRestaurerActionPerformed
        
        int id_caissier = Integer.parseInt(jT_idcaissier.getText());
        
        
        DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();
        
        if(jT_caissier.getSelectedRow() == -1){
            if(jT_caissier.getRowCount() == 0){
                message.setText("La table est encore vide !");
            }
            else{
                message.setText("Vous devriez d'abord selectionner un item de la table");
            }
        }
        
        else{
            
            int j = jT_caissier.getSelectedRow(); 
            int i = jT_caissier.convertRowIndexToModel(j);
            
            
            Miniprojetjava.baseDeDonnees.restaurerCaissierSupprime(id_caissier);
            model.removeRow(i);
                    
            jT_idcaissier.setText("0");
            jT_nom.setText("");
            jT_prenom.setText("");
            jT_numerobadge.setText("");
            jT_idpointvente.setText("0");

            message.setText("Vous pouvez cliquez sur les entetes des colonnes, pour trier la table suivant cette colonne");
            
        }
    }//GEN-LAST:event_boutonRestaurerActionPerformed

    private void jT_idcaissierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_idcaissierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_idcaissierActionPerformed

    private void jT_caissierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_caissierMouseClicked
        
        try{
            
            int j = jT_caissier.getSelectedRow(); 
            int i = jT_caissier.convertRowIndexToModel(j);
            
            TableModel tm = jT_caissier.getModel();
            
            jT_idcaissier.setText(tm.getValueAt(i,0).toString());
            jT_nom.setText(tm.getValueAt(i,1).toString());
            jT_prenom.setText(tm.getValueAt(i,2).toString());
            jT_numerobadge.setText(tm.getValueAt(i,3).toString());
            jT_idpointvente.setText(tm.getValueAt(i,4).toString());
            
            
        }
        catch(Exception e){
            message.setText("Vous devez cliquez sur ligne !");
        }
    }//GEN-LAST:event_jT_caissierMouseClicked

    private void voircaissierssupprimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voircaissierssupprimesActionPerformed
        
        if( ! desactivationbouton){
            
            String[][] tabprodSup = Miniprojetjava.baseDeDonnees.getCaissierSupprimes();
                
            DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();

            model.setRowCount(0);

            String[] columnNames = {"Id caissier", "Nom", "Prenom", "Numero badge", "Id point vente"};

            model.setDataVector(tabprodSup, columnNames );

            boutonRestaurer.setVisible(true);
            
            voircaissierssupprimes.setText("Revenir en arrière");

            ajouter.setEnabled(desactivationbouton);
            miseajour.setEnabled(desactivationbouton);
            supprimer.setEnabled(desactivationbouton);
            
            desactivationbouton = true ;
        }
        else{
            
            String[][] tabprodSup = Miniprojetjava.baseDeDonnees.getCaissierNonSupprimes();
                
            DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();

            model.setRowCount(0);

            String[] columnNames = {"Id caissier", "Nom", "Prenom", "Numero badge" , "Id point vente"};

            model.setDataVector(tabprodSup, columnNames );

            boutonRestaurer.setVisible(false);

            voircaissierssupprimes.setText("Voir les caissiers supprimés");

            ajouter.setEnabled(desactivationbouton);
            miseajour.setEnabled(desactivationbouton);
            supprimer.setEnabled(desactivationbouton);
            
            desactivationbouton = false ;
        }
        
    }//GEN-LAST:event_voircaissierssupprimesActionPerformed

    private void jT_rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_rechercheKeyReleased

        JPanel_Caissier.rechercheAutomatique(jT_caissier, jT_recherche, message);
        
        if(message.getText().equals("")){
            message.setText("Vous pouvez cliquez sur les entetes des colonnes, pour trier la table suivant cette colonne");
        }
        
    }//GEN-LAST:event_jT_rechercheKeyReleased

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        
        int id_caissier = 0 ;
        int id_pointvente = 0 ;
        
        if(jT_nom.getText().equals("")  || jT_prenom.getText().equals("")  || jT_numerobadge.getText().equals("") || jT_idpointvente.getText().equals("")){
            message.setText("Tous les champs doivent être remplis");
        }
        else{
            try{
                
                id_caissier = Integer.parseInt(jT_idcaissier.getText());
                id_pointvente = Integer.parseInt(jT_idpointvente.getText());
                
                int option = JOptionPane.showOptionDialog(
                    null,                             // Parent component
                    "Voulez-vous vraiment l'ajouter comme un nouveau caissier ?",       // Message
                    "Confirmation",                  // Titre de la boîte de dialogue
                    JOptionPane.YES_NO_OPTION,        // Type de boîte de dialogue
                    JOptionPane.QUESTION_MESSAGE,    // Type d'icône
                    null,                             // Options personnalisées
                    null,                             // Option sélectionnée par défaut
                    null                              // Options de fermeture de la boîte de dialogue
                );

                if (option == JOptionPane.YES_OPTION) {
    

                    id_caissier = Miniprojetjava.baseDeDonnees.dernier_id_personne + 1 ;
                
                    Caissier p = new Caissier( id_caissier +"_"+ jT_numerobadge.getText() + "_" + jT_nom.getText() + "_" + jT_prenom.getText() + "_0_" + jT_idpointvente.getText());

                    DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();
                    
                    model.addRow(new Object[]{p.idcaissier, p.nom, p.prenom, p.numerobadge , p.idpointvente});
                    
                    Miniprojetjava.baseDeDonnees.ajouterCaissier_BD(p);
                    
                    jT_idcaissier.setText("0");
                    jT_nom.setText("");
                    jT_prenom.setText("");
                    jT_numerobadge.setText("");
                    jT_idpointvente.setText("0");
                    

                    message.setText("Cliquez sur le bouton ajouter pour ajouter un item à la table");

                   
                }

                else{
                    message.setText("Vous pouvez cliquez sur les entetes des colonnes, pour trier la table suivant cette colonne");
                }

            }

            catch(Exception e){
                message.setText("L'ID point de vente doit etre un entier");
            }
        }
    }//GEN-LAST:event_ajouterActionPerformed

    private void miseajourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miseajourActionPerformed
        
        int id_caissier = 0 ;
        int id_pointvente = 0 ;
        
        if(jT_nom.getText().equals("")  || jT_prenom.getText().equals("")  || jT_numerobadge.getText().equals("") || jT_idpointvente.getText().equals("")){
            message.setText("Tous les champs doivent être remplis");
        }
        else{
            try{
                
                id_caissier = Integer.parseInt(jT_idcaissier.getText());
                id_pointvente = Integer.parseInt(jT_idpointvente.getText());
                
                int option = JOptionPane.showOptionDialog(
                    null,                             // Parent component
                    "Voulez-vous vraiment modifier ce caissier ?",       // Message
                    "Confirmation",                  // Titre de la boîte de dialogue
                    JOptionPane.YES_NO_OPTION,        // Type de boîte de dialogue
                    JOptionPane.QUESTION_MESSAGE,    // Type d'icône
                    null,                             // Options personnalisées
                    null,                             // Option sélectionnée par défaut
                    null                              // Options de fermeture de la boîte de dialogue
                );

                if (option == JOptionPane.YES_OPTION) {
                
                    Caissier p = new Caissier( id_caissier +"_"+ jT_numerobadge.getText() + "_" + jT_nom.getText() + "_" + jT_prenom.getText() + "_0_" + jT_idpointvente.getText());

                    DefaultTableModel model = (DefaultTableModel) jT_caissier.getModel();
                    
                    
                    model.setValueAt(p.idcaissier, jT_caissier.getSelectedRow(), 0);
                    model.setValueAt(p.nom, jT_caissier.getSelectedRow(), 1);
                    model.setValueAt(p.prenom, jT_caissier.getSelectedRow(), 2);
                    model.setValueAt(p.numerobadge, jT_caissier.getSelectedRow(), 3);
                    model.setValueAt(p.idpointvente, jT_caissier.getSelectedRow(), 4);
                    
                    
                    Miniprojetjava.baseDeDonnees.modifierCaissier_BD(id_caissier, p);
                    
                    jT_idcaissier.setText("0");
                    jT_nom.setText("");
                    jT_prenom.setText("");
                    jT_numerobadge.setText("");
                    jT_idpointvente.setText("0");
                    

                    message.setText("Cliquez sur le bouton ajouter pour ajouter un item à la table");

                   
                }

                else{
                    message.setText("Vous pouvez cliquez sur les entetes des colonnes, pour trier la table suivant cette colonne");
                }

            }

            catch(Exception e){
                message.setText("L'ID point de vente doit etre un entier");
            }
        }
        
    }//GEN-LAST:event_miseajourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton boutonRestaurer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_caissier;
    private javax.swing.JTextField jT_idcaissier;
    private javax.swing.JTextField jT_idpointvente;
    private javax.swing.JTextField jT_nom;
    private javax.swing.JTextField jT_numerobadge;
    private javax.swing.JTextField jT_prenom;
    private javax.swing.JTextField jT_recherche;
    private javax.swing.JLabel message;
    private javax.swing.JButton miseajour;
    private javax.swing.JButton supprimer;
    private javax.swing.JButton voircaissierssupprimes;
    // End of variables declaration//GEN-END:variables
}
