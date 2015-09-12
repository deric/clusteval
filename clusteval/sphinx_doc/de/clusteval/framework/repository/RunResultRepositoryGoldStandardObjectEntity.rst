.. java:import:: java.io FileNotFoundException

.. java:import:: java.util.concurrent ConcurrentHashMap

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset DataSetRegisterException

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.generator DataSetGenerator

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard.format GoldStandardFormat

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.data.randomizer DataRandomizer

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.db RunResultSQLCommunicator

.. java:import:: de.clusteval.framework.repository.db SQLCommunicator

.. java:import:: de.clusteval.framework.repository.db StubSQLCommunicator

.. java:import:: de.clusteval.framework.threading RunResultRepositorySupervisorThread

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.program DoubleProgramParameter

.. java:import:: de.clusteval.program IntegerProgramParameter

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program StringProgramParameter

.. java:import:: de.clusteval.program.r RProgram

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.utils Finder

.. java:import:: file FileUtils

RunResultRepositoryGoldStandardObjectEntity
===========================================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type::  class RunResultRepositoryGoldStandardObjectEntity extends StaticRepositoryEntity<GoldStandard>

Constructors
------------
RunResultRepositoryGoldStandardObjectEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultRepositoryGoldStandardObjectEntity(Repository repository, StaticRepositoryEntity<GoldStandard> parent, String basePath)
   :outertype: RunResultRepositoryGoldStandardObjectEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
register
^^^^^^^^

.. java:method:: @Override public boolean register(GoldStandard object) throws RegisterException
   :outertype: RunResultRepositoryGoldStandardObjectEntity

