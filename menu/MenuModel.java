package menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Cette classe définit le modèle du menu de la fenêtre principal du
 * programme.
 * 
 * @author Nicolas Vasseur
 */
public class MenuModel {
	
	public MenuModel() {
		
	}
	
	//Bouton nouveau
	public void nouveau(){
		final JFrame fenetre = new JFrame("Nouveau");
		GridLayout layout = new GridLayout(4, 3, 5, 5);
		JPanel panneau = new JPanel(layout);
		JLabel labelNom = new JLabel("Nom :");
		final JTextField fieldNom = new JTextField("Sans titre");
		JLabel labelLargeur = new JLabel("Largeur :");
		final JTextField fieldLargeur = new JTextField("800");
		JLabel labelHauteur = new JLabel("Hauteur :");
		final JTextField fieldHauteur = new JTextField("600");
		JButton boutonOk = new JButton("Ok");
		JButton boutonAnnuler = new JButton("Annuler");
		JLabel labelPixels1 = new JLabel("pixels");
		JLabel labelPixels2 = new JLabel("pixels");
		JLabel label1 = new JLabel("");
		JLabel label2 = new JLabel("");

		panneau.add(labelNom);
		panneau.add(fieldNom);
		panneau.add(label1);
		panneau.add(labelLargeur);
		panneau.add(fieldLargeur);
		panneau.add(labelPixels1);
		panneau.add(labelHauteur);
		panneau.add(fieldHauteur);
		panneau.add(labelPixels2);
		panneau.add(label2);
		panneau.add(boutonAnnuler);
		panneau.add(boutonOk);
		fenetre.add(panneau);

		panneau.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

		fenetre.setVisible(true);
		fenetre.pack();

		boutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
			}
		});

		boutonOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nouveau dessin non implémenté");
				fenetre.dispose();
			}
		});
	}
	
	//Boutons ouvrir
	public void ouvrir() {
		
	}

	//Boutons non implémentés
	public void notImplemented() {
		System.out.println("Non implémentée");
	}
	
}
