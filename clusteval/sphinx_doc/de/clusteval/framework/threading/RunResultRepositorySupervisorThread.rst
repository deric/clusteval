.. java:import:: java.util Map

.. java:import:: de.clusteval.data RunResultDataConfigFinderThread

.. java:import:: de.clusteval.data.dataset RunResultDataSetConfigFinderThread

.. java:import:: de.clusteval.data.dataset RunResultDataSetFinderThread

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigFinderThread

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.program ProgramConfigFinderThread

.. java:import:: de.clusteval.run RunResultRunFinderThread

RunResultRepositorySupervisorThread
===================================

.. java:package:: de.clusteval.framework.threading
   :noindex:

.. java:type:: public class RunResultRepositorySupervisorThread extends SupervisorThread

   A type of supervisor thread that supervises a \ :java:ref:`RunResultRepository`\ . In contrast to \ :java:ref:`RepositorySupervisorThread`\ , this class only checks certain things and has therefore less threads to supervise.

   :author: Christian Wiwie

Constructors
------------
RunResultRepositorySupervisorThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: @SuppressWarnings public RunResultRepositorySupervisorThread(Repository repository, Map<String, Long> threadSleepTimes)
   :outertype: RunResultRepositorySupervisorThread

   :param repository: The repository this thread belongs to.
   :param threadSleepTimes: The sleep times of the created threads.

