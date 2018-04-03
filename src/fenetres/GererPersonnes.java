package fenetres;

import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reseau.LienBDD;

public class GererPersonnes extends JFrame implements ActionListener  {
    
	private static final long serialVersionUID = 1L;
	int idPersonne = -1;
	JButton bt_Supprimer;
	JButton bt_Modifier;
	JButton bt_Creer;
	JButton bt_Charger;
	JLabel lb_Nom;
	JTextField tf_Nom;
	JLabel lb_Prenom;
	JTextField tf_Prenom;
	JComboBox<String> cmb_fonction;
	JLabel lb_Fonction;
	JTextField tf_naissance;
	JLabel lb_naissance;

	public GererPersonnes() {
        super();
        
        this.setTitle("Gestion des Personnes");
        this.setSize(500,220);
        
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
		gbcPanel0.gridx = 18;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 18;
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
		
		lb_Nom = new JLabel( "Nom"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.CENTER;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( lb_Nom, gbcPanel0 );
		this.add( lb_Nom );
		
		tf_Nom = new JTextField( );
		tf_Nom.setAutoscrolls( false );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 16;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( tf_Nom, gbcPanel0 );
		this.add( tf_Nom );
		
		lb_Prenom = new JLabel( "Prenom"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( lb_Prenom, gbcPanel0 );
		this.add( lb_Prenom );
		
		tf_Prenom = new JTextField( );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 16;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( tf_Prenom, gbcPanel0 );
		this.add( tf_Prenom );

		String []data_fonction = { "Ouvrier", "Technicien", "Ingénieur", "Maintenance", 
                "Cadre", "Assistant", "Employé" };
		cmb_fonction = new JComboBox<String>( data_fonction );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 12;
		gbcPanel0.gridwidth = 16;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( cmb_fonction, gbcPanel0 );
		this.add( cmb_fonction );
		
		lb_Fonction = new JLabel( "Fonction"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 12;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( lb_Fonction, gbcPanel0 );
		this.add( lb_Fonction );
		
		tf_naissance = new JTextField( );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 16;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( tf_naissance, gbcPanel0 );
		this.add( tf_naissance );
		
		lb_naissance = new JLabel( "Date de naissance"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( lb_naissance, gbcPanel0 );
		this.add( lb_naissance );

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }

	public void actionPerformed(ActionEvent arg0) {
		LienBDD reseau = new LienBDD();
        if ( arg0.getSource() == bt_Supprimer ) {
        	reseau.suppPers(idPersonne);
			modeNouveau();
        }
		if ( arg0.getSource() == bt_Modifier ) {
			reseau.updatePers(idPersonne, tf_Nom.getText(), tf_Prenom.getText(), tf_naissance.getText(), cmb_fonction.getSelectedItem().toString());
			modeNouveau();
        }
		if ( arg0.getSource() == bt_Creer ) {
			reseau.addPers(tf_Nom.getText(), tf_Prenom.getText(), tf_naissance.getText(), cmb_fonction.getSelectedItem().toString());
			modeNouveau();
        }
		if ( arg0.getSource() == bt_Charger ) {
			//this.setVisible(false);
			new Rechercher(this);
        }
		
	}

	public void modeNouveau() {
		bt_Creer.setEnabled( true );
		bt_Modifier.setEnabled( false );
		bt_Charger.setEnabled( true );
		bt_Supprimer.setEnabled( false );
		tf_Nom.setText("");
		tf_Prenom.setText("");
		tf_naissance.setText("");
	}
	
	public void modeCharge() {
		bt_Creer.setEnabled( false );
		bt_Modifier.setEnabled( true );
		bt_Charger.setEnabled( false );
		bt_Supprimer.setEnabled( true );
	}
	
	public void setChamps(int id,String nom, String prenom, String naissance, String fonction) {
		idPersonne = id;
		tf_Nom.setText(nom);
		tf_Prenom.setText(prenom);
		tf_naissance.setText(naissance);
		cmb_fonction.setSelectedItem(fonction);
		modeCharge();
	}
        
}
