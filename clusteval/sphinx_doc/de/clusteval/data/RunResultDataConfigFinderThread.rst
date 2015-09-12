.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RunResultDataSetConfigFinderThread

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigFinderThread

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

RunResultDataConfigFinderThread
===============================

.. java:package:: de.clusteval.data
   :noindex:

.. java:type:: public class RunResultDataConfigFinderThread extends DataConfigFinderThread

   :author: Christian Wiwie

Constructors
------------
RunResultDataConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataConfigFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: RunResultDataConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new data configurations.
   :param checkOnce: If true, this thread only checks once for new data configurations.

RunResultDataConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataConfigFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: RunResultDataConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new runs.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new runs.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: RunResultDataConfigFinderThread

