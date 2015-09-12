.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticCalculator

DataStatisticRepositoryEntity
=============================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class DataStatisticRepositoryEntity extends DynamicRepositoryEntity<DataStatistic>

   :author: Christian Wiwie

Fields
------
dataStatisticCalculatorClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Class<? extends DataStatisticCalculator<? extends DataStatistic>>> dataStatisticCalculatorClasses
   :outertype: DataStatisticRepositoryEntity

   A map containing all classes of data statistic calculators registered in this repository.

Constructors
------------
DataStatisticRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticRepositoryEntity(Repository repository, DataStatisticRepositoryEntity parent, String basePath)
   :outertype: DataStatisticRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
getDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends DataStatisticCalculator<? extends DataStatistic>> getDataStatisticCalculator(String dataStatisticClassName)
   :outertype: DataStatisticRepositoryEntity

   This method looks up and returns (if it exists) the class of the data statistic calculator for the datastatistic class with the given name.

   :param dataStatisticClassName: The name of the datastatistic class.
   :return: The class of the data statistic calculator with the given name or null, if it does not exist.

registerDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerDataStatisticCalculator(Class<? extends DataStatisticCalculator<? extends DataStatistic>> dataStatisticCalculator)
   :outertype: DataStatisticRepositoryEntity

