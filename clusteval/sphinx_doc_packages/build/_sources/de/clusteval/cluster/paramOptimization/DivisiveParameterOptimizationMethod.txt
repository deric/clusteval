.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils ArraysExt

.. java:import:: utils RangeCreationException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

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

DivisiveParameterOptimizationMethod
===================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public class DivisiveParameterOptimizationMethod extends ParameterOptimizationMethod

   :author: Christian Wiwie

Fields
------
currentPos
^^^^^^^^^^

.. java:field:: protected Map<ProgramParameter<?>, Integer> currentPos
   :outertype: DivisiveParameterOptimizationMethod

iterationPerParameter
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int[] iterationPerParameter
   :outertype: DivisiveParameterOptimizationMethod

parameterValues
^^^^^^^^^^^^^^^

.. java:field:: protected Map<ProgramParameter<?>, String[]> parameterValues
   :outertype: DivisiveParameterOptimizationMethod

Constructors
------------
DivisiveParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: @SuppressWarnings public DivisiveParameterOptimizationMethod(Repository repo, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int terminateCount, boolean isResume) throws ParameterOptimizationException, RegisterException
   :outertype: DivisiveParameterOptimizationMethod

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

DivisiveParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DivisiveParameterOptimizationMethod(DivisiveParameterOptimizationMethod other) throws RegisterException
   :outertype: DivisiveParameterOptimizationMethod

   The copy constructor for this method.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getCompatibleDataSetFormatBaseClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Class<? extends DataSetFormat>> getCompatibleDataSetFormatBaseClasses()
   :outertype: DivisiveParameterOptimizationMethod

getCompatibleProgramNames
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<String> getCompatibleProgramNames()
   :outertype: DivisiveParameterOptimizationMethod

getNextParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected ParameterSet getNextParameterSet(ParameterSet forcedParameterSet) throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException
   :outertype: DivisiveParameterOptimizationMethod

getTotalIterationCount
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public int getTotalIterationCount()
   :outertype: DivisiveParameterOptimizationMethod

hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: DivisiveParameterOptimizationMethod

increaseCurrentPos
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean increaseCurrentPos()
   :outertype: DivisiveParameterOptimizationMethod

   :return: True if the operation was successful, false otherwise.

initIterationsPerParameter
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void initIterationsPerParameter()
   :outertype: DivisiveParameterOptimizationMethod

initParameterValues
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void initParameterValues() throws ParameterOptimizationException, InternalAttributeException
   :outertype: DivisiveParameterOptimizationMethod

