package com.example.compare.sequencelist.action;

import java.util.EnumSet;
import java.util.Set;

import com.biobam.blast2go.api.action.ActionType;
import com.biobam.blast2go.api.action.B2GAction;
import com.biobam.blast2go.api.action.IB2GBaseGroup;
import com.biobam.blast2go.api.action.PlaceTag;
import com.biobam.blast2go.api.action.icon.IB2GIcon;
import com.biobam.blast2go.api.wizard.B2GWizard;
import com.example.compare.sequencelist.job.CompareSequenceListMetadata;
import com.example.compare.sequencelist.job.CompareSequenceListWizard;

public class CompareSequenceList extends B2GAction<CompareSequenceListMetadata> {

	@Override
	public IB2GBaseGroup getActionGroup() {
		// TODO Auto-generated method stub
		return IB2GBaseGroup.BASE_GROUP;
	}

	@Override
	public IB2GIcon getActionIcon() {
		// TODO Auto-generated method stub
		return IB2GIcon.DEFAULT_EMPTY_ICON;
	}

	@Override
	public ActionType getActionType() {
		// TODO Auto-generated method stub
		return ActionType.RUN;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "b2g.web.examples.loadData.action";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Create Venn Diagram";
	}

	@Override
	public Set<PlaceTag> getPlaceTags() {
		// TODO Auto-generated method stub
		return EnumSet.of(PlaceTag.MENU_ANALYSIS);
	}

	@Override
	public int getPreferredPositionInMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class<? extends B2GWizard<?>> getWizardClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListWizard.class;
	}

	@Override
	public Class<CompareSequenceListMetadata> jobMetadataClass() {
		// TODO Auto-generated method stub
		return CompareSequenceListMetadata.class;
	}

}
