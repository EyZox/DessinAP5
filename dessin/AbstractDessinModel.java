package dessin;

import java.awt.Color;
import java.io.File;
import java.util.Observable;

import toolbox.ExpectedOperation;

public abstract class AbstractDessinModel extends Observable implements DessinModel {
	
	protected File file;
	protected ExpectedOperation action;
	protected Color c;
	
	public Color getColor() { return c;}
	public void setColor(Color g) { this.c = g;}
	
	public ExpectedOperation getExpectedOperation() { return action;}
	public void setExpectedOperation(ExpectedOperation action) { this.action = action; }
	
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

}
