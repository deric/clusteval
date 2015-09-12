.. java:import:: java.io BufferedReader

.. java:import:: java.io BufferedWriter

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.io InputStreamReader

.. java:import:: java.io PrintWriter

.. java:import:: java.io StringWriter

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.concurrent CancellationException

.. java:import:: java.util.concurrent ExecutionException

.. java:import:: java.util.concurrent Future

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils ProgressPrinter

.. java:import:: de.clusteval.data.dataset.format IncompatibleDataSetFormatException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard IncompleteGoldStandardException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run RUN_STATUS

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.utils InternalAttributeException

RunRunnable
===========

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public abstract class RunRunnable<IR extends IterationRunnable, IW extends IterationWrapper> implements Runnable

   An abstract class that corresponds to a smaller atomic part of a \ :java:ref:`Run`\ . A runnable is executed asynchronously and no order among runnables is guaranteed.

   Objects of subclasses of this class are created in \ :java:ref:`Run.perform(RunSchedulerThread)`\  (in subclasses) and later executed by the RunScheduler. One instance represents the execution of one subunit of the overall run. The results are added and stored in \ :java:ref:`Run.results`\  in a synchronized way.

   In the class hierarchy this class corresponds to the \ :java:ref:`Run`\  class.

   :author: Christian Wiwie

Fields
------
exceptions
^^^^^^^^^^

.. java:field:: protected List<Throwable> exceptions
   :outertype: RunRunnable

   If exceptions are thrown during the execution it is stored in the following attributes. It will not been thrown automatically, to avoid disrupting the successive optimization iterations. If one wants to check for these exceptions afterwards, one can use the corresponding getter methods.

future
^^^^^^

.. java:field:: protected Future<?> future
   :outertype: RunRunnable

   This object can be used to get the status of the runnable thread.

futureToIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<Future<?>, Runnable> futureToIterationRunnable
   :outertype: RunRunnable

   A map from futures to iteration runnables to be able to handle termination of threads and processes started in the respective iteration run runnable in \ :java:ref:`afterRun()`\

futures
^^^^^^^

.. java:field:: protected List<Future<?>> futures
   :outertype: RunRunnable

   This list holds wrapper objects for each iteration runnable started.

isResume
^^^^^^^^

.. java:field:: protected boolean isResume
   :outertype: RunRunnable

   This attribute indicates, whether this run is a resumption of a previous execution or a completely new execution.

iterationRunnables
^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<IR> iterationRunnables
   :outertype: RunRunnable

lastStartTime
^^^^^^^^^^^^^

.. java:field:: protected long lastStartTime
   :outertype: RunRunnable

   This attribute is used to store the last start time in case this runnable is paused and resumed.

log
^^^

.. java:field:: protected Logger log
   :outertype: RunRunnable

   A logger that keeps track of all actions done by the runnable.

paused
^^^^^^

.. java:field:: protected boolean paused
   :outertype: RunRunnable

   True, if this runnable is paused, false otherwise.

progress
^^^^^^^^

.. java:field:: protected ProgressPrinter progress
   :outertype: RunRunnable

   Keep track of the progress of this runnable. In case of parameter optimization mode, it will increase by one after every percent reached of the parameter sets to evaluate.

run
^^^

.. java:field:: protected Run run
   :outertype: RunRunnable

   The run this runnable object was created by.

runThreadIdentString
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String runThreadIdentString
   :outertype: RunRunnable

   The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.

runningTime
^^^^^^^^^^^

.. java:field:: protected long runningTime
   :outertype: RunRunnable

   This attribute holds the running time after finishing the runnable.

terminated
^^^^^^^^^^

.. java:field:: protected boolean terminated
   :outertype: RunRunnable

   This boolean helper indicates, whether this run runnable has been terminated. We use this boolean instead of the future of this run runnable to signal termination, because the run thread belonging to this runnable will immediately terminate if this run runnable future is cancelled. However, in some cases the termination of this run runnable's iteration runnables takes some time. Then we want to set the future of this runnabel to cancalled only after all iteration runnables are terminated.

Constructors
------------
RunRunnable
^^^^^^^^^^^

.. java:constructor:: public RunRunnable(Run run, String runIdentString, boolean isResume)
   :outertype: RunRunnable

   Instantiates a new run runnable.

   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: protected void afterRun() throws InterruptedException
   :outertype: RunRunnable

   This method is invoked by \ :java:ref:`run()`\  after \ :java:ref:`doRun()`\  has finished. It is responsible for cleaning up all files, folders and for doing all kinds of postcalculations.

   :throws InterruptedException:

beforeRun
^^^^^^^^^

.. java:method:: @SuppressWarnings protected void beforeRun() throws UnknownDataSetFormatException, InvalidDataSetFormatVersionException, IllegalArgumentException, IOException, RegisterException, InternalAttributeException, IncompatibleDataSetFormatException, UnknownGoldStandardFormatException, IncompleteGoldStandardException, InterruptedException
   :outertype: RunRunnable

   This method is invoked by \ :java:ref:`run()`\  before anything else is done. It can be overwritten and used in subclasses to do any precalculations or requirements like copying or moving files.

   :throws UnknownGoldStandardFormatException:
   :throws IncompatibleDataSetFormatException:
   :throws IllegalArgumentException:
   :throws InterruptedException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws InternalAttributeException:
   :throws IncompleteGoldStandardException:
   :throws InvalidDataSetFormatVersionException:
   :throws RegisterException:

checkForInterrupted
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected final boolean checkForInterrupted()
   :outertype: RunRunnable

   Checks whether this runnable thread has been interrupted. If yes, it prints out a simple log statement and.

   :return: True, if this thread was interrupted, false otherwise.

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int consumeNextIteration() throws RunIterationException
   :outertype: RunRunnable

createIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract IR createIterationRunnable(IW iterationWrapper)
   :outertype: RunRunnable

createIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract IW createIterationWrapper()
   :outertype: RunRunnable

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void decorateIterationWrapper(IW iterationWrapper, int currentPos) throws RunIterationException
   :outertype: RunRunnable

doRun
^^^^^

.. java:method:: protected void doRun() throws RunIterationException
   :outertype: RunRunnable

   This method is invoked by \ :java:ref:`run()`\  after \ :java:ref:`beforeRun()`\  has finished and is responsible for the operation and execution of the runnable itself.

doRunIteration
^^^^^^^^^^^^^^

.. java:method:: protected abstract void doRunIteration(IW iterationWrapper) throws RunIterationException
   :outertype: RunRunnable

getExceptions
^^^^^^^^^^^^^

.. java:method:: public List<Throwable> getExceptions()
   :outertype: RunRunnable

   :return: A list with all exceptions thrown during execution of this runnable.

   **See also:** :java:ref:`.exceptions`

getFuture
^^^^^^^^^

.. java:method:: public Future<?> getFuture()
   :outertype: RunRunnable

   The future object of a runnable is only initialized, when it has been started.

   :return: The future object of this runnable.

   **See also:** :java:ref:`.future`

getProgressPrinter
^^^^^^^^^^^^^^^^^^

.. java:method:: public ProgressPrinter getProgressPrinter()
   :outertype: RunRunnable

   :return: The progress printer of this runnable.

   **See also:** :java:ref:`.progress`

getRun
^^^^^^

.. java:method:: public Run getRun()
   :outertype: RunRunnable

   :return: The run this runnable belongs to.

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean hasNextIteration()
   :outertype: RunRunnable

isCancelled
^^^^^^^^^^^

.. java:method:: public boolean isCancelled()
   :outertype: RunRunnable

   :return: True, if this runnable's thread has been cancelled.

isDone
^^^^^^

.. java:method:: public boolean isDone()
   :outertype: RunRunnable

   :return: True, if this runnable's thread has finished its execution.

isInterrupted
^^^^^^^^^^^^^

.. java:method:: protected final boolean isInterrupted()
   :outertype: RunRunnable

   Checks whether this runnable thread has been interrupted.

   :return: True, if this thread was interrupted, false otherwise.

isPaused
^^^^^^^^

.. java:method:: public boolean isPaused()
   :outertype: RunRunnable

   :return: True, if this runnable's thread has been paused.

pause
^^^^^

.. java:method:: public void pause()
   :outertype: RunRunnable

   This method pauses this runnable's thread until \ :java:ref:`resume()`\  is invoked. If it was paused before this invocation will be ignored.

resume
^^^^^^

.. java:method:: public void resume()
   :outertype: RunRunnable

   This method resumes this runnable's thread, after it has been paused. If it wasn't paused before this invocation will be ignored.

run
^^^

.. java:method:: @Override public final void run()
   :outertype: RunRunnable

submitIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void submitIterationRunnable(IR iterationRunnable)
   :outertype: RunRunnable

terminate
^^^^^^^^^

.. java:method:: public void terminate()
   :outertype: RunRunnable

waitFor
^^^^^^^

.. java:method:: public final void waitFor() throws InterruptedException, ExecutionException
   :outertype: RunRunnable

   This method causes the caller to wait for this runnable's thread to finish its execution.

   This method also waits in case this runnable has not yet been started (the future object has not yet been initialized).

   :throws CancellationException:
   :throws InterruptedException:
   :throws ExecutionException:

