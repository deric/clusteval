.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataRandomizerFinderThread
==========================

.. java:package:: de.clusteval.data.randomizer
   :noindex:

.. java:type:: public class DataRandomizerFinderThread extends FinderThread<DataRandomizer>

   :author: Christian Wiwie

Constructors
------------
DataRandomizerFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataRandomizerFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataRandomizerFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

DataRandomizerFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataRandomizerFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataRandomizerFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected DataRandomizerFinder getFinder() throws RegisterException
   :outertype: DataRandomizerFinderThread

