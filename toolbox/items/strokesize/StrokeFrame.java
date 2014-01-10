package toolbox.items.strokesize;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import toolbox.ToolboxModel;

@SuppressWarnings("serial")
public class StrokeFrame extends JFrame {
JSlider epaisseur;
JButton ok,annuler;

	public StrokeFrame(final ToolboxModel model) {
		
		this.setLayout(new FlowLayout());
		epaisseur = new JSlider(1,20);
		JPanel reponse = new JPanel();
		annuler = new JButton("Annuler");
		ok = new JButton("Ok");
		reponse.add(annuler);
		reponse.add(ok);
		epaisseur.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				model.setStroke(epaisseur.getValue());			
			}
			
		});
		
		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setStroke(epaisseur.getValue());
				dispose();
			}

		});
		this.getContentPane().add(epaisseur);
		this.getContentPane().add(reponse);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);
	}

}
