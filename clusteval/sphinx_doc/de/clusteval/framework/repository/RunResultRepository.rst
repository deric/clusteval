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

.. java:import:: de.clusteval.framework.repository.db DatabaseConnectException

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

RunResultRepository
===================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RunResultRepository extends Repository

   A runresult repository corresponds to a runresult directory in the results directory of its parent repository.

   The runresult directories contain copies of the inputs and configurations at the time, the corresponding runs were started. Therefore every runresult directory can be treated as an individual smaller repository which contains a subset of the files as a regular \ :java:ref:`Repository`\ .

   :author: Christian Wiwie

Constructors
------------
RunResultRepository
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultRepository(String basePath, Repository parent) throws FileNotFoundException, RepositoryAlreadyExistsException, InvalidRepositoryException, RepositoryConfigNotFoundException, RepositoryConfigurationException, DatabaseConnectException
   :outertype: RunResultRepository

   :param basePath: The absolute path of the root directory of this repository.
   :param parent: The parent repository.
   :throws RepositoryConfigNotFoundException:
   :throws RepositoryAlreadyExistsException:
   :throws RepositoryConfigurationException:
   :throws DatabaseConnectException:
   :throws InvalidRepositoryException:
   :throws FileNotFoundException:

Methods
-------
createSQLCommunicator
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected SQLCommunicator createSQLCommunicator() throws DatabaseConnectException
   :outertype: RunResultRepository

createSupervisorThread
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected SupervisorThread createSupervisorThread()
   :outertype: RunResultRepository

info
^^^^

.. java:method:: @Override protected void info(String message)
   :outertype: RunResultRepository

initAttributes
^^^^^^^^^^^^^^

.. java:method:: @Override protected void initAttributes()
   :outertype: RunResultRepository

initializePaths
^^^^^^^^^^^^^^^

.. java:method:: @Override protected void initializePaths() throws InvalidRepositoryException
   :outertype: RunResultRepository

warn
^^^^

.. java:method:: @Override protected void warn(String message)
   :outertype: RunResultRepository

