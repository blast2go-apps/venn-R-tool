package com.example.compare.sequencelist.parameters;

import com.biobam.blast2go.api.datatype.basics.idlist.B2GIdList;
import com.biobam.blast2go.api.datatype.basics.idlist.B2GIdListUtils;
import com.biobam.blast2go.api.job.parameters.Parameters;
import com.biobam.blast2go.api.job.parameters.key.BooleanKey;
import com.biobam.blast2go.api.job.parameters.key.FileKey;
import com.biobam.blast2go.api.job.parameters.key.FileObjectKey;
import com.biobam.blast2go.api.job.parameters.key.IntegerKey;
import com.biobam.blast2go.api.job.parameters.key.MultipleFileKey;
import com.biobam.blast2go.api.job.parameters.key.StringKey;
import com.biobam.blast2go.api.job.parameters.key.additional.FileExtension;
import com.biobam.blast2go.api.job.parameters.key.additional.FileObjectTypeFilter;
import com.biobam.blast2go.api.job.parameters.key.validator.IntegerValidator;
import com.biobam.blast2go.api.job.parameters.key.validator.PathValidator;
import com.biobam.blast2go.api.job.parameters.key.validator.StringValidator;
import com.biobam.blast2go.api.job.parameters.keys.internal.ParameterKey;
import com.biobam.blast2go.api.core.utils.callback.CallBack;

public class CompareSequenceListParameters extends Parameters {

	public CompareSequenceListParameters() {
		add(compareSequenceListString1, compareSequenceListString2, compareSequenceListString3,
				compareSequenceListInteger, compareSequenceListFile, compareSequenceListFile2,
				compareSequenceListBoolean, compareSequenceListFile3, compareSequenceListFileObject1,
				compareSequenceListFileObject2, compareSequenceListFileObject3);
		// add(loadDataFile);
	}

	public StringKey compareSequenceListString1 = StringKey
			.builder(getBaseName("compareSequenceListString1"), "List1").setName("List 1 name")
			.setDescription("Name to be assigned to VennDiagram label").setMessage("Name the list")
			.setValidator(StringValidator.notEmptyString()).build();

	public StringKey compareSequenceListString2 = StringKey
			.builder(getBaseName("compareSequenceListString2"), "List2").setName("List 2 name")
			.setDescription("Name to be assigned to VennDiagram label").setMessage("Name the list")
			.setValidator(StringValidator.notEmptyString()).build();

	public StringKey compareSequenceListString3 = StringKey
			.builder(getBaseName("compareSequenceListString3"), "List3").setName("List 3 name")
			.setDescription("Name to be assigned to VennDiagram label").setMessage("Name the list")
			.setValidator(StringValidator.notEmptyString()).build();

	public StringKey compareSequenceListString4 = StringKey
			.builder(getBaseName("compareSequenceListString4"), "Sequence list name").setName("List 4 name")
			.setDescription("Name to be assigned to VennDiagram label").setMessage("Name the list")
			.setValidator(StringValidator.notEmptyString()).build();

	public IntegerKey compareSequenceListInteger = IntegerKey.builder("compareSequenceListInteger", 5)
			.setName("Number of sequence lists")
			.setDescription("An integer representing the number of sequence lists to be compared")
			.setDescription("The IntegerKey represents an integer value parameter.")
			.setMessage("Insert an integer value.").setValidator(IntegerValidator.inRange(2, 4)).build();

	public FileKey compareSequenceListFile = FileKey.builder(getBaseName("compareSequenceListParameters.FileKey"))
			.setName("Sequence list 1").setDescription("Tab delimited text file containing ID list")
			.setMessage("Select a file path or insert one").setDefaultValue(System.getProperty("user.home"))
			.addFileFilter(FileExtension.create(".*txt", "TEXT file"))
			.addFileFilter(FileExtension.create("*.xml", "XML file"))
			.addFileFilter(FileExtension.create("*.b2g", "B2G file")).addFileFilter(FileExtension.ALL_FILES)
			.setMessage("Choose a file").setValidator(PathValidator.existingFile()).build();

	public FileKey compareSequenceListFile2 = FileKey.builder(getBaseName("compareSequenceListParameters.FileKey2"))
			.setName("Sequence list 2").setDescription("Tab delimited text file containing ID list")
			.setMessage("Select a file path or insert one").setDefaultValue(System.getProperty("user.home"))
			.addFileFilter(FileExtension.create("*.txt", "TEXT file"))
			.addFileFilter(FileExtension.create("*.xml", "XML file"))
			.addFileFilter(FileExtension.create("*.b2g", "B2G file")).addFileFilter(FileExtension.ALL_FILES)
			.setMessage("Choose a file").setValidator(PathValidator.existingFile()).build();

	public FileKey compareSequenceListFile3 = FileKey.builder(getBaseName("compareSequenceListParameters.FileKey3"))
			.setName("Sequence list 3").setDescription("Tab delimited text files containing ID lists")
			.setMessage("Select the file path")
			// .setDefaultValue(System.getProperty("user.home"))
			.addFileFilter(FileExtension.create("*.txt", "TEXT file"))
			.addFileFilter(FileExtension.create("*.xml", "XML file"))
			.addFileFilter(FileExtension.create("*.b2g", "B2G file")).addFileFilter(FileExtension.ALL_FILES)
			.setMessage("Select Files")
			// .setValidator(PathValidator.existingFile())
			.build();

	public FileObjectKey compareSequenceListFileObject1 = FileObjectKey
			.builder(getBaseName("compareSequenceListFileObject.FileObjectKey1")).setName("List 1")
			.setDescription("Object containing B2G lists for comparison").setMessage("Select the file path")
			.addFileFilter(FileExtension.create("*.txt", "TXT file"))
			.addObjectFilter(new FileObjectTypeFilter(B2GIdList.class, "B2G Object"))
			.setParserCallback(B2GIdListUtils.createFromFileCallback()).setValidator(PathValidator.validFile()).build();

	public FileObjectKey compareSequenceListFileObject2 = FileObjectKey
			.builder(getBaseName("compareSequenceListFileObject.FileObjectKey2")).setName("List 2")
			.setDescription("Object containing B2G lists for comparison").setMessage("Select the file path")
			.addFileFilter(FileExtension.create("*.txt", "TXT file"))
			.addObjectFilter(new FileObjectTypeFilter(B2GIdList.class, "B2G Object"))
			.setParserCallback(B2GIdListUtils.createFromFileCallback()).setValidator(PathValidator.validFile()).build();

	public FileObjectKey compareSequenceListFileObject3 = FileObjectKey
			.builder(getBaseName("compareSequenceListFileObject.FileObjectKey3")).setName("List 3")
			.setDescription("Object containing B2G lists for comparison").setMessage("Select the file path")
			.addFileFilter(FileExtension.create("*.txt", "TXT file"))
			.addObjectFilter(new FileObjectTypeFilter(B2GIdList.class, "B2G Object"))
			.setParserCallback(B2GIdListUtils.createFromFileCallback()).setValidator(PathValidator.validFile()).build();

	public BooleanKey compareSequenceListBoolean = BooleanKey.builder("compareSequenceListParameters.Boolean", true)
			.setName("My BooleanKey").setDescription("My BooleanKey Description").setMessage("BooleanKey Message")
			.build();

	@Override
	public boolean isEnabled(ParameterKey<?> parameterKey) {
		if (parameterKey == compareSequenceListString3){
			return compareSequenceListBoolean.getValue();
		}
		if (parameterKey == compareSequenceListFileObject3){
			return compareSequenceListBoolean.getValue();
		}
		// TODO Auto-generated method stub
		return super.isEnabled(parameterKey);
	}

}

// public ListKey compareSequenceListKey=ListKey<T>.builder(id, class, values,
// defaultValue)
