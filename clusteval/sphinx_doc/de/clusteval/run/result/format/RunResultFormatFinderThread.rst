.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

RunResultFormatFinderThread
===========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class RunResultFormatFinderThread extends FinderThread<RunResultFormat>

   :author: Christian Wiwie

Constructors
------------
RunResultFormatFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormatFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: RunResultFormatFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

RunResultFormatFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormatFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: RunResultFormatFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected RunResultFormatFinder getFinder() throws RegisterException
   :outertype: RunResultFormatFinderThread

