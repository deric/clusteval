.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: utils.parse SimFileMatrixParser

.. java:import:: utils.parse SimFileParser.SIM_FILE_FORMAT

.. java:import:: utils.parse SimilarityFileNormalizer

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetAttributeFilterer

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils FormatVersion

RowSimDataSetFormatParser.APSimFileConverter
============================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type::  class APSimFileConverter extends SimFileMatrixParser
   :outertype: RowSimDataSetFormatParser

   The Class APSimFileConverter.

Fields
------
mappingWriter
^^^^^^^^^^^^^

.. java:field:: protected BufferedWriter mappingWriter
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

   The mapping writer.

Constructors
------------
APSimFileConverter
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APSimFileConverter(String absFilePath, SIM_FILE_FORMAT simFileFormat, String absIdFilePath, ID_FILE_FORMAT idFileFormat, String outputFile, OUTPUT_MODE outputMode, SIM_FILE_FORMAT outputFormat) throws IOException
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

   Instantiates a new aP sim file converter.

   :param absFilePath: the abs file path
   :param simFileFormat: the sim file format
   :param absIdFilePath: the abs id file path
   :param idFileFormat: the id file format
   :param outputFile: the output file
   :param outputMode: the output mode
   :param outputFormat: the output format
   :throws IOException: Signals that an I/O exception has occurred.

Methods
-------
closeStreams
^^^^^^^^^^^^

.. java:method:: @Override protected void closeStreams() throws IOException
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

finishProcess
^^^^^^^^^^^^^

.. java:method:: @Override public void finishProcess()
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

getIdForKey
^^^^^^^^^^^

.. java:method:: @Override public int getIdForKey(String key)
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

resetReader
^^^^^^^^^^^

.. java:method:: @Override protected void resetReader() throws IOException
   :outertype: RowSimDataSetFormatParser.APSimFileConverter

