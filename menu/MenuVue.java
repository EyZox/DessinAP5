package menu;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Cette classe définit la vue du menu de la fenêtre principal du
 * programme.
 * 
 * @author Nicolas Vasseur
 */
@SuppressWarnings("serial")
public class MenuVue extends JMenuBar {
	// ======================================================================//
	// ============================ Variables ===============================//
	// ======================================================================//

	private MenuControleur controleur;
	
	private JMenu fichier = new JMenu("Fichier");
	private JMenu edition = new JMenu("Edition");

	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem ouvrir = new JMenuItem("Ouvrir");
	private JMenuItem enregistrer = new JMenuItem("Enregistrer");
	private JMenuItem enregistrerSous = new JMenuItem("Enregistrer sous");
	private JMenuItem quitter = new JMenuItem("Quitter");

	private JMenuItem annuler = new JMenuItem("Annuler");
	private JMenuItem retablir = new JMenuItem("Rétablir");

	private JMenuItem copier = new JMenuItem("Copier");
	private JMenuItem couper = new JMenuItem("Couper");
	private JMenuItem coller = new JMenuItem("Coller");

	// ======================================================================//
	// ========================== Constructeur =============================//
	// ======================================================================//

	public MenuVue() {
		
		//Mise en place et configuration des JMenuItem dans les JMenu
		this.fichier.add(nouveau);
		this.fichier.add(ouvrir);
		this.enregistrer.setEnabled(false);
		this.fichier.add(enregistrer);
		this.fichier.add(enregistrerSous);

		this.fichier.addSeparator();

		this.fichier.add(quitter);

		this.annuler.setEnabled(false);
		this.edition.add(annuler);

		this.retablir.setEnabled(false);
		this.edition.add(retablir);
		
		this.edition.addSeparator();
		
		this.edition.add(copier);
		this.edition.add(couper);
		this.edition.add(coller);

		this.add(fichier);
		this.add(edition);
		
		//Raccourcis
		this.nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		this.ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		this.enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		this.enregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + 
				KeyEvent.SHIFT_DOWN_MASK));
		this.annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		this.retablir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
		this.copier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		this.couper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
		this.coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		
	}

	// ======================================================================//
	// ============================= Getters ===============================//
	// ======================================================================//

	public MenuControleur getControleur() {
		return controleur;
	}

	public JMenu getFichier() {
		return fichier;
	}

	public JMenu getEdition() {
		return edition;
	}

	public JMenuItem getNouveau() {
		return nouveau;
	}

	public JMenuItem getOuvrir() {
		return ouvrir;
	}

	public JMenuItem getEnregistrer() {
		return enregistrer;
	}

	public JMenuItem getEnregistrerSous() {
		return enregistrerSous;
	}

	public JMenuItem getQuitter() {
		return quitter;
	}

	public JMenuItem getAnnuler() {
		return annuler;
	}

	public JMenuItem getRetablir() {
		return retablir;
	}

	public JMenuItem getCopier() {
		return copier;
	}

	public JMenuItem getCouper() {
		return couper;
	}

	public JMenuItem getColler() {
		return coller;
	}
}
