.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GraphAdhesionRDataStatistic
===========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class GraphAdhesionRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
GraphAdhesionRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphAdhesionRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: GraphAdhesionRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

GraphAdhesionRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphAdhesionRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: GraphAdhesionRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

GraphAdhesionRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphAdhesionRDataStatistic(GraphAdhesionRDataStatistic other) throws RegisterException
   :outertype: GraphAdhesionRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: GraphAdhesionRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: GraphAdhesionRDataStatistic

