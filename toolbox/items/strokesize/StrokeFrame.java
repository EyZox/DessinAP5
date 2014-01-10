package toolbox.items.strokesize;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import toolbox.ToolboxModel;

@SuppressWarnings("serial")
public class StrokeFrame extends JFrame {
	private JSlider epaisseur;
	private JButton ok,annuler;
	private JLabel valeur;
	public StrokeFrame(final ToolboxModel model) {

		this.setLayout(new FlowLayout());
		this.setTitle("Taille Pinceau");
		epaisseur = new JSlider(1,20);
		epaisseur.setValue(1);
		JPanel reponse = new JPanel();
		annuler = new JButton("Annuler");
		ok = new JButton("Ok");
		reponse.add(annuler);
		reponse.add(ok);
		epaisseur.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				valeur.setText(epaisseur.getValue()+ "/" + epaisseur.getMaximum());
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
				model.setStrokeSize(epaisseur.getValue());
				dispose();
			}

		});
		valeur = new JLabel(epaisseur.getValue()+ "/" + epaisseur.getMaximum());
		this.getContentPane().add(epaisseur);
		this.getContentPane().add(reponse);
		this.getContentPane().add(valeur);
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
