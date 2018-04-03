package fenetres;

import reseau.LienBDD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JFrame;

public class Rechercher extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> output;
	
	JButton btChargerPersonne;
	JTextField tfText5;
	JList<String> lsList1;
	JButton bt_Valider;
	
	public Rechercher(int type) {
        super();
		
        switch(type) {
        case 0:
            this.setTitle("Rechercher une personne");
        	
        	break;
        case 1:
            this.setTitle("Rechercher un lieu");
        	
        	break;
        case 2:
            this.setTitle("Rechercher un badge");
        	
        	break;
        }
        this.setSize(500,150);
        
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        this.setLayout( gbPanel0 );
		
		btChargerPersonne = new JButton( "Rechercher"  );
		gbcPanel0.gridx = 16;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btChargerPersonne, gbcPanel0 );
		this.add( btChargerPersonne );
		
		tfText5 = new JTextField( );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 16;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText5, gbcPanel0 );
		this.add( tfText5 );
		
		String []dataList1 = { "Aucun Résultat" };
		lsList1 = new JList<String>( dataList1 );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 24;
		gbcPanel0.gridheight = 16;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lsList1, gbcPanel0 );
		this.add( lsList1 );
		
		bt_Valider = new JButton( "Valider"  );
		bt_Valider.setEnabled( false );
		gbcPanel0.gridx = 14;
		gbcPanel0.gridy = 18;
		gbcPanel0.gridwidth = 10;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( bt_Valider, gbcPanel0 );
		this.add( bt_Valider );


        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<String> getOutput() {
		return output;
	}

}
