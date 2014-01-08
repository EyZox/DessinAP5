package dessin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapeComponent extends JPanel {

	private Point anchor;
	private Shape s;
	private Color fillColor, borderColor;
	private int strokeSize;

	public ShapeComponent(Point anchor,Shape s) {
		this(anchor, s, Color.WHITE, Color.BLACK, 1);
	}
	
	public ShapeComponent(Point anchor,Shape s, Color borderColor, Color fillColor, int strokeSize) {
		this.setAnchor(anchor);
		this.s = s;
		this.setStrokeSize(strokeSize);
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.setPreferredSize(new Dimension((int)(s.getBounds2D().getWidth())+1, (int)(s.getBounds2D().getHeight())+1));
	}

	public Point getAnchor() {
		return anchor;
	}

	public void setAnchor(Point anchor) {
		this.anchor = anchor;
	}

	public void resize(int newWidth, int newHeight) {
		Rectangle2D rect = s.getBounds2D();
		//rect.setRect(x,y,width,height
		rect.setRect(0, 0, newWidth, newHeight);
		this.setPreferredSize(new Dimension(newWidth, newHeight));
		repaint();
	}
	
	
	public void setStrokeSize(int size) {
		if(size <= 0) this.strokeSize = 1;
		else this.strokeSize = size;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(strokeSize));
		g2d.setColor(fillColor);
		g2d.fill(s);
		g2d.setColor(borderColor);
		g2d.draw(s);
	}


}
