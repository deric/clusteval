.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

DoubleValueDataStatistic
========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public abstract class DoubleValueDataStatistic extends DataStatistic

   :author: Christian Wiwie

Fields
------
value
^^^^^

.. java:field:: protected double value
   :outertype: DoubleValueDataStatistic

Constructors
------------
DoubleValueDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DoubleValueDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: DoubleValueDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

DoubleValueDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DoubleValueDataStatistic(DoubleValueDataStatistic other) throws RegisterException
   :outertype: DoubleValueDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getValue
^^^^^^^^

.. java:method:: public double getValue()
   :outertype: DoubleValueDataStatistic

   :return: The double value of this statistic.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: DoubleValueDataStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: DoubleValueDataStatistic

