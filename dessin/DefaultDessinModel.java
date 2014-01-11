package dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Observable;

import toolbox.ToolboxModel;

public class DefaultDessinModel extends Observable implements DessinModel  {
	/**
	 * @author duponcha,debuer,vasseurn
	 */
	private ListenedList<ShapeComponent> shapes = new ListenedList<ShapeComponent>(new Runnable() {
		@Override
		public void run() {
			setChanged();
			notifyObservers();
		}
	});
	private File file;
	private ToolboxModel toolboxModel;
	private Color c;
	private double scale = 1;
	/**
	 * Constructeur par defaut, genere un fichier sans titre.
	 */
	public DefaultDessinModel(ToolboxModel m) {
		this.toolboxModel  = m;
		this.file = null;
	}
	/**
	 * Instancie l'AbstractDessinModel et ouvre un fichier donne en parametre.
	 * @param f
	 */
	public DefaultDessinModel(ToolboxModel m, File f) {
		this.toolboxModel = m;
		open(f);
	}


	/**
	 * Trace une ligne de p1 a p2
	 * @param p1 p2 
	 */
	@Override
	public void addLine(Point p1, Point p2) {
		Point topLeftCorner = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		p1.translate(-topLeftCorner.x, -topLeftCorner.y);
		p2.translate(-topLeftCorner.x, -topLeftCorner.y);
		Shape s = new Line2D.Double(p1, p2);
		shapes.add(new ShapeComponent(this,topLeftCorner, s, toolboxModel.getStrokeColor(), toolboxModel.getFillColor(), toolboxModel.getStrokeSize()));
	}

	/**
	 * Trace un rectangle entre p1, representant le coin superieur gauche, et p2 representant le coin inferieur droit
	 * @param p1 p2 
	 * 
	 */
	@Override
	public void addRect(Point p1, Point p2) {

		Point debut = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		Point fin = new Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
		Shape s = new Rectangle(new Point(0,0), new Dimension(fin.x - debut.x,fin.y - debut.y));

		shapes.add(new ShapeComponent(this,debut, s, toolboxModel.getStrokeColor(), toolboxModel.getFillColor(), toolboxModel.getStrokeSize()));
	}

	/**
	 * Trace un cercle du point p1 au point p2
	 * @param p1 p2 

	 */
	@Override
	public void addOval(Point p1, Point p2) {
		Point debut = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		Point fin = new Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
		Shape s = new Ellipse2D.Double(0, 0, fin.x - debut.x, fin.y - debut.y);
		shapes.add(new ShapeComponent(this,debut, s, toolboxModel.getStrokeColor(), toolboxModel.getFillColor(), toolboxModel.getStrokeSize()));
	}

	/**
	 *  Trace un triangle du point p1 au point p2
	 * @param p1 p2 
	 */
	@Override
	public void addTri(Point p1, Point p2) {
		int[]x = new int[3];
		int[]y = new int[3];
		Point topLeftCorner = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));

		x[0]=p1.x-topLeftCorner.x; x[1]=p1.x-topLeftCorner.x; x[2]=p2.x-topLeftCorner.x;
		y[0]=p1.y-topLeftCorner.y; y[1]=p2.y-topLeftCorner.y; y[2]=p2.y-topLeftCorner.y;
		Shape s = new Polygon(x, y, 3);
		shapes.add(new ShapeComponent(this,topLeftCorner, s, toolboxModel.getStrokeColor(), toolboxModel.getFillColor(), toolboxModel.getStrokeSize()));

	}

	/**
	 * Trace un polygone selon un ensemble de point
	 * @param points
	 */
	@Override
	public void addPoly(Collection<Point> points) {
		// TODO Auto-generated method stub

	}

	/**
	 * Supprime un figure du dessin
	 * @param shape
	 */
	@Override
	public void remove(ShapeComponent shape) {
		shapes.remove(shape);

	}

	/**
	 * Supprime toutes les figures du dessin
	 */
	@Override
	public void clear() {
		shapes.clear();

	}


	/**
	 * Retourne la liste des figures
	 * @return liste de shapes
	 */
	@Override
	public Collection<ShapeComponent> getShapes() {
		return shapes;
	}

	/**
	 * permet d'obtenir la couleur du dessin actuelle.
	 * @return la couleur actuelle 
	 */
	public Color getColor() { return c;}
	/**
	 * permet de definir la couleur actuelle
	 * @param g
	 * 
	 */
	public void setColor(Color g) { this.c = g;}


	/**
	 * Sauvegarde le fichier
	 */
	@Override
	public void save() {
		if(file == null) {
			// TODO L'utilisateur choisis un chemin
			// A supprimer ensuite :
			file = new File("sauvegardeParDefaut");
		}else {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(shapes);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * Ouvre le fichier
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void open(File file) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			shapes = ((ListenedList<ShapeComponent>) ois.readObject());
			shapes.setRunnable(new Runnable() {
				
				@Override
				public void run() {
					setChanged();
					notifyObservers();
				}
			});
			
			for(ShapeComponent shape : shapes) {
				shape.setSupport(this);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		setChanged();
		notifyObservers();
	}
	/**
	 * Retourne le ToolboxModel associe au DessinModel.
	 * @return le ToolboxModel 
	 */
	@Override
	public ToolboxModel getToolBoxModel() {
		return this.toolboxModel;
	}
	/**
	 * Associe le ToolboxModel au DessinModel.
	 * @param m
	 */
	@Override
	public void setToolboxModel(ToolboxModel m) {
		this.toolboxModel = m;
	}
	@Override
	public void saveAs(File selectedFile) {
		file = selectedFile;
		save();
	}
	
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
		setChanged();
		notifyObservers();
	}


}
