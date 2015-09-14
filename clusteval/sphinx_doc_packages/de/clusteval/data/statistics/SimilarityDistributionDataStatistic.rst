.. java:import:: java.io File

.. java:import:: utils ArraysExt

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

SimilarityDistributionDataStatistic
===================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class SimilarityDistributionDataStatistic extends DataStatistic

   :author: Christian Wiwie

Fields
------
distribution
^^^^^^^^^^^^

.. java:field:: protected double[] distribution
   :outertype: SimilarityDistributionDataStatistic

xlabels
^^^^^^^

.. java:field:: protected double[] xlabels
   :outertype: SimilarityDistributionDataStatistic

Constructors
------------
SimilarityDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimilarityDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: SimilarityDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SimilarityDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimilarityDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double[] xlabels, double[] distribution) throws RegisterException
   :outertype: SimilarityDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param xlabels:
   :param distribution:
   :throws RegisterException:

SimilarityDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimilarityDistributionDataStatistic(SimilarityDistributionDataStatistic other) throws RegisterException
   :outertype: SimilarityDistributionDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SimilarityDistributionDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: SimilarityDistributionDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: SimilarityDistributionDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: SimilarityDistributionDataStatistic

