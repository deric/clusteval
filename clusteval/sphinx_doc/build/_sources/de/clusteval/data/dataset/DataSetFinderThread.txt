.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatFinderThread

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.dataset.type DataSetTypeFinderThread

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataSetFinderThread
===================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetFinderThread extends FinderThread<DataSet>

   :author: Christian Wiwie

Constructors
------------
DataSetFinderThread
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: DataSetFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

DataSetFinderThread
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataSetFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: DataSetFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected DataSetFinder getFinder() throws RegisterException
   :outertype: DataSetFinderThread

