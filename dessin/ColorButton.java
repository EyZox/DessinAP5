package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ColorButton extends JButton {
	private Color font = Color.BLACK, fill = Color.WHITE;
	private Shape upShape,downShape;
	private ColorSelection cs;

	public ColorButton() {
		cs = new ColorSelection(font, fill, this);
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				resize();
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				resize();
				
			}
		});
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cs.setVisible(true);
				
			}
		});

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(upShape != null && downShape != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(font);
			g2d.fill(upShape);
			g2d.setColor(fill);
			g2d.fill(downShape);
		}
	}
	
	private void resize() {
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = 0; y[0] = 0;
		x[1] = this.getWidth(); y[1] = 0;
		x[2] = 0; y[2] = getHeight();

		upShape = new Polygon(x, y, 3);
		x[0] = this.getWidth(); y[0] = this.getHeight(); 

		downShape = new Polygon(x,y,3);
	}
	public Color getFontColor() {
		return font;
	}
	public void setFontColor(Color font) {
		this.font = font;
	}
	public Color getFillColor() {
		return fill;
	}
	public void setFillColor(Color fill) {
		this.fill = fill;
	}


}
