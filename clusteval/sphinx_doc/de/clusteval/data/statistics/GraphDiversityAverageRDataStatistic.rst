.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GraphDiversityAverageRDataStatistic
===================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class GraphDiversityAverageRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
GraphDiversityAverageRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphDiversityAverageRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: GraphDiversityAverageRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

GraphDiversityAverageRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphDiversityAverageRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: GraphDiversityAverageRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

GraphDiversityAverageRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphDiversityAverageRDataStatistic(GraphDiversityAverageRDataStatistic other) throws RegisterException
   :outertype: GraphDiversityAverageRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: GraphDiversityAverageRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: GraphDiversityAverageRDataStatistic

