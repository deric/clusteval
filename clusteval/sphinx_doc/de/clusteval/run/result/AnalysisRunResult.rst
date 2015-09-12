.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.utils Statistic

AnalysisRunResult
=================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public abstract class AnalysisRunResult<S extends Object, T extends Statistic> extends RunResult

   :author: Christian Wiwie
   :param <S>: Type of the objects, on which the statistics are applied.
   :param <T>: Type of the Statistics

Fields
------
statistics
^^^^^^^^^^

.. java:field:: protected Map<S, List<T>> statistics
   :outertype: AnalysisRunResult

Constructors
------------
AnalysisRunResult
^^^^^^^^^^^^^^^^^

.. java:constructor:: public AnalysisRunResult(Repository repository, long changeDate, File absPath, String runIdentString, Run run) throws RegisterException
   :outertype: AnalysisRunResult

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :throws RegisterException:

AnalysisRunResult
^^^^^^^^^^^^^^^^^

.. java:constructor:: public AnalysisRunResult(AnalysisRunResult<S, T> other) throws RegisterException
   :outertype: AnalysisRunResult

   The copy constructor for analysis run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract AnalysisRunResult<S, T> clone()
   :outertype: AnalysisRunResult

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: protected abstract Map<S, List<T>> cloneStatistics(Map<S, List<T>> statistics)
   :outertype: AnalysisRunResult

   A helper method for cloning a map of statistics.

   :param statistics: The map to clone.
   :return: The cloned map.

put
^^^

.. java:method:: public void put(S object, List<T> statistics)
   :outertype: AnalysisRunResult

   :param object:
   :param statistics:

