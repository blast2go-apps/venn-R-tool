package com.example.compare.sequencelist.job;

import org.eclipse.swt.widgets.Composite;

import com.biobam.blast2go.api.wizard.page.B2GWizardPage;
import com.biobam.blast2go.api.wizard.page.widget.IB2GWidget;
import com.biobam.blast2go.api.wizard.page.widget.implementations.FileWidget;
import com.biobam.blast2go.api.wizard.page.widget.implementations.StringWidget;
import com.example.compare.sequencelist.parameters.CompareSequenceListParameters;

public class CompareSequenceListWizardFirstPage extends B2GWizardPage {
	private CompareSequenceListParameters parameters;

	public CompareSequenceListWizardFirstPage(CompareSequenceListParameters parameters) {
		this.parameters = parameters;
	}

	@Override
	public void definePage(Composite parent) {
		// TODO Auto-generated method stub
		setTitle("Load Lists");

		// addWidget(FileWidget.createFileOpenBuilder(parent,
		// parameters.compareSequenceListFile).build());
		// addWidget(FileWidget.createFileOpenBuilder(parent,
		// parameters.compareSequenceListFile2).build());
		// addWidget(IntegerWidget.create(parent,
		// parameters.compareSequenceListInteger));
		// addWidget(BooleanWidget.create(parent,
		// parameters.compareSequenceListBoolean));
		// addWidget(((IB2GFileWidgetBuilder)
		// FileWidget.createMultipleFilesOpen(parent,
		// parameters.compareSequenceListMultiFile)).build());
		addWidget(FileWidget.createObjectOpen(parent, parameters.compareSequenceListFileObject1));
		addWidget(StringWidget.create(parent, parameters.compareSequenceListString1));
		addWidget(FileWidget.createObjectOpen(parent, parameters.compareSequenceListFileObject2));
		addWidget(StringWidget.create(parent, parameters.compareSequenceListString2));
		addWidget(FileWidget.createObjectOpen(parent, parameters.compareSequenceListFileObject3,parameters.compareSequenceListBoolean));
		addWidget(StringWidget.create(parent, parameters.compareSequenceListString3));

	}

	
}
