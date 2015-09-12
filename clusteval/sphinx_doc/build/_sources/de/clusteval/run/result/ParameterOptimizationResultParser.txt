.. java:import:: java.io File

.. java:import:: java.io FilenameFilter

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: utils StringExt

.. java:import:: utils.parse TextFileParser

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster ClusteringParseException

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: file FileUtils

ParameterOptimizationResultParser
=================================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class ParameterOptimizationResultParser extends TextFileParser

   :author: Christian Wiwie

Fields
------
method
^^^^^^

.. java:field:: protected ParameterOptimizationMethod method
   :outertype: ParameterOptimizationResultParser

parameters
^^^^^^^^^^

.. java:field:: protected List<ProgramParameter<?>> parameters
   :outertype: ParameterOptimizationResultParser

parseClusterings
^^^^^^^^^^^^^^^^

.. java:field:: protected boolean parseClusterings
   :outertype: ParameterOptimizationResultParser

qualityMeasures
^^^^^^^^^^^^^^^

.. java:field:: protected List<ClusteringQualityMeasure> qualityMeasures
   :outertype: ParameterOptimizationResultParser

run
^^^

.. java:field:: protected ParameterOptimizationRun run
   :outertype: ParameterOptimizationResultParser

tmpResult
^^^^^^^^^

.. java:field:: protected ParameterOptimizationResult tmpResult
   :outertype: ParameterOptimizationResultParser

Constructors
------------
ParameterOptimizationResultParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationResultParser(ParameterOptimizationMethod method, ParameterOptimizationRun run, ParameterOptimizationResult tmpResult, String absFilePath, int[] keyColumnIds, int[] valueColumnIds, boolean parseClusterings, boolean storeClusterings) throws IOException
   :outertype: ParameterOptimizationResultParser

   :param method:
   :param run:
   :param tmpResult:
   :param absFilePath:
   :param keyColumnIds:
   :param valueColumnIds:
   :param parseClusterings:
   :param storeClusterings:
   :throws IOException:

Methods
-------
processLine
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void processLine(String[] key, String[] value)
   :outertype: ParameterOptimizationResultParser

split
^^^^^

.. java:method:: @Override protected String[] split(String line)
   :outertype: ParameterOptimizationResultParser

