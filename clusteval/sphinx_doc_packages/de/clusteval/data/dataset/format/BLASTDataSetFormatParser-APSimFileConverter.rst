.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: utils.parse SimFileMatrixParser

.. java:import:: utils.parse SimFileParser.ID_FILE_FORMAT

.. java:import:: utils.parse SimFileParser.SIM_FILE_FORMAT

.. java:import:: utils.parse SimilarityFileNormalizer

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetAttributeFilterer

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils FormatVersion

.. java:import:: de.costmatrixcreation.main Args

.. java:import:: de.costmatrixcreation.main Config

.. java:import:: de.costmatrixcreation.main Creator

BLASTDataSetFormatParser.APSimFileConverter
===========================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type::  class APSimFileConverter extends SimFileMatrixParser
   :outertype: BLASTDataSetFormatParser

Fields
------
mappingWriter
^^^^^^^^^^^^^

.. java:field:: protected BufferedWriter mappingWriter
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

Constructors
------------
APSimFileConverter
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APSimFileConverter(String absFilePath, SIM_FILE_FORMAT simFileFormat, String absIdFilePath, ID_FILE_FORMAT idFileFormat, String outputFile, OUTPUT_MODE outputMode, SIM_FILE_FORMAT outputFormat) throws IOException
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

   :param absFilePath:
   :param simFileFormat:
   :param absIdFilePath:
   :param idFileFormat:
   :param outputFile:
   :param outputMode:
   :param outputFormat:
   :throws IOException:

Methods
-------
closeStreams
^^^^^^^^^^^^

.. java:method:: @Override protected void closeStreams() throws IOException
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

finishProcess
^^^^^^^^^^^^^

.. java:method:: @Override public void finishProcess()
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

getIdForKey
^^^^^^^^^^^

.. java:method:: @Override public int getIdForKey(String key)
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

resetReader
^^^^^^^^^^^

.. java:method:: @Override protected void resetReader() throws IOException
   :outertype: BLASTDataSetFormatParser.APSimFileConverter

