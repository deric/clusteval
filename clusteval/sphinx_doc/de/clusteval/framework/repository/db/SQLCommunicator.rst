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

.. java:import:: de.clusteval.framework.repository.db SQLConfig.DB_TYPE

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

SQLCommunicator
===============

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: @SuppressWarnings public abstract class SQLCommunicator

   The sql communicator is responsible for the communication between \ :java:ref:`Repository`\  and mysql database.

   Therefore a sql communicator has a connection \ :java:ref:`conn`\  and a \ :java:ref:`repository`\

   :author: Christian Wiwie

Fields
------
conn
^^^^

.. java:field:: protected static Connection conn
   :outertype: SQLCommunicator

exceptionHandler
^^^^^^^^^^^^^^^^

.. java:field:: protected SQLExceptionHandler exceptionHandler
   :outertype: SQLCommunicator

log
^^^

.. java:field:: protected Logger log
   :outertype: SQLCommunicator

objectIds
^^^^^^^^^

.. java:field:: protected Map<RepositoryObject, Integer> objectIds
   :outertype: SQLCommunicator

queryBuilder
^^^^^^^^^^^^

.. java:field:: protected SQLQueryBuilder queryBuilder
   :outertype: SQLCommunicator

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: SQLCommunicator

sqlConfig
^^^^^^^^^

.. java:field:: protected SQLConfig sqlConfig
   :outertype: SQLCommunicator

   A sql communicator needs a mysql configuration to know, how to connect to the database server.

Constructors
------------
SQLCommunicator
^^^^^^^^^^^^^^^

.. java:constructor:: public SQLCommunicator(Repository repository, SQLConfig sqlConfig)
   :outertype: SQLCommunicator

   :param repository:
   :param sqlConfig:

Methods
-------
checkIfPresent
^^^^^^^^^^^^^^

.. java:method:: protected boolean checkIfPresent(String table, String column, String value) throws SQLException
   :outertype: SQLCommunicator

commitDB
^^^^^^^^

.. java:method:: public void commitDB()
   :outertype: SQLCommunicator

createExceptionHandler
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected SQLExceptionHandler createExceptionHandler()
   :outertype: SQLCommunicator

createQueryBuilder
^^^^^^^^^^^^^^^^^^

.. java:method:: protected SQLQueryBuilder createQueryBuilder()
   :outertype: SQLCommunicator

delete
^^^^^^

.. java:method:: protected boolean delete(String tableName, String value, String columnName) throws SQLException
   :outertype: SQLCommunicator

delete
^^^^^^

.. java:method:: protected boolean delete(String tableName, String[] value, String[] columnName) throws SQLException
   :outertype: SQLCommunicator

delete
^^^^^^

.. java:method:: protected boolean delete(String tableName, String value) throws SQLException
   :outertype: SQLCommunicator

   By default we delete rows where `id`=rowId

   :param tableName:
   :param rowId:
   :throws SQLException:

deleteFromTable
^^^^^^^^^^^^^^^

.. java:method:: protected void deleteFromTable(String tableName, String columnName, String[] value) throws SQLException
   :outertype: SQLCommunicator

   :param string:
   :throws SQLException:

getClusterId
^^^^^^^^^^^^

.. java:method:: protected abstract int getClusterId(int clusteringId, String name) throws SQLException
   :outertype: SQLCommunicator

getClusterObjectId
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getClusterObjectId(int clusterId, String name) throws SQLException
   :outertype: SQLCommunicator

getClusteringId
^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getClusteringId(String name) throws SQLException
   :outertype: SQLCommunicator

getDBPassword
^^^^^^^^^^^^^

.. java:method:: protected abstract String getDBPassword()
   :outertype: SQLCommunicator

getDBUsername
^^^^^^^^^^^^^

.. java:method:: protected abstract String getDBUsername()
   :outertype: SQLCommunicator

getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: SQLCommunicator

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: SQLCommunicator

getDatabase
^^^^^^^^^^^

.. java:method:: protected abstract String getDatabase()
   :outertype: SQLCommunicator

getObjectId
^^^^^^^^^^^

.. java:method:: protected int getObjectId(RepositoryObject object)
   :outertype: SQLCommunicator

getObjectIds
^^^^^^^^^^^^

.. java:method:: public Map<RepositoryObject, Integer> getObjectIds()
   :outertype: SQLCommunicator

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: SQLCommunicator

getParameterSetId
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterSetId(int runResultParamOptId) throws SQLException
   :outertype: SQLCommunicator

getParameterSetParameterId
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterSetParameterId(int parameterSetId, int parameterId) throws SQLException
   :outertype: SQLCommunicator

getParameterSetParameterValuesId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getParameterSetParameterValuesId(int parameterSetId, int parameterId, int iteration) throws SQLException
   :outertype: SQLCommunicator

getProgramParameterTypeId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getProgramParameterTypeId(String typeName) throws SQLException
   :outertype: SQLCommunicator

getRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRepositoryId(String absPath) throws SQLException
   :outertype: SQLCommunicator

getRepositoryTypeId
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRepositoryTypeId(String repositoryType) throws SQLException
   :outertype: SQLCommunicator

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunAnalysisId(int runId) throws SQLException
   :outertype: SQLCommunicator

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunExecutionId(int runId) throws SQLException
   :outertype: SQLCommunicator

getRunId
^^^^^^^^

.. java:method:: protected abstract int getRunId(Run run) throws SQLException
   :outertype: SQLCommunicator

getRunResultAnalysisId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultAnalysisId(int runResultId) throws SQLException
   :outertype: SQLCommunicator

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultExecutionId(int runResultId) throws SQLException
   :outertype: SQLCommunicator

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: SQLCommunicator

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: SQLCommunicator

getRunResultRunAnalysisId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract int getRunResultRunAnalysisId(int runResultAnalysisId) throws SQLException
   :outertype: SQLCommunicator

getRunTypeId
^^^^^^^^^^^^

.. java:method:: protected abstract int getRunTypeId(String name) throws SQLException
   :outertype: SQLCommunicator

getServer
^^^^^^^^^

.. java:method:: protected abstract String getServer()
   :outertype: SQLCommunicator

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: protected abstract int getStatisticId(String statisticsName) throws SQLException
   :outertype: SQLCommunicator

getTableClusterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusterObjects()
   :outertype: SQLCommunicator

getTableClusteringQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusteringQualityMeasures()
   :outertype: SQLCommunicator

getTableClusterings
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusterings()
   :outertype: SQLCommunicator

getTableClusters
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableClusters()
   :outertype: SQLCommunicator

getTableDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataConfigs()
   :outertype: SQLCommunicator

getTableDataSetConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataSetConfigs()
   :outertype: SQLCommunicator

getTableDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataSetFormats()
   :outertype: SQLCommunicator

getTableDataSetTypes
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDataSetTypes()
   :outertype: SQLCommunicator

getTableDatasets
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableDatasets()
   :outertype: SQLCommunicator

getTableGoldStandardConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableGoldStandardConfigs()
   :outertype: SQLCommunicator

getTableGoldStandards
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableGoldStandards()
   :outertype: SQLCommunicator

getTableOptimizableProgramParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableOptimizableProgramParameters()
   :outertype: SQLCommunicator

getTableParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterOptimizationMethods()
   :outertype: SQLCommunicator

getTableParameterOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterOptimizationQualities()
   :outertype: SQLCommunicator

getTableParameterSetIterations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSetIterations()
   :outertype: SQLCommunicator

getTableParameterSetParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSetParameterValues()
   :outertype: SQLCommunicator

getTableParameterSetParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSetParameters()
   :outertype: SQLCommunicator

getTableParameterSets
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableParameterSets()
   :outertype: SQLCommunicator

getTableProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramConfigs()
   :outertype: SQLCommunicator

getTableProgramConfigsCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramConfigsCompatibleDataSetFormats()
   :outertype: SQLCommunicator

getTableProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramParameter()
   :outertype: SQLCommunicator

getTableProgramParameterType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableProgramParameterType()
   :outertype: SQLCommunicator

getTablePrograms
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTablePrograms()
   :outertype: SQLCommunicator

getTableRepositories
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRepositories()
   :outertype: SQLCommunicator

getTableRepositoryTypes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRepositoryTypes()
   :outertype: SQLCommunicator

getTableRunResultFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultFormats()
   :outertype: SQLCommunicator

getTableRunResults
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResults()
   :outertype: SQLCommunicator

getTableRunResultsAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsAnalysis()
   :outertype: SQLCommunicator

getTableRunResultsClustering
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsClustering()
   :outertype: SQLCommunicator

getTableRunResultsClusteringsQuality
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsClusteringsQuality()
   :outertype: SQLCommunicator

getTableRunResultsDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsDataAnalysis()
   :outertype: SQLCommunicator

getTableRunResultsExecution
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsExecution()
   :outertype: SQLCommunicator

getTableRunResultsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsParameterOptimization()
   :outertype: SQLCommunicator

getTableRunResultsRunAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsRunAnalysis()
   :outertype: SQLCommunicator

getTableRunResultsRunDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunResultsRunDataAnalysis()
   :outertype: SQLCommunicator

getTableRunTypes
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunTypes()
   :outertype: SQLCommunicator

getTableRuns
^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRuns()
   :outertype: SQLCommunicator

getTableRunsAnalysis
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysis()
   :outertype: SQLCommunicator

getTableRunsAnalysisData
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisData()
   :outertype: SQLCommunicator

getTableRunsAnalysisDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisDataDataIdentifiers()
   :outertype: SQLCommunicator

getTableRunsAnalysisRun
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRun()
   :outertype: SQLCommunicator

getTableRunsAnalysisRunData
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunData()
   :outertype: SQLCommunicator

getTableRunsAnalysisRunDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunDataDataIdentifiers()
   :outertype: SQLCommunicator

getTableRunsAnalysisRunDataRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunDataRunIdentifiers()
   :outertype: SQLCommunicator

getTableRunsAnalysisRunRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisRunRunIdentifiers()
   :outertype: SQLCommunicator

getTableRunsAnalysisStatistics
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsAnalysisStatistics()
   :outertype: SQLCommunicator

getTableRunsClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsClustering()
   :outertype: SQLCommunicator

getTableRunsExecution
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecution()
   :outertype: SQLCommunicator

getTableRunsExecutionDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionDataConfigs()
   :outertype: SQLCommunicator

getTableRunsExecutionParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionParameterValues()
   :outertype: SQLCommunicator

getTableRunsExecutionProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionProgramConfigs()
   :outertype: SQLCommunicator

getTableRunsExecutionQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsExecutionQualityMeasures()
   :outertype: SQLCommunicator

getTableRunsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsInternalParameterOptimization()
   :outertype: SQLCommunicator

getTableRunsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimization()
   :outertype: SQLCommunicator

getTableRunsParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimizationMethods()
   :outertype: SQLCommunicator

getTableRunsParameterOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimizationParameters()
   :outertype: SQLCommunicator

getTableRunsParameterOptimizationQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableRunsParameterOptimizationQualityMeasures()
   :outertype: SQLCommunicator

getTableStatistics
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatistics()
   :outertype: SQLCommunicator

getTableStatisticsData
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatisticsData()
   :outertype: SQLCommunicator

getTableStatisticsRun
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatisticsRun()
   :outertype: SQLCommunicator

getTableStatisticsRunData
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getTableStatisticsRunData()
   :outertype: SQLCommunicator

initDB
^^^^^^

.. java:method:: public void initDB()
   :outertype: SQLCommunicator

   Initializes the database: 1) establishes a connection 2) tells the database to delete this repository and all corresponding entries (cascading) and recreate a new and empty repository

insert
^^^^^^

.. java:method:: protected int insert(String tableName, String[] columnNames, List<String[]> values) throws SQLException
   :outertype: SQLCommunicator

insert
^^^^^^

.. java:method:: protected int insert(String tableName, String[] columnNames, String[] values) throws SQLException
   :outertype: SQLCommunicator

refreshMaterializedView
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void refreshMaterializedView(String view) throws SQLException
   :outertype: SQLCommunicator

   This method is only useful with postgreSQL, since mySQL does not support materialized views.

refreshMaterializedViews
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean refreshMaterializedViews()
   :outertype: SQLCommunicator

   This method is only useful with postgreSQL, since mySQL does not support materialized views.

register
^^^^^^^^

.. java:method:: protected abstract boolean register(Run run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract boolean register(AnalysisRun<Statistic> run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(DataAnalysisRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(RunAnalysisRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(RunDataAnalysisRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract boolean register(ExecutionRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(ClusteringRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(ParameterOptimizationRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(InternalParameterOptimizationRun run, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(ProgramConfig object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(Program object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: public boolean register(RepositoryObject object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: public boolean register(Class<? extends RepositoryObject> c)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(GoldStandardConfig object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(GoldStandard object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(DoubleProgramParameter object)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(IntegerProgramParameter object)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(StringProgramParameter object)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(DataSet object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(DataConfig object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(DataSetConfig object, boolean updateOnly)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: protected abstract int register(Clustering object)
   :outertype: SQLCommunicator

register
^^^^^^^^

.. java:method:: public int register(RunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the runresult was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract boolean register(ExecutionRunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(ClusteringRunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(ParameterOptimizationResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract boolean register(AnalysisRunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(RunAnalysisRunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(RunDataAnalysisRunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

register
^^^^^^^^

.. java:method:: public abstract int register(DataAnalysisRunResult object)
   :outertype: SQLCommunicator

   :param object:
   :return: True, if the object was registered successfully.

registerClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> clusteringQualityMeasure)
   :outertype: SQLCommunicator

registerContextClass
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerContextClass(Class<? extends Context> object)
   :outertype: SQLCommunicator

registerDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: SQLCommunicator

registerDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: SQLCommunicator

registerDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerDataStatisticClass(Class<? extends DataStatistic> dataStatistic)
   :outertype: SQLCommunicator

registerParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> paramOptMethod)
   :outertype: SQLCommunicator

registerRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerRunDataStatisticClass(Class<? extends RunDataStatistic> runDataStatistic)
   :outertype: SQLCommunicator

registerRunResultFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerRunResultFormatClass(Class<? extends RunResultFormat> runResultFormat)
   :outertype: SQLCommunicator

registerRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean registerRunStatisticClass(Class<? extends RunStatistic> runStatistic)
   :outertype: SQLCommunicator

replaceNull
^^^^^^^^^^^

.. java:method:: protected static String replaceNull(String text, String replace)
   :outertype: SQLCommunicator

select
^^^^^^

.. java:method:: protected int select(String tableName, String columnName, String[] columnNames, String[] values) throws SQLException
   :outertype: SQLCommunicator

setRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: protected void setRepositoryId(int repositoryId)
   :outertype: SQLCommunicator

tryInsert
^^^^^^^^^

.. java:method:: protected int tryInsert(String tableName, String[] columnNames, String[] values)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: public boolean unregister(RepositoryObject object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: public boolean unregister(Class<? extends RepositoryObject> c)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(ProgramConfig object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(ProgramParameter<?> programParameter)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(Program object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(GoldStandardConfig object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(GoldStandard object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(Clustering object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(DataSet object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(Run object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(RunResult object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(ParameterOptimizationResult object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(DataConfig object)
   :outertype: SQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: protected abstract int unregister(DataSetConfig object)
   :outertype: SQLCommunicator

unregisterClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: SQLCommunicator

unregisterContextClass
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterContextClass(Class<? extends Context> object)
   :outertype: SQLCommunicator

unregisterDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: SQLCommunicator

unregisterDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: SQLCommunicator

unregisterDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: SQLCommunicator

unregisterParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: SQLCommunicator

unregisterRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: SQLCommunicator

unregisterRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterRunResultFormat(Class<? extends RunResultFormat> object)
   :outertype: SQLCommunicator

unregisterRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean unregisterRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: SQLCommunicator

update
^^^^^^

.. java:method:: protected boolean update(String tableName, String[] columnNames, String[] values, int rowId) throws SQLException
   :outertype: SQLCommunicator

updateRepositoryId
^^^^^^^^^^^^^^^^^^

.. java:method:: protected int updateRepositoryId()
   :outertype: SQLCommunicator

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean updateStatusOfRun(Run run, String runStatus)
   :outertype: SQLCommunicator

   :param run: The run which changed its status.
   :param runStatus: The new run status.
   :return: True, if the status of the run was updated successfully.

