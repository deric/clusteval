.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils StatisticCalculator

DataStatisticCalculator
=======================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public abstract class DataStatisticCalculator<T extends DataStatistic> extends StatisticCalculator<T>

   This class is parent class of all different kind of analyses on a DataConfig. This analyses can be performed unrelated to clustering, since it only requires the dataset (and optionally the goldstandard).

   :author: Christian Wiwie
   :param <T>:

Fields
------
dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: DataStatisticCalculator

Constructors
------------
DataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: DataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

DataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticCalculator(DataStatisticCalculator<T> other) throws RegisterException
   :outertype: DataStatisticCalculator

   The copy constructor of data statistic calculators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculate
^^^^^^^^^

.. java:method:: @Override public T calculate() throws StatisticCalculateException
   :outertype: DataStatisticCalculator

calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected abstract T calculateResult() throws DataStatisticCalculateException
   :outertype: DataStatisticCalculator

clone
^^^^^

.. java:method:: @SuppressWarnings @Override public DataStatisticCalculator<T> clone()
   :outertype: DataStatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: @Override public T getStatistic()
   :outertype: DataStatisticCalculator

