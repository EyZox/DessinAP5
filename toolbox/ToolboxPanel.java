package toolbox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author debuer,duponcha,vasseurm
 *
 */

@SuppressWarnings("serial")
public class ToolboxPanel extends JPanel implements Observer{
	private JButton carre,cercle,triangle,polygone,droite,curseur,supprimer,loupe,hand;
	private JColorChooser listecouleur;

	private  ToolboxModel model;
	
	public ToolboxPanel() {
		this(new DefaultToolboxModel());
	}

	public ToolboxPanel(ToolboxModel m) {
		super();
		this.model = m;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		listecouleur = new JColorChooser(Color.BLACK);
		carre = new JButton("Carre");
		cercle = new JButton("Cercle");
		triangle = new JButton("Triangle");
		polygone = new JButton("Polygone");
		droite = new JButton("Droite");
		curseur = new JButton("Curseur");
		loupe = new JButton("Zoom");
		supprimer = new JButton("Supprimer");
		hand = new JButton("Deplacer");
		listecouleur = new JColorChooser(Color.BLACK);
		this.customAdd(carre);
		this.customAdd(triangle);
		this.customAdd(cercle);
		this.customAdd(polygone);
		this.customAdd(droite);
		this.customAdd(curseur);
		this.customAdd(loupe);
		this.customAdd(hand);
		this.customAdd(supprimer);
		this.customAdd(listecouleur);
		
		
		carre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.RECT);
				
			}
		});
		
		triangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.TRI);
				
			}
		});
		cercle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.OVAL);
				
			}
		});
		
		polygone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.POLY);
				
			}
		});
		
		droite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.LINE);
				
			}
		});
		
		curseur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.CURSOR);
				
			}
		});
		
		loupe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.ZOOM);
				
			}
		});
		hand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.HAND);
				
			}
		});
		supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.getDessinModel().setExpectedOperation(ExpectedOperation.GOMME);
				
			}
		});

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		ToolboxPanel t = new ToolboxPanel();
		f.add(t);
		f.setVisible(true);
		f.setSize(new Dimension(300,300));

	}
	
	private void customAdd(JComponent c) {
		c.setAlignmentX(CENTER_ALIGNMENT);
		add(c);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
