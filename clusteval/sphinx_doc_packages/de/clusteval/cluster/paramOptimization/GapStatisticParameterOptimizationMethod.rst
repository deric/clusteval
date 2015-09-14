.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

GapStatisticParameterOptimizationMethod
=======================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: @RLibraryRequirement public class GapStatisticParameterOptimizationMethod extends ParameterOptimizationMethod

   TODO: This parameter optimization method does not support resumption of old values, because the forced parameter set is ignored.

   :author: Christian Wiwie

Constructors
------------
GapStatisticParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GapStatisticParameterOptimizationMethod(Repository repo, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int iterationPerParameter, boolean isResume) throws RegisterException
   :outertype: GapStatisticParameterOptimizationMethod

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param run: The run this method belongs to.
   :param programConfig: The program configuration this method was created for.
   :param dataConfig: The data configuration this method was created for.
   :param params: This list holds the program parameters that are to be optimized by the parameter optimization run.
   :param optimizationCriterion: The quality measure used as the optimization criterion (see \ :java:ref:`optimizationCriterion`\ ).
   :param iterationPerParameter: This array holds the number of iterations that are to be performed for each optimization parameter.
   :param isResume: This boolean indiciates, whether the run is a resumption of a previous run execution or a completely new execution.
   :throws RegisterException:

GapStatisticParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GapStatisticParameterOptimizationMethod(GapStatisticParameterOptimizationMethod other) throws RegisterException
   :outertype: GapStatisticParameterOptimizationMethod

   The copy constructor for this method.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getCompatibleDataSetFormatBaseClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Class<? extends DataSetFormat>> getCompatibleDataSetFormatBaseClasses()
   :outertype: GapStatisticParameterOptimizationMethod

getCompatibleProgramNames
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<String> getCompatibleProgramNames()
   :outertype: GapStatisticParameterOptimizationMethod

getNextParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected ParameterSet getNextParameterSet(ParameterSet forcedParameterSet) throws InterruptedException
   :outertype: GapStatisticParameterOptimizationMethod

getTotalIterationCount
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public int getTotalIterationCount()
   :outertype: GapStatisticParameterOptimizationMethod

hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: GapStatisticParameterOptimizationMethod

