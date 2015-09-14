.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: utils ArraysExt

.. java:import:: utils RangeCreationException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program DoubleProgramParameter

.. java:import:: de.clusteval.program IntegerProgramParameter

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.program StringProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.utils InternalAttributeException

MCODEDivisiveParameterOptimizationMethod
========================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public class MCODEDivisiveParameterOptimizationMethod extends DivisiveParameterOptimizationMethod

   :author: Christian Wiwie

Fields
------
reachedNTCutoff
^^^^^^^^^^^^^^^

.. java:field:: protected boolean reachedNTCutoff
   :outertype: MCODEDivisiveParameterOptimizationMethod

reachedT
^^^^^^^^

.. java:field:: protected boolean reachedT
   :outertype: MCODEDivisiveParameterOptimizationMethod

Constructors
------------
MCODEDivisiveParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCODEDivisiveParameterOptimizationMethod(MCODEDivisiveParameterOptimizationMethod other) throws RegisterException
   :outertype: MCODEDivisiveParameterOptimizationMethod

   The copy constructor for this method.

   :param other: The object to clone.
   :throws RegisterException:

MCODEDivisiveParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCODEDivisiveParameterOptimizationMethod(Repository repo, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int terminateCount, boolean isResume) throws ParameterOptimizationException, RegisterException
   :outertype: MCODEDivisiveParameterOptimizationMethod

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param run: The run this method belongs to.
   :param programConfig: The program configuration this method was created for.
   :param dataConfig: The data configuration this method was created for.
   :param params: This list holds the program parameters that are to be optimized by the parameter optimization run.
   :param optimizationCriterion: The quality measure used as the optimization criterion (see \ :java:ref:`optimizationCriterion`\ ).
   :param terminateCount: This array holds the number of iterations that are to be performed for each optimization parameter.
   :param isResume: This boolean indiciates, whether the run is a resumption of a previous run execution or a completely new execution.
   :throws ParameterOptimizationException:
   :throws RegisterException:

Methods
-------
giveQualityFeedback
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public synchronized void giveQualityFeedback(ParameterSet parameterSet, ClusteringQualitySet qualities)
   :outertype: MCODEDivisiveParameterOptimizationMethod

hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: MCODEDivisiveParameterOptimizationMethod

initParameterValues
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void initParameterValues() throws ParameterOptimizationException, InternalAttributeException
   :outertype: MCODEDivisiveParameterOptimizationMethod

