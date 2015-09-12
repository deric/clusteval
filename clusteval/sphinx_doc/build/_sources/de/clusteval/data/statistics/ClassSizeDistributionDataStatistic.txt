.. java:import:: java.io File

.. java:import:: utils ArraysExt

.. java:import:: utils StringExt

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ClassSizeDistributionDataStatistic
==================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class ClassSizeDistributionDataStatistic extends DataStatistic

   :author: Christian Wiwie

Fields
------
classLabels
^^^^^^^^^^^

.. java:field:: protected String[] classLabels
   :outertype: ClassSizeDistributionDataStatistic

distribution
^^^^^^^^^^^^

.. java:field:: protected double[] distribution
   :outertype: ClassSizeDistributionDataStatistic

Constructors
------------
ClassSizeDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClassSizeDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ClassSizeDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ClassSizeDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClassSizeDistributionDataStatistic(Repository repository, boolean register, long changeDate, File absPath, String[] classLabels, double[] distribution) throws RegisterException
   :outertype: ClassSizeDistributionDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param classLabels:
   :param distribution:
   :throws RegisterException:

ClassSizeDistributionDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClassSizeDistributionDataStatistic(ClassSizeDistributionDataStatistic other) throws RegisterException
   :outertype: ClassSizeDistributionDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ClassSizeDistributionDataStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: ClassSizeDistributionDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: ClassSizeDistributionDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ClassSizeDistributionDataStatistic

