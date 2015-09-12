.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset DataSetConfigFinderThread

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigFinderThread

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

DataConfigFinderThread
======================

.. java:package:: de.clusteval.data
   :noindex:

.. java:type:: public class DataConfigFinderThread extends FinderThread<DataConfig>

   :author: Christian Wiwie

Constructors
------------
DataConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataConfigFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new data configurations.
   :param checkOnce: If true, this thread only checks once for new data configurations.

DataConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataConfigFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: DataConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new runs.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new runs.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: DataConfigFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<DataConfig> getFinder() throws RegisterException
   :outertype: DataConfigFinderThread

