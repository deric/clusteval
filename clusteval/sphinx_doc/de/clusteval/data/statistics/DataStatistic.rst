.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run DataAnalysisRun

.. java:import:: de.clusteval.utils Statistic

DataStatistic
=============

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public abstract class DataStatistic extends Statistic

   A data statistic is a type of \ :java:ref:`Statistic`\ , which corresponds to properties of a data configuration (dataset and goldstandard).

   Data statistics correspond to \ :java:ref:`DataAnalysisRun`\  in the class hierarchy.

   :author: Christian Wiwie

Constructors
------------
DataStatistic
^^^^^^^^^^^^^

.. java:constructor:: public DataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DataStatistic
^^^^^^^^^^^^^

.. java:constructor:: public DataStatistic(DataStatistic other) throws RegisterException
   :outertype: DataStatistic

   The copy constructor of data statistics.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final DataStatistic clone()
   :outertype: DataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataStatistic parseFromString(Repository repository, String dataStatistic) throws UnknownDataStatisticException
   :outertype: DataStatistic

   This method parses a string and maps it to an instance of a \ :java:ref:`DataStatistic`\  looking its class up in the given repository.

   :param repository: The repository to look for the classes.
   :param dataStatistic: The string representation of a data statistic subclass.
   :throws UnknownDataStatisticException:
   :return: A subclass of \ :java:ref:`DataStatistic`\ .

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<DataStatistic> parseFromString(Repository repo, String[] dataStatistics) throws UnknownDataStatisticException
   :outertype: DataStatistic

   This method parses several strings and maps them to instances of \ :java:ref:`DataStatistic`\  looking their classes up in the given repository.

   :param repo: The repository to look for the classes.
   :param dataStatistics: The string representation of a data statistic subclass.
   :throws UnknownDataStatisticException:
   :return: A subclass of \ :java:ref:`DataStatistic`\ .

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean requiresGoldStandard()
   :outertype: DataStatistic

   :return: True, if this data statistic requires a goldstandard to be assessed.

