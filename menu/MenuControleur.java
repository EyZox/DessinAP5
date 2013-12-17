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
	}
}
