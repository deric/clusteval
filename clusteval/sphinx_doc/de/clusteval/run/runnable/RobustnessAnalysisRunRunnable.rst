.. java:import:: java.util Map

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run Run

RobustnessAnalysisRunRunnable
=============================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class RobustnessAnalysisRunRunnable extends ClusteringRunRunnable

   :author: Christian Wiwie

Constructors
------------
RobustnessAnalysisRunRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RobustnessAnalysisRunRunnable(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: RobustnessAnalysisRunRunnable

   :param runScheduler:
   :param run:
   :param programConfig:
   :param dataConfig:
   :param runIdentString:
   :param isResume:

