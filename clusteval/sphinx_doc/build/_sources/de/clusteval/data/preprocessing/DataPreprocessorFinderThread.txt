.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataPreprocessorFinderThread
============================

.. java:package:: de.clusteval.data.preprocessing
   :noindex:

.. java:type:: public class DataPreprocessorFinderThread extends FinderThread<DataPreprocessor>

   :author: Christian Wiwie

Constructors
------------
DataPreprocessorFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataPreprocessorFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataPreprocessorFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

DataPreprocessorFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataPreprocessorFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataPreprocessorFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected DataPreprocessorFinder getFinder() throws RegisterException
   :outertype: DataPreprocessorFinderThread

