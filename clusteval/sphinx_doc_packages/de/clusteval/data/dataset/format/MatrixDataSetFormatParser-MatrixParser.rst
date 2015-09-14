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

MatrixDataSetFormatParser.MatrixParser
======================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type::  class MatrixParser extends TextFileParser
   :outertype: MatrixDataSetFormatParser

Fields
------
idToCoordinates
^^^^^^^^^^^^^^^

.. java:field:: protected List<Pair<String, double[]>> idToCoordinates
   :outertype: MatrixDataSetFormatParser.MatrixParser

Constructors
------------
MatrixParser
^^^^^^^^^^^^

.. java:constructor:: public MatrixParser(String absFilePath) throws IOException
   :outertype: MatrixDataSetFormatParser.MatrixParser

   :param absFilePath:
   :throws IOException:

Methods
-------
checkLine
^^^^^^^^^

.. java:method:: @Override protected boolean checkLine(String line)
   :outertype: MatrixDataSetFormatParser.MatrixParser

getCoordinates
^^^^^^^^^^^^^^

.. java:method:: public List<Pair<String, double[]>> getCoordinates()
   :outertype: MatrixDataSetFormatParser.MatrixParser

processLine
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void processLine(String[] key, String[] value)
   :outertype: MatrixDataSetFormatParser.MatrixParser

