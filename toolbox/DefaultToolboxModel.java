package toolbox;


import java.awt.Color;
import java.util.Observable;

import dessin.DessinModel;

public class DefaultToolboxModel extends Observable implements ToolboxModel {
	private DessinModel model;
	private ExpectedOperation action = ExpectedOperation.CURSOR;
	private Color strokeColor =  Color.BLACK, fillColor = Color.WHITE;
	private int stroke;

	
	public DefaultToolboxModel(DessinModel m) {
		this.model = m;
		stroke = 1;
	}

	@Override
	public void setModel(DessinModel m) {
		this.model = m;
		
	}

	@Override
	public DessinModel getDessinModel() {
		return this.model;
	}

	@Override
	public ExpectedOperation getExpectedOperation() {
		return action;
	}

	@Override
	public void setExpectedOperation(ExpectedOperation operation) {
		this.action = operation;
		
	}

	@Override
	public void setStrokeColor(Color c) {
		this.strokeColor = c;
		setChanged();
		notifyObservers();
		
	}

	@Override
	public Color getStrokeColor() {
		return this.strokeColor;
	}

	@Override
	public void setFillColor(Color c) {
		this.fillColor = c;
		setChanged();
		notifyObservers();
	}

	@Override
	public Color getFillColor() {
		return this.fillColor;
	}

	@Override
	public void setStroke(int value) {
		if(value < 1) {
			stroke = 1;
		}
		this.stroke = value;
		
	}

	@Override
	public int getstrokeValue() {
		return this.stroke;
	}


}
