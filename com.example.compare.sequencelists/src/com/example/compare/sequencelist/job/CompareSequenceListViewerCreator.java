package com.example.compare.sequencelist.job;

import java.net.URL;
import java.util.EnumSet;

import com.biobam.blast2go.api.dataviewer.B2GViewer;
import com.biobam.blast2go.api.dataviewer.B2GViewerCreator;

public class CompareSequenceListViewerCreator implements B2GViewerCreator<CompareSequenceListObjectDataController> {

	@Override
	public Class<?> getControllerClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListObjectDataController.class;
	}

	//@Override
	//public int getPreferredPositionInMenu() {
		// TODO Auto-generated method stub
	//	return 0;
	//}

	@Override
	public Class<? extends B2GViewer<?>> getViewerClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListViewer.class;
	}

	@Override
	public URL getViewerIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public String getViewerName() {
		// TODO Auto-generated method stub
	//	return "List Viewer";
	//}

	//@Override
//	public EnumSet<com.biobam.blast2go.api.dataviewer.B2GViewerCreator.Properties> workbenchProperties() {
		// TODO Auto-generated method stub
		//return EnumSet.of(Properties.DEFAULT_VIEWER,
				//Properties.IMPORTANCE_PRIMARY_VIEWER,
			//	Properties.POSITION_RESULT, 
			//	Properties.SAVE_ALLOWED);
	//}

	@Override
	public boolean canHandleMultipeObjects() {
		// TODO Auto-generated method stub
		return false;
	}

}
