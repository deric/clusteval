.. java:import:: java.io File

.. java:import:: utils ArraysExt

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

NodeDegreeDistributionDataStatistic
===================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class NodeDegreeDistributionDataStatistic extends DataStatistic

   :author: Christian Wiwie

Fields
------
distribution
^^^^^^^^^^^^

.. java:field:: protected double[] distribution
   :outertype: NodeDegreeDistributionDataStatistic

xlabels
^^^^^^^

.. java:field:: protected double[] xlabels
   :outertype: NodeDegreeDistributionDataStatistic

Constructors
------------
NodeDegreeDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NodeDegreeDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: NodeDegreeDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

NodeDegreeDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NodeDegreeDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double[] xlabels, double[] distribution) throws RegisterException
   :outertype: NodeDegreeDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param xlabels:
   :param distribution:
   :throws RegisterException:

NodeDegreeDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NodeDegreeDistributionDataStatistic(NodeDegreeDistributionDataStatistic other) throws RegisterException
   :outertype: NodeDegreeDistributionDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: NodeDegreeDistributionDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: NodeDegreeDistributionDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: NodeDegreeDistributionDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: NodeDegreeDistributionDataStatistic

