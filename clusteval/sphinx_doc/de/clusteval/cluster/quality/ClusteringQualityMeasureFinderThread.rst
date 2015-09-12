.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

ClusteringQualityMeasureFinderThread
====================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class ClusteringQualityMeasureFinderThread extends FinderThread<ClusteringQualityMeasure>

   :author: Christian Wiwie

Constructors
------------
ClusteringQualityMeasureFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasureFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: ClusteringQualityMeasureFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new clustering quality measures.
   :param checkOnce: If true, this thread only checks once for new clustering quality measures.

ClusteringQualityMeasureFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasureFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: ClusteringQualityMeasureFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new clustering quality measures.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new clustering quality measures.

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected ClusteringQualityMeasureFinder getFinder() throws RegisterException
   :outertype: ClusteringQualityMeasureFinderThread

