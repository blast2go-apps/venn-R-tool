package com.example.compare.sequencelist.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.biobam.blast2go.api.core.utils.callback.CallBack;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.ColumnDataCreator;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.IB2GTableFormat;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.IColumnData;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.ITableModelChangedCallback;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.ITableTag;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.TableTag;
import com.biobam.blast2go.api.dataviewer.interfaces.tableformat.TagColor;

public class CompareSequenceListTableViewerController implements IB2GTableFormat<CompareSequenceListObject, String> {

	private CompareSequenceListObject object;

	public CompareSequenceListTableViewerController(CompareSequenceListObject object) {
		this.object = object;
	}

	// @Override
	// public CompareSequenceListObject extractFrom(List<String> entryIdList) {
	// CompareSequenceListObject dataObject= new
	// CompareSequenceListObject("extracted_set");
	// for(String entryId :entryIdList){
	// String entry=object.getEntry(entryId);
	// dataObject.addEntry(entry);
	// }
	// return dataObject;
	// }

	ITableTag shared = TableTag.create("Shared", TagColor.PURPLE);
	ITableTag unique1 = TableTag.create("List1", TagColor.RED);
	ITableTag unique2 = TableTag.create("List2", TagColor.BLUE);
	ITableTag unique3 = TableTag.create("List3", TagColor.GREEN);
	ITableTag shared12 = TableTag.create("List 1 & 2", TagColor.PINK);
	ITableTag shared23 = TableTag.create("List 2 & 3", TagColor.ORANGE);
	ITableTag shared13 = TableTag.create("List 1 & 3", TagColor.YELLOW);
	ITableTag shared123 = TableTag.create("Shared All", TagColor.PURPLE);

	@Override
	public List<IColumnData<?>> getColumnList() {
		List<IColumnData<?>> columnList = new ArrayList<>();
		columnList.add(ColumnDataCreator.stringColumnBuilder("List member ID")
				.setContentCallback(new CallBack<String, String>() {
					@Override
					public String call(String entry) {
						return entry;

					}
				}).build());
		columnList.add(ColumnDataCreator.tagColumnBuilder().setContentCallback(new CallBack<String, List<ITableTag>>() {

			@Override
			public List<ITableTag> call(String id) {
				String entry = getEntry(id);
				if (entry.equals("Shared")) {
					return Arrays.asList(shared);
				} else if (entry.equals("List1")) {
					return Arrays.asList(unique1);
				} else if (entry.equals("List2")) {
					return Arrays.asList(unique2);
				} else if (entry.equals("List3")) {
					return Arrays.asList(unique3);
				} else if (entry.equals("Shared 1 & 2")) {
					return Arrays.asList(shared12);
				} else if (entry.equals("Shared 2 & 3")) {
					return Arrays.asList(shared23);
				} else if (entry.equals("Shared 1 & 3")) {
					return Arrays.asList(shared13);
				} else if (entry.equals("Shared All")) {
					return Arrays.asList(shared123);
				}else {
					return null;
				}
			}
		}).build());

		return columnList;

	}

	@Override
	public String getEntry(String id) {
		return object.getEntry(id);
	}

	@Override
	public List<String> getIdList() {
		// TODO Auto-generated method stub
		return object.getIDList();
	}

	@Override
	public void setChangeCallback(ITableModelChangedCallback change) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setList(List<String> list) {
		object.setIDList(list);
	}

	@Override
	public void viewerClosing() {
		// TODO Auto-generated method stub

	}

	@Override
	public CompareSequenceListObject getObject() {
		return object;
	}

	@Override
	public void updateObject(CompareSequenceListObject object) {
		this.object = object;
	}

	@Override
	public CompareSequenceListObject extractFrom(List<String> arg0) {
		Map<String, String> geneTable = new HashMap<>();
		for (String id : arg0) {
			geneTable.put(id, getEntry(id));
		}
		return new CompareSequenceListObject("wev", geneTable);
	}

}
