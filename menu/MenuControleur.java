package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette classe définit le controleur du menu de la fenêtre principal du
 * programme.
 * 
 * @author Nicolas Vasseur
 */
public class MenuControleur {
	MenuModel model = new MenuModel();
	public MenuVue menu;
	
	//======================================================================//
	//========================== Constructeurs =============================//
	//======================================================================//
	
	public MenuControleur(MenuVue menu){
		this.menu = menu;
		
		//Bouton nouveau
		menu.getNouveau().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.nouveau();
			}
		});
		
		//Bouton ouvrir
		menu.getOuvrir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.ouvrir();
			}
		});
		
		//Bouton enregistrer
		menu.getEnregistrer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
		
		//Bouton enregistrerSous
		menu.getEnregistrerSous().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
		
		//Bouton quitter
		menu.getQuitter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.quitter();
			}
		});
		
		//Bouton annuler
		menu.getAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
		
		//Bouton rétablir
		menu.getRetablir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
		
		//Bouton copier
		menu.getCopier().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
		
		//Bouton couper
		menu.getCouper().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
		
		//Bouton coller
		menu.getColler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.notImplemented(e);
			}
		});
	}
}
