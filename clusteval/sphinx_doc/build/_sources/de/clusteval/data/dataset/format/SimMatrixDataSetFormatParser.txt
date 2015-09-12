.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: utils.parse SimFileMatrixParser

.. java:import:: utils.parse SimFileParser.SIM_FILE_FORMAT

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils FormatVersion

SimMatrixDataSetFormatParser
============================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class SimMatrixDataSetFormatParser extends DataSetFormatParser

   :author: Christian Wiwie

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected DataSet convertToStandardFormat(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException
   :outertype: SimMatrixDataSetFormatParser

convertToThisFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config) throws IOException, InvalidDataSetFormatVersionException, RegisterException
   :outertype: SimMatrixDataSetFormatParser

parse
^^^^^

.. java:method:: @Override protected SimilarityMatrix parse(DataSet dataSet, NUMBER_PRECISION precision) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: SimMatrixDataSetFormatParser

writeToFileHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void writeToFileHelper(DataSet dataSet, BufferedWriter writer) throws IOException
   :outertype: SimMatrixDataSetFormatParser

