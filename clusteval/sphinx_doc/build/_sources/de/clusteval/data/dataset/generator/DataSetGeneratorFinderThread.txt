.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.utils FinderThread

DataSetGeneratorFinderThread
============================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type:: public class DataSetGeneratorFinderThread extends FinderThread<DataSetGenerator>

   :author: Christian Wiwie

Constructors
------------
DataSetGeneratorFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetGeneratorFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: DataSetGeneratorFinderThread

   :param supervisorThread:
   :param repository:
   :param checkOnce:

DataSetGeneratorFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetGeneratorFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: DataSetGeneratorFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
getFinder
^^^^^^^^^

.. java:method:: @Override protected DataSetGeneratorFinder getFinder() throws RegisterException
   :outertype: DataSetGeneratorFinderThread

