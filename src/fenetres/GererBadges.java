package fenetres;

import core.*;
import reseau.LienBDD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe de la fenetre de gestion des badges
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class GererBadges extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
    int bloque = 0;
    int idBadge = -1;
    int idProprio = -1;
	JButton bt_Supprimer;
	JButton bt_Modifier;
	JButton bt_Creer;
	JButton bt_Charger;
	JButton bt_Bloquer;
	JTextField tf_idaff;
	JLabel lb_idaff;
	JButton btChargerPersonne;
	JLabel lbNom;
    
    /**
     * Constructeur de la fenetre de gestion des Badges
     */
    public GererBadges() {
        super();
        
        this.setTitle("Gestion des Badges");
        this.setSize(650,150);
        
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		this.setLayout( gbPanel0 );
		
		
		bt_Supprimer = new JButton( "Supprimer"  );
		bt_Supprimer.setEnabled( false );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 2,2,2,2 );
		gbPanel0.setConstraints( bt_Supprimer, gbcPanel0 );
		this.add( bt_Supprimer );
		bt_Supprimer.addActionListener(this);

		bt_Charger = new JButton( "Charger"  );
		gbcPanel0.gridx = 26;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 2,2,2,2 );
		gbPanel0.setConstraints( bt_Charger, gbcPanel0 );
		this.add( bt_Charger );
		bt_Charger.addActionListener(this);
		
		bt_Modifier = new JButton( "Modifier"  );
		bt_Modifier.setEnabled( false );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 2,2,2,2 );
		gbPanel0.setConstraints( bt_Modifier, gbcPanel0 );
		this.add( bt_Modifier );
		bt_Modifier.addActionListener(this);
		
		bt_Creer = new JButton( "Creer"  );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 2,2,2,2 );
		gbPanel0.setConstraints( bt_Creer, gbcPanel0 );
		this.add( bt_Creer );
		bt_Creer.addActionListener(this);
		
		bt_Bloquer = new JButton( "Bloquer"  );
		gbcPanel0.gridx = 18;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 2,2,2,2 );
		gbPanel0.setConstraints( bt_Bloquer, gbcPanel0 );
		this.add( bt_Bloquer );
		bt_Bloquer.addActionListener(this);


		lb_idaff = new JLabel( );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 18;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( lb_idaff, gbcPanel0 );
		this.add( lb_idaff );
		
		lb_idaff = new JLabel( "Personne affectée : "  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 25;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( lb_idaff, gbcPanel0 );
		this.add( lb_idaff );
		
		btChargerPersonne = new JButton( "Rechercher"  );
		gbcPanel0.gridx = 26;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btChargerPersonne, gbcPanel0 );
		this.add( btChargerPersonne );
		btChargerPersonne.addActionListener(this);
		
		lbNom = new JLabel( "Id du badge : {généré à la création}"  );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 18;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbNom, gbcPanel0 );
		this.add( lbNom );

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }

	public void actionPerformed(ActionEvent arg0) {
        if ( arg0.getSource() == bt_Supprimer ) {
        	LienBDD.suppBadge(idBadge);
        	modeNouveau();
        }
		if ( arg0.getSource() == bt_Modifier ) {
			LienBDD.updateBadge(idBadge, idProprio, bloque);
			modeNouveau();
        }
		if ( arg0.getSource() == bt_Creer ) {
			if( idProprio != -1) {
				LienBDD.addBadge(idProprio, bloque);
				modeNouveau();
			}else {
				JOptionPane.showMessageDialog(this, "Création impossible sans affecter de propriétaire");
			}
        }
		if ( arg0.getSource() == bt_Bloquer ) {
			if(bloque == 0)
				bloque = 1;
			else
				bloque = 0;
			majBloque();
        }
		if ( arg0.getSource() == bt_Charger ) {
			new Rechercher(this,false);
        }
		if ( arg0.getSource() == btChargerPersonne ) {
			new Rechercher(this,true);
        }
		
	}

	/**
	 * Configure l'interface pour une nouvelle entrée
	 */
	private void modeNouveau() {
		bt_Creer.setEnabled( true );
		bt_Modifier.setEnabled( false );
		bt_Charger.setEnabled( true );
		bt_Supprimer.setEnabled( false );
		lbNom.setText("Id du badge : {généré à la création}");
		idBadge = -1;
	    idProprio = -1;
		bloque = 0;
		majBloque();
		lb_idaff.setText(" Personne affectée :  ");
	}

	/**
	 *  Configure l'interface pour un badge chargé
	 */
	private void modeCharge() {
		bt_Creer.setEnabled( false );
		bt_Modifier.setEnabled( true );
		bt_Charger.setEnabled( false );
		bt_Supprimer.setEnabled( true );
	}
	
	/**
	 * Permet de renseigner les champs du badges dans l'interface
	 * @param id
	 * @param idAff
	 * @param bloque
	 */
	public void setChamps(int id,int idAff, int bloque) {
		idBadge = id;
		lbNom.setText("Id du badge : " + id);
		idProprio = idAff;
		Personne p = LienBDD.findPersfromID(idAff);
		if(p != null)
			lb_idaff.setText(" Personne affectée :  " + p.getNom() + " " + p.getPrenom());
		else
			lb_idaff.setText(" Personne affectée :  Erreur: Propriétaire inexistant (ID_" + idAff +")");
		this.bloque = bloque;
		majBloque();
		modeCharge();
	}

	/**
	 * Actualise le bouton Bloqué/Débloqué
	 */
	public void majBloque() {
		if(bloque == 0) {
			bt_Bloquer.setText("Bloquer");
		}else {
			bt_Bloquer.setText("Debloquer");
		}
		bt_Bloquer.repaint();
	}
	
	/**
	 * Permet de renseigner sur l'interface la personne associée au badge
	 * @param id : ID de la personne associée
	 */
	public void setProprietaire(int id) {
		idProprio = id;
		Personne p = LienBDD.findPersfromID(id);
		lb_idaff.setText(" Personne affectée :  "  + p.getNom() + " " + p.getPrenom());
	}
    
}
