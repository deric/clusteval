.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DistanceMeasureFinderThread
===========================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: public class DistanceMeasureFinderThread extends FinderThread<DistanceMeasure>

   :author: Christian Wiwie

Constructors
------------
DistanceMeasureFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasureFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: DistanceMeasureFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

DistanceMeasureFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasureFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DistanceMeasureFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected DistanceMeasureFinder getFinder() throws RegisterException
   :outertype: DistanceMeasureFinderThread

