.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util List

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.data.statistics IncompatibleDataConfigDataStatisticException

.. java:import:: de.clusteval.data.statistics RunDataStatisticCalculateException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result AnalysisRunResultException

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.utils InternalAttributeException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: de.clusteval.utils RNotAvailableException

RunDataStatisticRCalculator
===========================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunDataStatisticRCalculator<T extends RunDataStatistic> extends RunDataStatisticCalculator<T>

   :author: Christian Wiwie
   :param <T>:

Constructors
------------
RunDataStatisticRCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticRCalculator(Repository repository, long changeDate, File absPath, List<String> uniqueRunIdentifiers, List<String> uniqueDataIdentifiers) throws RegisterException
   :outertype: RunDataStatisticRCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param uniqueRunIdentifiers:
   :param uniqueDataIdentifiers:
   :throws RegisterException:

RunDataStatisticRCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticRCalculator(RunDataStatisticRCalculator<T> other) throws RegisterException
   :outertype: RunDataStatisticRCalculator

   The copy constructor of R run data statistic calculators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected final T calculateResult() throws RunDataStatisticCalculateException
   :outertype: RunDataStatisticRCalculator

calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract T calculateResultHelper(MyRengine rEngine) throws IncompatibleDataConfigDataStatisticException, UnknownGoldStandardFormatException, UnknownDataSetFormatException, IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, ConfigurationException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, UnknownRunResultFormatException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, InternalAttributeException, InvalidConfigurationFileException, RepositoryAlreadyExistsException, InvalidRepositoryException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, AnalysisRunResultException, RepositoryConfigNotFoundException, RepositoryConfigurationException, RegisterException, UnknownDataSetTypeException, NoDataSetException, UnknownRunDataStatisticException, RunResultParseException, REngineException, REXPMismatchException
   :outertype: RunDataStatisticRCalculator

