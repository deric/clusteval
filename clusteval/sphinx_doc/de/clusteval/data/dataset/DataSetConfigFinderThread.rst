.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.data.distance DistanceMeasureFinderThread

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.data.preprocessing DataPreprocessorFinderThread

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

DataSetConfigFinderThread
=========================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetConfigFinderThread extends FinderThread<DataSetConfig>

   :author: Christian Wiwie

Constructors
------------
DataSetConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetConfigFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataSetConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new dataset configurations.
   :param checkOnce: If true, this thread only checks once for new dataset configurations.

DataSetConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetConfigFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: DataSetConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new dataset configurations.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new dataset configurations.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: DataSetConfigFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<DataSetConfig> getFinder() throws RegisterException
   :outertype: DataSetConfigFinderThread

