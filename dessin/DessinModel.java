package dessin;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
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
	
	public void remove(Shape shape);
	public void clear();
	public void move(Shape shape, Point p);
	public void resize(Shape shape, Point p);
	
	
	//Fonction I/O
	public void save();
	public void open(File file);
	
	//Getter & Setter
	public Collection<Shape> getShapes(); //TODO Remplacer par ShapeComponent SEULEMENT quand l'objet sera pret
	public ToolboxModel getToolBoxModel();
	public void setToolboxModel(ToolboxModel m);
	
	//Obliger a ce que la classe soit un Observable
	public void addObserver(Observer obs);
	
	//Gestion des couleurs
	public Color getColor();
	public void setColor(Color g);
}
