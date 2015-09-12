.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: utils RangeCreationException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

TransClustQuantileParameterOptimizationMethod
=============================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public class TransClustQuantileParameterOptimizationMethod extends DivisiveParameterOptimizationMethod

   :author: Christian Wiwie

Constructors
------------
TransClustQuantileParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustQuantileParameterOptimizationMethod(Repository repo, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int terminateCount, boolean isResume) throws ParameterOptimizationException, RegisterException
   :outertype: TransClustQuantileParameterOptimizationMethod

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param run:
   :param programConfig:
   :param dataConfig:
   :param params:
   :param optimizationCriterion:
   :param terminateCount:
   :param isResume:
   :throws ParameterOptimizationException:
   :throws RegisterException:

TransClustQuantileParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustQuantileParameterOptimizationMethod(TransClustQuantileParameterOptimizationMethod other) throws RegisterException
   :outertype: TransClustQuantileParameterOptimizationMethod

   The copy constructor for this method.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
initParameterValues
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void initParameterValues() throws ParameterOptimizationException
   :outertype: TransClustQuantileParameterOptimizationMethod

