.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GraphMinCutRDataStatistic
=========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class GraphMinCutRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
GraphMinCutRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphMinCutRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: GraphMinCutRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

GraphMinCutRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphMinCutRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: GraphMinCutRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

GraphMinCutRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphMinCutRDataStatistic(GraphMinCutRDataStatistic other) throws RegisterException
   :outertype: GraphMinCutRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: GraphMinCutRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: GraphMinCutRDataStatistic

