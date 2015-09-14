.. java:import:: java.io File

.. java:import:: utils ArraysExt

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

IntraInterDistributionDataStatistic
===================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class IntraInterDistributionDataStatistic extends DataStatistic

   :author: Christian Wiwie

Fields
------
interDistribution
^^^^^^^^^^^^^^^^^

.. java:field:: protected double[] interDistribution
   :outertype: IntraInterDistributionDataStatistic

intraDistribution
^^^^^^^^^^^^^^^^^

.. java:field:: protected double[] intraDistribution
   :outertype: IntraInterDistributionDataStatistic

xlabels
^^^^^^^

.. java:field:: protected double[] xlabels
   :outertype: IntraInterDistributionDataStatistic

Constructors
------------
IntraInterDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: IntraInterDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

IntraInterDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double[] xlabels, double[] intraDistribution, double[] interDistribution) throws RegisterException
   :outertype: IntraInterDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param xlabels:
   :param intraDistribution:
   :param interDistribution:
   :throws RegisterException:

IntraInterDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterDistributionDataStatistic(IntraInterDistributionDataStatistic other) throws RegisterException
   :outertype: IntraInterDistributionDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: IntraInterDistributionDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: IntraInterDistributionDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: IntraInterDistributionDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: IntraInterDistributionDataStatistic

