package dessin;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Collection;

public class DefaultDessinModel extends AbstractDessinModel implements DessinModel{
	
	private ListenedList<Shape> shapes = new ListenedList<Shape>(new Runnable() {
		@Override
		public void run() {
			setChanged();
			notifyObservers();
		}
	});
	
	
	/**
	 * Trace une ligne de p1 a p2
	 */
	@Override
	public void addLine(Point p1, Point p2) {
		Shape s = new Line2D.Double(p1, p2);
		System.out.println("Ajout d'une ligne en "+p1+" , "+p2);
		shapes.add(s);
		System.out.println(shapes);
	}
	
	/**
	 * Trace un rectangle entre p1, repr�sentant le coin sup�rieur gauche, et p2 repr�sentant le coin inf�rieur droit
	 * 
	 *P1----|
	 *|		|
	 *|-----P2
	 *
	 */
	@Override
	public void addRect(Point p1, Point p2) {
		Shape s = new Rectangle(p1, new Dimension(p2.x-p1.x,p2.y-p1.y));
		shapes.add(s);
	}
	
	/**
	 * Trace un cercle du point p1 au point p2
	 */
	@Override
	public void addOval(Point p1, Point p2) {
		Shape s = new Ellipse2D.Double(p1.x, p2.y, p2.x-p1.x, p2.y-p1.y);
		shapes.add(s);
	}
	
	/**
	 * Trace un triangle du point p1 au point p2
	 */
	@Override
	public void addTri(Point p1, Point p2) {
		// TODO Triangle (utilise Polygone)
		
	}
	
	/**
	 * Trace un polygone selon un ensemble de point
	 */
	@Override
	public void addPoly(Collection<Point> points) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Supprime un figure du dessin
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
	 */
	@Override
	public void move(Shape shape, Point p) {
		Rectangle r = shape.getBounds();
		r.setBounds(r.x+p.x,r.y+p.y,r.width,r.height);
		shapes.add(r);
	}
	
	/**
	 * Redimensionne une figure
	 */
	@Override
	public void resize(Shape shape, Point p) {
		Rectangle r = shape.getBounds();
		r.setBounds(r.x,r.y,r.width+p.x,r.height+p.y);
		shapes.add(r);
		
	}
	
	/**
	 * Retourne la liste des figures
	 */
	@Override
	public Collection<Shape> getShapes() {
		return shapes;
	}

}
