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
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Classe de la fenetre de recherche
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class Rechercher extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList inList;
	private int mode = 0; // permet de selectionner la mise en forme de la réponse attendue
	JButton btCharger;
	JTextField tfText5;
	JList<String> lsList1;
	JButton bt_Valider;
	JFrame papa;
	
	/**
	 * Construteur de la fenetre de recherche de Personnes
	 * @param papa : Classe mère
	 */
	public Rechercher(GererPersonnes papa) {
		this.papa = papa;
		mode = 0;
		this.setTitle("Rechercher une personne");
        setup();
    }

	/**
	 * Construteur de la fenetre de recherche de Lieux
	 * @param papa : Classe mère
	 */
	public Rechercher(GererLieux papa) {
		this.papa = papa;
		mode = 1;
	    this.setTitle("Rechercher un lieu");
	    setup();
	}

	/**
	 * Construteur de la fenetre de recherche de Badges ou de Personnes associées à un badge
	 * @param papa : Classe mère
	 */
	public Rechercher(GererBadges papa,boolean personneMode) {
		this.papa = papa;
		if (personneMode == true) {
			mode = 3;
        	this.setTitle("Rechercher une personne");
		}else {
			mode = 2;
        	this.setTitle("Rechercher un badge");
		}
        setup();
    }
    
	
    /**
     * Fonction de génération de l'interface
     */
    private void setup() {  
        this.setSize(500,500);
        
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
		tfText5.addActionListener(this);
		
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
		bt_Valider.setEnabled( true );
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
		if ( arg0.getSource() == btCharger || arg0.getSource() == tfText5) {
    		String [] dataList1;
        	switch(mode) {
        	default: // ( mode 0 et 3)
            	inList = LienBDD.listPers(tfText5.getText());
            	System.out.println("Nombre de résultats :" + inList.size());
            	dataList1 = new String[inList.size()];
            	for(int j = 0; j<inList.size();j++)
            		dataList1[j] = " ID_" + ((Personne)inList.get(j)).getId() + " " + ((Personne)inList.get(j)).getNom() + " " + ((Personne)(inList.get(j))).getPrenom() + "  | " + ((Personne)(inList.get(j))).getFonction();
        		break;
        	case 1:
            	inList = LienBDD.listLieu(tfText5.getText());
            	System.out.println("Nombre de résultats :" + inList.size());
            	dataList1 = new String[inList.size()];
            	for(int j = 0; j<inList.size();j++)
            		dataList1[j] = ((Lieu)inList.get(j)).getEmplacement()  + " B" +  ((Lieu)inList.get(j)).getBloque();
        		break;
        	case 2:
            	inList = LienBDD.listBadge(tfText5.getText());
            	System.out.println("Nombre de résultats :" + inList.size());
            	dataList1 = new String[inList.size()];
            	for(int j = 0; j<inList.size();j++)
            		dataList1[j] = "ID_" + ((Badge)inList.get(j)).getId() + " " + ((Badge)(inList.get(j))).getProprietaireFullName() + "(ID_" + ((Badge)(inList.get(j))).getProprietaireId() + ") B" + ((Badge)inList.get(j)).getBloque();
        		break;
        		
        	}      	
        	lsList1.setListData(dataList1);
        }
		if ( arg0.getSource() == bt_Valider ) {
			if(lsList1.getSelectedIndex() != -1) {
				int i = lsList1.getSelectedIndex();
	        	switch(mode) {
	        	default:try{
	        		((GererPersonnes)papa).setChamps(((Personne)inList.get(i)).getId(), ((Personne)inList.get(i)).getNom(), ((Personne)inList.get(i)).getPrenom(), ((Personne)inList.get(i)).getNaissance().substring(0, 10), ((Personne)inList.get(i)).getFonction());
	        	}catch(Exception ignore1) {
	        		try{
		        		((GererPersonnes)papa).setChamps(((Personne)inList.get(i)).getId(), ((Personne)inList.get(i)).getNom(), ((Personne)inList.get(i)).getPrenom(), "", ((Personne)inList.get(i)).getFonction());
		        	}catch(Exception ignore2) {
		        		try{
			        		((GererPersonnes)papa).setChamps(((Personne)inList.get(i)).getId(), ((Personne)inList.get(i)).getNom(), ((Personne)inList.get(i)).getPrenom(), ((Personne)inList.get(i)).getNaissance().substring(0, 10), "");
			        	}catch(Exception ignore3) {
			        		((GererPersonnes)papa).setChamps(((Personne)inList.get(i)).getId(), ((Personne)inList.get(i)).getNom(), ((Personne)inList.get(i)).getPrenom(), "", "");
			        	}		        	}
	        	}
					break;
	        	case 1:((GererLieux)papa).setChamps(((Lieu)inList.get(i)).getId(),((Lieu)inList.get(i)).getEmplacement(),((Lieu)inList.get(i)).getNbAcces(),((Lieu)inList.get(i)).getHoraires(),((Lieu)inList.get(i)).getBloque());
	        		break;
	        	case 2:((GererBadges)papa).setChamps(((Badge)inList.get(i)).getId(), ((Badge)inList.get(i)).getProprietaireId(), ((Badge)inList.get(i)).getBloque());
	        		break;
	        	case 3:((GererBadges)papa).setProprietaire(((Personne)inList.get(i)).getId());
        			break;
	        	}
	        	this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Merci de selectionner une entrée avant de valider");
			}
				
        }
	}
	
	
}
