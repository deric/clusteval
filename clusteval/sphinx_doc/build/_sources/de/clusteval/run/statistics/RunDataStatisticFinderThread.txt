.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

RunDataStatisticFinderThread
============================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class RunDataStatisticFinderThread extends FinderThread<RunDataStatistic>

   :author: Christian Wiwie

Constructors
------------
RunDataStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: RunDataStatisticFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

RunDataStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: RunDataStatisticFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected RunDataStatisticFinder getFinder() throws RegisterException
   :outertype: RunDataStatisticFinderThread

