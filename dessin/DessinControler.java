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
			break;
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
