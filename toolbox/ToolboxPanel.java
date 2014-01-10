package toolbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import toolbox.items.ItemButton;
import toolbox.items.color.ColorButton;
import toolbox.items.strokesize.StrokeSizeButton;

/**
 * 
 * @author debuer,duponcha,vasseurm
 *
 */

@SuppressWarnings("serial")
public class ToolboxPanel extends JPanel implements Observer{
	private class ToolboxControler {
		public ToolboxControler() throws java.lang.NullPointerException{
			
			try {
			carre.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.RECT);
					
				}
			});
			
			triangle.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.TRI);
					
				}
			});
			cercle.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.OVAL);
					
				}
			});
			
			polygone.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.POLY);
					
				}
			});
			
			droite.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.LINE);
					
				}
			});
			
			curseur.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.CURSOR);
					
				}
			});
			
			loupe.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.ZOOM);
					
				}
			});
			hand.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.HAND);
					
				}
			});
			supprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					model.setExpectedOperation(ExpectedOperation.GOMME);
					
				}
			});
			
			}catch(java.lang.NullPointerException e) {
				throw e;
			}
			
		}

	}
	
	private JRadioButton carre,cercle,triangle,polygone,droite,curseur,supprimer,loupe,hand;
	private JButton color,stroke;
	private  ToolboxModel model;
	


	public ToolboxPanel(ToolboxModel m) {
		super();
		this.model = m;
		this.setLayout(new FlowLayout());
		
		color = new ColorButton(model);
		stroke = new StrokeSizeButton(model);
		carre = new ItemButton(new ImageIcon(this.getClass().getResource("/img/carre.png")));
		cercle = new ItemButton(new ImageIcon(this.getClass().getResource("/img/oval.png")));
		triangle = new ItemButton(new ImageIcon(this.getClass().getResource("/img/triangle.png")));
		polygone = new ItemButton(new ImageIcon(this.getClass().getResource("/img/polygone.png")));
		droite = new ItemButton(new ImageIcon(this.getClass().getResource("/img/ligne.png")));
		curseur = new ItemButton(new ImageIcon(this.getClass().getResource("/img/cursor.png")));
		loupe = new ItemButton(new ImageIcon(this.getClass().getResource("/img/loupe.png")));
		supprimer = new ItemButton(new ImageIcon(this.getClass().getResource("/img/supprimer.png")));
		hand = new ItemButton(new ImageIcon(this.getClass().getResource("/img/hand.png")));
		
		this.customAdd(curseur);
		this.customAdd(loupe);
		this.customAdd(hand);
		this.customAdd(droite);
		this.customAdd(carre);
		this.customAdd(triangle);
		this.customAdd(cercle);
		this.customAdd(polygone);
		this.customAdd(supprimer);
		color.setPreferredSize(carre.getPreferredSize());
		this.customAdd(color);
		stroke.setPreferredSize(carre.getPreferredSize());
		this.customAdd(stroke);
		
		new ToolboxControler();

		curseur.setSelected(true);
	}


	/**
	 * 
	 * @param c
	 * ajoute le component a la ToolboxPanel
	 */
	private void customAdd(JComponent c) {
		c.setAlignmentX(CENTER_ALIGNMENT);
		add(c);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
