package toolbox.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolbox.ToolboxModel;

@SuppressWarnings("serial")
public class ColorFrame extends JFrame {
	private JColorChooser lcp,lcs;
	public ColorFrame(final ToolboxModel model) {

		JPanel reponse = new JPanel();
		JButton annuler = new JButton("Annuler");
		JButton ok = new JButton("Ok");
		reponse.add(annuler);
		reponse.add(ok);
		lcp = new JColorChooser(model.getStrokeColor());
		lcp.getPreviewPanel().getParent().setVisible(false);
		lcs = new JColorChooser(model.getFillColor());
		lcs.getPreviewPanel().getParent().setVisible(false);
		this.getContentPane().add(lcp, BorderLayout.WEST);
		this.getContentPane().add(lcs, BorderLayout.EAST);
		this.getContentPane().add(reponse,BorderLayout.SOUTH);
		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setStrokeColor(lcp.getColor());
				model.setFillColor(lcs.getColor());
				dispose();
			}

		});
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);
	}

	public Color getActualColor() {
		return lcp.getColor();

	}
}
