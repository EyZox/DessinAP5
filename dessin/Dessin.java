package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import javax.swing.JPanel;

import toolbox.ExpectedOperation;



@SuppressWarnings("serial")
public class Dessin extends JPanel implements Observer{
	private class CustomMouseAdapter extends MouseAdapter {
		private Queue<Point> points = new LinkedList<Point>();
		@Override
		public void mouseReleased(MouseEvent event) {
			points.add(event.getPoint());
			switch(model.getExpectedOperation()) {
			case CURSOR:
				break;
			case GOMME:
				break;
			case HAND:
				break;
			case LINE:
				model.addLine(points.remove(), points.remove());
				break;
			case OVAL:
				model.addOval(points.remove(), points.remove());
				break;
			case POLY:
				break;
			case RECT:
				model.addRect(points.remove(), points.remove());
				break;
			case TRI:
				model.addTri(points.remove(), points.remove());
				break;
			case ZOOM:
				break;
			default:
				break;
			
			}
			if(model.getExpectedOperation() != ExpectedOperation.POLY) {
				points.clear();
			}
			
		}
		
		@Override
		public void mousePressed(MouseEvent event) {
			points.add(event.getPoint());
			
		}
	}
	
	private DessinModel model;
	
	public Dessin() {
		this(new DefaultDessinModel());
	}
	
	public Dessin(DessinModel m) {
		this.model = m;
		this.model.addObserver(this);
		this.setBackground(Color.WHITE);
		
		this.addMouseListener(new CustomMouseAdapter());
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

}
