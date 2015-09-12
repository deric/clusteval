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

StubSQLCommunicator
===================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: @SuppressWarnings public class StubSQLCommunicator extends SQLCommunicator

   :author: Christian Wiwie

Constructors
------------
StubSQLCommunicator
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StubSQLCommunicator(Repository repository)
   :outertype: StubSQLCommunicator

   :param repository:

Methods
-------
commitDB
^^^^^^^^

.. java:method:: @Override public void commitDB()
   :outertype: StubSQLCommunicator

getClusterId
^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterId(int clusteringId, String name) throws SQLException
   :outertype: StubSQLCommunicator

getClusterObjectId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterObjectId(int clusterId, String name) throws SQLException
   :outertype: StubSQLCommunicator

getClusteringId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusteringId(String name) throws SQLException
   :outertype: StubSQLCommunicator

getDBPassword
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBPassword()
   :outertype: StubSQLCommunicator

getDBUsername
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBUsername()
   :outertype: StubSQLCommunicator

getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: StubSQLCommunicator

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: StubSQLCommunicator

getDatabase
^^^^^^^^^^^

.. java:method:: @Override protected String getDatabase()
   :outertype: StubSQLCommunicator

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: StubSQLCommunicator

getParameterSetId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetId(int runResultParamOptId) throws SQLException
   :outertype: StubSQLCommunicator

getParameterSetParameterId
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterId(int parameterSetId, int parameterId) throws SQLException
   :outertype: StubSQLCommunicator

getParameterSetParameterValuesId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterValuesId(int parameterSetId, int parameterId, int iteration) throws SQLException
   :outertype: StubSQLCommunicator

getProgramParameterTypeId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getProgramParameterTypeId(String typeName) throws SQLException
   :outertype: StubSQLCommunicator

getRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryId(String absPath) throws SQLException
   :outertype: StubSQLCommunicator

getRepositoryTypeId
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryTypeId(String repositoryType) throws SQLException
   :outertype: StubSQLCommunicator

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunAnalysisId(int runId) throws SQLException
   :outertype: StubSQLCommunicator

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunExecutionId(int runId) throws SQLException
   :outertype: StubSQLCommunicator

getRunId
^^^^^^^^

.. java:method:: @Override protected int getRunId(Run run) throws SQLException
   :outertype: StubSQLCommunicator

getRunResultAnalysisId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultAnalysisId(int runResultId) throws SQLException
   :outertype: StubSQLCommunicator

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultExecutionId(int runResultId) throws SQLException
   :outertype: StubSQLCommunicator

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: StubSQLCommunicator

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: StubSQLCommunicator

getRunResultRunAnalysisId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultRunAnalysisId(int runResultAnalysisId) throws SQLException
   :outertype: StubSQLCommunicator

getRunTypeId
^^^^^^^^^^^^

.. java:method:: @Override protected int getRunTypeId(String name) throws SQLException
   :outertype: StubSQLCommunicator

getServer
^^^^^^^^^

.. java:method:: @Override protected String getServer()
   :outertype: StubSQLCommunicator

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getStatisticId(String statisticsName) throws SQLException
   :outertype: StubSQLCommunicator

getTableClusterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterObjects()
   :outertype: StubSQLCommunicator

getTableClusteringQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusteringQualityMeasures()
   :outertype: StubSQLCommunicator

getTableClusterings
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterings()
   :outertype: StubSQLCommunicator

getTableClusters
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusters()
   :outertype: StubSQLCommunicator

getTableDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataConfigs()
   :outertype: StubSQLCommunicator

getTableDataSetConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetConfigs()
   :outertype: StubSQLCommunicator

getTableDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetFormats()
   :outertype: StubSQLCommunicator

getTableDataSetTypes
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetTypes()
   :outertype: StubSQLCommunicator

getTableDatasets
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDatasets()
   :outertype: StubSQLCommunicator

getTableGoldStandardConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandardConfigs()
   :outertype: StubSQLCommunicator

getTableGoldStandards
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandards()
   :outertype: StubSQLCommunicator

getTableOptimizableProgramParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableOptimizableProgramParameters()
   :outertype: StubSQLCommunicator

getTableParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationMethods()
   :outertype: StubSQLCommunicator

getTableParameterOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationQualities()
   :outertype: StubSQLCommunicator

getTableParameterSetIterations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetIterations()
   :outertype: StubSQLCommunicator

getTableParameterSetParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameterValues()
   :outertype: StubSQLCommunicator

getTableParameterSetParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameters()
   :outertype: StubSQLCommunicator

getTableParameterSets
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSets()
   :outertype: StubSQLCommunicator

getTableProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigs()
   :outertype: StubSQLCommunicator

getTableProgramConfigsCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigsCompatibleDataSetFormats()
   :outertype: StubSQLCommunicator

getTableProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameter()
   :outertype: StubSQLCommunicator

getTableProgramParameterType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameterType()
   :outertype: StubSQLCommunicator

getTablePrograms
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTablePrograms()
   :outertype: StubSQLCommunicator

getTableRepositories
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositories()
   :outertype: StubSQLCommunicator

getTableRepositoryTypes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositoryTypes()
   :outertype: StubSQLCommunicator

getTableRunResultFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultFormats()
   :outertype: StubSQLCommunicator

getTableRunResults
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResults()
   :outertype: StubSQLCommunicator

getTableRunResultsAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsAnalysis()
   :outertype: StubSQLCommunicator

getTableRunResultsClustering
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClustering()
   :outertype: StubSQLCommunicator

getTableRunResultsClusteringsQuality
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClusteringsQuality()
   :outertype: StubSQLCommunicator

getTableRunResultsDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsDataAnalysis()
   :outertype: StubSQLCommunicator

getTableRunResultsExecution
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsExecution()
   :outertype: StubSQLCommunicator

getTableRunResultsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsParameterOptimization()
   :outertype: StubSQLCommunicator

getTableRunResultsRunAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunAnalysis()
   :outertype: StubSQLCommunicator

getTableRunResultsRunDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunDataAnalysis()
   :outertype: StubSQLCommunicator

getTableRunTypes
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunTypes()
   :outertype: StubSQLCommunicator

getTableRuns
^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRuns()
   :outertype: StubSQLCommunicator

getTableRunsAnalysis
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysis()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisData
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisData()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisDataDataIdentifiers()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisRun
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRun()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisRunData
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunData()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisRunDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataDataIdentifiers()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisRunDataRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataRunIdentifiers()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisRunRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunRunIdentifiers()
   :outertype: StubSQLCommunicator

getTableRunsAnalysisStatistics
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisStatistics()
   :outertype: StubSQLCommunicator

getTableRunsClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsClustering()
   :outertype: StubSQLCommunicator

getTableRunsExecution
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecution()
   :outertype: StubSQLCommunicator

getTableRunsExecutionDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionDataConfigs()
   :outertype: StubSQLCommunicator

getTableRunsExecutionParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionParameterValues()
   :outertype: StubSQLCommunicator

getTableRunsExecutionProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionProgramConfigs()
   :outertype: StubSQLCommunicator

getTableRunsExecutionQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionQualityMeasures()
   :outertype: StubSQLCommunicator

getTableRunsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsInternalParameterOptimization()
   :outertype: StubSQLCommunicator

getTableRunsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimization()
   :outertype: StubSQLCommunicator

getTableRunsParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationMethods()
   :outertype: StubSQLCommunicator

getTableRunsParameterOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationParameters()
   :outertype: StubSQLCommunicator

getTableRunsParameterOptimizationQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationQualityMeasures()
   :outertype: StubSQLCommunicator

getTableStatistics
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatistics()
   :outertype: StubSQLCommunicator

getTableStatisticsData
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsData()
   :outertype: StubSQLCommunicator

getTableStatisticsRun
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRun()
   :outertype: StubSQLCommunicator

getTableStatisticsRunData
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRunData()
   :outertype: StubSQLCommunicator

initDB
^^^^^^

.. java:method:: @Override public void initDB()
   :outertype: StubSQLCommunicator

refreshMaterializedViews
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean refreshMaterializedViews()
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected boolean register(Run run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ProgramConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(Program object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandardConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandard object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DoubleProgramParameter object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(IntegerProgramParameter object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(StringProgramParameter object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSet object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSetConfig object, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(RunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(ParameterOptimizationResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(DataAnalysisRunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public boolean register(ExecutionRunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(ClusteringRunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public boolean register(AnalysisRunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(RunAnalysisRunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(RunDataAnalysisRunResult object)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataAnalysisRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(RunAnalysisRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(RunDataAnalysisRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected boolean register(ExecutionRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ClusteringRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ParameterOptimizationRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(InternalParameterOptimizationRun run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected boolean register(AnalysisRun<Statistic> run, boolean updateOnly)
   :outertype: StubSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(Clustering object)
   :outertype: StubSQLCommunicator

registerClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> clusteringQualityMeasure)
   :outertype: StubSQLCommunicator

registerContextClass
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerContextClass(Class<? extends Context> object)
   :outertype: StubSQLCommunicator

registerDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: StubSQLCommunicator

registerDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: StubSQLCommunicator

registerDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataStatisticClass(Class<? extends DataStatistic> dataStatistic)
   :outertype: StubSQLCommunicator

registerParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> paramOptMethod)
   :outertype: StubSQLCommunicator

registerRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunDataStatisticClass(Class<? extends RunDataStatistic> runDataStatistic)
   :outertype: StubSQLCommunicator

registerRunResultFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunResultFormatClass(Class<? extends RunResultFormat> runResultFormat)
   :outertype: StubSQLCommunicator

registerRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunStatisticClass(Class<? extends RunStatistic> runStatistic)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramConfig object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Program object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandardConfig object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandard object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSet object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataConfig object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSetConfig object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramParameter<?> programParameter)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Run object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(RunResult object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ParameterOptimizationResult object)
   :outertype: StubSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Clustering object)
   :outertype: StubSQLCommunicator

unregisterClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: StubSQLCommunicator

unregisterContextClass
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterContextClass(Class<? extends Context> object)
   :outertype: StubSQLCommunicator

unregisterDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: StubSQLCommunicator

unregisterDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: StubSQLCommunicator

unregisterDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: StubSQLCommunicator

unregisterParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: StubSQLCommunicator

unregisterRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: StubSQLCommunicator

unregisterRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunResultFormat(Class<? extends RunResultFormat> object)
   :outertype: StubSQLCommunicator

unregisterRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: StubSQLCommunicator

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean updateStatusOfRun(Run run, String runStatus)
   :outertype: StubSQLCommunicator

