.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.security InvalidParameterException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: utils Pair

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: utils.parse TextFileParser

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetAttributeParser

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.utils FormatVersion

.. java:import:: de.clusteval.utils RNotAvailableException

MatrixDataSetFormatParser
=========================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class MatrixDataSetFormatParser extends DataSetFormatParser

   :author: Christian Wiwie

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSet convertToStandardFormat(DataSet dataSet, ConversionInputToStandardConfiguration config) throws IOException, RegisterException, UnknownDataSetFormatException, InvalidParameterException, RNotAvailableException, InterruptedException
   :outertype: MatrixDataSetFormatParser

convertToThisFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected DataSet convertToThisFormat(DataSet dataSet, DataSetFormat dataSetFormat, ConversionConfiguration config) throws InvalidDataSetFormatVersionException
   :outertype: MatrixDataSetFormatParser

parse
^^^^^

.. java:method:: @Override protected DataMatrix parse(DataSet dataSet, NUMBER_PRECISION precision) throws IOException
   :outertype: MatrixDataSetFormatParser

writeToFileHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void writeToFileHelper(DataSet dataSet, BufferedWriter writer) throws IOException
   :outertype: MatrixDataSetFormatParser

