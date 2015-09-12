.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run.runnable RunDataAnalysisRunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: de.clusteval.run.statistics RunDataStatistic

RunDataAnalysisRun
==================

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class RunDataAnalysisRun extends AnalysisRun<RunDataStatistic>

   A type of analysis run that conducts analyses on both run results and data inputs together.

   A run data analysis run has a list of unique run analysis run identifiers in \ :java:ref:`uniqueRunAnalysisRunIdentifiers`\  and a list of unique data analysis run identifiers in \ :java:ref:`uniqueDataAnalysisRunIdentifiers`\ , that should be assessed during execution of the run. Additionally they inherit a list of run statistics in \ :java:ref:`AnalysisRun.statistics`\  that should be assessed for every pair of run analysis and data analysis run identifier.

   :author: Christian Wiwie

Fields
------
uniqueDataAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueDataAnalysisRunIdentifiers
   :outertype: RunDataAnalysisRun

   A list of unique data analysis run identifiers to be assessed during this run.

uniqueRunAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueRunAnalysisRunIdentifiers
   :outertype: RunDataAnalysisRun

   A list of unique run analysis run identifiers to be assessed during this run.

Constructors
------------
RunDataAnalysisRun
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataAnalysisRun(Repository repository, Context context, long changeDate, File absPath, List<String> uniqueRunAnalysisRunIdentifiers, List<String> uniqueDataAnalysisRunIdentifiers, List<RunDataStatistic> statistics) throws RegisterException
   :outertype: RunDataAnalysisRun

   :param repository: The repository this run should be registered at.
   :param context:
   :param name: The name of this run.
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param uniqueRunAnalysisRunIdentifiers: The list of unique run analysis run identifiers, that should be assessed during execution of the run.
   :param uniqueDataAnalysisRunIdentifiers: The list of unique data analysis run identifiers, that should be assessed during execution of the run.
   :param statistics: The statistics that should be assessed for the objects of analysis.
   :throws RegisterException:

RunDataAnalysisRun
^^^^^^^^^^^^^^^^^^

.. java:constructor:: protected RunDataAnalysisRun(RunDataAnalysisRun other) throws RegisterException
   :outertype: RunDataAnalysisRun

   Copy constructor of run data analysis runs.

   :param other: The run to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RunDataAnalysisRun clone()
   :outertype: RunDataAnalysisRun

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: @Override protected List<RunDataStatistic> cloneStatistics(List<RunDataStatistic> statistics)
   :outertype: RunDataAnalysisRun

createAndScheduleRunnableForResumePair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected RunRunnable createAndScheduleRunnableForResumePair(RunSchedulerThread runScheduler, int p)
   :outertype: RunDataAnalysisRun

createAndScheduleRunnableForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForRunPair(RunSchedulerThread runScheduler, int p)
   :outertype: RunDataAnalysisRun

getNumberOfRunRunnables
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getNumberOfRunRunnables()
   :outertype: RunDataAnalysisRun

getUniqueDataAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<String> getUniqueDataAnalysisRunIdentifiers()
   :outertype: RunDataAnalysisRun

   :return: the dataConfigs

getUniqueRunAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<String> getUniqueRunAnalysisRunIdentifiers()
   :outertype: RunDataAnalysisRun

   :return: the run identifiers

getUpperLimitProgress
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected long getUpperLimitProgress()
   :outertype: RunDataAnalysisRun

terminate
^^^^^^^^^

.. java:method:: @Override public boolean terminate()
   :outertype: RunDataAnalysisRun

