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
import java.util.Observer;

import toolbox.ToolboxModel;

public class DefaultDessinModel extends Observable implements DessinModel  {
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
	 * @author duponcha,debuer,vasseurn
	 */
	private ListenedList<Shape> shapes = new ListenedList<Shape>(new Runnable() {
		@Override
		public void run() {
			setChanged();
			notifyObservers();
		}
	});
	
	
	/**
	 * Trace une ligne de p1 a p2
	 * @param p1 p2 
	 */
	@Override
	public void addLine(Point p1, Point p2) {
		Shape s = new Line2D.Double(p1, p2);
		System.out.println("Ajout d'une ligne en "+p1+" , "+p2);
		shapes.add(s);
		System.out.println(shapes);
	}
	
	/**
	 * Trace un rectangle entre p1, representant le coin superieur gauche, et p2 representant le coin inferieur droit
	 * @param p1 p2 
	 * 
	 */
	@Override
	public void addRect(Point p1, Point p2) {
		Shape s = new Rectangle(p1, new Dimension(p2.x-p1.x,p2.y-p1.y));
		shapes.add(s);
	}
	
	/**
	 * Trace un cercle du point p1 au point p2
	 * @param p1 p2 

	 */
	@Override
	public void addOval(Point p1, Point p2) {
		Shape s = new Ellipse2D.Double(p1.x, p2.y, p2.x-p1.x, p2.y-p1.y);
		shapes.add(s);
	}
	
	/**
	 *  Trace un triangle du point p1 au point p2
	 * @param p1 p2 
	 */
	@Override
	public void addTri(Point p1, Point p2) {
		int[]x = new int[3];
		int[]y = new int[3];
			
		x[0]=p1.x; x[1]=p1.x; x[2]=p2.x;
		y[0]=p1.y; y[1]=p2.y; y[2]=p2.y;
		Shape s = new Polygon(x, y, 3);
		shapes.add(s);
		
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
	public void remove(Shape shape) {
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
	 * Deplace une figure
	 * param shape p
	 */
	@Override
	public void move(Shape shape, Point p) {
		Rectangle r = shape.getBounds();
		r.setBounds(r.x+p.x,r.y+p.y,r.width,r.height);
		shapes.add(r);
	}
	
	/**
	 * Redimensionne une figure
	 * @param shape  p
	 */
	@Override
	public void resize(Shape shape, Point p) {
		Rectangle r = shape.getBounds();
		r.setBounds(r.x,r.y,r.width+p.x,r.height+p.y);
		shapes.add(r);
		
	}
	
	/**
	 * Retourne la liste des figures
	 * @return liste de shapes
	 */
	@Override
	public Collection<Shape> getShapes() {
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
