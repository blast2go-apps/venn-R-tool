package com.example.compare.sequencelist.job;

import java.util.Map;

import com.biobam.blast2go.api.datatype.B2GObject;
import com.biobam.blast2go.api.datatype.B2GObjectValue;

public class CompareSequenceListObjectValue extends B2GObjectValue{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8462395213169098681L;
	Map<String,String> geneTable;
	
	public CompareSequenceListObjectValue(B2GObject slObject){
		super(slObject);
		
	}
	
}
