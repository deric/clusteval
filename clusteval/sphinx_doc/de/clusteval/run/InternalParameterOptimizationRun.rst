.. java:import:: java.io File

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessorParameters

.. java:import:: de.clusteval.run.runnable ExecutionRunRunnable

.. java:import:: de.clusteval.run.runnable InternalParameterOptimizationRunRunnable

InternalParameterOptimizationRun
================================

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class InternalParameterOptimizationRun extends ExecutionRun

   A type of execution run that does the same as \ :java:ref:`ParameterOptimizationRun`\ , by using a programs internal parameter optimization mode instead of doing the parameter optimization itself within the framework.

   :author: Christian Wiwie

Constructors
------------
InternalParameterOptimizationRun
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public InternalParameterOptimizationRun(Repository repository, Context context, long changeDate, File absPath, List<ProgramConfig> programConfigs, List<DataConfig> dataConfigs, List<ClusteringQualityMeasure> qualityMeasures, List<Map<ProgramParameter<?>, String>> parameterValues, List<RunResultPostprocessor> postProcessors, Map<String, Integer> maxExecutionTimes) throws RegisterException
   :outertype: InternalParameterOptimizationRun

   New objects of this type are automatically registered at the repository.

   :param repository: the repository
   :param context:
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param programConfigs: The program configurations of the new run.
   :param dataConfigs: The data configurations of the new run.
   :param qualityMeasures: The clustering quality measures of the new run.
   :param parameterValues: The parameter values of this run.
   :throws RegisterException:

InternalParameterOptimizationRun
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: protected InternalParameterOptimizationRun(InternalParameterOptimizationRun other) throws RegisterException
   :outertype: InternalParameterOptimizationRun

   Copy constructor of internal parameter optimization runs.

   :param otherRun: The internal parameter optimization run to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public InternalParameterOptimizationRun clone()
   :outertype: InternalParameterOptimizationRun

createRunRunnableFor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected ExecutionRunRunnable createRunRunnableFor(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: InternalParameterOptimizationRun

