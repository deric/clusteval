.. java:import:: java.io File

.. java:import:: java.io FilenameFilter

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils ProgressPrinter

.. java:import:: utils.parse TextFileParser

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: ch.qos.logback.classic Level

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureParameters

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSet

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

.. java:import:: de.clusteval.data.randomizer UnknownDataRandomizerException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.db DatabaseConnectException

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils FormatConversionException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: de.clusteval.utils RNotAvailableException

.. java:import:: file FileUtils

MyProgressPrinter
=================

.. java:package:: de.clusteval.tools
   :noindex:

.. java:type::  class MyProgressPrinter extends ProgressPrinter

Constructors
------------
MyProgressPrinter
^^^^^^^^^^^^^^^^^

.. java:constructor:: public MyProgressPrinter(long upperLimit, boolean printOnNewPercent)
   :outertype: MyProgressPrinter

Methods
-------
log
^^^

.. java:method:: @Override protected void log(String message)
   :outertype: MyProgressPrinter

