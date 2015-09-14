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

   A data statistic is a \ :java:ref:`Statistic`\ , which summarizes properties of data sets. Data statistics are assessed by a \ :java:ref:`DataAnalysisRun`\ .

   A data statistic MyDataStatistic can be added to ClustEval by

   1. extending the class :java:ref:`DataStatistic` with your own class MyDataStatistic. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your class.

     * :java:ref:`DataStatistic(Repository, boolean, long, File)` : The constructor for your data statistic. This constructor has to be implemented and public.
     * :java:ref:`DataStatistic(MyDataStatistic)` : The copy constructor for your data statistic. This constructor has to be implemented and public.
     * :java:ref:`Statistic.getAlias()` : See :java:ref:`Statistic.getAlias()`.
     * :java:ref:`Statistic.parseFromString(String)` : See :java:ref:`Statistic.parseFromString(String)`.

   2. extending the class :java:ref:`DataStatisticCalculator` with your own class MyDataStatisticCalculator . You have to provide your own implementations for the following methods.

     * :java:ref:`DataStatisticCalculator(Repository, long, File, DataConfig)` : The constructor for your data statistic calculator. This constructor has to be implemented and public.
     * :java:ref:`DataStatisticCalculator(MyDataStatisticCalculator)` : The copy constructor for your data statistic calculator. This constructor has to be implemented and public.
     * :java:ref:`DataStatisticCalculator.calculateResult()`: See :java:ref:`StatisticCalculator.calculateResult()`.
     * :java:ref:`StatisticCalculator.writeOutputTo(File)`: See :java:ref:`StatisticCalculator.writeOutputTo(File)`.

   3. Creating a jar file named MyDataStatisticCalculator.jar containing the MyDataStatistic.class and MyDataStatisticCalculator.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/run/statistics/MyDataStatistic.class
     * de/clusteval/run/statistics/MyDataStatisticCalculator.class

   4. Putting the MyDataStatistic.jar into the data statistics folder of the repository:

     * <REPOSITORY ROOT>/supp/statistics/data
     * The backend server will recognize and try to load the new data statistics automatically the next time, the DataStatisticFinderThread checks the filesystem.

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

