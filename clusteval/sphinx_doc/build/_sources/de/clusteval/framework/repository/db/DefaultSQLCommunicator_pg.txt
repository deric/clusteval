.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.sql SQLException

.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureParameters

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.repository.config SQLConfig

.. java:import:: de.clusteval.program DoubleProgramParameter

.. java:import:: de.clusteval.program IntegerProgramParameter

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.program StringProgramParameter

.. java:import:: de.clusteval.run AnalysisRun

.. java:import:: de.clusteval.run ClusteringRun

.. java:import:: de.clusteval.run DataAnalysisRun

.. java:import:: de.clusteval.run ExecutionRun

.. java:import:: de.clusteval.run InternalParameterOptimizationRun

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.run RunDataAnalysisRun

.. java:import:: de.clusteval.run.result AnalysisRunResult

.. java:import:: de.clusteval.run.result ClusteringRunResult

.. java:import:: de.clusteval.run.result DataAnalysisRunResult

.. java:import:: de.clusteval.run.result ExecutionRunResult

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunAnalysisRunResult

.. java:import:: de.clusteval.run.result RunDataAnalysisRunResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.utils Statistic

DefaultSQLCommunicator_pg
=========================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: @SuppressWarnings public class DefaultSQLCommunicator_pg extends SQLCommunicator

   A default sql communicator is the standard implementation of the abstract \ :java:ref:`SQLCommunicator`\  and is intended as a default for standard repositories of type \ :java:ref:`Repository`\ .

   Subclasses of \ :java:ref:`Repository`\ , e.g. \ :java:ref:`RunResultRepository`\  have their own sql communicator implementations.

   :author: Christian Wiwie

Fields
------
mysqlConfig
^^^^^^^^^^^

.. java:field:: protected SQLConfig mysqlConfig
   :outertype: DefaultSQLCommunicator_pg

   A sql communicator needs a mysql configuration to know, how to connect to the database server.

Constructors
------------
DefaultSQLCommunicator_pg
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DefaultSQLCommunicator_pg(Repository repository, SQLConfig mysqlConfig)
   :outertype: DefaultSQLCommunicator_pg

   :param repository: The repository this communicator belongs to.
   :param mysqlConfig: The mysql configuration this communicator should use.

Methods
-------
getClusterId
^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterId(int clusteringId, String name) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getClusterObjectId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterObjectId(int clusterId, String name) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getClusteringId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusteringId(String absPath) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getDBPassword
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBPassword()
   :outertype: DefaultSQLCommunicator_pg

getDBUsername
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBUsername()
   :outertype: DefaultSQLCommunicator_pg

getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getDatabase
^^^^^^^^^^^

.. java:method:: @Override protected String getDatabase()
   :outertype: DefaultSQLCommunicator_pg

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getParameterSetId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetId(int runResultParamOptId) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getParameterSetParameterId
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterId(int run_results_parameter_optimizations_parameter_set_id, int program_parameter_id) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getParameterSetParameterValuesId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterValuesId(int run_results_parameter_optimizations_parameter_set_id, int program_parameter_id, int iteration) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getProgramParameterTypeId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getProgramParameterTypeId(String typeName) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryId(String absPath) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRepositoryTypeId
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryTypeId(String repositoryType) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunAnalysisId(int run_id) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunExecutionId(int run_id) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunId
^^^^^^^^

.. java:method:: @Override protected int getRunId(Run run) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunResultAnalysisId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultAnalysisId(int run_results_id) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultExecutionId(int run_results_id) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunResultRunAnalysisId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultRunAnalysisId(int run_results_analysis_id) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getRunTypeId
^^^^^^^^^^^^

.. java:method:: @Override protected int getRunTypeId(String name) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getServer
^^^^^^^^^

.. java:method:: @Override protected String getServer()
   :outertype: DefaultSQLCommunicator_pg

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getStatisticId(String statisticsName) throws SQLException
   :outertype: DefaultSQLCommunicator_pg

getTableClusterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterObjects()
   :outertype: DefaultSQLCommunicator_pg

getTableClusteringQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusteringQualityMeasures()
   :outertype: DefaultSQLCommunicator_pg

getTableClusterings
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterings()
   :outertype: DefaultSQLCommunicator_pg

getTableClusters
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusters()
   :outertype: DefaultSQLCommunicator_pg

getTableDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataConfigs()
   :outertype: DefaultSQLCommunicator_pg

getTableDataSetConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetConfigs()
   :outertype: DefaultSQLCommunicator_pg

getTableDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetFormats()
   :outertype: DefaultSQLCommunicator_pg

getTableDataSetTypes
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetTypes()
   :outertype: DefaultSQLCommunicator_pg

getTableDatasets
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDatasets()
   :outertype: DefaultSQLCommunicator_pg

getTableGoldStandardConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandardConfigs()
   :outertype: DefaultSQLCommunicator_pg

getTableGoldStandards
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandards()
   :outertype: DefaultSQLCommunicator_pg

getTableOptimizableProgramParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableOptimizableProgramParameters()
   :outertype: DefaultSQLCommunicator_pg

getTableParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationMethods()
   :outertype: DefaultSQLCommunicator_pg

getTableParameterOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationQualities()
   :outertype: DefaultSQLCommunicator_pg

getTableParameterSetIterations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetIterations()
   :outertype: DefaultSQLCommunicator_pg

getTableParameterSetParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameterValues()
   :outertype: DefaultSQLCommunicator_pg

getTableParameterSetParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameters()
   :outertype: DefaultSQLCommunicator_pg

getTableParameterSets
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSets()
   :outertype: DefaultSQLCommunicator_pg

getTableProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigs()
   :outertype: DefaultSQLCommunicator_pg

getTableProgramConfigsCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigsCompatibleDataSetFormats()
   :outertype: DefaultSQLCommunicator_pg

getTableProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameter()
   :outertype: DefaultSQLCommunicator_pg

getTableProgramParameterType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameterType()
   :outertype: DefaultSQLCommunicator_pg

getTablePrograms
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTablePrograms()
   :outertype: DefaultSQLCommunicator_pg

getTableRepositories
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositories()
   :outertype: DefaultSQLCommunicator_pg

getTableRepositoryTypes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositoryTypes()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultFormats()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResults
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResults()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsAnalysis()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsClustering
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClustering()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsClusteringsQuality
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClusteringsQuality()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsDataAnalysis()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsExecution
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsExecution()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsParameterOptimization()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsRunAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunAnalysis()
   :outertype: DefaultSQLCommunicator_pg

getTableRunResultsRunDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunDataAnalysis()
   :outertype: DefaultSQLCommunicator_pg

getTableRunTypes
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunTypes()
   :outertype: DefaultSQLCommunicator_pg

getTableRuns
^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRuns()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysis
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysis()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisData
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisData()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisDataDataIdentifiers()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisRun
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRun()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisRunData
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunData()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisRunDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataDataIdentifiers()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisRunDataRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataRunIdentifiers()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisRunRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunRunIdentifiers()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsAnalysisStatistics
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisStatistics()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsClustering()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsExecution
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecution()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsExecutionDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionDataConfigs()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsExecutionParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionParameterValues()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsExecutionProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionProgramConfigs()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsExecutionQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionQualityMeasures()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsInternalParameterOptimization()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimization()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationMethods()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsParameterOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationParameters()
   :outertype: DefaultSQLCommunicator_pg

getTableRunsParameterOptimizationQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationQualityMeasures()
   :outertype: DefaultSQLCommunicator_pg

getTableStatistics
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatistics()
   :outertype: DefaultSQLCommunicator_pg

getTableStatisticsData
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsData()
   :outertype: DefaultSQLCommunicator_pg

getTableStatisticsRun
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRun()
   :outertype: DefaultSQLCommunicator_pg

getTableStatisticsRunData
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRunData()
   :outertype: DefaultSQLCommunicator_pg

isInfinity
^^^^^^^^^^

.. java:method:: protected boolean isInfinity(double d)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected boolean register(Run object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected boolean register(AnalysisRun<Statistic> object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataAnalysisRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(RunAnalysisRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(RunDataAnalysisRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected boolean register(ExecutionRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ClusteringRun run, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(InternalParameterOptimizationRun run, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ParameterOptimizationRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ProgramConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(Program object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandardConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandard object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DoubleProgramParameter object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(IntegerProgramParameter object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(StringProgramParameter object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSet object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(Clustering object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSetConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(RunResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public boolean register(ExecutionRunResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(ClusteringRunResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(ParameterOptimizationResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public boolean register(AnalysisRunResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(DataAnalysisRunResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(RunAnalysisRunResult object)
   :outertype: DefaultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(RunDataAnalysisRunResult object)
   :outertype: DefaultSQLCommunicator_pg

registerClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: DefaultSQLCommunicator_pg

registerContextClass
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected boolean registerContextClass(Class<? extends Context> object)
   :outertype: DefaultSQLCommunicator_pg

registerDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: DefaultSQLCommunicator_pg

registerDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: DefaultSQLCommunicator_pg

registerDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: DefaultSQLCommunicator_pg

registerParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: DefaultSQLCommunicator_pg

registerRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: DefaultSQLCommunicator_pg

registerRunResultFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunResultFormatClass(Class<? extends RunResultFormat> object)
   :outertype: DefaultSQLCommunicator_pg

registerRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: DefaultSQLCommunicator_pg

replaceInfinity
^^^^^^^^^^^^^^^

.. java:method:: protected String replaceInfinity(double d)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Clustering object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramConfig object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Program object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandardConfig object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandard object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSet object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataConfig object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSetConfig object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramParameter<?> programParameter)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Run object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ParameterOptimizationResult object)
   :outertype: DefaultSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(RunResult object)
   :outertype: DefaultSQLCommunicator_pg

unregisterClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterContextClass
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected boolean unregisterContextClass(Class<? extends Context> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunResultFormat(Class<? extends RunResultFormat> object)
   :outertype: DefaultSQLCommunicator_pg

unregisterRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: DefaultSQLCommunicator_pg

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean updateStatusOfRun(Run run, String runStatus)
   :outertype: DefaultSQLCommunicator_pg

