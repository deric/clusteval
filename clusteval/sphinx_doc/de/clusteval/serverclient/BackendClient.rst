.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.rmi ConnectException

.. java:import:: java.rmi NotBoundException

.. java:import:: java.rmi RemoteException

.. java:import:: java.rmi.registry LocateRegistry

.. java:import:: java.rmi.registry Registry

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util Collection

.. java:import:: java.util Collections

.. java:import:: java.util HashSet

.. java:import:: java.util Iterator

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Properties

.. java:import:: java.util Set

.. java:import:: jline.console ConsoleReader

.. java:import:: jline.console.completer Completer

.. java:import:: org.apache.commons.cli CommandLine

.. java:import:: org.apache.commons.cli CommandLineParser

.. java:import:: org.apache.commons.cli HelpFormatter

.. java:import:: org.apache.commons.cli Option

.. java:import:: org.apache.commons.cli OptionBuilder

.. java:import:: org.apache.commons.cli Options

.. java:import:: org.apache.commons.cli ParseException

.. java:import:: org.apache.commons.cli PosixParser

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: utils Triple

.. java:import:: ch.qos.logback.classic Level

.. java:import:: ch.qos.logback.classic LoggerContext

.. java:import:: ch.qos.logback.classic PatternLayout

.. java:import:: ch.qos.logback.classic.encoder PatternLayoutEncoder

.. java:import:: ch.qos.logback.classic.spi ILoggingEvent

.. java:import:: ch.qos.logback.core FileAppender

.. java:import:: de.clusteval.run RUN_STATUS

.. java:import:: file FileUtils

.. java:import:: format Formatter

BackendClient
=============

.. java:package:: de.clusteval.serverclient
   :noindex:

.. java:type:: public class BackendClient extends Thread

   A backend client can give commands to the backend server (see \ :java:ref:`IBackendServer`\ ).

   :author: Christian Wiwie

Fields
------
VERSION
^^^^^^^

.. java:field:: protected static String VERSION
   :outertype: BackendClient

clientCLIOptions
^^^^^^^^^^^^^^^^

.. java:field:: public static Options clientCLIOptions
   :outertype: BackendClient

   This variable holds the command line options of the backend server.

reader
^^^^^^

.. java:field:: static ConsoleReader reader
   :outertype: BackendClient

Constructors
------------
BackendClient
^^^^^^^^^^^^^

.. java:constructor:: public BackendClient(String[] params) throws ConnectException, ParseException
   :outertype: BackendClient

   Instantiates a new eval client.

   If no port is specified in the options, the default 1099 will be used.

   If no ip is specified, the localhost will be used.

   If no clientId is specified, the client will retrieve a new one from the server.

   :param params: The command line parameters for this client (see \ :java:ref:`params`\ ).
   :throws ConnectException:
   :throws ParseException:

Methods
-------
getClientId
^^^^^^^^^^^

.. java:method:: public String getClientId()
   :outertype: BackendClient

   :return: The id of this client.

getDataRandomizers
^^^^^^^^^^^^^^^^^^

.. java:method:: public Collection<String> getDataRandomizers() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with the names of all data randomizers registered at the repository of this server.

getDataSetGenerators
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Collection<String> getDataSetGenerators() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with the names of all dataset generators registered at the repository of this server.

getDataSets
^^^^^^^^^^^

.. java:method:: public Collection<String> getDataSets() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException: the remote exception
   :return: A collection with all datasets contained in the server's repository.

getMyOptimizationRunStatus
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Pair<Pair<RUN_STATUS, Float>, Map<Pair<String, String>, Pair<Double, Map<String, Pair<Map<String, String>, String>>>>>> getMyOptimizationRunStatus() throws RemoteException
   :outertype: BackendClient

getMyRunStatus
^^^^^^^^^^^^^^

.. java:method:: public Map<String, Pair<RUN_STATUS, Float>> getMyRunStatus() throws RemoteException
   :outertype: BackendClient

   This method retrieves the status of all the runs of this client.

   :throws RemoteException:
   :return: A map containing the status as well as the percentage (if) for every run, this client has scheduled.

getOptionsForDataRandomizer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Options getOptionsForDataRandomizer(String randomizerName) throws RemoteException
   :outertype: BackendClient

   :param randomizerName: The simple name of the class of the data randomizer.
   :throws RemoteException:
   :return: A wrapper objects keeping all the options of the specified data randomizer.

getOptionsForDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Options getOptionsForDataSetGenerator(String generatorName) throws RemoteException
   :outertype: BackendClient

   :param generatorName: The simple name of the class of the dataset generator.
   :throws RemoteException:
   :return: A wrapper objects keeping all the options of the specified dataset generator.

getPrograms
^^^^^^^^^^^

.. java:method:: public Collection<String> getPrograms() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with all programs contained in the server's repository.

getQueue
^^^^^^^^

.. java:method:: public Collection<String> getQueue() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with the names of all runs and run results that are currently enqueued but not yet running.

getRunResults
^^^^^^^^^^^^^

.. java:method:: public Map<Pair<String, String>, Map<String, Double>> getRunResults(String uniqueRunIdentifier) throws RemoteException
   :outertype: BackendClient

   :param uniqueRunIdentifier: The unique run identifier of a run result stored in the corresponding directory of the repository.
   :throws RemoteException:
   :return: The run results for the given unique run identifier.

getRunResults
^^^^^^^^^^^^^

.. java:method:: public Collection<String> getRunResults() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with the names of those run result directories contained in the repository of this server, that contain a clusters subfolder and at least one *.complete file containing results (can be slow if many run result folders are present).

getRunResumes
^^^^^^^^^^^^^

.. java:method:: public Collection<String> getRunResumes() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with the names of all run result directories contained in the repository of this server. Those run result directories can be resumed, if they were terminated before.

getRuns
^^^^^^^

.. java:method:: public Collection<String> getRuns() throws RemoteException
   :outertype: BackendClient

   :throws RemoteException:
   :return: A collection with all runs contained in the server's repository.

main
^^^^

.. java:method:: @SuppressWarnings public static void main(String[] args) throws IOException
   :outertype: BackendClient

   :param args: Command line parameters for the backend client (see \ :java:ref:`params`\ ).
   :throws IOException:

performRun
^^^^^^^^^^

.. java:method:: public boolean performRun(String runId) throws RemoteException
   :outertype: BackendClient

   This method tells the server that this client wants to perform the specified run.

   :param runId: The id of the run to be performed
   :throws RemoteException:
   :return: true, if successful

resumeRun
^^^^^^^^^

.. java:method:: public boolean resumeRun(String uniqueRunIdentifier) throws RemoteException
   :outertype: BackendClient

   This method tells the server that this client wants to resume the run that corresponds to the run results folder with the specified unique identifier.

   :param uniqueRunIdentifier: The identifier of the run result that should be resumed.
   :throws RemoteException:
   :return: True, if successful

run
^^^

.. java:method:: @Override public void run()
   :outertype: BackendClient

setDefaultPromptAndCompleter
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static void setDefaultPromptAndCompleter(String ip, String port, Collection<Completer> newCompleters)
   :outertype: BackendClient

shutdownFramework
^^^^^^^^^^^^^^^^^

.. java:method:: public void shutdownFramework()
   :outertype: BackendClient

   This method will tell the server to shutdown the framework immediately (0 timeout).

terminateRun
^^^^^^^^^^^^

.. java:method:: public boolean terminateRun(String runId) throws RemoteException
   :outertype: BackendClient

   This method tells the server, that this client wants to terminate the specified run.

   This method only succeeds, if the run has been started before and is currently being performed.

   :param runId: The id of the run to be terminated.
   :throws RemoteException: the remote exception
   :return: true, if successful

