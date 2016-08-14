package com.example.compare.sequencelist.job;

import java.net.URL;

import com.biobam.blast2go.api.datatype.B2GObject;
import com.biobam.blast2go.api.datatype.B2GObjectCreator;
import com.biobam.blast2go.api.datatype.B2GObjectInfo;
import com.biobam.blast2go.api.datatype.B2GObjectValue;

public class CompareSequenceListObjectCreator implements B2GObjectCreator{

	@Override
	public B2GObject create(B2GObjectInfo objectInfo) {
		// TODO Auto-generated method stub
		return new CompareSequenceListObject(objectInfo);
	}

	@Override
	public URL getIcon() {
		// TODO Auto-generated method stub
		return getClass().getResource("/icon_32px_blast2go_aa.png");
	}

	@Override
	public Class<? extends B2GObject> getObjectClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListObject.class;
	}

	@Override
	public Class<? extends B2GObjectValue> getValueClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListObjectValue.class;
	}
	

}
