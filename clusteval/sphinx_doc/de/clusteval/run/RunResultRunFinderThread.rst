.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethodFinderThread

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context ContextFinderThread

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data RunResultDataConfigFinderThread

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RunResultDataSetConfigFinderThread

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigFinderThread

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticFinderThread

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramConfigFinderThread

RunResultRunFinderThread
========================

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class RunResultRunFinderThread extends RunFinderThread

   A thread that uses a \ :java:ref:`RunFinder`\  to check the runresult repository for new runs.

   :author: Christian Wiwie

Constructors
------------
RunResultRunFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultRunFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: RunResultRunFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new runs.
   :param checkOnce: If true, this thread only checks once for new runs.

RunResultRunFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultRunFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: RunResultRunFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new runs.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new runs.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: RunResultRunFinderThread

