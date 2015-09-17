.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.rmi AccessException

.. java:import:: java.rmi AlreadyBoundException

.. java:import:: java.rmi NoSuchObjectException

.. java:import:: java.rmi NotBoundException

.. java:import:: java.rmi RemoteException

.. java:import:: java.rmi.registry LocateRegistry

.. java:import:: java.rmi.registry Registry

.. java:import:: java.rmi.server UnicastRemoteObject

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util Collection

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Properties

.. java:import:: org.apache.commons.cli CommandLine

.. java:import:: org.apache.commons.cli CommandLineParser

.. java:import:: org.apache.commons.cli HelpFormatter

.. java:import:: org.apache.commons.cli Option

.. java:import:: org.apache.commons.cli OptionBuilder

.. java:import:: org.apache.commons.cli Options

.. java:import:: org.apache.commons.cli ParseException

.. java:import:: org.apache.commons.cli PosixParser

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils Pair

.. java:import:: utils Triple

.. java:import:: ch.qos.logback.classic Level

.. java:import:: ch.qos.logback.classic LoggerContext

.. java:import:: ch.qos.logback.classic PatternLayout

.. java:import:: ch.qos.logback.classic.encoder PatternLayoutEncoder

.. java:import:: ch.qos.logback.classic.spi ILoggingEvent

.. java:import:: ch.qos.logback.core ConsoleAppender

.. java:import:: ch.qos.logback.core FileAppender

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.generator DataSetGenerationException

.. java:import:: de.clusteval.data.dataset.generator DataSetGenerator

.. java:import:: de.clusteval.data.dataset.generator GoldStandardGenerationException

.. java:import:: de.clusteval.data.dataset.generator UnknownDataSetGeneratorException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.randomizer DataRandomizeException

.. java:import:: de.clusteval.data.randomizer DataRandomizer

.. java:import:: de.clusteval.data.randomizer UnknownDataRandomizerException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.db DatabaseConnectException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run RUN_STATUS

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.runnable AnalysisIterationRunnable

.. java:import:: de.clusteval.run.runnable DataAnalysisIterationRunnable

.. java:import:: de.clusteval.run.runnable DataAnalysisRunRunnable

.. java:import:: de.clusteval.run.runnable ExecutionIterationRunnable

.. java:import:: de.clusteval.run.runnable ExecutionRunRunnable

.. java:import:: de.clusteval.run.runnable IterationRunnable

.. java:import:: de.clusteval.run.runnable IterationWrapper

.. java:import:: de.clusteval.run.runnable RunAnalysisIterationRunnable

.. java:import:: de.clusteval.run.runnable RunAnalysisRunRunnable

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.serverclient BackendClient

.. java:import:: de.clusteval.serverclient IBackendServer

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: de.clusteval.utils MyHighlightingCompositeConverter

.. java:import:: file FileUtils

ClustevalBackendServer
======================

.. java:package:: de.clusteval.framework
   :noindex:

.. java:type:: public class ClustevalBackendServer implements IBackendServer

   This class represents the server of the backend of the framework. The server takes commands from the client (see \ :java:ref:`BackendClient`\ ) like performing, resuming or terminating runs, shutdown the framework or get status information about various objects available in the repository (e.g. datasets, runs, programs,...).

   You can start the server by invoking the \ :java:ref:`main(String[])`\  method. If you do so, you can pass either a path to an existing repository or a new repository is automatically created in the subfolder 'repository'.

   When the server is started it registers itself in the RMI registry (remote method invocation), either with the default port 1099 or if specified with -hostport xxxx under any other port.

   The start of the server requires a running Rserve instance. If this cannot be found, the server will not start.

   :author: Christian Wiwie

Fields
------
VERSION
^^^^^^^

.. java:field:: protected static String VERSION
   :outertype: ClustevalBackendServer

clientCount
^^^^^^^^^^^

.. java:field:: protected int clientCount
   :outertype: ClustevalBackendServer

   The number of clients connected to this server so far. This number is used to give new clients a new number for authentication in case, several users connect to the server.

config
^^^^^^

.. java:field:: protected static BackendServerConfig config
   :outertype: ClustevalBackendServer

isRAvailable
^^^^^^^^^^^^

.. java:field:: protected static boolean isRAvailable
   :outertype: ClustevalBackendServer

port
^^^^

.. java:field:: protected static int port
   :outertype: ClustevalBackendServer

   This variable holds the port this server will be listening on. It can be specified by passing -hostport xxx to the \ :java:ref:`main(String[])`\  method.

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: ClustevalBackendServer

   Every backend server has exactly one repository, which stores all the data on the filesystem.

serverCLIOptions
^^^^^^^^^^^^^^^^

.. java:field:: public static Options serverCLIOptions
   :outertype: ClustevalBackendServer

   This variable holds the command line options of the backend server.

Constructors
------------
ClustevalBackendServer
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClustevalBackendServer(String absRepositoryPath) throws FileNotFoundException, RepositoryAlreadyExistsException, InvalidRepositoryException, RepositoryConfigNotFoundException, RepositoryConfigurationException, InterruptedException, DatabaseConnectException
   :outertype: ClustevalBackendServer

   Instantiates a new backend server.

   :param absRepositoryPath: The absolute path to the repository used by this server.
   :throws RepositoryConfigNotFoundException:
   :throws RepositoryAlreadyExistsException:
   :throws InterruptedException:
   :throws DatabaseConnectException:
   :throws RepositoryConfigurationException:
   :throws InvalidRepositoryException:
   :throws FileNotFoundException:

ClustevalBackendServer
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClustevalBackendServer(Repository repository) throws InterruptedException
   :outertype: ClustevalBackendServer

   Instantiates a new backend server and registers the server at the RMI registry.

   :param repository: The repository used by this server.
   :throws InterruptedException:

ClustevalBackendServer
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClustevalBackendServer(Repository repository, boolean registerServer) throws InterruptedException
   :outertype: ClustevalBackendServer

   :param repository:
   :param registerServer:
   :throws InterruptedException:

Methods
-------
generateDataSet
^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public boolean generateDataSet(String generatorName, String[] args) throws RemoteException
   :outertype: ClustevalBackendServer

getActiveThreads
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, Triple<String, String, Long>> getActiveThreads() throws RemoteException
   :outertype: ClustevalBackendServer

getBackendServerConfiguration
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static BackendServerConfig getBackendServerConfiguration()
   :outertype: ClustevalBackendServer

   :return: The configuration of this backend server.

getClientId
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public String getClientId() throws RemoteException
   :outertype: ClustevalBackendServer

getCommonFile
^^^^^^^^^^^^^

.. java:method:: public static File getCommonFile(File file)
   :outertype: ClustevalBackendServer

   This method returns file objects that can be used to synchronize process wide access to files.

   :param file: The file object for which you want a common file object.
   :return: A common file object for the passed file, that is stored centrally such that synchronize operations on this file object affect all other methods, that also use this method.

getDataRandomizers
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Collection<String> getDataRandomizers()
   :outertype: ClustevalBackendServer

getDataSetGenerators
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Collection<String> getDataSetGenerators()
   :outertype: ClustevalBackendServer

getDataSets
^^^^^^^^^^^

.. java:method:: @Override public Collection<String> getDataSets()
   :outertype: ClustevalBackendServer

getOptimizationRunStatusForClientId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, Pair<Pair<RUN_STATUS, Float>, Map<Pair<String, String>, Pair<Double, Map<String, Pair<Map<String, String>, String>>>>>> getOptimizationRunStatusForClientId(String clientId) throws RemoteException
   :outertype: ClustevalBackendServer

getOptionsForDataRandomizer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Options getOptionsForDataRandomizer(String randomizerName)
   :outertype: ClustevalBackendServer

getOptionsForDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Options getOptionsForDataSetGenerator(String generatorName)
   :outertype: ClustevalBackendServer

getPrograms
^^^^^^^^^^^

.. java:method:: @Override public Collection<String> getPrograms()
   :outertype: ClustevalBackendServer

getQueue
^^^^^^^^

.. java:method:: @SuppressWarnings @Override public Collection<String> getQueue() throws RemoteException
   :outertype: ClustevalBackendServer

getRepository
^^^^^^^^^^^^^

.. java:method:: public Repository getRepository()
   :outertype: ClustevalBackendServer

   Gets the repository.

   :return: The repository used by this server.

   **See also:** :java:ref:`.repository`

getRunResults
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public Collection<String> getRunResults() throws RemoteException
   :outertype: ClustevalBackendServer

getRunResults
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public Map<Pair<String, String>, Map<String, Double>> getRunResults(String uniqueRunIdentifier) throws RemoteException
   :outertype: ClustevalBackendServer

getRunResumes
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public Collection<String> getRunResumes() throws RemoteException
   :outertype: ClustevalBackendServer

getRunStatusForClientId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public Map<String, Pair<RUN_STATUS, Float>> getRunStatusForClientId(String clientId) throws RemoteException
   :outertype: ClustevalBackendServer

getRuns
^^^^^^^

.. java:method:: @Override public Collection<String> getRuns()
   :outertype: ClustevalBackendServer

isRAvailable
^^^^^^^^^^^^

.. java:method:: public static boolean isRAvailable()
   :outertype: ClustevalBackendServer

   :return: True if R is available through Rserve, false otherwise.

isRunning
^^^^^^^^^

.. java:method:: public boolean isRunning()
   :outertype: ClustevalBackendServer

   :return: True, if this framework is still running and the corresponding supervisor thread hasn't been interrupted.

logLevel
^^^^^^^^

.. java:method:: public static void logLevel(Level logLevel)
   :outertype: ClustevalBackendServer

   Change the log level of this JVM.

   :param logLevel: The new log level

main
^^^^

.. java:method:: public static void main(String[] args) throws FileNotFoundException, RepositoryAlreadyExistsException, InvalidRepositoryException, RepositoryConfigNotFoundException, RepositoryConfigurationException, InterruptedException, DatabaseConnectException
   :outertype: ClustevalBackendServer

   This method can be used to start a backend server. The args parameter can contain options that specify the behaviour of the server:

   ..

   * \ **-absRepositoryPath**\ : An absolute path to the repository
   * \ **-port**\ : The port on which this server should listen

   :param args: Arguments to control the behaviour of the server
   :throws RepositoryConfigNotFoundException:
   :throws RepositoryAlreadyExistsException:
   :throws InterruptedException:
   :throws DatabaseConnectException:
   :throws RepositoryConfigurationException:
   :throws InvalidRepositoryException:
   :throws FileNotFoundException:

performRun
^^^^^^^^^^

.. java:method:: @Override public boolean performRun(String clientId, String runId)
   :outertype: ClustevalBackendServer

randomizeDataConfig
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public boolean randomizeDataConfig(String randomizerName, String[] args) throws RemoteException
   :outertype: ClustevalBackendServer

registerServer
^^^^^^^^^^^^^^

.. java:method:: protected static boolean registerServer(ClustevalBackendServer framework)
   :outertype: ClustevalBackendServer

   A helper method for \ :java:ref:`ClusteringEvalFramework(Repository)`\ , which registers the new backend server instance in the RMI registry.

   :param framework: The backend server to register.
   :return: True, if the server has been registered successfully

resumeRun
^^^^^^^^^

.. java:method:: @Override public boolean resumeRun(String clientId, String uniqueRunIdentifier)
   :outertype: ClustevalBackendServer

setLogLevel
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void setLogLevel(Level logLevel) throws RemoteException
   :outertype: ClustevalBackendServer

setThreadNumber
^^^^^^^^^^^^^^^

.. java:method:: @Override public void setThreadNumber(int threadNumber) throws RemoteException
   :outertype: ClustevalBackendServer

shutdown
^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void shutdown(String clientId, long timeOut)
   :outertype: ClustevalBackendServer

terminateRun
^^^^^^^^^^^^

.. java:method:: @Override public boolean terminateRun(String clientId, String runId)
   :outertype: ClustevalBackendServer

