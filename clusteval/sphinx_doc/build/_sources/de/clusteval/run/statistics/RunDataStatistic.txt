.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run RunDataAnalysisRun

.. java:import:: de.clusteval.utils Statistic

RunDataStatistic
================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunDataStatistic extends Statistic

   A run-data statistic is a \ :java:ref:`Statistic`\ , which summarizes relationships of clustering run results and data set properties. Run-data statistics are assessed by a \ :java:ref:`RunDataAnalysisRun`\ .

   A run-data statistic MyRunDataStatistic can be added to ClustEval by

   1. extending the class :java:ref:`RunDataStatistic` with your own class MyRunDataStatistic. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your class.

     * :java:ref:`RunDataStatistic(Repository, boolean, long, File)` : The constructor for your run-data statistic. This constructor has to be implemented and public.
     * :java:ref:`RunDataStatistic(MyRunDataStatistic)`q : The copy constructor for your run-data statistic. This constructor has to be implemented and public.
     * :java:ref:`Statistic.getAlias()` : See :java:ref:`Statistic.getAlias()`.
     * :java:ref:`Statistic.parseFromString(String)` : See :java:ref:`Statistic.parseFromString(String)`.

   2. extending the class :java:ref:`RunDataStatisticCalculator` with your own class MyRunDataStatisticCalculator . You have to provide your own implementations for the following methods.

     * :java:ref:`RunDataStatisticCalculator(Repository, long, File, DataConfig)` : The constructor for your run-data statistic calculator. This constructor has to be implemented and public.
     * :java:ref:`RunDataStatisticCalculator(MyRunDataStatisticCalculator)` : The copy constructor for your run-data statistic calculator. This constructor has to be implemented and public.
     * :java:ref:`RunDataStatisticCalculator.calculateResult()`: See :java:ref:`StatisticCalculator.calculateResult()`.
     * :java:ref:`StatisticCalculator.writeOutputTo(File)`: See :java:ref:`StatisticCalculator.writeOutputTo(File)`.

   3. Creating a jar file named MyRunDataStatisticCalculator.jar containing the MyRunDataStatistic.class and MyRunDataStatisticCalculator.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/run/statistics/MyRunDataStatistic.class
     * de/clusteval/run/statistics/MyRunDataStatisticCalculator.class

   4. Putting the MyRunDataStatistic.jar into the run-data statistics folder of the repository:

     * <REPOSITORY ROOT>/supp/statistics/rundata
     * The backend server will recognize and try to load the new run statistics automatically the next time, the RunDataStatisticFinderThread checks the filesystem.

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

