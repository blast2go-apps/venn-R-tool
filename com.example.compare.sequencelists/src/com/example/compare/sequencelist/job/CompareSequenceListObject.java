package com.example.compare.sequencelist.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.biobam.blast2go.api.datatype.AbstractB2GObject;
import com.biobam.blast2go.api.datatype.B2GObjectInfo;
import com.biobam.blast2go.api.datatype.B2GObjectValue;

public class CompareSequenceListObject extends AbstractB2GObject{
	private final static String TYPE_NAME="Lists";
//	private String list;
	private Map<String, String> geneTable;
	
//	public Map<String,String> getGeneTable() {
		//return geneTable;
	//}
	
	public CompareSequenceListObject(B2GObjectInfo objectInfo){
		super(objectInfo);
		
	}
	

	public CompareSequenceListObject(String name, Map<String, String> geneTable) {
		super(name);
		this.geneTable = geneTable;
		
	}

	@Override
	public void loadValue(B2GObjectValue objectValue) {
		if(objectValue instanceof CompareSequenceListObjectValue){
			CompareSequenceListObjectValue listValue=(CompareSequenceListObjectValue) objectValue;
			geneTable=listValue.geneTable;
			
		}
	}

	@Override
	public B2GObjectValue saveValue() {
		CompareSequenceListObjectValue listValue= new CompareSequenceListObjectValue(this);
		listValue.geneTable=geneTable;
		return listValue;
	}

	public List<String> getIDList() {
		return new ArrayList<>(geneTable.keySet());
	}


	public void setIDList(List<String> list){
	}

	@Override
	public String getType() {
		return TYPE_NAME;
	}

	public String getEntry(String id) {
		return geneTable.get(id);
	}
}