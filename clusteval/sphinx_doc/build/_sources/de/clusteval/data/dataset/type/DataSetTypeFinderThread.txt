.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataSetTypeFinderThread
=======================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class DataSetTypeFinderThread extends FinderThread<DataSetType>

   :author: Christian Wiwie

Constructors
------------
DataSetTypeFinderThread
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetTypeFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataSetTypeFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

DataSetTypeFinderThread
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetTypeFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataSetTypeFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
afterFind
^^^^^^^^^

.. java:method:: @Override protected void afterFind()
   :outertype: DataSetTypeFinderThread

beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: DataSetTypeFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected DataSetTypeFinder getFinder() throws RegisterException
   :outertype: DataSetTypeFinderThread

