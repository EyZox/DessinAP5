package dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.Collection;
import java.util.Observable;

import toolbox.ToolboxModel;

public class DefaultDessinModel extends Observable implements DessinModel  {
	/**
	 * @author duponcha,debuer,vasseurn
	 */
	private ListenedList<ShapeComponent> shapes = new ListenedList<ShapeComponent>(new Runnable() {
		@Override
		public void run() {
			setChanged();
			notifyObservers();
		}
	});
	private File file;
	private ToolboxModel toolboxModel;
	private Color c;
	/**
	 * Constructeur par defaut, genere un fichier sans titre.
	 */
	public DefaultDessinModel(ToolboxModel m) {
		this.toolboxModel  = m;
		this.file = new File("Sans titre");
	}
	/**
	 * Instancie l'AbstractDessinModel et ouvre un fichier donne en parametre.
	 * @param f
	 */
	public DefaultDessinModel(ToolboxModel m, File f) {
		this.toolboxModel = m;
		open(f);
	}
	
	
	/**
	 * Trace une ligne de p1 a p2
	 * @param p1 p2 
	 */
	@Override
	public void addLine(Point p1, Point p2) {
		// Ne fonctionne pas :
		// En fait, il faut créer la shape a partir des coordonées (0,0), vu qu'on fixe le point d'ancrage sur le dessin (cad la position de la figue),
		// en le passant en parametre dans le contructeur de ShapeComponent (Exemple avec Rect ou Cercle)
		// Donc ici, il faut trouver le vecteur permettant de faire une translation avec tout les points pour ramener les coordonée a (0,0);
		Shape s = new Line2D.Double(p1, p2);
		shapes.add(new ShapeComponent(p1, s));
	}
	
	/**
	 * Trace un rectangle entre p1, representant le coin superieur gauche, et p2 representant le coin inferieur droit
	 * @param p1 p2 
	 * 
	 */
	@Override
	public void addRect(Point p1, Point p2) {
		
		Point debut = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		Point fin = new Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
		Shape s = new Rectangle(new Point(0,0), new Dimension(fin.x - debut.x,fin.y - debut.y));
		
		shapes.add(new ShapeComponent(debut, s, toolboxModel.getStrokeColor(), toolboxModel.getFillColor(), 1));
	}
	
	/**
	 * Trace un cercle du point p1 au point p2
	 * @param p1 p2 

	 */
	@Override
	public void addOval(Point p1, Point p2) {
		Point debut = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		Point fin = new Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
		Shape s = new Ellipse2D.Double(0, 0, fin.x - debut.x, fin.y - debut.y);
		shapes.add(new ShapeComponent(debut, s, toolboxModel.getStrokeColor(), toolboxModel.getFillColor(), 1));
	}
	
	/**
	 *  Trace un triangle du point p1 au point p2
	 * @param p1 p2 
	 */
	@Override
	public void addTri(Point p1, Point p2) {
		//Ne fonctionne pas correctement : voir addLine()
		int[]x = new int[3];
		int[]y = new int[3];
			
		x[0]=p1.x; x[1]=p1.x; x[2]=p2.x;
		y[0]=p1.y; y[1]=p2.y; y[2]=p2.y;
		Shape s = new Polygon(x, y, 3);
		shapes.add(new ShapeComponent(p1, s));
		
	}
	
	/**
	 * Trace un polygone selon un ensemble de point
	 * @param points
	 */
	@Override
	public void addPoly(Collection<Point> points) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Supprime un figure du dessin
	 * @param shape
	 */
	@Override
	public void remove(ShapeComponent shape) {
		shapes.remove(shape);
		
	}
	
	/**
	 * Supprime toutes les figures du dessin
	 */
	@Override
	public void clear() {
		shapes.clear();
		
	}
	
	
	/**
	 * Retourne la liste des figures
	 * @return liste de shapes
	 */
	@Override
	public Collection<ShapeComponent> getShapes() {
		return shapes;
	}
	
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
