.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository.db SQLConfig.DB_TYPE

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

RunResultFinderThread
=====================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class RunResultFinderThread extends FinderThread<RunResult>

   :author: Christian Wiwie

Constructors
------------
RunResultFinderThread
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: RunResultFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new run results.
   :param checkOnce: If true, this thread only checks once for new run results.

RunResultFinderThread
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: RunResultFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new run results.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new run results.

Methods
-------
afterFind
^^^^^^^^^

.. java:method:: @Override protected void afterFind()
   :outertype: RunResultFinderThread

beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: RunResultFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<RunResult> getFinder() throws RegisterException
   :outertype: RunResultFinderThread

