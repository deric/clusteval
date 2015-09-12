.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataSetFormatFinderThread
=========================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public class DataSetFormatFinderThread extends FinderThread<DataSetFormat>

   :author: Christian Wiwie

Constructors
------------
DataSetFormatFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormatFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataSetFormatFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

DataSetFormatFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormatFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataSetFormatFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected DataSetFormatFinder getFinder() throws RegisterException
   :outertype: DataSetFormatFinderThread

