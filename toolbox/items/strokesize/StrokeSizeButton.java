package toolbox.items.strokesize;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import toolbox.ToolboxModel;
import toolbox.items.color.ColorButtonControler;

@SuppressWarnings("serial")
public class StrokeSizeButton extends JButton implements Observer{
	private ToolboxModel model;

	public StrokeSizeButton(ToolboxModel m) {
		model = m;
		//new StrokeSizeControler(this);
		model.addObserver(this);

	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public ToolboxModel getToolboxModel() {
		return model;
	}

}
