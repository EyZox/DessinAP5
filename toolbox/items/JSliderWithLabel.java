package toolbox.items;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class JSliderWithLabel extends JPanel {

	private JLabel rate = new JLabel(), title;
	private JSlider slider;
	
	public JSliderWithLabel(String title,int min, int max) {
		this.title = new JLabel(title);
		slider = new JSlider(min,max);
		rate.setHorizontalAlignment(SwingConstants.CENTER);
		
		/* POSITIONNEMENT */
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0; c.gridy = 0;
		add(this.title,c);
		c.gridx = 1;
		add(rate, c);
		c.gridx = 0; c.gridy = 1; c.gridwidth = GridBagConstraints.REMAINDER;
		add(slider,c);
		
		update();
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				update();
			}
		});
	}
	
	private void update() {
		rate.setText(slider.getValue()+"/"+slider.getMaximum());
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JSlider getSlider() {
		return slider;
	}

	public void setSlider(JSlider slider) {
		this.slider = slider;
	}
	
	public static void main(String[] a) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JSliderWithLabel("Label :",1,100));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}