package toolbox;


import java.util.Observable;

import dessin.DefaultDessinModel;
import dessin.DessinModel;

public class DefaultToolboxModel extends Observable implements ToolboxModel {
	private DessinModel model;
	private ExpectedOperation action = ExpectedOperation.CURSOR;
	

	
	public DefaultToolboxModel(DessinModel m) {
		this.model = m;
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


}
