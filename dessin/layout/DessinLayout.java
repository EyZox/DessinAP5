package dessin.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import dessin.ShapeComponent;

public class DessinLayout implements LayoutManager {

	private int scale = 1;
	private Point origin = new Point(0,0);
	
	
	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// NOTHING
		
	}

	@Override
	public void layoutContainer(Container parent) {
		for(int i = 0; i<parent.getComponentCount();i++) {
			try {
			ShapeComponent item = (ShapeComponent) parent.getComponent(i);
			item.setBounds((origin.x + item.getAnchor().x) * scale, (origin.y + item.getAnchor().y) * scale, scale*item.getPreferredSize().width, scale * item.getPreferredSize().height);
			}catch(ClassCastException e) {
				parent.remove(i);
			}
		}
		
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return new Dimension(0,0);
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return parent.getPreferredSize();
	}

	@Override
	public void removeLayoutComponent(Component arg0) {
		// NOTHING
		
	}
	
	public Point getOrigin() { return origin;}

	public int getScale() {
		return scale;
	}

	public boolean setScale(int scale) {
		if(scale <= 0) return false;
		this.scale = scale;
		return true;
	}

}
