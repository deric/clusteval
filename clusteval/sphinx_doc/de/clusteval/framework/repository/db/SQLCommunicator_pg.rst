.. java:import:: java.net ConnectException

.. java:import:: java.sql Connection

.. java:import:: java.sql DriverManager

.. java:import:: java.sql PreparedStatement

.. java:import:: java.sql ResultSet

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils Formatter

.. java:import:: com.mysql.jdbc.exceptions.jdbc4 CommunicationsException

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

.. java:import:: de.clusteval.framework.repository RepositoryObject

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

SQLCommunicator_pg
==================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: @SuppressWarnings public abstract class SQLCommunicator_pg

   The sql communicator is responsible for the communication between \ :java:ref:`Repository`\  and mysql database.

   Therefore a sql communicator has a connection \ :java:ref:`conn`\  and a \ :java:ref:`repository`\

   :author: Christian Wiwie

Fields
------
conn
^^^^

.. java:field:: protected static Connection conn
   :outertype: SQLCommunicator_pg

objectIds
^^^^^^^^^

.. java:field:: protected Map<RepositoryObject, Integer> objectIds
   :outertype: SQLCommunicator_pg

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: SQLCommunicator_pg

Constructors
------------
SQLCommunicator_pg
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SQLCommunicator_pg(Repository repository)
   :outertype: SQLCommunicator_pg

   :param repository:

Methods
-------
commitDB
^^^^^^^^

.. java:method:: public void commitDB()
   :outertype: SQLCommunicator_pg

delete
^^^^^^

.. java:method:: protected boolean delete(String tableName, int rowId, String columnName) throws SQLException
   :outertype: SQLCommunicator_pg

delete
^^^^^^

.. java:method:: protected boolean delete(String tableName, int rowId) throws SQLException
   :outertype: SQLCommunicator_pg

   By default we delete rows where id=rowId

   :param tableName:
   :param rowId:
   :throws SQLException:

deleteFromTable
^^^^^^^^^^^^^^^

.. java:method:: protected void deleteFromTable(String tableName, String columnName, String[] value) throws SQLException
   :outertype: SQLCommunicator_pg

   :param string:
   :throws SQLException:

disableKeys
^^^^^^^^^^^

.. java:method:: public void disableKeys(String tableName) throws SQLException
   :outertype: SQLCommunicator_pg

enableKeys
^^^^^^^^^^

.. java:method:: public void enableKeys(String tableName) throws SQLException
   :outertype: SQLCommunicator_pg

getClusterId
^^^^^^^^^^^^

.. java:method:: protected abstract int getClusterId(int clusteringId, String name) throws SQLException
   :outertype: SQLCommunicator_pg

getClusterObjectId
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getClusterObjectId(int clusterId, String name) throws SQLException
   :outertype: SQLCommunicator_pg

getClusteringId
^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getClusteringId(String name) throws SQLException
   :outertype: SQLCommunicator_pg

getDBPassword
^^^^^^^^^^^^^

.. java:method:: protected abstract String getDBPassword()
   :outertype: SQLCommunicator_pg

getDBUsername
^^^^^^^^^^^^^

.. java:method:: protected abstract String getDBUsername()
   :outertype: SQLCommunicator_pg

getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: SQLCommunicator_pg

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: SQLCommunicator_pg

getDatabase
^^^^^^^^^^^

.. java:method:: protected abstract String getDatabase()
   :outertype: SQLCommunicator_pg

getObjectId
^^^^^^^^^^^

.. java:method:: protected int getObjectId(RepositoryObject object)
   :outertype: SQLCommunicator_pg

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: SQLCommunicator_pg

getParameterSetId
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterSetId(int runResultParamOptId) throws SQLException
   :outertype: SQLCommunicator_pg

getParameterSetParameterId
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterSetParameterId(int parameterSetId, int parameterId) throws SQLException
   :outertype: SQLCommunicator_pg

getParameterSetParameterValuesId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterSetParameterValuesId(int parameterSetId, int parameterId, int iteration) throws SQLException
   :outertype: SQLCommunicator_pg

getProgramParameterTypeId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getProgramParameterTypeId(String typeName) throws SQLException
   :outertype: SQLCommunicator_pg

getRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRepositoryId(String absPath) throws SQLException
   :outertype: SQLCommunicator_pg

getRepositoryTypeId
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRepositoryTypeId(String repositoryType) throws SQLException
   :outertype: SQLCommunicator_pg

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunAnalysisId(int runId) throws SQLException
   :outertype: SQLCommunicator_pg

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunExecutionId(int runId) throws SQLException
   :outertype: SQLCommunicator_pg

getRunId
^^^^^^^^

.. java:method:: protected abstract int getRunId(Run run) throws SQLException
   :outertype: SQLCommunicator_pg

getRunResultAnalysisId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultAnalysisId(int runResultId) throws SQLException
   :outertype: SQLCommunicator_pg

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultExecutionId(int runResultId) throws SQLException
   :outertype: SQLCommunicator_pg

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: SQLCommunicator_pg

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: SQLCommunicator_pg

getRunResultRunAnalysisId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultRunAnalysisId(int runResultAnalysisId) throws SQLException
   :outertype: SQLCommunicator_pg

getRunTypeId
^^^^^^^^^^^^

.. java:method:: protected abstract int getRunTypeId(String name) throws SQLException
   :outertype: SQLCommunicator_pg

getServer
^^^^^^^^^

.. java:method:: protected abstract String getServer()
   :outertype: SQLCommunicator_pg

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: protected abstract int getStatisticId(String statisticsName) throws SQLException
   :outertype: SQLCommunicator_pg

getTableClusterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusterObjects()
   :outertype: SQLCommunicator_pg

getTableClusteringQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusteringQualityMeasures()
   :outertype: SQLCommunicator_pg

getTableClusterings
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusterings()
   :outertype: SQLCommunicator_pg

getTableClusters
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusters()
   :outertype: SQLCommunicator_pg

getTableDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataConfigs()
   :outertype: SQLCommunicator_pg

getTableDataSetConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataSetConfigs()
   :outertype: SQLCommunicator_pg

getTableDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataSetFormats()
   :outertype: SQLCommunicator_pg

getTableDataSetTypes
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataSetTypes()
   :outertype: SQLCommunicator_pg

getTableDatasets
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDatasets()
   :outertype: SQLCommunicator_pg

getTableGoldStandardConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableGoldStandardConfigs()
   :outertype: SQLCommunicator_pg

getTableGoldStandards
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableGoldStandards()
   :outertype: SQLCommunicator_pg

getTableOptimizableProgramParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableOptimizableProgramParameters()
   :outertype: SQLCommunicator_pg

getTableParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterOptimizationMethods()
   :outertype: SQLCommunicator_pg

getTableParameterOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterOptimizationQualities()
   :outertype: SQLCommunicator_pg

getTableParameterSetIterations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSetIterations()
   :outertype: SQLCommunicator_pg

getTableParameterSetParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSetParameterValues()
   :outertype: SQLCommunicator_pg

getTableParameterSetParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSetParameters()
   :outertype: SQLCommunicator_pg

getTableParameterSets
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSets()
   :outertype: SQLCommunicator_pg

getTableProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramConfigs()
   :outertype: SQLCommunicator_pg

getTableProgramConfigsCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramConfigsCompatibleDataSetFormats()
   :outertype: SQLCommunicator_pg

getTableProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramParameter()
   :outertype: SQLCommunicator_pg

getTableProgramParameterType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramParameterType()
   :outertype: SQLCommunicator_pg

getTablePrograms
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTablePrograms()
   :outertype: SQLCommunicator_pg

getTableRepositories
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRepositories()
   :outertype: SQLCommunicator_pg

getTableRepositoryTypes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRepositoryTypes()
   :outertype: SQLCommunicator_pg

getTableRunResultFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultFormats()
   :outertype: SQLCommunicator_pg

getTableRunResults
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResults()
   :outertype: SQLCommunicator_pg

getTableRunResultsAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsAnalysis()
   :outertype: SQLCommunicator_pg

getTableRunResultsClustering
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsClustering()
   :outertype: SQLCommunicator_pg

getTableRunResultsClusteringsQuality
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsClusteringsQuality()
   :outertype: SQLCommunicator_pg

getTableRunResultsDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsDataAnalysis()
   :outertype: SQLCommunicator_pg

getTableRunResultsExecution
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsExecution()
   :outertype: SQLCommunicator_pg

getTableRunResultsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsParameterOptimization()
   :outertype: SQLCommunicator_pg

getTableRunResultsRunAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsRunAnalysis()
   :outertype: SQLCommunicator_pg

getTableRunResultsRunDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsRunDataAnalysis()
   :outertype: SQLCommunicator_pg

getTableRunTypes
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunTypes()
   :outertype: SQLCommunicator_pg

getTableRuns
^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRuns()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysis
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysis()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisData
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisData()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisDataDataIdentifiers()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisRun
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRun()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisRunData
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunData()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisRunDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunDataDataIdentifiers()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisRunDataRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunDataRunIdentifiers()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisRunRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunRunIdentifiers()
   :outertype: SQLCommunicator_pg

getTableRunsAnalysisStatistics
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisStatistics()
   :outertype: SQLCommunicator_pg

getTableRunsClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsClustering()
   :outertype: SQLCommunicator_pg

getTableRunsExecution
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecution()
   :outertype: SQLCommunicator_pg

getTableRunsExecutionDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionDataConfigs()
   :outertype: SQLCommunicator_pg

getTableRunsExecutionParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionParameterValues()
   :outertype: SQLCommunicator_pg

getTableRunsExecutionProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionProgramConfigs()
   :outertype: SQLCommunicator_pg

getTableRunsExecutionQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionQualityMeasures()
   :outertype: SQLCommunicator_pg

getTableRunsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsInternalParameterOptimization()
   :outertype: SQLCommunicator_pg

getTableRunsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimization()
   :outertype: SQLCommunicator_pg

getTableRunsParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimizationMethods()
   :outertype: SQLCommunicator_pg

getTableRunsParameterOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimizationParameters()
   :outertype: SQLCommunicator_pg

getTableRunsParameterOptimizationQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimizationQualityMeasures()
   :outertype: SQLCommunicator_pg

getTableStatistics
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatistics()
   :outertype: SQLCommunicator_pg

getTableStatisticsData
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatisticsData()
   :outertype: SQLCommunicator_pg

getTableStatisticsRun
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatisticsRun()
   :outertype: SQLCommunicator_pg

getTableStatisticsRunData
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatisticsRunData()
   :outertype: SQLCommunicator_pg

initDB
^^^^^^

.. java:method:: public void initDB()
   :outertype: SQLCommunicator_pg

   Initializes the database: 1) establishes a connection 2) tells the database to delete this repository and all corresponding entries (cascading) and recreate a new and empty repository

insert
^^^^^^

.. java:method:: protected int insert(String tableName, String[] columnNames, List<String[]> values) throws SQLException
   :outertype: SQLCommunicator_pg

insert
^^^^^^

.. java:method:: protected int insert(String tableName, String[] columnNames, String[] values) throws SQLException
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract boolean register(Run run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract boolean register(AnalysisRun<Statistic> run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(DataAnalysisRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(RunAnalysisRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(RunDataAnalysisRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract boolean register(ExecutionRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(ClusteringRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(ParameterOptimizationRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(InternalParameterOptimizationRun run, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(ProgramConfig object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(Program object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected boolean register(RepositoryObject object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected boolean register(Class<? extends RepositoryObject> c)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(GoldStandardConfig object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(GoldStandard object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(DoubleProgramParameter object)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(IntegerProgramParameter object)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(StringProgramParameter object)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(DataSet object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(DataConfig object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(DataSetConfig object, boolean updateOnly)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: protected abstract int register(Clustering object)
   :outertype: SQLCommunicator_pg

register
^^^^^^^^

.. java:method:: public int register(RunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the runresult was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract boolean register(ExecutionRunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(ClusteringRunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(ParameterOptimizationResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract boolean register(AnalysisRunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(RunAnalysisRunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(RunDataAnalysisRunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(DataAnalysisRunResult object)
   :outertype: SQLCommunicator_pg

   :param object:
   :return: True, if the object was registered successfully.

registerClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> clusteringQualityMeasure)
   :outertype: SQLCommunicator_pg

registerContextClass
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerContextClass(Class<? extends Context> object)
   :outertype: SQLCommunicator_pg

registerDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: SQLCommunicator_pg

registerDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: SQLCommunicator_pg

registerDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerDataStatisticClass(Class<? extends DataStatistic> dataStatistic)
   :outertype: SQLCommunicator_pg

registerParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> paramOptMethod)
   :outertype: SQLCommunicator_pg

registerRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerRunDataStatisticClass(Class<? extends RunDataStatistic> runDataStatistic)
   :outertype: SQLCommunicator_pg

registerRunResultFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerRunResultFormatClass(Class<? extends RunResultFormat> runResultFormat)
   :outertype: SQLCommunicator_pg

registerRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerRunStatisticClass(Class<? extends RunStatistic> runStatistic)
   :outertype: SQLCommunicator_pg

replaceNull
^^^^^^^^^^^

.. java:method:: protected static String replaceNull(String text, String replace)
   :outertype: SQLCommunicator_pg

select
^^^^^^

.. java:method:: protected int select(String tableName, String columnName, String[] columnNames, String[] values) throws SQLException
   :outertype: SQLCommunicator_pg

setRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: protected void setRepositoryId(int repositoryId)
   :outertype: SQLCommunicator_pg

tryInsert
^^^^^^^^^

.. java:method:: protected void tryInsert(String tableName, String[] columnNames, String[] values)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected boolean unregister(RepositoryObject object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected boolean unregister(Class<? extends RepositoryObject> c)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(ProgramConfig object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(ProgramParameter<?> programParameter)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(Program object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(GoldStandardConfig object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(GoldStandard object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(Clustering object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(DataSet object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(Run object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(RunResult object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(ParameterOptimizationResult object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(DataConfig object)
   :outertype: SQLCommunicator_pg

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(DataSetConfig object)
   :outertype: SQLCommunicator_pg

unregisterClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: SQLCommunicator_pg

unregisterContextClass
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterContextClass(Class<? extends Context> object)
   :outertype: SQLCommunicator_pg

unregisterDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: SQLCommunicator_pg

unregisterDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: SQLCommunicator_pg

unregisterDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: SQLCommunicator_pg

unregisterParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: SQLCommunicator_pg

unregisterRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: SQLCommunicator_pg

unregisterRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterRunResultFormat(Class<? extends RunResultFormat> object)
   :outertype: SQLCommunicator_pg

unregisterRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: SQLCommunicator_pg

update
^^^^^^

.. java:method:: protected boolean update(String tableName, String[] columnNames, String[] values, int rowId) throws SQLException
   :outertype: SQLCommunicator_pg

updateRepositoryId
^^^^^^^^^^^^^^^^^^

.. java:method:: protected int updateRepositoryId()
   :outertype: SQLCommunicator_pg

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean updateStatusOfRun(Run run, String runStatus)
   :outertype: SQLCommunicator_pg

   :param run: The run which changed its status.
   :param runStatus: The new run status.
   :return: True, if the status of the run was updated successfully.

