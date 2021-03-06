.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

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

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.utils InternalAttributeException

FlatteningLayeredDivisiveParameterOptimizationMethod
====================================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: @LoadableClassParentAnnotation public class FlatteningLayeredDivisiveParameterOptimizationMethod extends ParameterOptimizationMethod

   :author: Christian Wiwie

Fields
------
currentDivisiveMethod
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected DivisiveParameterOptimizationMethod currentDivisiveMethod
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

currentLayer
^^^^^^^^^^^^

.. java:field:: protected int currentLayer
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

iterationsPerLayer
^^^^^^^^^^^^^^^^^^

.. java:field:: protected int iterationsPerLayer
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

layerCount
^^^^^^^^^^

.. java:field:: protected int layerCount
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

   The number of layers.

originalParameters
^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<ProgramParameter<?>> originalParameters
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

paramToValueRange
^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Pair<?, ?>> paramToValueRange
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

remainingIterationCount
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int remainingIterationCount
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

Constructors
------------
FlatteningLayeredDivisiveParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FlatteningLayeredDivisiveParameterOptimizationMethod(Repository repo, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int totalIterations, boolean isResume) throws RegisterException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param run:
   :param programConfig:
   :param dataConfig:
   :param params:
   :param optimizationCriterion:
   :param totalIterations:
   :param isResume:
   :throws RegisterException:

FlatteningLayeredDivisiveParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FlatteningLayeredDivisiveParameterOptimizationMethod(FlatteningLayeredDivisiveParameterOptimizationMethod other) throws RegisterException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

   The copy constructor for this method.

   Cloning of this method does not keep potentially already initialized parameter value ranges

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
applyNextDivisiveMethod
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void applyNextDivisiveMethod() throws InternalAttributeException, RegisterException, InterruptedException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

   :throws InterruptedException:
   :throws InternalAttributeException:
   :throws RegisterException:

createDivisiveMethod
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected DivisiveParameterOptimizationMethod createDivisiveMethod(List<ProgramParameter<?>> newParams, int newIterationsPerParameter) throws ParameterOptimizationException, RegisterException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

getCompatibleDataSetFormatBaseClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Class<? extends DataSetFormat>> getCompatibleDataSetFormatBaseClasses()
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

getCompatibleProgramNames
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<String> getCompatibleProgramNames()
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

getNextIterationsPerLayer
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected int getNextIterationsPerLayer()
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

getNextParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected synchronized ParameterSet getNextParameterSet(ParameterSet forcedParameterSet) throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException, ParameterSetAlreadyEvaluatedException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

getTotalIterationCount
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public int getTotalIterationCount()
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

giveQualityFeedback
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public synchronized void giveQualityFeedback(ParameterSet paramSet, ClusteringQualitySet qualities)
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

initParameterValues
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void initParameterValues() throws ParameterOptimizationException, InternalAttributeException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

reset
^^^^^

.. java:method:: @Override public void reset(File absResultPath) throws ParameterOptimizationException, InternalAttributeException, RegisterException, RunResultParseException, InterruptedException
   :outertype: FlatteningLayeredDivisiveParameterOptimizationMethod

