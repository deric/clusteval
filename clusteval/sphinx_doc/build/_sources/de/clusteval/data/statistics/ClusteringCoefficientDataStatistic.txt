.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ClusteringCoefficientDataStatistic
==================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class ClusteringCoefficientDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
ClusteringCoefficientDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ClusteringCoefficientDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ClusteringCoefficientDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: ClusteringCoefficientDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

ClusteringCoefficientDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientDataStatistic(ClusteringCoefficientDataStatistic other) throws RegisterException
   :outertype: ClusteringCoefficientDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ClusteringCoefficientDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: ClusteringCoefficientDataStatistic

