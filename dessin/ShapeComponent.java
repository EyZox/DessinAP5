package dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapeComponent extends JPanel {

	private Shape s;
	private Color fillColor, borderColor;
	private int strokeSize;

	public ShapeComponent(Shape s) {
		this(s, Color.BLACK, Color.WHITE, 1);
	}
	
	public ShapeComponent(Shape s, Color fillColor, Color borderColor, int strokeSize) {
		this.s = s;
		this.setStrockeSize(strokeSize);
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.setPreferredSize(new java.awt.Dimension(s.getBounds().width, s.getBounds().height));
	}

	public void resize(int newWidth, int newHeight) {
		Rectangle2D rect = s.getBounds2D();
		//rect.setRect(x,y,width,height
		rect.setRect(0, 0, newWidth, newHeight);
		this.setPreferredSize(new Dimension(newWidth, newHeight));
		repaint();
	}
	
	
	public void setStrockeSize(int size) {
		if(size <= 0) this.strokeSize = 1;
		else this.strokeSize = size;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(s);
	}


}
