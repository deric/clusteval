.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GraphCohesionRDataStatistic
===========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class GraphCohesionRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
GraphCohesionRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphCohesionRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: GraphCohesionRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

GraphCohesionRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphCohesionRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: GraphCohesionRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

GraphCohesionRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphCohesionRDataStatistic(GraphCohesionRDataStatistic other) throws RegisterException
   :outertype: GraphCohesionRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: GraphCohesionRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: GraphCohesionRDataStatistic

