package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
/**
 * 
 * @author duponcha,debuer,vasseurn
 *
 */


@SuppressWarnings("serial")
public class Dessin extends JPanel implements Observer{
	
	private DessinModel model;

	/**
	 * Constructeur du Dessin avec un Dessin Model en parametre.
	 * @param m
	 */
	public Dessin(DessinModel m) {
		this.model = m;
		this.model.addObserver(this);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setPreferredSize(new java.awt.Dimension(640,480));
		
		new DessinControler(this);
	}
	
	

	@Override
	public void update(Observable arg0, Object arg1) {
		removeAll();
		for(ShapeComponent shape : model.getShapes()) {
			shape.setBounds(shape.getAnchor().x, shape.getAnchor().y, shape.getPreferredSize().width, shape.getPreferredSize().height);
			add(shape);
		}
		repaint();
		
	}
	/**
	 * Methode permettant de dessiner les differentes formes.
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	/**
	 * Retourne le Model du Dessin.
	 * @return model
	 */
	public DessinModel getModel() { return model;}
	/**
	 * Definit un model pour le Dessin.
	 * @param model
	 */
	public void setDessinModel(DessinModel model) { this.model = model;}

}
