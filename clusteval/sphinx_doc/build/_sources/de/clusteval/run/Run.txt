.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util.concurrent CancellationException

.. java:import:: java.util.concurrent ExecutionException

.. java:import:: utils Pair

.. java:import:: utils ProgressPrinter

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run.result ClusteringRunResult

.. java:import:: de.clusteval.run.result NoRunResultFormatParserException

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnableInitializationException

.. java:import:: file FileUtils

.. java:import:: format Formatter

Run
===

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public abstract class Run extends RepositoryObject

   A representation of an abstract run including configurations and results. A run is an entity, that can be performed by the framework. Depending on the concrete subclass of the run, actions during execution differ. After execution of the run results are stored in \ :java:ref:`results`\ .

   A run corresponds to a *.run-file on the file system in the run-directory of the repository. The name of the run is deduced from the filesystem in \ :java:ref:`getName()`\ , thus it is unique for every repository.

   Every time a run is performed, its results are also stored in a new subdirectory in the results-directory of the repository. The subdirectory is named after the \ :java:ref:`runIdentString`\ , which consists of a time-stamp and the name of this run.

   When a run is performed, it's divided into a number of atomic operations that can be performed in parallel, objects of subclasses of \ :java:ref:`RunRunnable`\ . Those are then passed to the run scheduler and are performed in any order in parallel.

   :author: Christian Wiwie

Fields
------
context
^^^^^^^

.. java:field:: protected Context context
   :outertype: Run

   Every run belongs to a context.

logFilePath
^^^^^^^^^^^

.. java:field:: protected String logFilePath
   :outertype: Run

   The path to the log file in the results-directory of the execution of this run.

progress
^^^^^^^^

.. java:field:: protected volatile ProgressPrinter progress
   :outertype: Run

   Keeps track of the progress of this run when it is executed. Can be used to get a percental status.

results
^^^^^^^

.. java:field:: protected List<RunResult> results
   :outertype: Run

   After this run was performed using the \ :java:ref:`perform()`\  method, all the results are stored in this list. If this run is a ExecutionRun this list contains one \ :java:ref:`ClusteringRunResult`\  object for every executed combination of program and dataset.

runIdentString
^^^^^^^^^^^^^^

.. java:field:: protected String runIdentString
   :outertype: Run

   Unique identifier of this run - consists of a time & date stamp, as well as the name of the run. This string is inserted into the results path of every run, to avoid overwriting of any files (input, output, whatsoever) between several runs.

runnables
^^^^^^^^^

.. java:field:: protected List<RunRunnable> runnables
   :outertype: Run

   Contains the runnable objects created during the execution of this run.

startTime
^^^^^^^^^

.. java:field:: protected long startTime
   :outertype: Run

   The starting time of the execution of this run. Is used to calculate the duration of the execution afterwards.

status
^^^^^^

.. java:field:: protected RUN_STATUS status
   :outertype: Run

   The status of this run.

   Initially when a Run object is created its status is \ :java:ref:`RUN_STATUS.INACTIVE`\ .

   When a Run should be performed it is passed to the run scheduler. Then the runs status is \ :java:ref:`RUN_STATUS.SCHEDULED`\ .

   As soon as the run is started by the scheduler, the runs status is \ :java:ref:`RUN_STATUS.RUNNING`\ .

   After the runs completion its status is \ :java:ref:`RUN_STATUS.FINISHED`\ .

   When the run is terminated by the user during its execution and before it's finished its status is \ :java:ref:`RUN_STATUS.TERMINATED`\ .

Constructors
------------
Run
^^^

.. java:constructor:: protected Run(Repository repository, Context context, long changeDate, File absPath) throws RegisterException
   :outertype: Run

   The constructor of this class takes a date and configuration. It is protected, to force usage of the static method

   :param repository: the repository
   :param context: The context of this run
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :throws RegisterException:

Run
^^^

.. java:constructor:: protected Run(Run otherRun) throws RegisterException
   :outertype: Run

   A copy constructor for the Run class.

   Runnables, run results and status of the given run are not copied into the new run.

   :param otherRun: The run to clone.
   :throws RegisterException:

Methods
-------
afterPerform
^^^^^^^^^^^^

.. java:method:: protected void afterPerform()
   :outertype: Run

   This method is invoked by \ :java:ref:`perform(RunSchedulerThread)`\  after completion of \ :java:ref:`doPerform(RunSchedulerThread)`\ .

   Override this method to do any postcalculations on the run results after everything is finished.

afterResume
^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected void afterResume(String runIdentString)
   :outertype: Run

   This method is invoked by \ :java:ref:`resume(RunSchedulerThread,String)`\  after completion of \ :java:ref:`doResume(RunSchedulerThread,String)`\ .

   Override this method to do any postcalculations on the run results after everything is finished.

   :param runIdentString: The unique run identifier of the results directory, corresponding to an execution of a run, that should by resumed.

beforePerform
^^^^^^^^^^^^^

.. java:method:: protected void beforePerform() throws IOException, RunInitializationException
   :outertype: Run

   This method is invoked by \ :java:ref:`perform(RunSchedulerThread)`\  before \ :java:ref:`doPerform(RunSchedulerThread)`\  is invoked.

   Override this method in subclasses to do any operation, that should only be done once per run execution, and before any runnable is started. This can be useful for logging or for filesystem operations like copying any input files to avoid overriding files unintentionally when they would be performed in the runnables asynchronously instead.

   :throws RunInitializationException:

beforeResume
^^^^^^^^^^^^

.. java:method:: protected void beforeResume(String runIdentString) throws RunInitializationException
   :outertype: Run

   This method is invoked by \ :java:ref:`resume(RunSchedulerThread,String)`\  before \ :java:ref:`doResume(RunSchedulerThread,String)`\  is invoked.

   Override this method in subclasses to do any operation, that should only be done once per run execution, and before any runnable is started. This can be useful for logging or for filesystem operations like copying any input files to avoid overriding files unintentionally when they would be performed in the runnables asynchronously instead.

   :param runIdentString: The unique run identifier of the results directory, corresponding to an execution of a run, that should by resumed.
   :throws RunInitializationException:
   :throws IOException:

clone
^^^^^

.. java:method:: @Override public abstract Run clone()
   :outertype: Run

cloneParameterValues
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static List<Map<ProgramParameter<?>, String>> cloneParameterValues(List<Map<ProgramParameter<?>, String>> parameterValues)
   :outertype: Run

   This method is invoked by different copy-constructors of subclasses of this Run, e.g. by ExecutionRun.ExecutionRun(ExecutionRun) to clone a given run object.

   It is a convenience method to clone a map containing parameter values.

   :param parameterValues:

copyConfigurationFiles
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void copyConfigurationFiles(boolean isResume)
   :outertype: Run

   When this run is performed, this method copies all configuration files to the results directory.

   This method is invoked by \ :java:ref:`beforePerform()`\  or \ :java:ref:`beforeResume(String)`\ . Thus it is not executed asynchronously to avoid overwriting of several threads in the result directory.

   :param isResume: Indicates, whether the execution of this run is a resumption or not.

createAndScheduleRunnableForResumePair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract RunRunnable createAndScheduleRunnableForResumePair(RunSchedulerThread runScheduler, int p) throws RunRunnableInitializationException
   :outertype: Run

   This method will be invoked by \ :java:ref:`doResume(RunSchedulerThread)`\  to create the p'th runnable for the resumption of an execution of this run and to submit it to the run scheduler.

   :param runScheduler: The run scheduler to which the newly created runnable should be passed.
   :param p: The index of the runnable to be created.
   :throws RunRunnableInitializationException:

createAndScheduleRunnableForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract RunRunnable createAndScheduleRunnableForRunPair(RunSchedulerThread runScheduler, int p) throws RunRunnableInitializationException
   :outertype: Run

   This method will be invoked by \ :java:ref:`doPerform(RunSchedulerThread)`\  to create the p'th runnable for the execution of this run and to submit it to the run scheduler.

   :param runScheduler: The run scheduler to which the newly created runnable should be passed.
   :param p: The index of the runnable to be created.
   :throws RunRunnableInitializationException:

doPerform
^^^^^^^^^

.. java:method:: public void doPerform(RunSchedulerThread runScheduler) throws RunRunnableInitializationException
   :outertype: Run

   This method creates instances of subclasses of RunRunnable and passes them to the run scheduler. The run scheduler then executes the run runnables at some point in the future depending on the available physical ressources.

   The RunRunnable objects represent atomic peaces of the overall run, which can be executed in parallel.

   :param runScheduler: The run scheduler, this run should be executed by.
   :throws RunRunnableInitializationException:

doResume
^^^^^^^^

.. java:method:: @SuppressWarnings public void doResume(RunSchedulerThread runScheduler, String runIdentString) throws RunRunnableInitializationException
   :outertype: Run

   This method will perform this run, i.e. it combines every program with every dataset contained in this run's configuration. For every such combination the result of this will be added to the list of run results

   :param runScheduler: The run scheduler, this run should be executed by.
   :param runIdentString: The unique run identifier of the results directory, corresponding to an execution of a run, that should by resumed.
   :throws RunRunnableInitializationException:

getContext
^^^^^^^^^^

.. java:method:: public Context getContext()
   :outertype: Run

   :return: The context of this run.

getLogFilePath
^^^^^^^^^^^^^^

.. java:method:: public String getLogFilePath()
   :outertype: Run

   :return: The path to the log file when this run is executed.

   **See also:** :java:ref:`.logFilePath`

getMovedConfigsDir
^^^^^^^^^^^^^^^^^^

.. java:method:: protected File getMovedConfigsDir()
   :outertype: Run

   This method constructs and returns the path to the configuration subdirectory in the results directory of this run execution.

   This method should only be invoked while a run is executed, because only then the unique run identification string is set.

   :return: The path to the configuration subdirectory in the results directory of this run execution.

getMovedGoldStandardsDir
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected File getMovedGoldStandardsDir()
   :outertype: Run

   This method constructs and returns the path to the goldstandard subdirectory in the results directory of this run execution.

   This method should only be invoked while a run is executed, because only then the unique run identification string is set.

   :return: The path to the goldstandard subdirectory in the results directory of this run execution.

getMovedInputsDir
^^^^^^^^^^^^^^^^^

.. java:method:: protected File getMovedInputsDir()
   :outertype: Run

   This method constructs and returns the path to the dataset subdirectory in the results directory of this run execution.

   This method should only be invoked while a run is executed, because only then the unique run identification string is set.

   :return: The path to the dataset subdirectory in the results directory of this run execution.

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Run

   The name of a run is used to uniquely identify runs.

   The name of a run is deduced from the filename of the run file. It is the filename without file extension.

   :return: the name

getNumberOfRunRunnables
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getNumberOfRunRunnables()
   :outertype: Run

   :return: The number of run runnables this run will create. This number will be used in the \ :java:ref:`doPerform(RunSchedulerThread)`\  method to create the correct number of runnables.

getOptimizationStatus
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<Pair<String, String>, Pair<Double, Map<String, Pair<Map<String, String>, String>>>> getOptimizationStatus()
   :outertype: Run

   :return: A map with the optimization status of this run.

getPercentFinished
^^^^^^^^^^^^^^^^^^

.. java:method:: public float getPercentFinished()
   :outertype: Run

   Returns the current status of this run execution in terms of finished percentage. Depending on the current status of the run, this method returns different values:

   If the run is scheduled, finished or terminated this method always returns 100%.

   If the run is currently running, the percentage of the execution is returned.

   Otherwise this method returns 0%.

   :return: The percent finished

getResults
^^^^^^^^^^

.. java:method:: public List<RunResult> getResults()
   :outertype: Run

   Gets the results.

   :return: Get the list of run results that are produced by the execution of this run.

getRunIdentificationString
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRunIdentificationString()
   :outertype: Run

   :return: The unique run identification string created when this run is executed.

   **See also:** :java:ref:`.runIdentString`

getRunRunnables
^^^^^^^^^^^^^^^

.. java:method:: public List<RunRunnable> getRunRunnables()
   :outertype: Run

   :return: A list containing all run runnables this run created during its execution.

getStatus
^^^^^^^^^

.. java:method:: public RUN_STATUS getStatus()
   :outertype: Run

   :return: the status

   **See also:** :java:ref:`.status`

getUpperLimitProgress
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract long getUpperLimitProgress()
   :outertype: Run

   Implement this method in subclasses to provide the number of steps this run performs before it is finished. This method is then later on used by the method \ :java:ref:`getPercentFinished()`\  to calculate the finished percentage.

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: Run

perform
^^^^^^^

.. java:method:: public void perform(RunSchedulerThread runScheduler) throws IOException, RunRunnableInitializationException, RunInitializationException
   :outertype: Run

   This method will perform this run.

   First this method invokes \ :java:ref:`beforePerform()`\  and does all necessary preoperations before the actual run is started. Afterwards in \ :java:ref:`doPerform(RunSchedulerThread)`\  the runnables are created and executed asynchronously by the run scheduler. Then invoking \ :java:ref:`waitForRunnablesToFinish()`\  guarantees that the method waits until all calculations are finished. Last \ :java:ref:`afterPerform()`\  performs additional operations with the results after all calculations are finished.

   :param runScheduler: The run scheduler, this run should be executed by.
   :throws RunRunnableInitializationException:
   :throws IOException: Signals that an I/O exception has occurred.
   :throws RunInitializationException:

resume
^^^^^^

.. java:method:: @SuppressWarnings public void resume(RunSchedulerThread runScheduler, String runIdentString) throws MissingParameterValueException, IOException, NoRunResultFormatParserException, RunRunnableInitializationException, RunInitializationException
   :outertype: Run

   This method will resume a previously started run. This method should only be invoked on a run, that was parsed from a runresult folder. Otherwise it will show unexpected behaviour.

   :param runScheduler: The run scheduler, this run should be executed by.
   :param runIdentString: The unique run identifier of the results directory, corresponding to an execution of a run, that should by resumed.
   :throws MissingParameterValueException: If a parameter required in the invocation line of some program, is neither set in the program nor in the run configuration, an exception will be thrown.
   :throws IOException: Signals that an I/O exception has occurred.
   :throws RunInitializationException:
   :throws NoRunResultFormatParserException: For every \ :java:ref:`RunResultFormat`\  there needs to be a parser, that converts this format into the default format of the framework for later analysis. If no such parser exists for some format, this exception will be thrown.
   :throws RunRunnableInitializationException:

setStatus
^^^^^^^^^

.. java:method:: public void setStatus(RUN_STATUS status)
   :outertype: Run

   Sets the status of this run.

   :param status:

terminate
^^^^^^^^^

.. java:method:: public abstract boolean terminate()
   :outertype: Run

   This method terminates the execution of this run. It waits for the termination of all corresponding threads.

   :return: True if everything, including all corresponding threads, could be terminated, false otherwise.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Run

waitForRunnablesToFinish
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void waitForRunnablesToFinish()
   :outertype: Run

   This method is invoked by \ :java:ref:`perform(RunSchedulerThread)`\ , after completion of \ :java:ref:`doPerform(RunSchedulerThread)`\ .

   It waits, until all threads (corresponding to created runnables) are finished.

   During this time, it updates the progress after completion of single threads, such that \ :java:ref:`getPercentFinished()`\  returns the correct value.

   Additionally it checks, whether any of the threads threw exceptions and prints those exceptions.

