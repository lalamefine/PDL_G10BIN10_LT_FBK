package fenetres;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import reseau.LienBDD;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe de gestion de la fenetre du reporting
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class Reporting extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
    
    JTextArea textZone;
    
	/**
	 * Constructeur de la fenetre du reporting
	 */
	public Reporting() {
	    super();
	    
	    this.setTitle("Reporting");
	    this.setSize(500,220);
	    
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		this.setLayout( gbPanel0 );
		
		textZone = new JTextArea(2,10);
		JScrollPane scpAdresse = new JScrollPane( textZone );
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

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        ArrayList<String> lst = LienBDD.readReporting();
        String tmp = "";
        System.out.println("len : " + lst.size());
        for(int i = 0; i<lst.size();i++)
        	tmp = tmp + lst.get(i) + "\n";
        textZone.setText(tmp);
	}
	
	// Obligatoire  
	public void actionPerformed(ActionEvent arg0) {	}
	

}
