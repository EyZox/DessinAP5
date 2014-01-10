package toolbox.items.strokesize;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import toolbox.ToolboxModel;

@SuppressWarnings("serial")
public class StrokeSizeButton extends JButton implements Observer{
	private ToolboxModel model;

	public StrokeSizeButton(ToolboxModel m) {
		model = m;
		new StrokeSizeControler(this);
		model.addObserver(this);

	}
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		String strokeSize = model.getStrokeSize()+"";
		g2d.drawString(strokeSize, (getWidth()-((strokeSize.length()*g2d.getFont().getSize())/2))/2, getHeight()/2);
		
		int posStrokeLine = getHeight() - getHeight()/4;
		Stroke oldStroke = g2d.getStroke();
		g2d.setStroke(new BasicStroke(model.getStrokeSize()));
		int insets = 10+model.getStrokeSize()/2;
		g2d.drawLine(insets, posStrokeLine, getWidth()-insets, posStrokeLine);
		g2d.setStroke(oldStroke);
	}
	
	public ToolboxModel getToolboxModel() {
		return model;
	}

}
