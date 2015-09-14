.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: utils StringExt

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

LinearModelRidgeRunDataStatistic
================================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class LinearModelRidgeRunDataStatistic extends RunDataStatistic

   :author: Christian Wiwie

Fields
------
coefficients
^^^^^^^^^^^^

.. java:field:: protected Map<Pair<String, String>, double[]> coefficients
   :outertype: LinearModelRidgeRunDataStatistic

dataStatistics
^^^^^^^^^^^^^^

.. java:field:: protected List<String> dataStatistics
   :outertype: LinearModelRidgeRunDataStatistic

Constructors
------------
LinearModelRidgeRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelRidgeRunDataStatistic(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: LinearModelRidgeRunDataStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

LinearModelRidgeRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelRidgeRunDataStatistic(Repository repo, boolean register, long changeDate, File absPath, List<String> dataStatistics, Map<Pair<String, String>, double[]> coefficients) throws RegisterException
   :outertype: LinearModelRidgeRunDataStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param dataStatistics:
   :param coefficients:
   :throws RegisterException:

LinearModelRidgeRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelRidgeRunDataStatistic(LinearModelRidgeRunDataStatistic other) throws RegisterException
   :outertype: LinearModelRidgeRunDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: LinearModelRidgeRunDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: LinearModelRidgeRunDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: LinearModelRidgeRunDataStatistic

