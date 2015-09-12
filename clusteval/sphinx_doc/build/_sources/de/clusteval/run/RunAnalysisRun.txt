.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.apache.commons.configuration HierarchicalINIConfiguration

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run.runnable RunAnalysisRunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

RunAnalysisRun
==============

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class RunAnalysisRun extends AnalysisRun<RunStatistic>

   A type of analysis run that conducts analyses of run results.

   A run analysis run has a list of unique run identifiers in \ :java:ref:`uniqueRunAnalysisRunIdentifiers`\  , that should be assessed during execution of the run. Additionally they inherit a list of run statistics in \ :java:ref:`AnalysisRun.statistics`\  that should be assessed for every run result corresponding to a unique run identifier.

   :author: Christian Wiwie

Fields
------
uniqueRunAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueRunAnalysisRunIdentifiers
   :outertype: RunAnalysisRun

   A list of unique run identifiers, that should be assessed during execution of the run

Constructors
------------
RunAnalysisRun
^^^^^^^^^^^^^^

.. java:constructor:: public RunAnalysisRun(Repository repository, Context context, long changeDate, File absPath, List<String> uniqueRunIdentifiers, List<RunStatistic> statistics) throws RegisterException
   :outertype: RunAnalysisRun

   :param repository: The repository this run should be registered at.
   :param context:
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param uniqueRunIdentifiers: The list of unique run identifiers, that should be assessed during execution of the run.
   :param statistics: The statistics that should be assessed for the objects of analysis.
   :throws RegisterException:

RunAnalysisRun
^^^^^^^^^^^^^^

.. java:constructor:: protected RunAnalysisRun(RunAnalysisRun other) throws RegisterException
   :outertype: RunAnalysisRun

   Copy constructor of run analysis runs.

   :param other: The run analysis run to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RunAnalysisRun clone()
   :outertype: RunAnalysisRun

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: @Override protected List<RunStatistic> cloneStatistics(List<RunStatistic> statistics)
   :outertype: RunAnalysisRun

createAndScheduleRunnableForResumePair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForResumePair(RunSchedulerThread runScheduler, int p)
   :outertype: RunAnalysisRun

createAndScheduleRunnableForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForRunPair(RunSchedulerThread runScheduler, int p)
   :outertype: RunAnalysisRun

getNumberOfRunRunnables
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getNumberOfRunRunnables()
   :outertype: RunAnalysisRun

getUniqueRunAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<String> getUniqueRunAnalysisRunIdentifiers()
   :outertype: RunAnalysisRun

   :return: A list with all unique run identifiers of this run.

getUpperLimitProgress
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected long getUpperLimitProgress()
   :outertype: RunAnalysisRun

terminate
^^^^^^^^^

.. java:method:: @Override public boolean terminate()
   :outertype: RunAnalysisRun

