.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util Collection

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Iterator

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util NoSuchElementException

.. java:import:: java.util Set

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.apache.commons.configuration HierarchicalINIConfiguration

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureParameters

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetAttributeParser

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset RunResultDataSetConfig

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.data.dataset.format ConversionStandardToInputConfiguration

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.randomizer DataRandomizer

.. java:import:: de.clusteval.data.randomizer UnknownDataRandomizerException

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.program StandaloneProgram

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r RProgram

.. java:import:: de.clusteval.program.r RProgramConfig

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run AnalysisRun

.. java:import:: de.clusteval.run ClusteringRun

.. java:import:: de.clusteval.run DataAnalysisRun

.. java:import:: de.clusteval.run ExecutionRun

.. java:import:: de.clusteval.run InternalParameterOptimizationRun

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run RobustnessAnalysisRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.run RunDataAnalysisRun

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessorParameters

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: file FileUtils

DataConfigParser
================

.. java:package:: de.clusteval.framework.repository.parse
   :noindex:

.. java:type::  class DataConfigParser extends RepositoryObjectParser<DataConfig>

Methods
-------
parseFromFile
^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromFile(File absPath) throws NoRepositoryFoundException, ConfigurationException, UnknownContextException, UnknownClusteringQualityMeasureException, RunException, UnknownDataSetFormatException, FileNotFoundException, RegisterException, UnknownParameterType, IncompatibleContextException, UnknownRunResultFormatException, InvalidOptimizationParameterException, UnknownProgramParameterException, UnknownProgramTypeException, UnknownRProgramException, GoldStandardNotFoundException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, NoDataSetException, DataConfigurationException, DataConfigNotFoundException, NumberFormatException, UnknownDistanceMeasureException, UnknownDataSetTypeException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, IncompatibleParameterOptimizationMethodException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownDataStatisticException, UnknownRunStatisticException, UnknownRunDataStatisticException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: DataConfigParser

