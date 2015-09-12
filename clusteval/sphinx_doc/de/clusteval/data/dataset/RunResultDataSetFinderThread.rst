.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatFinderThread

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.dataset.type DataSetTypeFinderThread

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

RunResultDataSetFinderThread
============================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class RunResultDataSetFinderThread extends DataSetFinderThread

   :author: Christian Wiwie

Constructors
------------
RunResultDataSetFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetFinderThread(SupervisorThread supervisorThread, Repository framework, boolean checkOnce)
   :outertype: RunResultDataSetFinderThread

   :param supervisorThread:
   :param framework:
   :param checkOnce:

RunResultDataSetFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetFinderThread(SupervisorThread supervisorThread, Repository framework, long sleepTime, boolean checkOnce)
   :outertype: RunResultDataSetFinderThread

   :param supervisorThread:
   :param framework:
   :param sleepTime:
   :param checkOnce:

Methods
-------
afterFind
^^^^^^^^^

.. java:method:: @Override protected void afterFind()
   :outertype: RunResultDataSetFinderThread

beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: RunResultDataSetFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected RunResultDataSetFinder getFinder() throws RegisterException
   :outertype: RunResultDataSetFinderThread

