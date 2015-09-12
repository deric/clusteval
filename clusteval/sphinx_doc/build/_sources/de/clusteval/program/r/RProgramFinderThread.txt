.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

RProgramFinderThread
====================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public class RProgramFinderThread extends FinderThread<RProgram>

   :author: Christian Wiwie

Constructors
------------
RProgramFinderThread
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RProgramFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: RProgramFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

RProgramFinderThread
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RProgramFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: RProgramFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected RProgramFinder getFinder() throws RegisterException
   :outertype: RProgramFinderThread

