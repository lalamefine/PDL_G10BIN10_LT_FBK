package fenetres;

import core.*;
import reseau.LienBDD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GererBadges extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
    int bloque = 0;
    int idBadge = -1;
	JButton bt_Supprimer;
	JButton bt_Modifier;
	JButton bt_Creer;
	JButton bt_Charger;
	JButton bt_Bloquer;
	JTextField tf_idaff;
	JLabel lb_idaff;
	JButton btChargerPersonne;
	JLabel lbNom;
    
    public GererBadges() {
        super();
        
        this.setTitle("Gestion des Badges");
        this.setSize(500,150);
        
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
		bt_Bloquer.setEnabled( false );
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


		tf_idaff = new JTextField( );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 18;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( tf_idaff, gbcPanel0 );
		this.add( tf_idaff );
		
		lb_idaff = new JLabel( "ID Personne affectée"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 6;
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
		
		lbNom = new JLabel( "Nom : "  );
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
        	
        }
		if ( arg0.getSource() == bt_Modifier ) {

        }
		if ( arg0.getSource() == bt_Creer ) {

        }
		if ( arg0.getSource() == bt_Bloquer ) {

        }
		if ( arg0.getSource() == bt_Charger ) {

        }
		
	}

	public void setChamps(int id,int idAff, int bloque) {
		idBadge = id;
		tf_idaff.setText(String.valueOf(idAff));
		this.bloque = bloque;
		majBloque();
	}
	public void majBloque() {
		if(bloque == 0) {
			bt_Bloquer.setText("Bloquer");
		}else {
			bt_Bloquer.setText("Debloquer");
		}
	}
    
}
