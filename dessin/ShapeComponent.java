package dessin;

import java.awt.Shape;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapeComponent extends JPanel {

	private Shape s;

	public ShapeComponent(Shape s) {
		this.s = s;
		this.setPreferredSize(new java.awt.Dimension(s.getBounds().width, s.getBounds().height));
	}

	public void resize(int newWidth, int newHeight) {}


}
