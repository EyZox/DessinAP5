package dessin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapeComponent extends JPanel implements Serializable{

	private Point anchor;
	private Shape s;
	private Color fillColor, borderColor;
	private int strokeSize;
	private transient DessinModel support;

	public ShapeComponent(DessinModel support,Point anchor,Shape s) {
		this(support, anchor, s, Color.WHITE, Color.BLACK, 1);
	}
	
	public ShapeComponent(DessinModel support,Point anchor,Shape s, Color borderColor, Color fillColor, int strokeSize) {
		this.support = support;
		this.setAnchor(anchor);
		this.s = s;
		this.setStrokeSize(strokeSize);
		this.fillColor = fillColor;
		this.borderColor = borderColor;
	}

	public Point getAnchor() {
		return anchor;
	}

	public void setAnchor(Point anchor) {
		this.anchor = anchor;
		if(getParent() != null) getParent().repaint();
	}

	public void resize(int newWidth, int newHeight) {
		Rectangle2D rect = s.getBounds2D();
		//rect.setRect(x,y,width,height
		rect.setRect(0, 0, newWidth, newHeight);
		this.setPreferredSize(new Dimension(newWidth, newHeight));
		repaint();
	}
	
	
	public void setStrokeSize(int size) {
		this.strokeSize = size;
		this.setPreferredSize(new Dimension((int)(s.getBounds2D().getWidth())+this.strokeSize, (int)(s.getBounds2D().getHeight())+this.strokeSize));
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.getTransform().setToScale(support.getScale(), support.getScale());
		g2d.setStroke(new BasicStroke(strokeSize));
		g2d.setColor(fillColor);
		g2d.translate(strokeSize/2, strokeSize/2);
		g2d.fill(s);
		g2d.setColor(borderColor);
		g2d.draw(s);
	}

	public Shape getShape() {
		return s;
	}

	public void setShape(Shape s) {
		this.s = s;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
		repaint();
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		repaint();
	}

	public int getStrokeSize() {
		return strokeSize;
	}

	public DessinModel getSupport() {
		return support;
	}

	public void setSupport(DessinModel support) {
		this.support = support;
	}
	
	


}
