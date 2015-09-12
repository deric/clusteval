.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: utils ProgressPrinter

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run AnalysisRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.utils Statistic

.. java:import:: file FileUtils

AnalysisRunRunnable
===================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public abstract class AnalysisRunRunnable<S extends Statistic, R extends RunResult, IW extends AnalysisIterationWrapper<S>, IR extends AnalysisIterationRunnable> extends RunRunnable<IR, IW>

   A type of a runnable, that corresponds to \ :java:ref:`AnalysisRun`\  and is therefore responsible for analysing a object of interest. This can be for example analysis of a dataset (in case of \ :java:ref:`DataAnalysisRunRunnable`\ ) or of run results (\ :java:ref:`RunAnalysisRunRunnable`\ ).

   :author: Christian Wiwie
   :param <S>: A type of statistic, that should be assessed and stored during execution of this runnable, e.g. \ :java:ref:`DataStatistic`\ .
   :param <R>: A type of run result, that the results of this runnable will be of.

Fields
------
analysesFolder
^^^^^^^^^^^^^^

.. java:field:: protected String analysesFolder
   :outertype: AnalysisRunRunnable

   A temporary variable needed during execution of this runnable.

repo
^^^^

.. java:field:: protected Repository repo
   :outertype: AnalysisRunRunnable

   A temporary variable needed during execution of this runnable.

result
^^^^^^

.. java:field:: protected R result
   :outertype: AnalysisRunRunnable

   The runresult object is a wrapper object that tells the framework, that the result folder of this runnable in the repository results directory (see \ :java:ref:`Repository.runResultBasePath`\ ) holds a run result.

results
^^^^^^^

.. java:field:: protected List<S> results
   :outertype: AnalysisRunRunnable

   The results of this runnables are stored in a list. Every result is a single statistic object. A statistic object encapsulates its assessed value itself.

statistics
^^^^^^^^^^

.. java:field:: protected List<S> statistics
   :outertype: AnalysisRunRunnable

   A list of all statistic-classes that should be assessed during execution of this runnable.

Constructors
------------
AnalysisRunRunnable
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AnalysisRunRunnable(Run run, String runIdentString, List<S> statistics, boolean isResume)
   :outertype: AnalysisRunRunnable

   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param statistics: The statistics that should be assessed during execution of this runnable.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: @Override public void afterRun()
   :outertype: AnalysisRunRunnable

beforeRun
^^^^^^^^^

.. java:method:: @Override public void beforeRun()
   :outertype: AnalysisRunRunnable

createRunResult
^^^^^^^^^^^^^^^

.. java:method:: protected abstract R createRunResult() throws RegisterException
   :outertype: AnalysisRunRunnable

   This method creates a run result object encapsulating the results of this runnable which has the right subtype depending on the dynamic type of this class.

   :throws RegisterException:
   :return: A runresult object encapsulating the results of this runnable.

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void decorateIterationWrapper(IW iterationWrapper, int currentPos) throws RunIterationException
   :outertype: AnalysisRunRunnable

