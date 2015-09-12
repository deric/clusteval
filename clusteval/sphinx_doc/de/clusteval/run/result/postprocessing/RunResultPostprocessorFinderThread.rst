.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

RunResultPostprocessorFinderThread
==================================

.. java:package:: de.clusteval.run.result.postprocessing
   :noindex:

.. java:type:: public class RunResultPostprocessorFinderThread extends FinderThread<RunResultPostprocessor>

   :author: Christian Wiwie

Constructors
------------
RunResultPostprocessorFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultPostprocessorFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: RunResultPostprocessorFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

RunResultPostprocessorFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultPostprocessorFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: RunResultPostprocessorFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected RunResultPostprocessorFinder getFinder() throws RegisterException
   :outertype: RunResultPostprocessorFinderThread

