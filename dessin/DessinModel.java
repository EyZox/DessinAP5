package dessin;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.io.File;
import java.util.Collection;
import java.util.Observer;

import toolbox.ExpectedOperation;

public interface DessinModel {
	
	//Fonction pour reconaitre les formes demandées lors du click
	public ExpectedOperation getExpectedOperation();
	public void setExpectedOperation(ExpectedOperation shape);
	
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
	public Collection<Shape> getShapes();
	
	//Obliger a ce que la classe soit un Observable
	public void addObserver(Observer obs);
	
	//Gestion des couleurs
	public Color getColor();
	public void setColor(Color g);
}
