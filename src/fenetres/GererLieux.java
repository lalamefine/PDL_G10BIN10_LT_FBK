package fenetres;

import reseau.LienBDD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GererLieux extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;

	JButton bt_Supprimer;
	JButton bt_Modifier;
	JButton bt_Creer;
	JButton bt_Charger;
	JLabel lb_Emplacement;
	JButton bt_Bloquer;
	JTextArea taAdresse;
	JComboBox<String> cmbCombo0;
	JTextField tfNbacces;
	JLabel lbLabel4;
    /**
     *Constructor for the Menu object
     */
    public GererLieux() {
        super();
        
        this.setTitle("Gestion des Lieux");
        this.setSize(500,250);
        
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
		
		lb_Emplacement = new JLabel( "Emplacement"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 8;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.CENTER;
		gbcPanel0.insets = new Insets( 4,20,84,4 );
		gbPanel0.setConstraints( lb_Emplacement, gbcPanel0 );
		this.add( lb_Emplacement );
		
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
		
		taAdresse = new JTextArea(2,10);
		JScrollPane scpAdresse = new JScrollPane( taAdresse );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 24;
		gbcPanel0.gridheight = 8;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( scpAdresse, gbcPanel0 );
		this.add( scpAdresse );
		
		String []dataCombo0 = { "8h-10h", "8h-12h", "9h-12h", "8h30-12h30", "13h-14h", 
		            "16h-18h", "13h-17h", "13h30-17h30", "13h-18h", "13h-20h", 
		            "8h30-16h30", "8h30-17h30", "8h-16h", "8h-17h", "8h-18h" };
		cmbCombo0 = new JComboBox<String>( dataCombo0 );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 15;
		gbcPanel0.gridwidth = 24;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( cmbCombo0, gbcPanel0 );
		this.add( cmbCombo0 );
		
		tfNbacces = new JTextField( );
		tfNbacces.setAutoscrolls( false );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 12;
		gbcPanel0.gridwidth = 24;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,4,4,4 );
		gbPanel0.setConstraints( tfNbacces, gbcPanel0 );
		this.add( tfNbacces );
		
		lbLabel4 = new JLabel( "Nombre d'acc�s"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 12;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,20,4,4 );
		gbPanel0.setConstraints( lbLabel4, gbcPanel0 );
		this.add( lbLabel4 );   
		
		lbLabel4 = new JLabel( "Horraires"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 15;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 4,20,4,4 );
		gbPanel0.setConstraints( lbLabel4, gbcPanel0 );
		this.add( lbLabel4 );  
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
        if ( arg0.getSource() == bt_Supprimer ) {
        	
        }
		if ( arg0.getSource() == bt_Modifier ) {

        }
		if ( arg0.getSource() == bt_Creer ) {

        }
		if ( arg0.getSource() == bt_Bloquer ) {

        }
        
	}
        
}
