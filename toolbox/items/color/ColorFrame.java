package toolbox.items.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import toolbox.ToolboxModel;
import toolbox.items.JSliderWithLabel;

@SuppressWarnings("serial")
public class ColorFrame extends JFrame {
	private JColorChooser stroke,fill;
	private JSliderWithLabel opStroke, opFill;
	public ColorFrame(final ToolboxModel model) {
		super("Selection de couleurs");
		/*Ecran de la selection de couleur */
		stroke = new JColorChooser(model.getStrokeColor());
		stroke.getPreviewPanel().getParent().setVisible(false);
		fill = new JColorChooser(model.getFillColor());
		fill.getPreviewPanel().getParent().setVisible(false);
		
		/*Slider Transparence*/
		//Couleur trait :
		JPanel strokePanel = new JPanel();
		strokePanel.setLayout(new BoxLayout(strokePanel, BoxLayout.Y_AXIS));
		opStroke = new JSliderWithLabel("Opacité",0,100);
		strokePanel.add(stroke); strokePanel.add(opStroke);
		strokePanel.setBorder(new TitledBorder("Couleur du trait"));
		
		//Couleur de remplissage :
		JPanel fillPanel = new JPanel();
		fillPanel.setLayout(new BoxLayout(fillPanel,BoxLayout.Y_AXIS));
		opFill = new JSliderWithLabel("Opacité",0,100);
		fillPanel.add(fill); fillPanel.add(opFill);
		fillPanel.setBorder(new TitledBorder("Couleur de remplissage"));
		
		
		JPanel colorPanel = new JPanel(new GridLayout(1,2));
		colorPanel.add(strokePanel); colorPanel.add(fillPanel);
		
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
