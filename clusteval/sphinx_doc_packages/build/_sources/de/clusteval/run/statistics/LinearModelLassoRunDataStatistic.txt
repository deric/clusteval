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

LinearModelLassoRunDataStatistic
================================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class LinearModelLassoRunDataStatistic extends RunDataStatistic

   :author: Christian Wiwie

Fields
------
coefficients
^^^^^^^^^^^^

.. java:field:: protected Map<Pair<String, String>, double[]> coefficients
   :outertype: LinearModelLassoRunDataStatistic

dataStatistics
^^^^^^^^^^^^^^

.. java:field:: protected List<String> dataStatistics
   :outertype: LinearModelLassoRunDataStatistic

Constructors
------------
LinearModelLassoRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelLassoRunDataStatistic(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: LinearModelLassoRunDataStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

LinearModelLassoRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelLassoRunDataStatistic(Repository repo, boolean register, long changeDate, File absPath, List<String> dataStatistics, Map<Pair<String, String>, double[]> coefficients) throws RegisterException
   :outertype: LinearModelLassoRunDataStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param dataStatistics:
   :param coefficients:
   :throws RegisterException:

LinearModelLassoRunDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelLassoRunDataStatistic(LinearModelLassoRunDataStatistic other) throws RegisterException
   :outertype: LinearModelLassoRunDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: LinearModelLassoRunDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: LinearModelLassoRunDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: LinearModelLassoRunDataStatistic

