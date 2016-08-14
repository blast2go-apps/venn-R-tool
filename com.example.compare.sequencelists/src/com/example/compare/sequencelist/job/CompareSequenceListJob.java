package com.example.compare.sequencelist.job;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//import com.biobam.blast2go.api.datatype.AbstractB2GObject;
//import com.biobam.blast2go.api.datatype.B2GObject;
import com.biobam.blast2go.api.datatype.basics.html.B2GHtml;
import com.biobam.blast2go.api.datatype.basics.idlist.B2GIdList;
import com.biobam.blast2go.api.job.B2GJob;

//import javax.swing.text.html.HTMLDocument.Iterator;

import com.biobam.blast2go.api.scm.IResultFSHandler;
import com.biobam.blast2go.api.scm.IServiceCloud;
import com.biobam.blast2go.api.scm.IServiceCloudParameters;
import com.biobam.blast2go.api.scm.RequestPack;
import com.biobam.blast2go.api.scm.SimpleServiceCloudImpl;
import com.example.compare.sequencelist.parameters.CompareSequenceListParameters;

public class CompareSequenceListJob extends B2GJob<CompareSequenceListParameters> {
	public CompareSequenceListJob() {
		super("Compare Sequence Lists", new CompareSequenceListParameters());
	}

	@Override
	public void run() throws InterruptedException {
		// TODO Auto-generated method stub
		CompareSequenceListParameters parameters = getParameters();
		parameters.getKeys();

		// Get paths of sequence lists
		B2GIdList filepath = (B2GIdList) parameters.compareSequenceListFileObject1.getObjectValue();
		B2GIdList filepath2 = (B2GIdList) parameters.compareSequenceListFileObject2.getObjectValue();
		boolean filepath3bool = parameters.compareSequenceListBoolean.getValue();

		// Define lists and strings to be used in sequence comparisons
		List<String> list1 = new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		List<String> list3 = new LinkedList<String>();

		beginTask("Compare sequence lists", 8);
		postJobMessage("Loading lists");
		try {
		
			// Initialize variables
			int sharedSeqs = 0;
			int seqCount1 = 0;
			int seqCount2 = 0;
			int seqCount3 = 0;
			int uniqueSeqs1 = 0;
			int uniqueSeqs2 = 0;
			int uniqueSeqs3 = 0;
			int sharedSeqs12 = 0;
			int sharedSeqs23 = 0;
			int sharedSeqs13 = 0;
			int sharedSeqs123 = 0;
			int seqs1Venn = 0;
			int seqs2Venn = 0;
			int seqs3Venn = 0;
			int seqs12shared = 0;
			int seqs23shared = 0;
			int seqs13shared = 0;
			int seqs123shared = 0;
			int sharedSeqsVenn = 0;
			///////////////////////////////////////////// Three-Way
			///////////////////////////////////////////// Comparison///////////////////

			if (filepath3bool) {
				B2GIdList filepath3 = (B2GIdList) parameters.compareSequenceListFileObject3.getObjectValue();
		
				worked(1);
				postJobMessage("Counting list 1");
			
				list1 = filepath.getIds();
				seqCount1 = list1.size();

				worked(2);
				postJobMessage("Counting list 2");
				list2 = filepath2.getIds();
				seqCount2 = list2.size();

				worked(3);
				postJobMessage("Counting list 3");

				list3 = filepath3.getIds();
				seqCount3 = list3.size();

				worked(4);
				postApplicationMessage("Making comparisons");
				List<String> sharedList12 = new LinkedList<>(list1);
				sharedList12.retainAll(list2);
				sharedSeqs12 = sharedList12.size();

				List<String> sharedList23 = new LinkedList<>(list2);
				sharedList23.retainAll(list3);

				List<String> sharedList13 = new LinkedList<>(list1);
				sharedList13.retainAll(list3);

				List<String> sharedList123 = new LinkedList<>(sharedList12);
				sharedList123.retainAll(sharedList23);
				sharedList123.retainAll(sharedList13);
				sharedSeqs123 = sharedList123.size();

				System.out.println("Shared all:" + sharedSeqs123);
				postApplicationMessage("Shared all:" + sharedSeqs123);

				System.out.println("Shared 1 & 2:" + sharedSeqs12);
				postApplicationMessage("Shared 1 & 2:" + sharedSeqs12);

				sharedSeqs23 = sharedList23.size();
				System.out.println("Shared 2 & 3:" + sharedSeqs23);
				postApplicationMessage("Shared 2 & 3:" + sharedSeqs23);

				sharedSeqs13 = sharedList13.size();
				System.out.println("Shared 1 & 3:" + sharedSeqs13);
				postApplicationMessage("Shared 1 & 3:" + sharedSeqs13);

				List<String> uniqueList1 = new LinkedList<>(list1);
				uniqueList1.removeAll(sharedList12);
				uniqueList1.removeAll(sharedList23);
				uniqueList1.removeAll(sharedList13);
				uniqueList1.removeAll(sharedList123);
				uniqueSeqs1 = uniqueList1.size();
				System.out.println("List 1 unique:" + uniqueSeqs1);
				postApplicationMessage("List 1 unique:" + uniqueSeqs1);

				List<String> uniqueList2 = new LinkedList<>(list2);
				uniqueList2.removeAll(sharedList12);
				uniqueList2.removeAll(sharedList23);
				uniqueList2.removeAll(sharedList13);
				uniqueList2.removeAll(sharedList123);
				uniqueSeqs2 = uniqueList2.size();
				System.out.println("List 2 unique:" + uniqueSeqs2);
				postApplicationMessage("List 2 unique:" + uniqueSeqs2);

				List<String> uniqueList3 = new LinkedList<>(list3);
				uniqueList3.removeAll(sharedList12);
				uniqueList3.removeAll(sharedList23);
				uniqueList3.removeAll(sharedList13);
				uniqueList3.removeAll(sharedList123);
				uniqueSeqs3 = uniqueList3.size();
				System.out.println("List 3 unique:" + uniqueSeqs3);
				postApplicationMessage("List 3 unique:" + uniqueSeqs3);

				worked(5);
				subTask("Finalizing counts");
				// Calculate numbers for parameters to be passed for Venn
				// Diagram
				seqs1Venn = seqCount1;
				seqs2Venn = seqCount2;
				seqs3Venn = seqCount3;
				seqs12shared = sharedSeqs12;
				seqs23shared = sharedSeqs23;
				seqs13shared = sharedSeqs13;
				seqs123shared = sharedSeqs123;

				postApplicationMessage("Generating list member ID table");
				Map<String, String> geneTable = new HashMap<>();
				for (String member : sharedList12) {
					geneTable.put(member, "Shared 1 & 2");
				}
				for (String member : sharedList23) {
					geneTable.put(member, "Shared 2 & 3");
				}
				for (String member : sharedList13) {
					geneTable.put(member, "Shared 1 & 3");
				}
				for (String member : sharedList123) {
					geneTable.put(member, "Shared All");
				}
				for (String member : uniqueList1) {
					geneTable.put(member, "List1");
				}
				for (String member : uniqueList2) {
					geneTable.put(member, "List2");
				}
				for (String member : uniqueList3) {
					geneTable.put(member, "List3");
				}

				CompareSequenceListObject me = new CompareSequenceListObject("SequenceIds", geneTable);
				postOutputResults(me);

				worked(6);

				// Server connection
				IServiceCloud sc = new SimpleServiceCloudImpl();

				// Getting results
				sc.setPackResultHandler(new IResultFSHandler() {

					@Override
					public void handleResult(FileSystem fs) {
						Path path = fs.getPath("venndiagram.svg");

						String content;
						try {
							content = new String(Files.readAllBytes(path));
							B2GHtml htmlObj4 = B2GHtml.newInstance("Venn Diagram", content);
							postOutputResults(htmlObj4);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

				postJobMessage("Sending parameters");
				// Sending parameters
				final IServiceCloudParameters scParameters = IServiceCloudParameters.create();
				scParameters.put("seqs1", String.valueOf(seqs1Venn));
				scParameters.put("seqs1Name", parameters.compareSequenceListString1.getValue());
				scParameters.put("seqs2", String.valueOf(seqs2Venn));
				scParameters.put("seqs2Name", parameters.compareSequenceListString2.getValue());
				scParameters.put("seqs3", String.valueOf(seqs3Venn));
				scParameters.put("seqs3Name", parameters.compareSequenceListString3.getValue());
				scParameters.put("seqs12shared", String.valueOf(seqs12shared));
				scParameters.put("seqs23shared", String.valueOf(seqs23shared));
				scParameters.put("seqs13shared", String.valueOf(seqs13shared));
				scParameters.put("seqs123shared", String.valueOf(seqs123shared));

				// send temporal files
				RequestPack requestPack;
				File parameterFile = File.createTempFile("parameters_", ".tmp");
				List<String> file = new ArrayList<>();
				if (parameterFile != null) {
					file.add(parameterFile.getAbsolutePath());
				}
				parameterFile.deleteOnExit();
				worked(7);

				// Server task
				postJobMessage("Creating venn diagram");

				requestPack = new RequestPack("venndiagram", scParameters.toKeyValueString(), file);
				sc.sendRequestPack(requestPack);

				String parametersKeyValue = scParameters.toKeyValueString();
				System.out.println(parametersKeyValue);

				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(parameterFile)))) {
					bw.write(parametersKeyValue);
				} catch (IOException e) {
					e.printStackTrace();
				}
				sc.waitForTermination();
				worked(8);
			}

			///////////// Pairwise Comparison ////////////////////////////////

			else {
				beginTask("Compare sequence lists", 6);
				postApplicationMessage("Counting List1 members");
	
				list1 = filepath.getIds();
				seqCount1 = list1.size();
				
				postApplicationMessage("Counting List2 members");
				
				list2 = filepath2.getIds();
				seqCount2 = list2.size();

				worked(1);
				// postApplicationMessage("Counting list members");

				List<String> sharedList = new LinkedList<>(list1);
				sharedList.retainAll(list2);
				sharedSeqs = sharedList.size();

				List<String> uniqueList1 = new LinkedList<>(list1);
				uniqueList1.removeAll(sharedList);
				uniqueSeqs1 = uniqueList1.size();

				List<String> uniqueList2 = new LinkedList<>(list2);
				uniqueList2.removeAll(sharedList);
				uniqueSeqs2 = uniqueList2.size();

				seqs1Venn = sharedSeqs + uniqueSeqs1;
				seqs2Venn = sharedSeqs + uniqueSeqs2;
				sharedSeqsVenn = sharedSeqs;

				worked(2);

				Map<String, String> geneTable = new HashMap<>();
				for (String member : sharedList) {
					geneTable.put(member, "Shared");
				}
				for (String member : uniqueList1) {
					geneTable.put(member, "List1");
				}
				for (String member : uniqueList2) {
					geneTable.put(member, "List2");
				}

				CompareSequenceListObject me = new CompareSequenceListObject("SequenceIds", geneTable);
				postOutputResults(me);

				System.out.println(geneTable);

				postApplicationMessage("Generating lists");

				worked(3);

				postApplicationMessage("Creating venn diagram");

				// Server connection
				IServiceCloud sc = new SimpleServiceCloudImpl();

				// Getting results
				sc.setPackResultHandler(new IResultFSHandler() {

					@Override
					public void handleResult(FileSystem fs) {
						Path path = fs.getPath("venndiagram.svg");

						String content;
						try {
							content = new String(Files.readAllBytes(path));
							B2GHtml htmlObj4 = B2GHtml.newInstance("Venn Diagram", content);
							postOutputResults(htmlObj4);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

				// Sending parameters
				final IServiceCloudParameters scParameters = IServiceCloudParameters.create();
				scParameters.put("seqs1", String.valueOf(seqs1Venn));
				scParameters.put("seqs1Name", parameters.compareSequenceListString1.getValue());
				scParameters.put("seqs2", String.valueOf(seqs2Venn));
				scParameters.put("seqs2Name", parameters.compareSequenceListString2.getValue());
				scParameters.put("shared", String.valueOf(sharedSeqsVenn));

				// send temporal files
				RequestPack requestPack;
				File parameterFile = File.createTempFile("parameters_", ".tmp");
				List<String> file = new ArrayList<>();
				if (parameterFile != null) {
					file.add(parameterFile.getAbsolutePath());
				}

				// parameterFile.deleteOnExit();

				// Server task
				requestPack = new RequestPack("venndiagram", scParameters.toKeyValueString(), file);
				sc.sendRequestPack(requestPack);

				String parametersKeyValue = scParameters.toKeyValueString();
				System.out.println(parametersKeyValue);

				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(parameterFile)))) {
					bw.write(parametersKeyValue);
				} catch (IOException e) {
					e.printStackTrace();
				}
				sc.waitForTermination();
				worked(4);
			}
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.out.println("unable to open files");
		}
	}
}
