.. java:import:: java.io File

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ClusteringCoefficientRDataStatistic
===================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class ClusteringCoefficientRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
ClusteringCoefficientRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ClusteringCoefficientRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ClusteringCoefficientRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: ClusteringCoefficientRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

ClusteringCoefficientRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientRDataStatistic(ClusteringCoefficientRDataStatistic other) throws RegisterException
   :outertype: ClusteringCoefficientRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ClusteringCoefficientRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: ClusteringCoefficientRDataStatistic

