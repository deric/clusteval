.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

NumberOfSamplesDataStatistic
============================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class NumberOfSamplesDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
NumberOfSamplesDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NumberOfSamplesDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: NumberOfSamplesDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

NumberOfSamplesDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NumberOfSamplesDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: NumberOfSamplesDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

NumberOfSamplesDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NumberOfSamplesDataStatistic(NumberOfSamplesDataStatistic other) throws RegisterException
   :outertype: NumberOfSamplesDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: NumberOfSamplesDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: NumberOfSamplesDataStatistic

