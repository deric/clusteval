.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

ContextFinderThread
===================

.. java:package:: de.clusteval.context
   :noindex:

.. java:type:: public class ContextFinderThread extends FinderThread<Context>

   :author: Christian Wiwie

Constructors
------------
ContextFinderThread
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ContextFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: ContextFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

ContextFinderThread
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ContextFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: ContextFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected ContextFinder getFinder() throws RegisterException
   :outertype: ContextFinderThread

