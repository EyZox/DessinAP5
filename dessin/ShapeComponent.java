package dessin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapeComponent extends JPanel implements Shape {

private Shape s;
	public ShapeComponent(Shape s) {
		this.s = s;
	}
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {
		return s.contains(arg0, arg1, arg2, arg3);
	}
	public boolean contains(double arg0, double arg1) {
		return s.contains(arg0, arg1);
	}
	public boolean contains(Point2D arg0) {
		return s.contains(arg0);
	}
	public boolean contains(Rectangle2D arg0) {
		return s.contains(arg0);
	}
	public Rectangle getBounds() {
		return s.getBounds();
	}
	public Rectangle2D getBounds2D() {
		return s.getBounds2D();
	}
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
		return s.getPathIterator(arg0, arg1);
	}
	public PathIterator getPathIterator(AffineTransform arg0) {
		return s.getPathIterator(arg0);
	}
	public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
		return s.intersects(arg0, arg1, arg2, arg3);
	}
	public boolean intersects(Rectangle2D arg0) {
		return s.intersects(arg0);
	}
	public Shape getS() {
		return s;
	}
	public void setS(Shape s) {
		this.s = s;
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(s);
	}
	

}
