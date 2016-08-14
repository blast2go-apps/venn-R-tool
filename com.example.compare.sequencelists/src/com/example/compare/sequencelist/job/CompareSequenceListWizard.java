package com.example.compare.sequencelist.job;

import com.biobam.blast2go.api.wizard.B2GWizard;
import com.example.compare.sequencelist.parameters.CompareSequenceListParameters;

public class CompareSequenceListWizard extends B2GWizard<CompareSequenceListParameters> {
	public CompareSequenceListWizard(){
			setWindowTitle("Load Data");
	}
	
	@Override
	protected void definePages() {
	
		// TODO Auto-generated method stub
		CompareSequenceListParameters parameters = getParameters();

		addPage(new CompareSequenceListWizardFirstPage(parameters));
	}
	

}