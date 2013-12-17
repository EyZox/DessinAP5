package toolbox;


import java.util.Observable;

import dessin.DefaultDessinModel;
import dessin.DessinModel;

public class DefaultToolboxModel extends Observable implements ToolboxModel {
	private DessinModel model;
	
	public DefaultToolboxModel() {
		this(new DefaultDessinModel());
	}
	
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


}
