package com.example.compare.sequencelist.action;

import java.util.Collections;
import java.util.List;

import com.biobam.blast2go.api.action.IB2GBaseGroup;
import com.biobam.blast2go.api.action.icon.IB2GIcon;

public class CompareSequenceListBaseGroup implements IB2GBaseGroup {
	public static final CompareSequenceListBaseGroup INSTANCE=new CompareSequenceListBaseGroup();
	private CompareSequenceListBaseGroup(){
		
	}

	@Override
	public IB2GIcon getGroupIcon() {
		// TODO Auto-generated method stub
		return IB2GIcon.DEFAULT_EMPTY_ICON;
	}

	@Override
	public String getGroupId() {
		// TODO Auto-generated method stub
		return "b2g.web.examples.compare.sequencelist.base.group";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "LoadSequenceLists";
	}

	@Override
	public IB2GBaseGroup getParentGroup() {
		// TODO Auto-generated method stub
		return IB2GBaseGroup.BASE_GROUP;
	}

	@Override
	public int getPreferredPositionInMenu() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public List<Integer> getSeparatorsPrefferedPositions() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

}
