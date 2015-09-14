.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: utils Pair

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ParameterImportanceRunStatistic
===============================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class ParameterImportanceRunStatistic extends RunStatistic

   :author: Christian Wiwie

Fields
------
parameterImportances
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<Pair<String, String>, Map<String, Double>> parameterImportances
   :outertype: ParameterImportanceRunStatistic

Constructors
------------
ParameterImportanceRunStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterImportanceRunStatistic(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ParameterImportanceRunStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ParameterImportanceRunStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterImportanceRunStatistic(Repository repo, boolean register, long changeDate, File absPath, Map<Pair<String, String>, Map<String, Double>> parameterImportances) throws RegisterException
   :outertype: ParameterImportanceRunStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param parameterNames:
   :param parameterImportances:
   :throws RegisterException:

ParameterImportanceRunStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterImportanceRunStatistic(ParameterImportanceRunStatistic other) throws RegisterException
   :outertype: ParameterImportanceRunStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ParameterImportanceRunStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: ParameterImportanceRunStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ParameterImportanceRunStatistic

