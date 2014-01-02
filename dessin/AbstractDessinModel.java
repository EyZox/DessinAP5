package dessin;

import java.awt.Color;
import java.io.File;
import java.util.Observable;

import toolbox.ToolboxModel;

public abstract class AbstractDessinModel extends Observable implements DessinModel {
	
	protected File file;
	protected ToolboxModel toolboxModel;
	protected Color c;
	/**
	 * permet d'obtenir la couleur du dessin actuelle.
	 * @return la couleur actuelle 
	 */
	public Color getColor() { return c;}
	/**
	 * permet de definir la couleur actuelle
	 * @param g
	 * 
	 */
	public void setColor(Color g) { this.c = g;}
	/**
	 * Constructeur par defaut, genere un fichier sans titre.
	 */
	public AbstractDessinModel() {
		this.file = new File("Sans titre");
	}
	/**
	 * Instancie l'AbstractDessinModel et ouvre un fichier donne en parametre.
	 * @param f
	 */
	public AbstractDessinModel(File f) {
		open(f);
	}

	/**
	 * Sauvegarde le fichier
	 */
	@Override
	public void save() {
		// TODO Sauvegarder le fichier

	}
	/**
	 * Ouvre le fichier
	 */
	@Override
	public void open(File file) {
		// TODO Ouvrir le fichier
	}
	/**
	 * Retourne le ToolboxModel associe au DessinModel.
	 * @return le ToolboxModel 
	 */
	@Override
	public ToolboxModel getToolBoxModel() {
		return this.toolboxModel;
	}
	/**
	 * Associe le ToolboxModel au DessinModel.
	 * @param m
	 */
	@Override
	public void setToolboxModel(ToolboxModel m) {
		this.toolboxModel = m;
	}

}
