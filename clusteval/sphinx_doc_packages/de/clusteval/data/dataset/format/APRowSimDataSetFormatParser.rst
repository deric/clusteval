.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: utils.parse SimFileMatrixParser

.. java:import:: utils.parse SimFileParser

.. java:import:: utils.parse SimFileParser.SIM_FILE_FORMAT

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetAttributeParser

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils FormatVersion

APRowSimDataSetFormatParser
===========================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class APRowSimDataSetFormatParser extends DataSetFormatParser

   :author: Christian Wiwie

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected DataSet convertToStandardFormat(DataSet ds, ConversionInputToStandardConfiguration config)
   :outertype: APRowSimDataSetFormatParser

convertToThisFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException
   :outertype: APRowSimDataSetFormatParser

convertToThisFormat_v1
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected DataSet convertToThisFormat_v1(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config) throws IOException, RegisterException, UnknownDataSetFormatException
   :outertype: APRowSimDataSetFormatParser

parse
^^^^^

.. java:method:: @SuppressWarnings @Override protected SimilarityMatrix parse(DataSet dataSet, NUMBER_PRECISION precision)
   :outertype: APRowSimDataSetFormatParser

writeToFileHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void writeToFileHelper(DataSet dataSet, BufferedWriter writer)
   :outertype: APRowSimDataSetFormatParser

