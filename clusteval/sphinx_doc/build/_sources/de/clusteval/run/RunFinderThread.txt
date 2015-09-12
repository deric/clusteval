.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethodFinderThread

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context ContextFinderThread

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset DataSetConfigFinderThread

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigFinderThread

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticFinderThread

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramConfigFinderThread

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunDataStatisticFinderThread

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics RunStatisticFinderThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

RunFinderThread
===============

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class RunFinderThread extends FinderThread<Run>

   A thread that uses a \ :java:ref:`RunFinder`\  to check the repository for new runs.

   :author: Christian Wiwie

Constructors
------------
RunFinderThread
^^^^^^^^^^^^^^^

.. java:constructor:: public RunFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: RunFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new runs.
   :param checkOnce: If true, this thread only checks once for new runs.

RunFinderThread
^^^^^^^^^^^^^^^

.. java:constructor:: public RunFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: RunFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new runs.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new runs.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: RunFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<Run> getFinder() throws RegisterException
   :outertype: RunFinderThread

