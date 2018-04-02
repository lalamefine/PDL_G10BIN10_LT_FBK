package fenetres;

	
	import javax.swing.JPanel;
	import javax.swing.BorderFactory;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import javax.swing.JButton;

	/**
	 * @author  Administrator
	 * @created April 2, 2018
	 */
public class Menu extends JPanel implements ActionListener {
    JButton bt_lieux;
    JButton bt_personnes;
    JButton bt_badges;
    JButton bt_reporting;

    /**
     *Constructor for the Menu object
     */
    public Menu() {
        super();

        GridBagLayout gbMenu = new GridBagLayout();
        GridBagConstraints gbcMenu = new GridBagConstraints();
        setLayout( gbMenu );

        bt_lieux = new JButton( "Gérer les lieux"  );
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

        bt_personnes = new JButton( "Gérer les personnes"  );
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

        bt_badges = new JButton( "Gérer les badges"  );
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
    } 

    /**
     */
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == bt_lieux ) {
        // Action for bt_lieux
        }
        if ( e.getSource() == bt_personnes ) {
        // Action for bt_personnes
        }
        if ( e.getSource() == bt_badges ) {
        // Action for bt_badges
        }
        if ( e.getSource() == bt_reporting ) {
        // Action for bt_reporting
        }
    } 

} 
