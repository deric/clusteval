.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

RunStatisticFinderThread
========================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class RunStatisticFinderThread extends FinderThread<RunStatistic>

   :author: Christian Wiwie

Constructors
------------
RunStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: RunStatisticFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

RunStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: RunStatisticFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected RunStatisticFinder getFinder() throws RegisterException
   :outertype: RunStatisticFinderThread

