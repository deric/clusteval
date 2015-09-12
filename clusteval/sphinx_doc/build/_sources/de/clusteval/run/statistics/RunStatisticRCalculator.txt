.. java:import:: java.io File

.. java:import:: java.io IOException

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

.. java:import:: de.clusteval.data.statistics RunStatisticCalculateException

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

RunStatisticRCalculator
=======================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public abstract class RunStatisticRCalculator<T extends RunStatistic> extends RunStatisticCalculator<T>

   :author: Christian Wiwie
   :param <T>:

Constructors
------------
RunStatisticRCalculator
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticRCalculator(Repository repository, long changeDate, File absPath, String uniqueRunIdentifiers) throws RegisterException
   :outertype: RunStatisticRCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param uniqueRunIdentifiers:
   :throws RegisterException:

RunStatisticRCalculator
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticRCalculator(RunStatisticRCalculator<T> other) throws RegisterException
   :outertype: RunStatisticRCalculator

   The copy constructor of run statistic calculators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected final T calculateResult() throws RunStatisticCalculateException
   :outertype: RunStatisticRCalculator

calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract T calculateResultHelper(MyRengine rEngine) throws IncompatibleDataConfigDataStatisticException, UnknownGoldStandardFormatException, UnknownDataSetFormatException, IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, ConfigurationException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, UnknownRunResultFormatException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, InternalAttributeException, InvalidConfigurationFileException, RepositoryAlreadyExistsException, InvalidRepositoryException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, AnalysisRunResultException, RepositoryConfigNotFoundException, RepositoryConfigurationException, RegisterException, UnknownDataSetTypeException, NoDataSetException, UnknownRunDataStatisticException, RunResultParseException, REngineException, REXPMismatchException
   :outertype: RunStatisticRCalculator

