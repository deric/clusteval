.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.security InvalidParameterException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils RNotAvailableException

DataSetFormatParser
===================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public abstract class DataSetFormatParser

   :author: Christian Wiwie

Fields
------
log
^^^

.. java:field:: protected Logger log
   :outertype: DataSetFormatParser

   The log.

normalize
^^^^^^^^^

.. java:field:: protected boolean normalize
   :outertype: DataSetFormatParser

version
^^^^^^^

.. java:field:: protected int version
   :outertype: DataSetFormatParser

Constructors
------------
DataSetFormatParser
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormatParser()
   :outertype: DataSetFormatParser

   Instantiates a new data set format parser.

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract DataSet convertToStandardFormat(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException, RNotAvailableException, InvalidParameterException, InterruptedException
   :outertype: DataSetFormatParser

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

.. java:method:: protected abstract DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException
   :outertype: DataSetFormatParser

   Convert the given dataset to the given dataset format (this format) using the passed configuration.

   The passed dataset format object has to be of this class and is used only for its version and normalize attributes.

   This method validates, that the passed dataset format to convert the dataset to is correct and that the version of the format is supported.

   :param dataSet: The dataset to convert to the standard format.
   :param config: The configuration to use to convert the passed dataset.
   :throws UnknownDataSetFormatException:
   :throws IOException: Signals that an I/O exception has occurred.
   :throws InvalidDataSetFormatVersionException:
   :throws RegisterException:
   :return: The converted dataset.

parse
^^^^^

.. java:method:: protected abstract Object parse(DataSet dataSet, NUMBER_PRECISION precision) throws IOException, InvalidDataSetFormatVersionException
   :outertype: DataSetFormatParser

   :param dataSet: The dataset to be parsed.
   :param precision: The precision with which to store the similarities in memory.
   :throws IllegalArgumentException:
   :throws IOException:
   :throws InvalidDataSetFormatVersionException:
   :return: A wrapper object containing the contents of the dataset

removeResultFileNameSuffix
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static String removeResultFileNameSuffix(String resultFileName)
   :outertype: DataSetFormatParser

   Removes the result file name suffix.

   :param resultFileName: the result file name
   :return: the string

setNormalize
^^^^^^^^^^^^

.. java:method:: public void setNormalize(boolean normalize)
   :outertype: DataSetFormatParser

   :param normalize: Whether this dataset should be normalized.

writeHeaderIntoFile
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected final void writeHeaderIntoFile(DataSet dataSet, BufferedWriter writer) throws IOException
   :outertype: DataSetFormatParser

writeToFile
^^^^^^^^^^^

.. java:method:: protected final boolean writeToFile(DataSet dataSet, boolean withHeader)
   :outertype: DataSetFormatParser

   This method writes the contents of the dataset hold in memory to the filesystem.

   This method assumes, that the data set has the correct format and that the dataset is loaded into memory. If any of these conditions does not hold, nothing is written to the filesystem.

   :param dataSet:

writeToFileHelper
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract void writeToFileHelper(DataSet dataSet, BufferedWriter writer) throws IOException
   :outertype: DataSetFormatParser

