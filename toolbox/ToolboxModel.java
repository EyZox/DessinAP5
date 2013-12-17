package toolbox;

import java.util.Observer;

import dessin.DessinModel;

public interface ToolboxModel {
	
	public void addObserver(Observer o);
	public void setModel(DessinModel m);
	public DessinModel getDessinModel();
}
