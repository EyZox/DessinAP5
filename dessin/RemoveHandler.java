package dessin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.MainFrame;

import toolbox.ExpectedOperation;

public class RemoveHandler extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		ShapeComponent shape = (ShapeComponent) e.getSource();
		if(shape.getSupport().getToolBoxModel().getExpectedOperation() == ExpectedOperation.GOMME) {
			MainFrame.getCurrentDessin().getShapes().remove(shape);
		}
	}
}
