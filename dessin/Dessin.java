package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Dessin extends JPanel implements Observer{
	
	private DessinModel model;
	
	public Dessin() {
		this(new DefaultDessinModel());
	}
	
	public Dessin(DessinModel m) {
		this.model = m;
		this.model.addObserver(this);
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new java.awt.Dimension(640,480));
		
		new DessinControler();
	}
	
	

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		System.out.println("Update");
		
		// Dessine le background
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Dessine les shapes
		g2d.setColor(Color.BLACK);
		for(Shape shape : model.getShapes()) {
			g2d.draw(shape);
		}
	}
	
	public DessinModel getModel() { return model;}
	public void setDessinModel(DessinModel model) { this.model = model;}

}
