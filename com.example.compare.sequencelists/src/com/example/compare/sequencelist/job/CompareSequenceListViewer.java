package com.example.compare.sequencelist.job;
import java.awt.Label;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.biobam.blast2go.api.dataviewer.B2GViewer;
import com.example.compare.sequencelist.job.CompareSequenceListObjectDataController;

public class CompareSequenceListViewer implements B2GViewer<CompareSequenceListObjectDataController> {
	
	public Label text;
	
	public void postConstruct(String parent) {
		// TODO Auto-generated method stub
		Label text= new Label(parent, SWT.COLOR_BLUE);
	}

	@Override
	public void preSave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInputData(List<CompareSequenceListObjectDataController> controllerList) {
		// TODO Auto-generated method stub
		CompareSequenceListObjectDataController objectController=controllerList.get(0);
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				text.setText("List Viewer: "
					+ objectController.getDataName());
			}
			});
		}

	@Override
	public void postConstruct(Composite arg0) {
		// TODO Auto-generated method stub
		
	}
}
