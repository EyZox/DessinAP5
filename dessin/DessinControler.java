package dessin;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

import toolbox.ExpectedOperation;

public class DessinControler extends MouseAdapter {
	
	private Queue<Point> points = new LinkedList<Point>();
	private Dessin dessin;
	
	public DessinControler(Dessin d) {
		this.dessin =d;
		dessin.addMouseListener(this);
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		points.add(event.getPoint());
		switch(dessin.getModel().getToolBoxModel().getExpectedOperation()) {
		case CURSOR:
			break;
		case GOMME:
			break;
		case HAND:
			break;
		case LINE:
			dessin.getModel().addLine(points.remove(), points.remove());
			break;
		case OVAL:
			dessin.getModel().addOval(points.remove(), points.remove());
			break;
		case POLY:
			break;
		case RECT:
			dessin.getModel().addRect(points.remove(), points.remove());
			break;
		case TRI:
			dessin.getModel().addTri(points.remove(), points.remove());
			break;
		case ZOOM:
			if(event.getButton() == MouseEvent.BUTTON1) {
				//Click gauche
				dessin.getModel().setScale(dessin.getModel().getScale()+0.1);
			}else if(event.getButton() == MouseEvent.BUTTON3) {
				//Click gauche
				double newScale = dessin.getModel().getScale()-0.1; 
				dessin.getModel().setScale(newScale>0?newScale:0.1);
			}
		default:
			break;
		
		}
		if(dessin.getModel().getToolBoxModel().getExpectedOperation() != ExpectedOperation.POLY) {
			points.clear();
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		points.add(event.getPoint());
		
	}
}
