.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

GoldStandardConfigFinderThread
==============================

.. java:package:: de.clusteval.data.goldstandard
   :noindex:

.. java:type:: public class GoldStandardConfigFinderThread extends FinderThread<GoldStandardConfig>

   :author: Christian Wiwie

Constructors
------------
GoldStandardConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GoldStandardConfigFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: GoldStandardConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new goldstandard configurations.
   :param checkOnce: If true, this thread only checks once for new goldstandard configurations.

GoldStandardConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GoldStandardConfigFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: GoldStandardConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new goldstandard configurations.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new goldstandard configurations.

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<GoldStandardConfig> getFinder() throws RegisterException
   :outertype: GoldStandardConfigFinderThread

