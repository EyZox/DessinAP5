package dessin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import toolbox.ExpectedOperation;

public class SelectHandler extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {
		ShapeComponent shape = (ShapeComponent) e.getSource();
		if(shape.getSupport().getToolBoxModel().getExpectedOperation() == ExpectedOperation.CURSOR) {
		shape.setBorder(BorderFactory.createEtchedBorder());
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		ShapeComponent shape = (ShapeComponent) e.getSource();
		if(shape.getSupport().getToolBoxModel().getExpectedOperation() == ExpectedOperation.CURSOR) {
		shape.setBorder(BorderFactory.createEmptyBorder());
		}
	}
	
}
