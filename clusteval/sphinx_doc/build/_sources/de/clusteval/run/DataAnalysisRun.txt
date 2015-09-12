.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run.runnable DataAnalysisRunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: file FileUtils

DataAnalysisRun
===============

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class DataAnalysisRun extends AnalysisRun<DataStatistic>

   A type of analysis run that conducts analyses of data inputs encapsulated by data configurations.

   A data analysis run has a list of data configurations in \ :java:ref:`dataConfigs`\  , that should be assessed during execution of the run. Additionally they inherit a list of data statistics in \ :java:ref:`AnalysisRun.statistics`\  that should be assessed for every data configuration.

   :author: Christian Wiwie

Fields
------
dataConfigs
^^^^^^^^^^^

.. java:field:: protected List<DataConfig> dataConfigs
   :outertype: DataAnalysisRun

   A list of data configurations, that should be assessed during execution of the run.

Constructors
------------
DataAnalysisRun
^^^^^^^^^^^^^^^

.. java:constructor:: public DataAnalysisRun(Repository repository, Context context, long changeDate, File absPath, List<DataConfig> dataConfigs, List<DataStatistic> statistics) throws RegisterException
   :outertype: DataAnalysisRun

   :param repository: The repository this run should be registered at.
   :param context:
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param dataConfigs: The list of data configurations, that should be assessed during execution of the run.
   :param statistics: The statistics that should be assessed for the objects of analysis.
   :throws RegisterException:

DataAnalysisRun
^^^^^^^^^^^^^^^

.. java:constructor:: protected DataAnalysisRun(DataAnalysisRun other) throws RegisterException
   :outertype: DataAnalysisRun

   Copy constructor of data analysis runs.

   :param other: The data analysis run to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DataAnalysisRun clone()
   :outertype: DataAnalysisRun

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: @Override protected List<DataStatistic> cloneStatistics(List<DataStatistic> statistics)
   :outertype: DataAnalysisRun

createAndScheduleRunnableForResumePair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForResumePair(RunSchedulerThread runScheduler, int p)
   :outertype: DataAnalysisRun

createAndScheduleRunnableForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForRunPair(RunSchedulerThread runScheduler, int p)
   :outertype: DataAnalysisRun

getDataConfigs
^^^^^^^^^^^^^^

.. java:method:: public List<DataConfig> getDataConfigs()
   :outertype: DataAnalysisRun

   :return: A list containing all data configurations to be assessed by this run.

getNumberOfRunRunnables
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getNumberOfRunRunnables()
   :outertype: DataAnalysisRun

getUpperLimitProgress
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected long getUpperLimitProgress()
   :outertype: DataAnalysisRun

terminate
^^^^^^^^^

.. java:method:: @Override public boolean terminate()
   :outertype: DataAnalysisRun

