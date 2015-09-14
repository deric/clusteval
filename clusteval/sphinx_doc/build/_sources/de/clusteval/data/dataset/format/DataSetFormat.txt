.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.security InvalidParameterException

.. java:import:: java.util ArrayList

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.utils RNotAvailableException

.. java:import:: file FileUtils

DataSetFormat
=============

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public abstract class DataSetFormat extends RepositoryObject

   Datasets can have different formats. For all kinds of operations the framework needs to know which format a dataset has and how it can be converted to an understandable (standard) format.

   Every dataset format comes together with a parser class (see \ :java:ref:`DataSetFormatParser`\ ).

   A data set format MyDataSetFormat can be added to ClustEval by

   1. extending the class de.clusteval.data.dataset.format.DataSetFormat with your own class MyDataSetFormat. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your dataset format.

     * :java:ref:`DataSetFormat(Repository, boolean, long, File, int)`: The constructor of your dataset format class. This constructor has to be implemented and public, otherwise the framework will not be able to load your dataset format.
     * :java:ref:`DataSetFormat(DataSetFormat)`: The copy constructor of your class taking another instance of your class. This constructor has to be implemented and public.

   2. extending the class de.clusteval.data.dataset.format.DataSetFormatParser with your own class MyDataSetFormatParser. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your class.

     * :java:ref:`convertToStandardFormat(DataSet, ConversionInputToStandardConfiguration)`: This method converts the given dataset to the standard input format of the framework using the given conversion configuration. This assumes, that the passed dataset has this format.
     * :java:ref:`convertToThisFormat(DataSet, DataSetFormat, ConversionConfiguration)`: This method converts the given dataset to the given input format using the conversion configuration.
     * :java:ref:`parse(DataSet)`: This method parses the given dataset and returns an object, wrapping the contents of the dataset (e.g. an instance of SimilarityMatrix or DataMatrix ).

   3. Creating a jar file named MyDataSetFormat.jar containing the MyDataSetFormat.class and MyDataSetFormatParser.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/data/dataset/format/MyDataSetFormat.class
     * de/clusteval/data/dataset/format/MyDataSetFormatParser.class

   4. Putting the MyDataSetFormat.jar into the dataset formats folder of the repository:

     * <REPOSITORY ROOT>/supp/formats/dataset
     * The backend server will recognize and try to load the new dataset format automatically the next time, the :java:ref:`DataSetFormatFinderThread` checks the filesystem.

   :author: Christian Wiwie

Constructors
------------
DataSetFormat
^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: DataSetFormat

   Instantiates a new dataset format with the given version.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version: The version of the dataset format.
   :throws RegisterException:

DataSetFormat
^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormat(DataSetFormat other) throws RegisterException
   :outertype: DataSetFormat

   The copy constructor of dataset formats.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final DataSetFormat clone()
   :outertype: DataSetFormat

cloneDataSetFormats
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<DataSetFormat> cloneDataSetFormats(List<DataSetFormat> dataSetFormats)
   :outertype: DataSetFormat

   This method returns a deep copy of the given list of dataset formats, i.e. the objects of the list are also cloned.

   :param dataSetFormats: The list of dataset formats to clone.
   :return: The cloned list of dataset formats.

convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public final DataSet convertToStandardFormat(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException, RNotAvailableException, InvalidParameterException, InterruptedException
   :outertype: DataSetFormat

   Convert the given dataset with this dataset format and the given version using the passed configuration.

   This method validates, that the passed dataset has the correct format and that the version of the format is supported.

   :param dataSet: The dataset to convert to the standard format.
   :param config: The configuration to use to convert the passed dataset.
   :throws InterruptedException:
   :throws InvalidParameterException:
   :throws UnknownDataSetFormatException:
   :throws IOException: Signals that an I/O exception has occurred.
   :throws RNotAvailableException:
   :throws InvalidDataSetFormatVersionException:
   :throws RegisterException:
   :return: The converted dataset.

convertToThisFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: public final DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException
   :outertype: DataSetFormat

   Convert the given dataset to the given dataset format (this format) using the passed configuration.

   The passed dataset format object has to be of this class and is used only for its version and normalize attributes.

   This method validates, that the passed dataset format to convert the dataset to is correct and that the version of the format is supported.

   :param dataSet: The dataset to convert to the standard format.
   :param dataSetFormat: The dataset format to convert the dataset to.
   :param config: The configuration to use to convert the passed dataset.
   :throws UnknownDataSetFormatException:
   :throws IOException: Signals that an I/O exception has occurred.
   :throws InvalidDataSetFormatVersionException:
   :throws RegisterException:
   :return: The converted dataset.

copyDataSetTo
^^^^^^^^^^^^^

.. java:method:: public boolean copyDataSetTo(DataSet dataSet, File copyDestination, boolean overwrite)
   :outertype: DataSetFormat

   This method copies the given dataset to the given target file, assuming that the format of the dataset is this dataset format.

   :param dataSet: The dataset to copy to the target file destination.
   :param copyDestination: The target file to which to copy the given dataset.
   :param overwrite: Whether to overwrite the possibly already existing target file.
   :return: True, if the copy operation was successful.

copyDataSetToFolder
^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean copyDataSetToFolder(DataSet dataSet, File copyFolderDestination, boolean overwrite)
   :outertype: DataSetFormat

   This method copies the given dataset into the given target folder, assuming that the format of the dataset is this dataset format.

   :param dataSet: The dataset to copy to the target file destination.
   :param copyFolderDestination: The target folder to which into copy the given dataset.
   :param overwrite: Whether to overwrite the possibly already existing target file.
   :return: True, if the copy operation was successful.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: DataSetFormat

getAlias
^^^^^^^^

.. java:method:: public abstract String getAlias()
   :outertype: DataSetFormat

   This alias is used whenever this dataset format is visually represented and a readable name is needed.

   :return: The alias of this dataset format.

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract DataSetFormatParser getDataSetFormatParser()
   :outertype: DataSetFormat

   :return: An instance of the dataset format parser corresponding to this dataset format class.

getNormalized
^^^^^^^^^^^^^

.. java:method:: public boolean getNormalized()
   :outertype: DataSetFormat

   :return: Whether this dataset is normalized.

getVersion
^^^^^^^^^^

.. java:method:: public int getVersion()
   :outertype: DataSetFormat

   :return: The version number of the dataset format.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: DataSetFormat

moveDataSetTo
^^^^^^^^^^^^^

.. java:method:: public boolean moveDataSetTo(DataSet dataSet, File moveDestination, boolean overwrite)
   :outertype: DataSetFormat

   This method copies the given dataset to the given target file, assuming that the format of the dataset is this dataset format.

   :param dataSet: The dataset to copy to the target file destination.
   :param moveDestination: The target file to which to copy the given dataset.
   :param overwrite: Whether to overwrite the possibly already existing target file.
   :return: True, if the copy operation was successful.

parse
^^^^^

.. java:method:: public Object parse(DataSet dataSet, NUMBER_PRECISION precision) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: DataSetFormat

   :param dataSet: The dataset to be parsed.
   :throws IllegalArgumentException:
   :throws IOException:
   :throws InvalidDataSetFormatVersionException:
   :return: A wrapper object containing the contents of the dataset

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataSetFormat parseFromString(Repository repository, String datasetFormat, int formatVersion) throws UnknownDataSetFormatException
   :outertype: DataSetFormat

   This method parses a dataset format from the given string, containing a dataset format class name and a given dataset format version.

   :param repository: The repository where to look up the dataset format class.
   :param datasetFormat: The dataset format class name as string.
   :param formatVersion: The version of the dataset format.
   :throws UnknownDataSetFormatException:
   :return: The parsed dataset format.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataSetFormat parseFromString(Repository repository, String datasetFormat) throws UnknownDataSetFormatException
   :outertype: DataSetFormat

   This method parses a dataset format from the given string, containing a dataset format class name.

   :param repository: The repository where to look up the dataset format class.
   :param datasetFormat: The dataset format class name as string.
   :throws UnknownDataSetFormatException:
   :return: The parsed dataset format.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<DataSetFormat> parseFromString(Repository repo, String[] datasetFormats) throws UnknownDataSetFormatException
   :outertype: DataSetFormat

   This method parses several dataset formats from a string array.

   This is a convenience method for \ :java:ref:`parseFromString(Repository,String)`\ .

   :param repo: the repo
   :param datasetFormats: the dataset formats
   :throws UnknownDataSetFormatException: the unknown data set format exception
   :return: the list

setNormalized
^^^^^^^^^^^^^

.. java:method:: public void setNormalized(boolean normalized)
   :outertype: DataSetFormat

   :param normalized: Whether this dataset is normalized.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: DataSetFormat

writeToFile
^^^^^^^^^^^

.. java:method:: public boolean writeToFile(DataSet dataSet, boolean withHeader)
   :outertype: DataSetFormat

   :param dataSet: The dataset to be written to the filesystem.
   :param withHeader: Whether to write the header into the dataset file.
   :return: True, if the dataset has been written to filesystem successfully.

