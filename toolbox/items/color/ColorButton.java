package toolbox.items.color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import toolbox.ToolboxModel;

@SuppressWarnings("serial")
public class ColorButton extends JButton implements Observer{
	private Shape upShape,downShape;
	private ToolboxModel model;

	public ColorButton(ToolboxModel m) {
		model = m;
		new ColorButtonControler(this);
		model.addObserver(this);

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(upShape != null && downShape != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(model.getStrokeColor());
			g2d.fill(upShape);
			g2d.setColor(model.getFillColor());
			g2d.fill(downShape);
		}
	}
	
	protected void resize() {
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = 0; y[0] = 0;
		x[1] = this.getWidth(); y[1] = 0;
		x[2] = 0; y[2] = getHeight();

		upShape = new Polygon(x, y, 3);
		x[0] = this.getWidth(); y[0] = this.getHeight(); 

		downShape = new Polygon(x,y,3);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
	
	public ToolboxModel getToolboxModel() {
		return model;
	}


}
