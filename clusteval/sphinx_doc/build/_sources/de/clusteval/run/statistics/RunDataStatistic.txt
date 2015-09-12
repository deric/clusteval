.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.utils Statistic

RunDataStatistic
================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunDataStatistic extends Statistic

   A run-data statistic is a type of \ :java:ref:`Statistic`\ , which corresponds to relationships between data analysis runresults and run analysis runresults.

   Run statistics correspond to \ :java:ref:`RunAnalysisRun`\  in the class hierarchy.

   :author: Christian Wiwie

Constructors
------------
RunDataStatistic
^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RunDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RunDataStatistic
^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatistic(RunDataStatistic other) throws RegisterException
   :outertype: RunDataStatistic

   The copy constructor of run data statistics.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final RunDataStatistic clone()
   :outertype: RunDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static RunDataStatistic parseFromString(Repository repository, String runDataStatistic) throws UnknownRunDataStatisticException
   :outertype: RunDataStatistic

   This method parses a string and maps it to a subclass of \ :java:ref:`RunDataStatistic`\  looking it up in the given repository.

   :param repository: The repository to look for the classes.
   :param runDataStatistic: The string representation of a run-data statistic subclass.
   :throws UnknownRunDataStatisticException:
   :return: A subclass of \ :java:ref:`RunDataStatistic`\ .

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<RunDataStatistic> parseFromString(Repository repo, String[] runStatistics) throws UnknownRunDataStatisticException
   :outertype: RunDataStatistic

   This method parses several strings and maps them to subclasses of \ :java:ref:`RunDataStatistic`\  looking them up in the given repository.

   :param repo: The repository to look for the classes.
   :param runStatistics: The string representation of a run-data statistic subclass.
   :throws UnknownRunDataStatisticException:
   :return: A subclass of \ :java:ref:`RunDataStatistic`\ .

