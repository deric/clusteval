.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: utils ArraysExt

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: utils.parse SimFileMatrixParser

.. java:import:: utils.parse SimFileParser.SIM_FILE_FORMAT

.. java:import:: utils.parse SimilarityFileNormalizer

.. java:import:: utils.parse TextFileParser

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetAttributeFilterer

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils FormatVersion

TransClustSimMatrixDataSetFormatParser
======================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class TransClustSimMatrixDataSetFormatParser extends DataSetFormatParser

   :author: Christian Wiwie

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public DataSet convertToStandardFormat(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException
   :outertype: TransClustSimMatrixDataSetFormatParser

convertToStandardFormat_v1
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected DataSet convertToStandardFormat_v1(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, RegisterException, UnknownDataSetFormatException
   :outertype: TransClustSimMatrixDataSetFormatParser

convertToThisFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config)
   :outertype: TransClustSimMatrixDataSetFormatParser

parse
^^^^^

.. java:method:: @Override protected SimilarityMatrix parse(DataSet dataSet, NUMBER_PRECISION precision) throws IOException, InvalidDataSetFormatVersionException
   :outertype: TransClustSimMatrixDataSetFormatParser

parse_v1
^^^^^^^^

.. java:method:: protected SimilarityMatrix parse_v1(DataSet dataSet, NUMBER_PRECISION precision) throws IOException
   :outertype: TransClustSimMatrixDataSetFormatParser

writeToFileHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void writeToFileHelper(DataSet dataSet, BufferedWriter writer)
   :outertype: TransClustSimMatrixDataSetFormatParser

