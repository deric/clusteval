.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util ArrayList

.. java:import:: java.util ConcurrentModificationException

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethodFinderThread

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureFinderThread

.. java:import:: de.clusteval.data.dataset DataSetConfigFinderThread

.. java:import:: de.clusteval.data.dataset.format DataSetFormatFinderThread

.. java:import:: de.clusteval.data.statistics DataStatisticFinderThread

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run RunFinderThread

.. java:import:: de.clusteval.run.result.format RunResultFormatFinderThread

.. java:import:: de.clusteval.run.statistics RunStatisticFinderThread

SupervisorThread
================

.. java:package:: de.clusteval.framework.threading
   :noindex:

.. java:type:: public abstract class SupervisorThread extends Thread

   This supervisor thread is responsible for starting and keeping alive all other threads of the framework. He continuously checks whether the other threads are still alive as they should. In case any of those threads terminates in an uncontrolled way, the supervisor thread restarts a new thread of the corresponding class of threads that was terminated unexpectedly.

   :author: Christian Wiwie

Fields
------
checkOnce
^^^^^^^^^

.. java:field:: protected boolean checkOnce
   :outertype: SupervisorThread

   A boolean indicating, whether this thread only should check once and then terminate. This can be useful in some subclasses of this class (e.g. \ :java:ref:`RunResultRepositorySupervisorThread`\ ).

interrupted
^^^^^^^^^^^

.. java:field:: protected boolean interrupted
   :outertype: SupervisorThread

log
^^^

.. java:field:: protected Logger log
   :outertype: SupervisorThread

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: SupervisorThread

   The repository this supervisor belongs to and for which all threads should be supervised.

supervisorSleepTime
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected long supervisorSleepTime
   :outertype: SupervisorThread

   The time between two checks of this thread.

threads
^^^^^^^

.. java:field:: protected final Map<Class<? extends ClustevalThread>, ClustevalThread> threads
   :outertype: SupervisorThread

   A map containing all threads that were started by this supervisor together with their thread class.

   This map is used by the supervisor to iterate through the existing threads and checking whether they are still alive. If the supervisor thread finds a thread in this map that terminated unexpectedly, he creates a new thread of this class.

Constructors
------------
SupervisorThread
^^^^^^^^^^^^^^^^

.. java:constructor:: public SupervisorThread(Repository repository, List<Class<? extends ClustevalThread>> threads, Map<String, Long> threadSleepTimes, boolean checkOnce)
   :outertype: SupervisorThread

   Constructor of abstract supervisor threads.

   :param repository: The repository this supervisor belongs to and for which all threads should be supervised.
   :param threads: A list containing all threads this supervisor thread should start and keep alive.
   :param threadSleepTimes: A map containing sleep times for threads (must not be complete).
   :param checkOnce: A boolean indicating, whether this thread only should check once and then terminate. This can be useful in some subclasses of this class (e.g. \ :java:ref:`RunResultRepositorySupervisorThread`\ ).

Methods
-------
createList
^^^^^^^^^^

.. java:method:: public static List<Class<? extends ClustevalThread>> createList(Class<? extends ClustevalThread>... classes)
   :outertype: SupervisorThread

   :param classes: The clusteval thread classes to add to a list.
   :return: A list of clusteval thread classes.

getClusteringQualityMeasureFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ClusteringQualityMeasureFinderThread getClusteringQualityMeasureFinderThread()
   :outertype: SupervisorThread

   :return: The thread which finds clustering quality measures.

getDataSetConfigThread
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public DataSetConfigFinderThread getDataSetConfigThread()
   :outertype: SupervisorThread

   :return: The thread which finds dataset configurations.

getDataSetFormatThread
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public DataSetFormatFinderThread getDataSetFormatThread()
   :outertype: SupervisorThread

   :return: The thread which finds dataset formats.

getDataStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public DataStatisticFinderThread getDataStatisticFinderThread()
   :outertype: SupervisorThread

   :return: The thread which finds data statistics.

getParameterOptimizationMethodFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ParameterOptimizationMethodFinderThread getParameterOptimizationMethodFinderThread()
   :outertype: SupervisorThread

   :return: The thread which finds parameter optimization methods.

getRunFinderThread
^^^^^^^^^^^^^^^^^^

.. java:method:: public RunFinderThread getRunFinderThread()
   :outertype: SupervisorThread

   :return: The thread which finds runs.

getRunResultFormatThread
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public RunResultFormatFinderThread getRunResultFormatThread()
   :outertype: SupervisorThread

   :return: The thread which finds runresult formats.

getRunScheduler
^^^^^^^^^^^^^^^

.. java:method:: public RunSchedulerThread getRunScheduler()
   :outertype: SupervisorThread

   :return: The run scheduler thread.

getRunStatisticFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public RunStatisticFinderThread getRunStatisticFinderThread()
   :outertype: SupervisorThread

   :return: The thread which finds run statistics.

getThread
^^^^^^^^^

.. java:method:: public ClustevalThread getThread(Class<? extends ClustevalThread> clazz)
   :outertype: SupervisorThread

   :param clazz: The class for which we want the thread instance
   :return: The thread instance of the passed class.

interrupt
^^^^^^^^^

.. java:method:: @Override public void interrupt()
   :outertype: SupervisorThread

run
^^^

.. java:method:: @Override public void run()
   :outertype: SupervisorThread

