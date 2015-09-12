.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

RunResultDataSetConfigFinderThread
==================================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class RunResultDataSetConfigFinderThread extends FinderThread<DataSetConfig>

   :author: Christian Wiwie

Constructors
------------
RunResultDataSetConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetConfigFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: RunResultDataSetConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new dataset configurations.
   :param checkOnce: If true, this thread only checks once for new dataset configurations.

RunResultDataSetConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetConfigFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: RunResultDataSetConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new dataset configurations.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new dataset configurations.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: RunResultDataSetConfigFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<DataSetConfig> getFinder() throws RegisterException
   :outertype: RunResultDataSetConfigFinderThread

