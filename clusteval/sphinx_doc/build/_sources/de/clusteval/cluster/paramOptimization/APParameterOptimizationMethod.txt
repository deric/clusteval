.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.utils InternalAttributeException

APParameterOptimizationMethod
=============================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: @LoadableClassParentAnnotation public class APParameterOptimizationMethod extends LayeredDivisiveParameterOptimizationMethod implements IDivergingParameterOptimizationMethod

   :author: Christian Wiwie

Fields
------
allParams
^^^^^^^^^

.. java:field:: protected List<ProgramParameter<?>> allParams
   :outertype: APParameterOptimizationMethod

iterationParamMethods
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<ParameterSet, DivisiveParameterOptimizationMethod> iterationParamMethods
   :outertype: APParameterOptimizationMethod

numberTriesOnNotTerminated
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int numberTriesOnNotTerminated
   :outertype: APParameterOptimizationMethod

Constructors
------------
APParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APParameterOptimizationMethod(Repository repo, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int iterationPerParameter, boolean isResume) throws RegisterException
   :outertype: APParameterOptimizationMethod

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

APParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APParameterOptimizationMethod(APParameterOptimizationMethod other) throws RegisterException
   :outertype: APParameterOptimizationMethod

   The copy constructor for this method.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getNextParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected synchronized ParameterSet getNextParameterSet(ParameterSet forcedParameterSet) throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException, ParameterSetAlreadyEvaluatedException
   :outertype: APParameterOptimizationMethod

getOptimizationParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ProgramParameter<?>> getOptimizationParameter()
   :outertype: APParameterOptimizationMethod

getPreferenceParam
^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<ProgramParameter<?>> getPreferenceParam(List<ProgramParameter<?>> params)
   :outertype: APParameterOptimizationMethod

   :param params: The complete list of optimization parameters
   :return: A list containing only the preference parameter.

giveFeedbackNotTerminated
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public synchronized void giveFeedbackNotTerminated(ParameterSet parameterSet, ClusteringQualitySet minimalQualities)
   :outertype: APParameterOptimizationMethod

giveQualityFeedback
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public synchronized void giveQualityFeedback(ParameterSet parameterSet, ClusteringQualitySet qualities)
   :outertype: APParameterOptimizationMethod

hasNext
^^^^^^^

.. java:method:: @Override public synchronized boolean hasNext()
   :outertype: APParameterOptimizationMethod

