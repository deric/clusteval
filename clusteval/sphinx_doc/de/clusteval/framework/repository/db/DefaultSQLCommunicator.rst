.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.sql ResultSet

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

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

.. java:import:: file FileUtils

DefaultSQLCommunicator
======================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: @SuppressWarnings public class DefaultSQLCommunicator extends SQLCommunicator

   A default sql communicator is the standard implementation of the abstract \ :java:ref:`SQLCommunicator`\  and is intended as a default for standard repositories of type \ :java:ref:`Repository`\ .

   Subclasses of \ :java:ref:`Repository`\ , e.g. \ :java:ref:`RunResultRepository`\  have their own sql communicator implementations.

   :author: Christian Wiwie

Constructors
------------
DefaultSQLCommunicator
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DefaultSQLCommunicator(Repository repository, SQLConfig sqlConfig)
   :outertype: DefaultSQLCommunicator

   :param repository: The repository this communicator belongs to.
   :param sqlConfig: The sql configuration this communicator should use.

Methods
-------
getClusterId
^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterId(int clusteringId, String name) throws SQLException
   :outertype: DefaultSQLCommunicator

getClusterObjectId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusterObjectId(int clusterId, String name) throws SQLException
   :outertype: DefaultSQLCommunicator

getClusteringId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getClusteringId(String absPath) throws SQLException
   :outertype: DefaultSQLCommunicator

getDBPassword
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBPassword()
   :outertype: DefaultSQLCommunicator

getDBUsername
^^^^^^^^^^^^^

.. java:method:: @Override protected String getDBUsername()
   :outertype: DefaultSQLCommunicator

getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: DefaultSQLCommunicator

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: DefaultSQLCommunicator

getDatabase
^^^^^^^^^^^

.. java:method:: @Override protected String getDatabase()
   :outertype: DefaultSQLCommunicator

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: DefaultSQLCommunicator

getParameterSetId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetId(int runResultParamOptId) throws SQLException
   :outertype: DefaultSQLCommunicator

getParameterSetParameterId
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterId(int run_results_parameter_optimizations_parameter_set_id, int program_parameter_id) throws SQLException
   :outertype: DefaultSQLCommunicator

getParameterSetParameterValuesId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterSetParameterValuesId(int run_results_parameter_optimizations_parameter_set_id, int program_parameter_id, int iteration) throws SQLException
   :outertype: DefaultSQLCommunicator

getProgramParameterTypeId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getProgramParameterTypeId(String typeName) throws SQLException
   :outertype: DefaultSQLCommunicator

getRepositoryId
^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryId(String absPath) throws SQLException
   :outertype: DefaultSQLCommunicator

getRepositoryTypeId
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRepositoryTypeId(String repositoryType) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunAnalysisId(int run_id) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunExecutionId(int run_id) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunId
^^^^^^^^

.. java:method:: @Override protected int getRunId(Run run) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunResultAnalysisId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultAnalysisId(int run_results_id) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultExecutionId(int run_results_id) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunResultRunAnalysisId
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultRunAnalysisId(int run_results_analysis_id) throws SQLException
   :outertype: DefaultSQLCommunicator

getRunTypeId
^^^^^^^^^^^^

.. java:method:: @Override protected int getRunTypeId(String name) throws SQLException
   :outertype: DefaultSQLCommunicator

getServer
^^^^^^^^^

.. java:method:: @Override protected String getServer()
   :outertype: DefaultSQLCommunicator

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getStatisticId(String statisticsName) throws SQLException
   :outertype: DefaultSQLCommunicator

getTableClusterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterObjects()
   :outertype: DefaultSQLCommunicator

getTableClusteringQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusteringQualityMeasures()
   :outertype: DefaultSQLCommunicator

getTableClusterings
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusterings()
   :outertype: DefaultSQLCommunicator

getTableClusters
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableClusters()
   :outertype: DefaultSQLCommunicator

getTableDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataConfigs()
   :outertype: DefaultSQLCommunicator

getTableDataSetConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetConfigs()
   :outertype: DefaultSQLCommunicator

getTableDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetFormats()
   :outertype: DefaultSQLCommunicator

getTableDataSetTypes
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDataSetTypes()
   :outertype: DefaultSQLCommunicator

getTableDatasets
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableDatasets()
   :outertype: DefaultSQLCommunicator

getTableGoldStandardConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandardConfigs()
   :outertype: DefaultSQLCommunicator

getTableGoldStandards
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableGoldStandards()
   :outertype: DefaultSQLCommunicator

getTableOptimizableProgramParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableOptimizableProgramParameters()
   :outertype: DefaultSQLCommunicator

getTableParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationMethods()
   :outertype: DefaultSQLCommunicator

getTableParameterOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterOptimizationQualities()
   :outertype: DefaultSQLCommunicator

getTableParameterSetIterations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetIterations()
   :outertype: DefaultSQLCommunicator

getTableParameterSetParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameterValues()
   :outertype: DefaultSQLCommunicator

getTableParameterSetParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSetParameters()
   :outertype: DefaultSQLCommunicator

getTableParameterSets
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableParameterSets()
   :outertype: DefaultSQLCommunicator

getTableProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigs()
   :outertype: DefaultSQLCommunicator

getTableProgramConfigsCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramConfigsCompatibleDataSetFormats()
   :outertype: DefaultSQLCommunicator

getTableProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameter()
   :outertype: DefaultSQLCommunicator

getTableProgramParameterType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableProgramParameterType()
   :outertype: DefaultSQLCommunicator

getTablePrograms
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTablePrograms()
   :outertype: DefaultSQLCommunicator

getTableRepositories
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositories()
   :outertype: DefaultSQLCommunicator

getTableRepositoryTypes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRepositoryTypes()
   :outertype: DefaultSQLCommunicator

getTableRunResultFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultFormats()
   :outertype: DefaultSQLCommunicator

getTableRunResults
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResults()
   :outertype: DefaultSQLCommunicator

getTableRunResultsAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsAnalysis()
   :outertype: DefaultSQLCommunicator

getTableRunResultsClustering
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClustering()
   :outertype: DefaultSQLCommunicator

getTableRunResultsClusteringsQuality
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsClusteringsQuality()
   :outertype: DefaultSQLCommunicator

getTableRunResultsDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsDataAnalysis()
   :outertype: DefaultSQLCommunicator

getTableRunResultsExecution
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsExecution()
   :outertype: DefaultSQLCommunicator

getTableRunResultsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsParameterOptimization()
   :outertype: DefaultSQLCommunicator

getTableRunResultsRunAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunAnalysis()
   :outertype: DefaultSQLCommunicator

getTableRunResultsRunDataAnalysis
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunResultsRunDataAnalysis()
   :outertype: DefaultSQLCommunicator

getTableRunTypes
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunTypes()
   :outertype: DefaultSQLCommunicator

getTableRuns
^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRuns()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysis
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysis()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisData
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisData()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisDataDataIdentifiers()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisRun
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRun()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisRunData
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunData()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisRunDataDataIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataDataIdentifiers()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisRunDataRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunDataRunIdentifiers()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisRunRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisRunRunIdentifiers()
   :outertype: DefaultSQLCommunicator

getTableRunsAnalysisStatistics
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsAnalysisStatistics()
   :outertype: DefaultSQLCommunicator

getTableRunsClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsClustering()
   :outertype: DefaultSQLCommunicator

getTableRunsExecution
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecution()
   :outertype: DefaultSQLCommunicator

getTableRunsExecutionDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionDataConfigs()
   :outertype: DefaultSQLCommunicator

getTableRunsExecutionParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionParameterValues()
   :outertype: DefaultSQLCommunicator

getTableRunsExecutionProgramConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionProgramConfigs()
   :outertype: DefaultSQLCommunicator

getTableRunsExecutionQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsExecutionQualityMeasures()
   :outertype: DefaultSQLCommunicator

getTableRunsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsInternalParameterOptimization()
   :outertype: DefaultSQLCommunicator

getTableRunsParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimization()
   :outertype: DefaultSQLCommunicator

getTableRunsParameterOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationMethods()
   :outertype: DefaultSQLCommunicator

getTableRunsParameterOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationParameters()
   :outertype: DefaultSQLCommunicator

getTableRunsParameterOptimizationQualityMeasures
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableRunsParameterOptimizationQualityMeasures()
   :outertype: DefaultSQLCommunicator

getTableStatistics
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatistics()
   :outertype: DefaultSQLCommunicator

getTableStatisticsData
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsData()
   :outertype: DefaultSQLCommunicator

getTableStatisticsRun
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRun()
   :outertype: DefaultSQLCommunicator

getTableStatisticsRunData
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getTableStatisticsRunData()
   :outertype: DefaultSQLCommunicator

isInfinity
^^^^^^^^^^

.. java:method:: protected boolean isInfinity(double d)
   :outertype: DefaultSQLCommunicator

refreshMaterializedViews
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean refreshMaterializedViews()
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected boolean register(Run object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected boolean register(AnalysisRun<Statistic> object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataAnalysisRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(RunAnalysisRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(RunDataAnalysisRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected boolean register(ExecutionRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ClusteringRun run, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(InternalParameterOptimizationRun run, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ParameterOptimizationRun object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ProgramConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(Program object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandardConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(GoldStandard object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DoubleProgramParameter object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(IntegerProgramParameter object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(StringProgramParameter object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSet object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(Clustering object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(DataSetConfig object, boolean updateOnly)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(RunResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public boolean register(ExecutionRunResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(ClusteringRunResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(ParameterOptimizationResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public boolean register(AnalysisRunResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(DataAnalysisRunResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(RunAnalysisRunResult object)
   :outertype: DefaultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override public int register(RunDataAnalysisRunResult object)
   :outertype: DefaultSQLCommunicator

registerClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: DefaultSQLCommunicator

registerContextClass
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected boolean registerContextClass(Class<? extends Context> object)
   :outertype: DefaultSQLCommunicator

registerDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: DefaultSQLCommunicator

registerDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: DefaultSQLCommunicator

registerDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: DefaultSQLCommunicator

registerParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: DefaultSQLCommunicator

registerRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: DefaultSQLCommunicator

registerRunResultFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunResultFormatClass(Class<? extends RunResultFormat> object)
   :outertype: DefaultSQLCommunicator

registerRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean registerRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: DefaultSQLCommunicator

replaceInfinity
^^^^^^^^^^^^^^^

.. java:method:: protected String replaceInfinity(double d)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Clustering object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramConfig object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Program object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandardConfig object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(GoldStandard object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSet object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataConfig object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(DataSetConfig object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ProgramParameter<?> programParameter)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(Run object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(ParameterOptimizationResult object)
   :outertype: DefaultSQLCommunicator

unregister
^^^^^^^^^^

.. java:method:: @Override protected int unregister(RunResult object)
   :outertype: DefaultSQLCommunicator

unregisterClusteringQualityMeasureClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterClusteringQualityMeasureClass(Class<? extends ClusteringQualityMeasure> object)
   :outertype: DefaultSQLCommunicator

unregisterContextClass
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected boolean unregisterContextClass(Class<? extends Context> object)
   :outertype: DefaultSQLCommunicator

unregisterDataSetFormatClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetFormatClass(Class<? extends DataSetFormat> object)
   :outertype: DefaultSQLCommunicator

unregisterDataSetTypeClass
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataSetTypeClass(Class<? extends DataSetType> object)
   :outertype: DefaultSQLCommunicator

unregisterDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterDataStatisticClass(Class<? extends DataStatistic> object)
   :outertype: DefaultSQLCommunicator

unregisterParameterOptimizationMethodClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterParameterOptimizationMethodClass(Class<? extends ParameterOptimizationMethod> object)
   :outertype: DefaultSQLCommunicator

unregisterRunDataStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunDataStatisticClass(Class<? extends RunDataStatistic> object)
   :outertype: DefaultSQLCommunicator

unregisterRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunResultFormat(Class<? extends RunResultFormat> object)
   :outertype: DefaultSQLCommunicator

unregisterRunStatisticClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean unregisterRunStatisticClass(Class<? extends RunStatistic> object)
   :outertype: DefaultSQLCommunicator

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean updateStatusOfRun(Run run, String runStatus)
   :outertype: DefaultSQLCommunicator

