package toolbox.items.color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ColorButtonControler {
	private ColorFrame colorFrame;
	
	
	public ColorButtonControler(final ColorButton cb) {
		colorFrame = new ColorFrame(cb.getToolboxModel());
		cb.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				cb.resize();
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				cb.resize();
				
			}
		});
		
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				colorFrame.setVisible(true);
				
			}
		});
	}
}
