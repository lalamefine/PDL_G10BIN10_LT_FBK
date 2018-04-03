package fenetres;

import core.*;
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
	private ArrayList inList;
	private int mode = 0;
	JButton btCharger;
	JTextField tfText5;
	JList<String> lsList1;
	JButton bt_Valider;
	JFrame papa;
	
	public Rechercher(GererPersonnes papa) {
		this.papa = papa;
		mode = 0;
		this.setTitle("Rechercher une personne");
        setup();
    }
	public Rechercher(GererLieux papa) {
		this.papa = papa;
		mode = 1;
        this.setTitle("Rechercher un lieu");
        setup();
    }
	public Rechercher(GererBadges papa) {
		this.papa = papa;
		mode = 2;
        this.setTitle("Rechercher un badge");
        setup();
    }
    
	
    private void setup() {  
    	System.out.println("coucou");
        this.setSize(500,150);
        
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        this.setLayout( gbPanel0 );
		
		btCharger = new JButton( "Rechercher"  );
		gbcPanel0.gridx = 16;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btCharger, gbcPanel0 );
		this.add( btCharger );
		btCharger.addActionListener(this);
		
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
		
		String []dataList1 = {};
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
		bt_Valider.addActionListener(this);


        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String [] dataList1;
        if ( arg0.getSource() == btCharger ) {
        	LienBDD reseau = new LienBDD();
        	switch(mode) {
        	default:
            	inList = reseau.listPers(tfText5.getText());
            	dataList1 = new String[inList.size()];
            	for(int j = 0; j<inList.size();j++)
            		dataList1[j] = ((Personne)inList.get(j)).getNom() + " " + ((Personne)(inList.get(j))).getPrenom();
        		break;
        	case 1:
            	inList = reseau.listLieu(tfText5.getText());
            	dataList1 = new String[inList.size()];
            	for(int j = 0; j<inList.size();j++)
            		dataList1[j] = ((Lieu)inList.get(j)).getEmplacement() + ((Lieu)inList.get(j)).getBloque();
        		break;
        	case 2:
            	inList = reseau.listBadge(tfText5.getText());
            	dataList1 = new String[inList.size()];
            	for(int j = 0; j<inList.size();j++)
            		dataList1[j] = ((Badge)inList.get(j)).getId() + " " + ((Badge)inList.get(j)).getBloque() + " " + ((Badge)(inList.get(j))).getProprietaireId();
        		break;
        		
        	}      	
        	lsList1.setListData(dataList1);
        }
		if ( arg0.getSource() == bt_Valider ) {
			int i = lsList1.getSelectedIndex();
        	switch(mode) {
        	default:((GererPersonnes)papa).setChamps(((Personne)inList.get(i)).getId(), ((Personne)inList.get(i)).getNom(), ((Personne)inList.get(i)).getPrenom(), ((Personne)inList.get(i)).getNaissance(), ((Personne)inList.get(i)).getFonction());
				break;
        	case 1://TODO
        		break;
        	case 2://TODO
        		break;
        	}
        	this.setVisible(false);
        }
	}
	
	
}
