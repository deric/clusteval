.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

IntraInterOverlapDataStatistic
==============================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class IntraInterOverlapDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
IntraInterOverlapDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterOverlapDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: IntraInterOverlapDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

IntraInterOverlapDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterOverlapDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: IntraInterOverlapDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

IntraInterOverlapDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterOverlapDataStatistic(IntraInterOverlapDataStatistic other) throws RegisterException
   :outertype: IntraInterOverlapDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: IntraInterOverlapDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: IntraInterOverlapDataStatistic

