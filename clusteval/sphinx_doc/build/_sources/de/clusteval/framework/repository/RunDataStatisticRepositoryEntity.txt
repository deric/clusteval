.. java:import:: java.util Map

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticCalculator

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunDataStatisticCalculator

RunDataStatisticRepositoryEntity
================================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RunDataStatisticRepositoryEntity extends DynamicRepositoryEntity<RunDataStatistic>

   :author: Christian Wiwie

Fields
------
runDataStatisticCalculatorClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>>> runDataStatisticCalculatorClasses
   :outertype: RunDataStatisticRepositoryEntity

   A map containing all classes of run data statistic calculators registered in this repository.

Constructors
------------
RunDataStatisticRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticRepositoryEntity(Repository repository, RunDataStatisticRepositoryEntity parent, String basePath)
   :outertype: RunDataStatisticRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
getRunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> getRunDataStatisticCalculator(String runDataStatisticClassName)
   :outertype: RunDataStatisticRepositoryEntity

   This method looks up and returns (if it exists) the class of the run-data statistic calculator corresponding to the run-data-statistic with the given name.

   :param runDataStatisticClassName: The name of the class of the run-data statistic.
   :return: The class of the run-data statistic calculator for the given name, or null if it does not exist.

registerRunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerRunDataStatisticCalculator(Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> object)
   :outertype: RunDataStatisticRepositoryEntity

   This method registers a new run-data statistic calculator class.

   :param object: The new class to register.
   :return: True, if the new class replaced an old one.

