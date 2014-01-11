package dessin;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.Collection;
import java.util.Observer;

import toolbox.ToolboxModel;

public interface DessinModel {
	
	// Fonction de dessin
	
	public void addLine(Point p1, Point p2);
	public void addRect(Point p1, Point p2);
	public void addOval(Point p1, Point p2);
	public void addTri(Point p1, Point p2);
	public void addPoly(Collection<Point> points);
	
	public void remove(ShapeComponent shape);
	public void clear();
	
	
	//Fonction I/O
	public void save();
	public void open(File file);
	
	//Getter & Setter
	public Collection<ShapeComponent> getShapes();
	public ToolboxModel getToolBoxModel();
	public void setToolboxModel(ToolboxModel m);
	
	//Obliger a ce que la classe soit un Observable
	public void addObserver(Observer obs);
	
	//Gestion des couleurs
	public Color getColor();
	public void setColor(Color g);
	public void saveAs(File selectedFile);
}
