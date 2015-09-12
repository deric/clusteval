.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.statistics IncompatibleDataConfigDataStatisticException

.. java:import:: de.clusteval.data.statistics RunStatisticCalculateException

.. java:import:: de.clusteval.data.statistics StatisticCalculateException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result AnalysisRunResultException

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

StatisticCalculator
===================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class StatisticCalculator<T extends Statistic> extends RepositoryObject

   Together with every statistic class comes a calculator class, which is a factory class for the corresponding statistic. The calculator has a \ :java:ref:`calculate()`\  method, which calculates, stores and returns a statistic object.

   :author: Christian Wiwie
   :param <T>:

Fields
------
lastResult
^^^^^^^^^^

.. java:field:: protected T lastResult
   :outertype: StatisticCalculator

   This attribute holds the statistic, after \ :java:ref:`calculate()`\  has been invoked.

Constructors
------------
StatisticCalculator
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StatisticCalculator(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: StatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

StatisticCalculator
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StatisticCalculator(StatisticCalculator<T> other) throws RegisterException
   :outertype: StatisticCalculator

   The copy constructor of statistic calculators

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculate
^^^^^^^^^

.. java:method:: public T calculate() throws StatisticCalculateException
   :outertype: StatisticCalculator

   Calculate the result. This method stores the calculated result in the \ :java:ref:`lastResult`\  attribute for later usage, e.g. in \ :java:ref:`writeOutputTo(File)`\ .

   :throws StatisticCalculateException:
   :return: The calculated statistic.

calculateResult
^^^^^^^^^^^^^^^

.. java:method:: protected abstract T calculateResult() throws StatisticCalculateException
   :outertype: StatisticCalculator

   Overwrite this method in subclasses to provide your own statistic calculator type.

   :throws UnknownDataStatisticException:
   :throws UnknownGoldStandardFormatException:
   :throws UnknownRunStatisticException:
   :throws REngineException:
   :throws DataSetConfigurationException:
   :throws RepositoryConfigurationException:
   :throws InterruptedException:
   :throws UnknownParameterType:
   :throws UnknownContextException:
   :throws UnknownRProgramException:
   :throws IncompatibleContextException:
   :throws UnknownRunResultPostprocessorException:
   :throws RegisterException:
   :throws UnknownDistanceMeasureException:
   :throws IncompatibleParameterOptimizationMethodException:
   :throws UnknownProgramParameterException:
   :throws UnknownRunDataStatisticException:
   :throws UnknownDataPreprocessorException:
   :throws NoOptimizableProgramParameterException:
   :throws NoRepositoryFoundException:
   :throws InvalidRepositoryException:
   :throws UnknownDataSetFormatException:
   :throws AnalysisRunResultException:
   :throws UnknownRunResultFormatException:
   :throws IncompatibleDataSetConfigPreprocessorException:
   :throws DataSetNotFoundException:
   :throws InvalidDataSetFormatVersionException:
   :throws ConfigurationException:
   :throws GoldStandardConfigNotFoundException:
   :throws IncompatibleDataConfigDataStatisticException:
   :throws UnknownParameterOptimizationMethodException:
   :throws UnknownDataSetTypeException:
   :throws RepositoryAlreadyExistsException:
   :throws InvalidOptimizationParameterException:
   :throws RunResultParseException:
   :throws IOException:
   :throws InternalAttributeException:
   :throws DataConfigNotFoundException:
   :throws UnknownClusteringQualityMeasureException:
   :throws UnknownProgramTypeException:
   :throws DataConfigurationException:
   :throws RunStatisticCalculateException:
   :throws InvalidRunModeException:
   :throws GoldStandardConfigurationException:
   :throws RepositoryConfigNotFoundException:
   :throws NoDataSetException:
   :throws IllegalArgumentException:
   :throws InvalidConfigurationFileException:
   :throws DataSetConfigNotFoundException:
   :throws RunException:
   :throws GoldStandardNotFoundException:
   :throws RNotAvailableException:
   :return: The calculated statistic.

clone
^^^^^

.. java:method:: @Override public abstract StatisticCalculator<T> clone()
   :outertype: StatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: public T getStatistic()
   :outertype: StatisticCalculator

   :return: The statistic calculated during the last \ :java:ref:`calculate()`\  invocation.

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: public abstract void writeOutputTo(File absFolderPath) throws REngineException, RNotAvailableException, InterruptedException
   :outertype: StatisticCalculator

   :param absFolderPath: The absolute path to the folder where the statistic should be written to.
   :throws RNotAvailableException:
   :throws InterruptedException:
   :throws REngineException:

