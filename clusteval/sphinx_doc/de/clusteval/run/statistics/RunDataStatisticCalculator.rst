.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util ArrayList

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: de.clusteval.data.statistics RunDataStatisticCalculateException

.. java:import:: de.clusteval.data.statistics StatisticCalculateException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils StatisticCalculator

RunDataStatisticCalculator
==========================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunDataStatisticCalculator<T extends RunDataStatistic> extends StatisticCalculator<T>

   :author: Christian Wiwie
   :param <T>:

Fields
------
uniqueDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueDataIdentifiers
   :outertype: RunDataStatisticCalculator

uniqueRunIdentifiers
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueRunIdentifiers
   :outertype: RunDataStatisticCalculator

Constructors
------------
RunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticCalculator(Repository repository, long changeDate, File absPath, List<String> uniqueRunIdentifiers, List<String> uniqueDataIdentifiers) throws RegisterException
   :outertype: RunDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param uniqueRunIdentifiers:
   :param uniqueDataIdentifiers:
   :throws RegisterException:

RunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticCalculator(RunDataStatisticCalculator<T> other) throws RegisterException
   :outertype: RunDataStatisticCalculator

   The copy constructor of run data statistic calculators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculate
^^^^^^^^^

.. java:method:: @Override public T calculate() throws StatisticCalculateException
   :outertype: RunDataStatisticCalculator

calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected abstract T calculateResult() throws RunDataStatisticCalculateException
   :outertype: RunDataStatisticCalculator

clone
^^^^^

.. java:method:: @SuppressWarnings @Override public RunDataStatisticCalculator<T> clone()
   :outertype: RunDataStatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: @Override public abstract T getStatistic()
   :outertype: RunDataStatisticCalculator

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static RunDataStatistic parseFromString(Repository repository, String runDataStatistic) throws UnknownRunDataStatisticException
   :outertype: RunDataStatisticCalculator

   This method parses a string and maps it to a subclass of \ :java:ref:`RunDataStatistic`\  looking it up in the given repository.

   :param repository: The repository to look for the classes.
   :param runDataStatistic: The string representation of a run data statistic subclass.
   :throws UnknownRunDataStatisticException:
   :return: A subclass of \ :java:ref:`RunDataStatistic`\ .

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<RunDataStatistic> parseFromString(Repository repo, String[] runStatistics) throws UnknownRunDataStatisticException
   :outertype: RunDataStatisticCalculator

   This method parses several strings and maps them to subclasses of \ :java:ref:`RunDataStatistic`\  looking them up in the given repository.

   :param repo: The repository to look for the classes.
   :param runStatistics: The string representation of a run data statistic subclass.
   :throws UnknownRunDataStatisticException:
   :return: A subclass of \ :java:ref:`RunDataStatistic`\ .

