.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.security InvalidParameterException

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.data.dataset.format ConversionStandardToInputConfiguration

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatParser

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryMoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

.. java:import:: de.clusteval.utils FormatConversionException

.. java:import:: de.clusteval.utils NamedDoubleAttribute

.. java:import:: de.clusteval.utils NamedIntegerAttribute

.. java:import:: de.clusteval.utils RNotAvailableException

DataSet
=======

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public abstract class DataSet extends RepositoryObject

   A wrapper class for a dataset on the filesystem.

   A dataset corresponds to and is parsed from a file on the filesystem in the corresponding folder of the repository (see \ :java:ref:`Repository.basePath`\  and \ :java:ref:`DataSetFinder`\ ).

   When a program should be applied to a certain dataset during a run, the dataset is not directly used by the run but instead a \ :java:ref:`DataSetConfig`\  is referenced, which encapsulates a dataset together with some settings.

   :author: Christian Wiwie

Fields
------
alias
^^^^^

.. java:field:: protected String alias
   :outertype: DataSet

   Every data set needs an alias, that is used to represent the data set as a short string, for example on the website.

checksum
^^^^^^^^

.. java:field:: protected long checksum
   :outertype: DataSet

   The checksum of a dataset is used to check a dataset for changes and to check two datasets for equality.

datasetFormat
^^^^^^^^^^^^^

.. java:field:: protected DataSetFormat datasetFormat
   :outertype: DataSet

   The format of this dataset. The format for a dataset is required by the framework in order for it to be able to convert it to the internal standard format.

   When a dataset is used during a run, it is first converted from its original dataset format to the internal standard format. Then it is converted to the input format required by the clustering method.

datasetType
^^^^^^^^^^^

.. java:field:: protected DataSetType datasetType
   :outertype: DataSet

   The type of the dataset is used to categorize the datasets.

originalDataSet
^^^^^^^^^^^^^^^

.. java:field:: protected DataSet originalDataSet
   :outertype: DataSet

   When a dataset is used during a run, it first is converted to the internal standard format and afterwards into the format required by the clustering method. This attribute holds the original unconverted dataset.

thisInStandardFormat
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected DataSet thisInStandardFormat
   :outertype: DataSet

   When a dataset is used during a run, it first is converted to the internal standard format and afterwards into the format required by the clustering method. This attribute holds the version of this dataset in the standard format.

websiteVisibility
^^^^^^^^^^^^^^^^^

.. java:field:: protected WEBSITE_VISIBILITY websiteVisibility
   :outertype: DataSet

Constructors
------------
DataSet
^^^^^^^

.. java:constructor:: public DataSet(Repository repository, boolean register, long changeDate, File absPath, String alias, DataSetFormat dsFormat, DataSetType dsType, WEBSITE_VISIBILITY websiteVisibility) throws RegisterException
   :outertype: DataSet

   Instantiates a new dataset object.

   :param repository: The repository this dataset should be registered at.
   :param register: Whether this dataset should be registered in the repository.
   :param changeDate: The change date of this dataset is used for equality checks.
   :param absPath: The absolute path of this dataset.
   :param alias: A short alias name for this data set.
   :param dsFormat: The format of this dataset.
   :param dsType: The type of this dataset
   :throws RegisterException:

DataSet
^^^^^^^

.. java:constructor:: public DataSet(DataSet dataset) throws RegisterException
   :outertype: DataSet

   Copy constructor for the DataSet class.

   :param dataset: the dataset to be cloned
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract DataSet clone()
   :outertype: DataSet

convertStandardToDirectly
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected DataSet convertStandardToDirectly(Context context, DataSetFormat targetFormat, ConversionStandardToInputConfiguration configStandardToInput) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException, FormatConversionException
   :outertype: DataSet

   This method is a helper method to convert a dataset in a internal standard format to a target format directly, that means using one conversion step.

   :param targetFormat: This is the format, the dataset is expected to be in after the conversion process. After the dataset is converted to the internal format, it is converted to the target format.
   :param configStandardToInput: This is the configuration that is used during the conversion from the internal standard format to the target format.
   :throws UnknownDataSetFormatException:
   :throws IOException: Signals that an I/O exception has occurred.
   :throws InvalidDataSetFormatVersionException:
   :throws FormatConversionException:
   :throws RegisterException:
   :return: The dataset in the target format.

convertToStandardDirectly
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected DataSet convertToStandardDirectly(Context context, ConversionInputToStandardConfiguration configInputToStandard) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException, InvalidParameterException, RNotAvailableException, InterruptedException
   :outertype: DataSet

   This method is a helper method to convert a dataset in its original format to a internal standard format directly, that means using one conversion step.

   :param dsFormat: This is the format, the dataset is expected to be in after the conversion process. After the dataset is converted to the internal format, it is converted to the target format.
   :param configInputToStandard: This is the configuration that is used during the conversion from the original format to the internal standard format.
   :throws InterruptedException:
   :throws InvalidParameterException:
   :throws UnknownDataSetFormatException:
   :throws IOException: Signals that an I/O exception has occurred.
   :throws RNotAvailableException:
   :throws InvalidDataSetFormatVersionException:
   :throws RegisterException:
   :return: The dataset in the target format.

copyTo
^^^^^^

.. java:method:: @Override public boolean copyTo(File copyDestination, boolean overwrite)
   :outertype: DataSet

copyTo
^^^^^^

.. java:method:: @Override public boolean copyTo(File copyDestination, boolean overwrite, boolean updateAbsolutePath)
   :outertype: DataSet

copyToFolder
^^^^^^^^^^^^

.. java:method:: @Override public boolean copyToFolder(File copyFolderDestination, boolean overwrite)
   :outertype: DataSet

extractDataSetAttributes
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Deprecated protected static Map<String, String> extractDataSetAttributes(File absPath) throws IOException
   :outertype: DataSet

   This method parses the header of a dataset file. A header is required for a dataset file to be recognized by the framework as a valid dataset file. If the file does not contain any header lines, it is ignored by the framework. A header line is of the form '// attribute = value'. The header should contain several lines:

   The type of the dataset, e.g. '// dataSetType = GeneExpressionDataSetType'

   The format of the dataset, e.g. '// dataSetFormat = RowSimDataSetFormat'

   The version of the dataset format, e.g. '// dataSetFormatVersion = 1'

   :param absPath:
   :throws IOException:

getAlias
^^^^^^^^

.. java:method:: public String getAlias()
   :outertype: DataSet

   :return: The alias of this data set.

   **See also:** :java:ref:`.alias`

getChecksum
^^^^^^^^^^^

.. java:method:: public long getChecksum()
   :outertype: DataSet

   :return: Checksum of this dataset

   **See also:** :java:ref:`.checksum`

getDataSetContent
^^^^^^^^^^^^^^^^^

.. java:method:: public abstract Object getDataSetContent()
   :outertype: DataSet

   This method does not load the content of the dataset into memory, it just assumes that it has been loaded before and returns the reference.

   :return: The content of this dataset.

getDataSetFormat
^^^^^^^^^^^^^^^^

.. java:method:: public DataSetFormat getDataSetFormat()
   :outertype: DataSet

   Gets the dataset format.

   :return: The dataset format

   **See also:** :java:ref:`DataSet.datasetFormat`

getDataSetType
^^^^^^^^^^^^^^

.. java:method:: public DataSetType getDataSetType()
   :outertype: DataSet

   :return: The type of this dataset.

   **See also:** :java:ref:`.datasetType`

getFullName
^^^^^^^^^^^

.. java:method:: public String getFullName()
   :outertype: DataSet

   Gets the full name of this dataset. The full name consists of the minor and the major name, separated by a slash: MAJOR/MINOR

   :return: The full name

getIds
^^^^^^

.. java:method:: public abstract List<String> getIds()
   :outertype: DataSet

   :return: The object ids contained in the dataset.

getInStandardFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: public DataSet getInStandardFormat()
   :outertype: DataSet

   :return: This dataset in the internal standard format.

   **See also:** :java:ref:`.thisInStandardFormat`

getMajorName
^^^^^^^^^^^^

.. java:method:: public String getMajorName()
   :outertype: DataSet

   Gets the major name of this dataset. The major name corresponds to the folder the dataset resides in in the filesystem.

   :return: The major name

getMinorName
^^^^^^^^^^^^

.. java:method:: public String getMinorName()
   :outertype: DataSet

   Gets the minor name of this dataset. The minor name corresponds to the name of the file of this dataset.

   :return: The minor name

getOriginalDataSet
^^^^^^^^^^^^^^^^^^

.. java:method:: public DataSet getOriginalDataSet()
   :outertype: DataSet

   :return: This dataset in its original format.

   **See also:** :java:ref:`.originalDataSet`

getWebsiteVisibility
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public WEBSITE_VISIBILITY getWebsiteVisibility()
   :outertype: DataSet

isInMemory
^^^^^^^^^^

.. java:method:: public abstract boolean isInMemory()
   :outertype: DataSet

   Checks whether this dataset is loaded into the memory.

   :return: true, if is in memory

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: public boolean loadIntoMemory() throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, UnknownDataSetFormatException
   :outertype: DataSet

   Load this dataset into memory. When this method is invoked, it parses the dataset file on the filesystem using the \ :java:ref:`DataSetFormatParser.parse(DataSet)`\  method corresponding to the dataset format of this dataset. Then the contents of the dataset is stored in a member variable. Depending on whether this dataset is relative or absolute, this member variable varies: For absolute datasets the data is stored in \ :java:ref:`AbsoluteDataSet.dataMatrix`\ , for relative datasets in \ :java:ref:`RelativeDataSet.similarities`\

   :throws IllegalArgumentException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws InvalidDataSetFormatVersionException:
   :return: true, if successful

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: public abstract boolean loadIntoMemory(NUMBER_PRECISION precision) throws UnknownDataSetFormatException, IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: DataSet

   Load this dataset into memory. When this method is invoked, it parses the dataset file on the filesystem using the \ :java:ref:`DataSetFormatParser.parse(DataSet)`\  method corresponding to the dataset format of this dataset. Then the contents of the dataset is stored in a member variable. Depending on whether this dataset is relative or absolute, this member variable varies: For absolute datasets the data is stored in \ :java:ref:`AbsoluteDataSet.dataMatrix`\ , for relative datasets in \ :java:ref:`RelativeDataSet.similarities`\

   :throws IllegalArgumentException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws InvalidDataSetFormatVersionException:
   :return: true, if successful

moveTo
^^^^^^

.. java:method:: @Override public boolean moveTo(File targetFile, boolean overwrite)
   :outertype: DataSet

   Move this dataset to a new location.

   If the overwrite parameter is true and the target file exists already, it is overwritten.

   :param targetFile: A file object wrapping the absolute path of the destination this dataset should be moved to.
   :param overwrite: A boolean indicating, whether to overwrite a possibly existing target file.
   :return: True, if this dataset has been moved successfully.

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: DataSet

preprocessAndConvertTo
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public DataSet preprocessAndConvertTo(Context context, DataSetFormat targetFormat, ConversionInputToStandardConfiguration configInputToStandard, ConversionStandardToInputConfiguration configStandardToInput) throws FormatConversionException, IOException, InvalidDataSetFormatVersionException, RegisterException, RNotAvailableException, InterruptedException
   :outertype: DataSet

   This method converts this dataset to a target format:

   First this dataset is converted to a internal standard format (depending on the type of the Run). Then it is converted to the target format.

   :param context:
   :param targetFormat: This is the format, the dataset is expected to be in after the conversion process. After the dataset is converted to the internal format, it is converted to the target format.
   :param configInputToStandard: This is the configuration that is used during the conversion from the original format to the internal standard format.
   :param configStandardToInput: This is the configuration that is used during the conversion from the internal standard format to the target format.
   :throws InterruptedException:
   :throws InvalidDataSetFormatVersionException:
   :throws IOException:
   :throws RNotAvailableException:
   :throws FormatConversionException:
   :throws RegisterException:
   :return: The dataset in the target format.

setAbsolutePath
^^^^^^^^^^^^^^^

.. java:method:: @Override public void setAbsolutePath(File absFilePath)
   :outertype: DataSet

setDataSetContent
^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean setDataSetContent(Object newContent)
   :outertype: DataSet

   This method sets the content of this dataset in memory to a new object. Contents on file system are not refreshed.

   :param newContent: The new content of this dataset.
   :return: True, if the content of this dataset has been updated to the new object.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: DataSet

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean unloadFromMemory()
   :outertype: DataSet

   Unload the contents of this dataset from memory.

   :return: true, if successful

writeToFile
^^^^^^^^^^^

.. java:method:: public boolean writeToFile(boolean withHeader)
   :outertype: DataSet

   This method writes the contents of this dataset to the file denoted by the \ :java:ref:`getAbsolutePath()`\ .

   :param withHeader: Whether to write a header into the dataset file.
   :return: True, if the writing was succesfull

