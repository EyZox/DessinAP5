package toolbox.items;

import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ItemButton extends JRadioButton{
	private static ButtonGroup group = new ButtonGroup();
	
	public ItemButton(ImageIcon img) {
		super(img);
		try {
			setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/over.png")));
		}catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		}
		
		try {
			setSelectedIcon(new ImageIcon(this.getClass().getResource("/img/selected.png")));
		}catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		}
		
		group.add(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		getIcon().paintIcon(this, g, getInsets().left, getInsets().top);
	}
}
