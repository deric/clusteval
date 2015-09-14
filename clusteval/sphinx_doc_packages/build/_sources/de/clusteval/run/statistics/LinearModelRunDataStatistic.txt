.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: utils StringExt

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

LinearModelRunDataStatistic
===========================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class LinearModelRunDataStatistic extends RunDataStatistic

   :author: Christian Wiwie

Fields
------
coefficients
^^^^^^^^^^^^

.. java:field:: protected Map<Pair<String, String>, double[]> coefficients
   :outertype: LinearModelRunDataStatistic

dataStatistics
^^^^^^^^^^^^^^

.. java:field:: protected List<String> dataStatistics
   :outertype: LinearModelRunDataStatistic

Constructors
------------
LinearModelRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelRunDataStatistic(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: LinearModelRunDataStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

LinearModelRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelRunDataStatistic(Repository repo, boolean register, long changeDate, File absPath, List<String> dataStatistics, Map<Pair<String, String>, double[]> coefficients) throws RegisterException
   :outertype: LinearModelRunDataStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param dataStatistics:
   :param coefficients:
   :throws RegisterException:

LinearModelRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelRunDataStatistic(LinearModelRunDataStatistic other) throws RegisterException
   :outertype: LinearModelRunDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: LinearModelRunDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: LinearModelRunDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: LinearModelRunDataStatistic

