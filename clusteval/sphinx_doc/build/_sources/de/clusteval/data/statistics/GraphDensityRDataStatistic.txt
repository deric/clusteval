.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GraphDensityRDataStatistic
==========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class GraphDensityRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
GraphDensityRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphDensityRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: GraphDensityRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

GraphDensityRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphDensityRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: GraphDensityRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

GraphDensityRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphDensityRDataStatistic(GraphDensityRDataStatistic other) throws RegisterException
   :outertype: GraphDensityRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: GraphDensityRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: GraphDensityRDataStatistic

