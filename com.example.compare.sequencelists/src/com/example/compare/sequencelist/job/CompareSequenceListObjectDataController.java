package com.example.compare.sequencelist.job;

import com.biobam.blast2go.api.dataviewer.interfaces.IB2GObjectController;

public class CompareSequenceListObjectDataController implements IB2GObjectController<CompareSequenceListObject> {
	
		private CompareSequenceListObject object;
		
		public CompareSequenceListObjectDataController(CompareSequenceListObject dataObject){
			this.object=dataObject;
		
		}
	@Override
	public CompareSequenceListObject getObject() {
		// TODO Auto-generated method stub
		return object;
	}

	@Override
	public void updateObject(CompareSequenceListObject object) {
		// TODO Auto-generated method stub
		this.object=object;
	}
	
	public String getDataName(){
		return object.getName();
		
	}
}

