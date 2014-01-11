package toolbox.items.strokesize;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolbox.ToolboxModel;
import toolbox.items.JSliderWithLabel;

@SuppressWarnings("serial")
public class StrokeFrame extends JFrame {
	private JSliderWithLabel epaisseur;
	private JButton ok,annuler;
	public StrokeFrame(final ToolboxModel model) {

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Taille Pinceau");
		epaisseur = new JSliderWithLabel("Taille du trait :",1,20);
		epaisseur.getSlider().setValue(model.getStrokeSize());
		JPanel reponse = new JPanel();
		annuler = new JButton("Annuler");
		ok = new JButton("Ok");
		reponse.add(ok);
		reponse.add(annuler);

		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setStrokeSize(epaisseur.getSlider().getValue());
				dispose();
			}

		});
		
		epaisseur.setAlignmentX(CENTER_ALIGNMENT);
		reponse.setAlignmentX(CENTER_ALIGNMENT);
		
		this.getContentPane().add(epaisseur);
		this.getContentPane().add(reponse);
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
