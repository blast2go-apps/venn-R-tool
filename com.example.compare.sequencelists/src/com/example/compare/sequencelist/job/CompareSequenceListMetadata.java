package com.example.compare.sequencelist.job;

import java.util.List;

import com.biobam.blast2go.api.job.IB2GJobMetadata;
import com.biobam.blast2go.api.job.InputDefinition;
import com.example.compare.sequencelist.parameters.CompareSequenceListParameters;

public class CompareSequenceListMetadata implements IB2GJobMetadata<CompareSequenceListJob,CompareSequenceListParameters> {
	//public static InputDefinition<ItemsOrderList> INPUT_PROJECT=ItemsOrderList.INPUT_DEFINITION_OPTIONAL;
	@Override
	public List<InputDefinition<?>> additionalRequirements() {
		// TODO Auto-generated method stub
		return InputDefinition.EMPTY_LIST;
	}

	@Override
	public List<InputDefinition<?>> inputs() {
		// TODO Auto-generated method stub
		//return InputDefinition.listOf(INPUT_PROJECT);
		return InputDefinition.EMPTY_LIST;
	}

	@Override
	public Class<CompareSequenceListJob> jobClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListJob.class;
	}

	@Override
	public List<InputDefinition<?>> outputs() {
		// TODO Auto-generated method stub
		return InputDefinition.EMPTY_LIST;
	}

	@Override
	public Class<CompareSequenceListParameters> parametersClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListParameters.class;
	}

}

