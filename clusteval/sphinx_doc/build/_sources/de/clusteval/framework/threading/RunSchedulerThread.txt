.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Queue

.. java:import:: java.util Set

.. java:import:: java.util.concurrent ConcurrentLinkedQueue

.. java:import:: java.util.concurrent Future

.. java:import:: java.util.concurrent ScheduledThreadPoolExecutor

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils Pair

.. java:import:: utils Triple

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run MissingParameterValueException

.. java:import:: de.clusteval.run RUN_STATUS

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunInitializationException

.. java:import:: de.clusteval.run.result NoRunResultFormatParserException

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.runnable IterationRunnable

.. java:import:: de.clusteval.run.runnable IterationWrapper

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnableInitializationException

.. java:import:: file FileUtils

RunSchedulerThread
==================

.. java:package:: de.clusteval.framework.threading
   :noindex:

.. java:type:: public class RunSchedulerThread extends ClustevalThread

   Threads of this class are responsible for scheduling, creating, starting and terminating runs.

   The methods \ :java:ref:`schedule(String,String)`\ , \ :java:ref:`scheduleResume(String,String)`\  and \ :java:ref:`terminate(String,String)`\  of this thread are invoked by the backend server \ :java:ref:`ClustevalBackendServer`\  which in turn gets its commands from a client.

   :author: Christian Wiwie

Fields
------
activeIterationRunnables
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<Thread, IterationRunnable<? extends IterationWrapper>> activeIterationRunnables
   :outertype: RunSchedulerThread

clientToRunResumes
^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Collection<Run>> clientToRunResumes
   :outertype: RunSchedulerThread

   A map containing all the run resumes that are executed right now. The map maps from client id to collections of runs.

clientToRuns
^^^^^^^^^^^^

.. java:field:: protected Map<String, Collection<Run>> clientToRuns
   :outertype: RunSchedulerThread

   A map containing all the runs that are executed right now. The map maps from client id to collections of runs.

iterationThreadPool
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ScheduledThreadPoolExecutor iterationThreadPool
   :outertype: RunSchedulerThread

   A thread pool containing all threads that were started to execute iteration runnables. Iteration runnables are started by certain types of run runnables (e.g. ParameterOptimizationRunRunnables)

log
^^^

.. java:field:: protected Logger log
   :outertype: RunSchedulerThread

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: RunSchedulerThread

   The repository this run scheduler belongs to. This scheduler can only control runs that are contained in this repository.

runQueue
^^^^^^^^

.. java:field:: protected Queue<Triple<String, String, Boolean>> runQueue
   :outertype: RunSchedulerThread

   A queue containing all the runs that were scheduled, but not yet executed. Every entry of the queue contains (clientId,runId,isResume).

threadPool
^^^^^^^^^^

.. java:field:: protected ScheduledThreadPoolExecutor threadPool
   :outertype: RunSchedulerThread

   A thread pool containing all threads that were started to execute runs. This data structure allows convenient control over the number of threads to be started in parallel.

Constructors
------------
RunSchedulerThread
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunSchedulerThread(SupervisorThread supervisorThread, Repository repository, int numberThreads)
   :outertype: RunSchedulerThread

   Constructor of run scheduler threads.

   :param supervisorThread:
   :param repository: The repository this run scheduler belongs to. This scheduler can only control runs that are contained in this repository.
   :param numberThreads: The maximal number of threads to run in parallel.

Methods
-------
getActiveIterationRunnables
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public synchronized Map<Thread, IterationRunnable<? extends IterationWrapper>> getActiveIterationRunnables()
   :outertype: RunSchedulerThread

getOptimizationRunStatusForClientId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Pair<Pair<RUN_STATUS, Float>, Map<Pair<String, String>, Pair<Double, Map<String, Pair<Map<String, String>, String>>>>>> getOptimizationRunStatusForClientId(String clientId)
   :outertype: RunSchedulerThread

   :param clientId:

getQueue
^^^^^^^^

.. java:method:: public Queue<String> getQueue()
   :outertype: RunSchedulerThread

   :return: A collection containing names of all enqueued runs and run resumes.

getRunStatusForClientId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Pair<RUN_STATUS, Float>> getRunStatusForClientId(String clientId)
   :outertype: RunSchedulerThread

   This method is invoked by \ :java:ref:`ClustevalBackendServer.getRunStatusForClientId(String)`\  and gets the status of all runs and run resumes scheduled and executed by the user with the given id.

   :param clientId: The id of the client for which we want to know the status of its scheduled and executed runs and run resumes.
   :return: A map containing the id of the runs and run resumes together with their current status and percentage (if currently executing).

getRuns
^^^^^^^

.. java:method:: public Set<Run> getRuns()
   :outertype: RunSchedulerThread

   :return: A collection of runs, that have been executed or resumed.

informOnFinishedIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public synchronized void informOnFinishedIterationRunnable(Thread t, IterationRunnable runnable)
   :outertype: RunSchedulerThread

informOnStartedIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public synchronized void informOnStartedIterationRunnable(Thread t, IterationRunnable runnable)
   :outertype: RunSchedulerThread

interrupt
^^^^^^^^^

.. java:method:: @Override public void interrupt()
   :outertype: RunSchedulerThread

registerIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Future<?> registerIterationRunnable(IterationRunnable iterationRunnable)
   :outertype: RunSchedulerThread

registerRunRunnable
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Future<?> registerRunRunnable(RunRunnable runRunnable)
   :outertype: RunSchedulerThread

   This method takes a \ :java:ref:`RunRunnable`\  and adds it to the thread pool of this run scheduler thread. The thread pool then determines, when the runnable can and will be performed depending on the available ressources.

   :param runRunnable: The new runnable to perform.
   :return: A future object, that allows to retrieve the current status of the execution of the runnable.

run
^^^

.. java:method:: @Override public void run()
   :outertype: RunSchedulerThread

schedule
^^^^^^^^

.. java:method:: public boolean schedule(String clientId, String runId)
   :outertype: RunSchedulerThread

   This method is invoked by \ :java:ref:`ClustevalBackendServer.performRun(String,String)`\  and schedules a run. As soon as ressources are available this run is then performed in an asynchronous way in its own thread.

   :param clientId: The id of the client that wants to schedule this run.
   :param runId: The id of the run that should be scheduled
   :return: True, if successful. That means, a run with the given id must exist and the run has not been scheduled already.

scheduleResume
^^^^^^^^^^^^^^

.. java:method:: public boolean scheduleResume(String clientId, String uniqueRunResultIdentifier)
   :outertype: RunSchedulerThread

   This method is invoked by \ :java:ref:`ClustevalBackendServer.resumeRun(String,String)`\  and schedules a resume of a run. As soon as ressources are available this resume is then performed in an asynchronous way in its own thread.

   :param clientId: The id of the client that wants to schedule this run.
   :param uniqueRunResultIdentifier: The unique identifier of the run result that should be resumed.
   :return: True, if successful. That means, a run result with the given id must exist and the run has not been scheduled already.

terminate
^^^^^^^^^

.. java:method:: public boolean terminate(String clientId, String runId)
   :outertype: RunSchedulerThread

   This method is invoked by \ :java:ref:`ClustevalBackendServer.terminateRun(String,String)`\  and terminates a run that is currently being executed.

   :param clientId: The id of the client that wants to terminate this run.
   :param runId: The id of the run that should be terminated
   :return: True, if successful. That means, a run with the given id must exist and it is currently being executed.

terminate
^^^^^^^^^

.. java:method:: protected boolean terminate(String clientId, String runId, boolean isResume)
   :outertype: RunSchedulerThread

updateThreadPoolSize
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public synchronized void updateThreadPoolSize(int numberThreads)
   :outertype: RunSchedulerThread

