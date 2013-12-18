package dessin;

import java.awt.Color;
import java.io.File;
import java.util.Observable;

import toolbox.ToolboxModel;

public abstract class AbstractDessinModel extends Observable implements DessinModel {
	
	protected File file;
	protected ToolboxModel toolboxModel;
	protected Color c;
	
	public Color getColor() { return c;}
	public void setColor(Color g) { this.c = g;}
	
	public AbstractDessinModel() {
		this.file = new File("Sans titre");
	}
	
	public AbstractDessinModel(File f) {
		open(f);
	}

	@Override
	public void save() {
		// TODO Sauvegarder le fichier

	}

	@Override
	public void open(File file) {
		// TODO Ouvrir le fichier
	}
	
	@Override
	public ToolboxModel getToolBoxModel() {
		return this.toolboxModel;
	}
	
	@Override
	public void setToolboxModel(ToolboxModel m) {
		this.toolboxModel = m;
	}

}
