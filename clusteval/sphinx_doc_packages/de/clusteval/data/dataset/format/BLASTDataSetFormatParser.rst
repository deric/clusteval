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

BLASTDataSetFormatParser
========================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class BLASTDataSetFormatParser extends DataSetFormatParser

   :author: Christian Wiwie

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSet convertToStandardFormat(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException
   :outertype: BLASTDataSetFormatParser

convertToStandardFormat_v1
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected DataSet convertToStandardFormat_v1(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, RegisterException, UnknownDataSetFormatException
   :outertype: BLASTDataSetFormatParser

convertToThisFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config)
   :outertype: BLASTDataSetFormatParser

parse
^^^^^

.. java:method:: @Override protected SimilarityMatrix parse(DataSet dataSet, NUMBER_PRECISION precision) throws IOException, InvalidDataSetFormatVersionException
   :outertype: BLASTDataSetFormatParser

parse_v1
^^^^^^^^

.. java:method:: protected SimilarityMatrix parse_v1(DataSet dataSet, NUMBER_PRECISION precision) throws IOException
   :outertype: BLASTDataSetFormatParser

writeToFileHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void writeToFileHelper(DataSet dataSet, BufferedWriter writer)
   :outertype: BLASTDataSetFormatParser

