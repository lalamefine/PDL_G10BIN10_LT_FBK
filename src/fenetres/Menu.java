package fenetres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe de gestion de la fenetre du menu principal
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class Menu extends JFrame implements ActionListener {
   
	private static final long serialVersionUID = 1L;
    		//Variables li�es � l'interface
	JButton bt_lieux;
    JButton bt_personnes;
    JButton bt_badges;
    JButton bt_reporting;
    		//Variable li�es � la gestion des fenetres
    GererLieux fenLieux = null;
    GererPersonnes fenPersonnes = null;
    GererBadges fenBadges = null;
    Reporting fenReporting = null;

    /**
     * Constructeur de la fenetre du menu principal
     */
    public Menu() {
        super();
        
        this.setTitle("Menu");
        this.setSize(300,200);
        GridBagLayout gbMenu = new GridBagLayout();
        GridBagConstraints gbcMenu = new GridBagConstraints();
        setLayout( gbMenu );

        bt_lieux = new JButton( "G�rer les lieux"  );
        bt_lieux.addActionListener( this );
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 0;
        gbcMenu.gridwidth = 1;
        gbcMenu.gridheight = 1;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 0;
        gbcMenu.anchor = GridBagConstraints.NORTH;
        gbcMenu.insets = new Insets( 4,4,4,4 );
        gbMenu.setConstraints( bt_lieux, gbcMenu );
        add( bt_lieux );

        bt_personnes = new JButton( "G�rer les personnes"  );
        bt_personnes.addActionListener( this );
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 1;
        gbcMenu.gridwidth = 1;
        gbcMenu.gridheight = 1;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 0;
        gbcMenu.anchor = GridBagConstraints.NORTH;
        gbcMenu.insets = new Insets( 4,4,4,4 );
        gbMenu.setConstraints( bt_personnes, gbcMenu );
        add( bt_personnes );

        bt_badges = new JButton( "G�rer les badges"  );
        bt_badges.addActionListener( this );
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 2;
        gbcMenu.gridwidth = 1;
        gbcMenu.gridheight = 1;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 0;
        gbcMenu.anchor = GridBagConstraints.NORTH;
        gbcMenu.insets = new Insets( 4,4,4,4 );
        gbMenu.setConstraints( bt_badges, gbcMenu );
        add( bt_badges );

        bt_reporting = new JButton( "Reporting"  );
        bt_reporting.addActionListener( this );
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 3;
        gbcMenu.gridwidth = 1;
        gbcMenu.gridheight = 1;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 0;
        gbcMenu.anchor = GridBagConstraints.NORTH;
        gbcMenu.insets = new Insets( 4,4,4,4 );
        gbMenu.setConstraints( bt_reporting, gbcMenu );
        add( bt_reporting );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    } 

	public void actionPerformed(ActionEvent arg0) {
        if ( arg0.getSource() == bt_lieux ) {
        	if(fenLieux == null) {
        		fenLieux = new GererLieux();
        	}else{
        		fenLieux.setVisible(true);
        	}
        }
        if ( arg0.getSource() == bt_personnes ) {
        	if(fenPersonnes == null) {
        		fenPersonnes = new GererPersonnes();
        	}else{
        		fenPersonnes.setVisible(true);
        	}
        }
        if ( arg0.getSource() == bt_badges ) {
        	if(fenBadges == null) {
        		fenBadges = new GererBadges();
        	}else{
        		fenBadges.setVisible(true);
        	}
        }
        if ( arg0.getSource() == bt_reporting ) {
        	if(fenReporting == null) {
        		fenReporting = new Reporting();
        	}else{
        		fenReporting.setVisible(true);
        	}
        }
		
	} 

} 
