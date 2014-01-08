package toolbox;

import java.awt.Color;
import java.util.Observer;

import dessin.DessinModel;

public interface ToolboxModel {

	public void addObserver(Observer o);
	public void setModel(DessinModel m);
	public DessinModel getDessinModel();

	//Fonction pour reconaitre les formes demandées lors du click
	public ExpectedOperation getExpectedOperation();
	public void setExpectedOperation(ExpectedOperation operation);
	
	//Gestion des couleurs
	public void setStrokeColor(Color c);
	public Color getStrokeColor();
	public void setFillColor(Color c);
	public Color getFillColor();

}
