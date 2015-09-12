.. java:import:: java.sql SQLException

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program DoubleProgramParameter

.. java:import:: de.clusteval.program IntegerProgramParameter

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

StubSQLCommunicator_pg
======================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: @SuppressWarnings public class StubSQLCommunicator_pg extends SQLCommunicator

   :author: Christian Wiwie

Constructors
------------
StubSQLCommunicator_pg
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StubSQLCommunicator_pg(Repository repository)
   :outertype: StubSQLCommunicator_pg

   :param repository:

Methods
-------
commitDB
^^^^^^^^

.. java:method:: @Override public void commitDB()
   :outertype: StubSQLCommunicator_pg

getClusterId
^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterId(int clusteringId, String name) throws SQLException
   :outertype: StubSQLCommunicator_pg

getClusterObjectId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterObjectId(int clusterId, String name) throws SQLException
   :outertype: StubSQLCommunicator_pg

getClusteringId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusteringId(String name) throws SQLException
   :outertype: StubSQLCommunicator_pg

getDBPassword
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBPassword()
   :outertype: StubSQLCommunicator_pg

getDBUsername
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBUsername()
   :outertype: StubSQLCommunicator_pg

getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: StubSQLCommunicator_pg

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: StubSQLCommunicator_pg

getDatabase
^^^^^^^^^^^

.. java:method:: @Override protected String getDatabase()
   :outertype: StubSQLCommunicator_pg

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: StubSQLCommunicator_pg

getParameterSetId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetId(int runResultParamOptId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getParameterSetParameterId
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterId(int parameterSetId, int parameterId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getParameterSetParameterValuesId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterValuesId(int parameterSetId, int parameterId, int iteration) throws SQLException
   :outertype: StubSQLCommunicator_pg

getProgramParameterTypeId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getProgramParameterTypeId(String typeName) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryId(String absPath) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRepositoryTypeId
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryTypeId(String repositoryType) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunAnalysisId(int runId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunExecutionId(int runId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunId
^^^^^^^^

.. java:method:: @Override protected int getRunId(Run run) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunResultAnalysisId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultAnalysisId(int runResultId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultExecutionId(int runResultId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunResultRunAnalysisId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultRunAnalysisId(int runResultAnalysisId) throws SQLException
   :outertype: StubSQLCommunicator_pg

getRunTypeId
^^^^^^^^^^^^

.. java:method:: @Override protected int getRunTypeId(String name) throws SQLException
   :outertype: StubSQLCommunicator_pg

getServer
^^^^^^^^^

.. java:method:: @Override protected String getServer()
   :outertype: StubSQLCommunicator_pg

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getStatisticId(String statisticsName) throws SQLException
   :outertype: StubSQLCommunicator_pg

getTableClusterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterObjects()
   :outertype: StubSQLCommunicator_pg

getTableClusteringQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusteringQualityMeasures()
   :outertype: StubSQLCommunicator_pg

getTableClusterings
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterings()
   :outertype: StubSQLCommunicator_pg

getTableClusters
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusters()
   :outertype: StubSQLCommunicator_pg

getTableDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataConfigs()
   :outertype: StubSQLCommunicator_pg

getTableDataSetConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetConfigs()
   :outertype: StubSQLCommunicator_pg

getTableDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetFormats()
   :outertype: StubSQLCommunicator_pg

getTableDataSetTypes
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetTypes()
   :outertype: StubSQLCommunicator_pg

getTableDatasets
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDatasets()
   :outertype: StubSQLCommunicator_pg

getTableGoldStandardConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandardConfigs()
   :outertype: StubSQLCommunicator_pg

getTableGoldStandards
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandards()
   :outertype: StubSQLCommunicator_pg

getTableOptimizableProgramParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableOptimizableProgramParameters()
   :outertype: StubSQLCommunicator_pg

getTableParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationMethods()
   :outertype: StubSQLCommunicator_pg

getTableParameterOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationQualities()
   :outertype: StubSQLCommunicator_pg

getTableParameterSetIterations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetIterations()
   :outertype: StubSQLCommunicator_pg

getTableParameterSetParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameterValues()
   :outertype: StubSQLCommunicator_pg

getTableParameterSetParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameters()
   :outertype: StubSQLCommunicator_pg

getTableParameterSets
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSets()
   :outertype: StubSQLCommunicator_pg

getTableProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigs()
   :outertype: StubSQLCommunicator_pg

getTableProgramConfigsCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigsCompatibleDataSetFormats()
   :outertype: StubSQLCommunicator_pg

getTableProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameter()
   :outertype: StubSQLCommunicator_pg

getTableProgramParameterType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameterType()
   :outertype: StubSQLCommunicator_pg

getTablePrograms
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTablePrograms()
   :outertype: StubSQLCommunicator_pg

getTableRepositories
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositories()
   :outertype: StubSQLCommunicator_pg

getTableRepositoryTypes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositoryTypes()
   :outertype: StubSQLCommunicator_pg

getTableRunResultFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultFormats()
   :outertype: StubSQLCommunicator_pg

getTableRunResults
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResults()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsAnalysis()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsClustering
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClustering()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsClusteringsQuality
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClusteringsQuality()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsDataAnalysis()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsExecution
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsExecution()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsParameterOptimization()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsRunAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunAnalysis()
   :outertype: StubSQLCommunicator_pg

getTableRunResultsRunDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunDataAnalysis()
   :outertype: StubSQLCommunicator_pg

getTableRunTypes
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunTypes()
   :outertype: StubSQLCommunicator_pg

getTableRuns
^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRuns()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysis
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysis()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisData
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisData()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisDataDataIdentifiers()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisRun
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRun()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisRunData
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunData()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisRunDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataDataIdentifiers()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisRunDataRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataRunIdentifiers()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisRunRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunRunIdentifiers()
   :outertype: StubSQLCommunicator_pg

getTableRunsAnalysisStatistics
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisStatistics()
   :outertype: StubSQLCommunicator_pg

getTableRunsClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsClustering()
   :outertype: StubSQLCommunicator_pg

getTableRunsExecution
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecution()
   :outertype: StubSQLCommunicator_pg

getTableRunsExecutionDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionDataConfigs()
   :outertype: StubSQLCommunicator_pg

getTableRunsExecutionParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionParameterValues()
   :outertype: StubSQLCommunicator_pg

getTableRunsExecutionProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionProgramConfigs()
   :outertype: StubSQLCommunicator_pg

getTableRunsExecutionQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionQualityMeasures()
   :outertype: StubSQLCommunicator_pg

getTableRunsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsInternalParameterOptimization()
   :outertype: StubSQLCommunicator_pg

getTableRunsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimization()
   :outertype: StubSQLCommunicator_pg

getTableRunsParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationMethods()
   :outertype: StubSQLCommunicator_pg

getTableRunsParameterOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationParameters()
   :outertype: StubSQLCommunicator_pg

getTableRunsParameterOptimizationQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationQualityMeasures()
   :outertype: StubSQLCommunicator_pg

getTableStatistics
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatistics()
   :outertype: StubSQLCommunicator_pg

getTableStatisticsData
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsData()
   :outertype: StubSQLCommunicator_pg

getTableStatisticsRun
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRun()
   :outertype: StubSQLCommunicator_pg

getTableStatisticsRunData
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRunData()
   :outertype: StubSQLCommunicator_pg

initDB
^^^^^^

.. java:method:: @Override public void initDB()
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected boolean register(Run run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ProgramConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(Program object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandardConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandard object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DoubleProgramParameter object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(IntegerProgramParameter object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(StringProgramParameter object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSet object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSetConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(RunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(ParameterOptimizationResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(DataAnalysisRunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public boolean register(ExecutionRunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(ClusteringRunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public boolean register(AnalysisRunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(RunAnalysisRunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override public int register(RunDataAnalysisRunResult object)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(DataAnalysisRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(RunAnalysisRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(RunDataAnalysisRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected boolean register(ExecutionRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ClusteringRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ParameterOptimizationRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(InternalParameterOptimizationRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected boolean register(AnalysisRun<Statistic> run, boolean updateOnly)
   :outertype: StubSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(Clustering object)
   :outertype: StubSQLCommunicator_pg

registerClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> clusteringQualityMeasure)
   :outertype: StubSQLCommunicator_pg

registerContextClass
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerContextClass(Class<? extends Context> object)
   :outertype: StubSQLCommunicator_pg

registerDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: StubSQLCommunicator_pg

registerDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: StubSQLCommunicator_pg

registerDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataStatisticClass(Class<? extends DataStatistic> dataStatistic)
   :outertype: StubSQLCommunicator_pg

registerParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> paramOptMethod)
   :outertype: StubSQLCommunicator_pg

registerRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunDataStatisticClass(Class<? extends RunDataStatistic> runDataStatistic)
   :outertype: StubSQLCommunicator_pg

registerRunResultFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunResultFormatClass(Class<? extends RunResultFormat> runResultFormat)
   :outertype: StubSQLCommunicator_pg

registerRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunStatisticClass(Class<? extends RunStatistic> runStatistic)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramConfig object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Program object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandardConfig object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandard object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSet object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataConfig object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSetConfig object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramParameter<?> programParameter)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Run object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(RunResult object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ParameterOptimizationResult object)
   :outertype: StubSQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Clustering object)
   :outertype: StubSQLCommunicator_pg

unregisterClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: StubSQLCommunicator_pg

unregisterContextClass
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterContextClass(Class<? extends Context> object)
   :outertype: StubSQLCommunicator_pg

unregisterDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: StubSQLCommunicator_pg

unregisterDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: StubSQLCommunicator_pg

unregisterDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: StubSQLCommunicator_pg

unregisterParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: StubSQLCommunicator_pg

unregisterRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: StubSQLCommunicator_pg

unregisterRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunResultFormat(Class<? extends RunResultFormat> object)
   :outertype: StubSQLCommunicator_pg

unregisterRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: StubSQLCommunicator_pg

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean updateStatusOfRun(Run run, String runStatus)
   :outertype: StubSQLCommunicator_pg

