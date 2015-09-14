.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.utils Statistic

RunStatistic
============

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunStatistic extends Statistic

   A run statistic is a \ :java:ref:`Statistic`\ , which summarizes properties of clustering run results. Run statistics are assessed by a \ :java:ref:`RunAnalysisRun`\ .

   A run statistic MyRunStatistic can be added to ClustEval by

   1. extending the class :java:ref:`RunStatistic` with your own class MyRunStatistic. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your class.

     * :java:ref:`RunStatistic(Repository, boolean, long, File)` : The constructor for your run statistic. This constructor has to be implemented and public.
     * :java:ref:`RunStatistic(MyRunStatistic)` : The copy constructor for your run statistic. This constructor has to be implemented and public.
     * :java:ref:`Statistic.getAlias()` : See :java:ref:`Statistic.getAlias()`.
     * :java:ref:`Statistic.parseFromString(String)` : See :java:ref:`Statistic.parseFromString(String)`.

   2. extending the class :java:ref:`RunStatisticCalculator` with your own class MyRunStatisticCalculator . You have to provide your own implementations for the following methods.

     * :java:ref:`RunStatisticCalculator(Repository, long, File, DataConfig)` : The constructor for your run statistic calculator. This constructor has to be implemented and public.
     * :java:ref:`RunStatisticCalculator(MyRunStatisticCalculator)` : The copy constructor for your run statistic calculator. This constructor has to be implemented and public.
     * :java:ref:`RunStatisticCalculator.calculateResult()`: See :java:ref:`StatisticCalculator.calculateResult()`.
     * :java:ref:`StatisticCalculator.writeOutputTo(File)`: See :java:ref:`StatisticCalculator.writeOutputTo(File)`.

   3. Creating a jar file named MyRunStatisticCalculator.jar containing the MyRunStatistic.class and MyRunStatisticCalculator.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/run/statistics/MyRunStatistic.class
     * de/clusteval/run/statistics/MyRunStatisticCalculator.class

   4. Putting the MyRunStatistic.jar into the run statistics folder of the repository:

     * <REPOSITORY ROOT>/supp/statistics/run
     * The backend server will recognize and try to load the new run statistics automatically the next time, the RunStatisticFinderThread checks the filesystem.

   :author: Christian Wiwie

Constructors
------------
RunStatistic
^^^^^^^^^^^^

.. java:constructor:: public RunStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RunStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RunStatistic
^^^^^^^^^^^^

.. java:constructor:: public RunStatistic(RunStatistic other) throws RegisterException
   :outertype: RunStatistic

   The copy constructor of run statistics.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final RunStatistic clone()
   :outertype: RunStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static RunStatistic parseFromString(Repository repository, String runStatistic) throws UnknownRunStatisticException
   :outertype: RunStatistic

   This method parses a string and maps it to a subclass of \ :java:ref:`RunStatistic`\  looking it up in the given repository.

   :param repository: The repository to look for the classes.
   :param runStatistic: The string representation of a run statistic subclass.
   :throws UnknownRunStatisticException:
   :return: A subclass of \ :java:ref:`RunStatistic`\ .

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<RunStatistic> parseFromString(Repository repo, String[] runStatistics) throws UnknownRunStatisticException
   :outertype: RunStatistic

   This method parses several strings and maps them to subclasses of \ :java:ref:`RunStatistic`\  looking them up in the given repository.

   :param repo: The repository to look for the classes.
   :param runStatistics: The string representation of a run statistic subclass.
   :throws UnknownRunStatisticException:
   :return: A subclass of \ :java:ref:`RunStatistic`\ .

