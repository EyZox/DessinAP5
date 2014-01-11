package toolbox.items.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import toolbox.ToolboxModel;

@SuppressWarnings("serial")
public class ColorFrame extends JFrame {
	private JColorChooser stroke,fill;
	public ColorFrame(final ToolboxModel model) {
		
		/*Ecran de la selection de couleur */
		stroke = new JColorChooser(model.getStrokeColor());
		stroke.getPreviewPanel().getParent().setVisible(false);
		stroke.setBorder(new TitledBorder("Couleur du trait"));
		fill = new JColorChooser(model.getFillColor());
		fill.getPreviewPanel().getParent().setVisible(false);
		fill.setBorder(new TitledBorder("Couleur de remplissage"));
		
		JPanel colorPanel = new JPanel(new GridLayout(1,0));
		colorPanel.add(stroke); colorPanel.add(fill);
		
		/*Bouttons*/
		JButton ok = new JButton("Ok");
		JButton reset = new JButton("Reset");
		JButton annuler = new JButton("Annuler");
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(ok); buttonPanel.add(reset); buttonPanel.add(annuler);
		
		this.getContentPane().add(colorPanel,BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		
		
		/* EVENTS */
		
		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setStrokeColor(stroke.getColor());
				model.setFillColor(fill.getColor());
				dispose();
			}

		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setStrokeColor(Color.BLACK);
				model.setFillColor(Color.WHITE);
				dispose();
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				stroke.setColor(model.getStrokeColor());
				fill.setColor(model.getFillColor());
			}
		});
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);
	}
}
