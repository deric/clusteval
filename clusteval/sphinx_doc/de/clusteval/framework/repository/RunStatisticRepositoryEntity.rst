.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics RunStatisticCalculator

RunStatisticRepositoryEntity
============================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RunStatisticRepositoryEntity extends DynamicRepositoryEntity<RunStatistic>

   :author: Christian Wiwie

Fields
------
runStatisticCalculatorClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Class<? extends RunStatisticCalculator<? extends RunStatistic>>> runStatisticCalculatorClasses
   :outertype: RunStatisticRepositoryEntity

   A map containing all classes of run data statistic calculators registered in this repository.

Constructors
------------
RunStatisticRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticRepositoryEntity(Repository repository, RunStatisticRepositoryEntity parent, String basePath)
   :outertype: RunStatisticRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
getRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends RunStatisticCalculator<? extends RunStatistic>> getRunStatisticCalculator(String runStatisticClassName)
   :outertype: RunStatisticRepositoryEntity

   This method looks up and returns (if it exists) the class of the run-data statistic calculator corresponding to the run-data-statistic with the given name.

   :param runStatisticClassName: The name of the class of the run-data statistic.
   :return: The class of the run-data statistic calculator for the given name, or null if it does not exist.

registerRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerRunStatisticCalculator(Class<? extends RunStatisticCalculator<? extends RunStatistic>> object)
   :outertype: RunStatisticRepositoryEntity

   This method registers a new run-data statistic calculator class.

   :param object: The new class to register.
   :return: True, if the new class replaced an old one.

