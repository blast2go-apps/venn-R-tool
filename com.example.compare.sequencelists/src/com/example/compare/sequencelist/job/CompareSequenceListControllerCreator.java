package com.example.compare.sequencelist.job;

import java.util.EnumSet;

import com.biobam.blast2go.api.dataviewer.interfaces.IB2GObjectController;
import com.biobam.blast2go.api.dataviewer.interfaces.IB2GObjectControllerCreator;
import com.biobam.blast2go.api.dataviewer.interfaces.WorkbenchProperty;

public class CompareSequenceListControllerCreator implements IB2GObjectControllerCreator<CompareSequenceListObject> {

	@Override
	public IB2GObjectController<CompareSequenceListObject> getControllerInstance(CompareSequenceListObject dataObject) {
		// TODO Auto-generated method stub
		return new CompareSequenceListTableViewerController(dataObject);
	}

	@Override
	public Class<CompareSequenceListObject> getObjectClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListObject.class;
	}

	@Override
	public Class<? extends IB2GObjectController<CompareSequenceListObject>> getObjectControllerClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListTableViewerController.class;
	}

	@Override
	public int getPreferredPositionInMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getViewerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumSet<WorkbenchProperty> getWorkbenchProperties() {
		// TODO Auto-generated method stub
		return null;
	}


}
