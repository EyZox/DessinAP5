package toolbox.items.strokesize;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StrokeSizeControler {
	private StrokeFrame strokeFrame;
	public StrokeSizeControler(final StrokeSizeButton ssb) {
		strokeFrame = new StrokeFrame(ssb.getToolboxModel());
		ssb.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				//ssb.resize();
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				//ssb.resize();
				
			}
		});
		
		ssb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				strokeFrame.setVisible(true);
				
			}
		});
	}
	
}
