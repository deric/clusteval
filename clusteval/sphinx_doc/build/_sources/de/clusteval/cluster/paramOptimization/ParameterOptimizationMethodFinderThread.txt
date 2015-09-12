.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

ParameterOptimizationMethodFinderThread
=======================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public class ParameterOptimizationMethodFinderThread extends FinderThread<ParameterOptimizationMethod>

   :author: Christian Wiwie

Constructors
------------
ParameterOptimizationMethodFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationMethodFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: ParameterOptimizationMethodFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new parameter optimization methods.
   :param checkOnce: If true, this thread only checks once for new parameter optimization methods.

ParameterOptimizationMethodFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationMethodFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: ParameterOptimizationMethodFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new parameter optimization methods.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new parameter optimization methods.

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected ParameterOptimizationMethodFinder getFinder() throws RegisterException
   :outertype: ParameterOptimizationMethodFinderThread

