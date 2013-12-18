package toolbox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
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
	
	private JButton carre,cercle,triangle,polygone,droite,curseur,supprimer,loupe,hand;
	private JColorChooser listecouleur;
	private  ToolboxModel model;
	
	public ToolboxPanel() {
		this(new DefaultToolboxModel());
	}

	public ToolboxPanel(ToolboxModel m) {
		super();
		this.model = m;
		this.setLayout(new FlowLayout());
		listecouleur = new JColorChooser(Color.BLACK);
		
		carre = new JButton(new ImageIcon(this.getClass().getResource("/img/carre.png")));
		cercle = new JButton(new ImageIcon(this.getClass().getResource("/img/oval.png")));
		triangle = new JButton(new ImageIcon(this.getClass().getResource("/img/triangle.png")));
		polygone = new JButton(new ImageIcon(this.getClass().getResource("/img/polygone.png")));
		droite = new JButton(new ImageIcon(this.getClass().getResource("/img/ligne.png")));
		curseur = new JButton(new ImageIcon(this.getClass().getResource("/img/cursor.png")));
		loupe = new JButton(new ImageIcon(this.getClass().getResource("/img/loupe.png")));
		supprimer = new JButton(new ImageIcon(this.getClass().getResource("/img/supprimer.png")));
		hand = new JButton(new ImageIcon(this.getClass().getResource("/img/hand.png")));
		
		carre.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/carreOver.png")));
		cercle.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/ovalOver.png")));
		triangle.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/triangleOver.png")));
		polygone.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/polygoneOver.png")));
		droite.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/ligneOver.png")));
		curseur.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/cursorOver.png")));
		loupe.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/loupeOver.png")));
		supprimer.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/supprimerOver.png")));
		hand.setRolloverIcon(new ImageIcon(this.getClass().getResource("/img/handOver.png")));
		
		carre.setContentAreaFilled(false);
		cercle.setContentAreaFilled(false);
		triangle.setContentAreaFilled(false);
		polygone.setContentAreaFilled(false);
		curseur.setContentAreaFilled(false);
		loupe.setContentAreaFilled(false);
		supprimer.setContentAreaFilled(false);
		hand.setContentAreaFilled(false);
		droite.setContentAreaFilled(false);
		
		carre.setBorder(null);
		cercle.setBorder(null);
		triangle.setBorder(null);
		polygone.setBorder(null);
		curseur.setBorder(null);
		loupe.setBorder(null);
		supprimer.setBorder(null);
		hand.setBorder(null);
		droite.setBorder(null);
		
		
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
		//this.customAdd(listecouleur);
		
		new ToolboxControler();
		
		

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		ToolboxPanel t = new ToolboxPanel();
		f.add(t);
		f.setVisible(true);
		f.setSize(new Dimension(300,300));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
