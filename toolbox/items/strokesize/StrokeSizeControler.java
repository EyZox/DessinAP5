package toolbox.items.strokesize;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StrokeSizeControler {
	private StrokeFrame strokeFrame;
	public StrokeSizeControler(final StrokeSizeButton ssb) {
		strokeFrame = new StrokeFrame(ssb.getToolboxModel());
		
		ssb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				strokeFrame.setVisible(true);
			}
		});
	}
	
}
