.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataStatisticFinderThread
=========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class DataStatisticFinderThread extends FinderThread<DataStatistic>

   :author: Christian Wiwie

Constructors
------------
DataStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: DataStatisticFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

DataStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataStatisticFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected DataStatisticFinder getFinder() throws RegisterException
   :outertype: DataStatisticFinderThread

