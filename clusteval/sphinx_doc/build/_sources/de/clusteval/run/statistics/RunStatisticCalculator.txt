.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: de.clusteval.data.statistics RunStatisticCalculateException

.. java:import:: de.clusteval.data.statistics StatisticCalculateException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils StatisticCalculator

RunStatisticCalculator
======================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunStatisticCalculator<T extends RunStatistic> extends StatisticCalculator<T>

   :author: Christian Wiwie
   :param <T>:

Fields
------
uniqueRunIdentifiers
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String uniqueRunIdentifiers
   :outertype: RunStatisticCalculator

Constructors
------------
RunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticCalculator(Repository repository, long changeDate, File absPath, String uniqueRunIdentifiers) throws RegisterException
   :outertype: RunStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param uniqueRunIdentifiers:
   :throws RegisterException:

RunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticCalculator(RunStatisticCalculator<T> other) throws RegisterException
   :outertype: RunStatisticCalculator

   The copy constructor of run statistic calculators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculate
^^^^^^^^^

.. java:method:: @Override public T calculate() throws StatisticCalculateException
   :outertype: RunStatisticCalculator

calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected abstract T calculateResult() throws RunStatisticCalculateException
   :outertype: RunStatisticCalculator

clone
^^^^^

.. java:method:: @SuppressWarnings @Override public RunStatisticCalculator<T> clone()
   :outertype: RunStatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: @Override public abstract T getStatistic()
   :outertype: RunStatisticCalculator

