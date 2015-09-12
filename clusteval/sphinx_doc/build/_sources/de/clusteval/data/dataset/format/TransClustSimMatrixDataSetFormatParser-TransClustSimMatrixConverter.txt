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

TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter
===================================================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type::  class TransClustSimMatrixConverter extends TextFileParser
   :outertype: TransClustSimMatrixDataSetFormatParser

Fields
------
idToKey
^^^^^^^

.. java:field:: protected Map<Integer, String> idToKey
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

keyToId
^^^^^^^

.. java:field:: protected Map<String, Integer> keyToId
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

maxSimilarity
^^^^^^^^^^^^^

.. java:field:: protected double maxSimilarity
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

proteinCount
^^^^^^^^^^^^

.. java:field:: protected int proteinCount
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

similarities
^^^^^^^^^^^^

.. java:field:: protected double[][] similarities
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

Constructors
------------
TransClustSimMatrixConverter
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustSimMatrixConverter(String absFilePath, String outputPath) throws IOException
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

   :param absFilePath:
   :param outputPath:
   :throws IOException:

Methods
-------
getBurstOutput
^^^^^^^^^^^^^^

.. java:method:: @Override protected String getBurstOutput()
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

processLine
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void processLine(String[] key, String[] value)
   :outertype: TransClustSimMatrixDataSetFormatParser.TransClustSimMatrixConverter

