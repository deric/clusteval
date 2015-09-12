.. java:import:: java.rmi Remote

.. java:import:: java.rmi RemoteException

.. java:import:: java.util Collection

.. java:import:: java.util Map

.. java:import:: org.apache.commons.cli Options

.. java:import:: utils Pair

.. java:import:: utils Triple

.. java:import:: ch.qos.logback.classic Level

.. java:import:: de.clusteval.run RUN_STATUS

IBackendServer
==============

.. java:package:: de.clusteval.serverclient
   :noindex:

.. java:type:: public interface IBackendServer extends Remote

   An interface for the backend server. This interface contains all command a server can take from a client, e.g. starting, stopping, resuming of runs or shutting down the server.

   :author: Christian Wiwie

Methods
-------
generateDataSet
^^^^^^^^^^^^^^^

.. java:method:: public boolean generateDataSet(String generatorName, String[] args) throws RemoteException
   :outertype: IBackendServer

   :param generatorName: The simple name of the class of the dataset generator to use to generate the new dataset.
   :param args: The arguments to pass on to the dataset generator.
   :throws RemoteException:
   :return: True, if the dataset (and goldstandard) has been generated successfully.

getActiveThreads
^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Triple<String, String, Long>> getActiveThreads() throws RemoteException
   :outertype: IBackendServer

   Returns a map containing active threads and the corresponding runs/iterations/starttime that they perform

   :throws RemoteException:

getClientId
^^^^^^^^^^^

.. java:method:: public String getClientId() throws RemoteException
   :outertype: IBackendServer

   This is a factory method which returns the next free unused client id. Client ids are needed for the clients to communicate with the server and give certain commands.

   :throws RemoteException:
   :return: The next free client id.

getDataRandomizers
^^^^^^^^^^^^^^^^^^

.. java:method:: public Collection<String> getDataRandomizers() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of all data randomizers registered at the repository of this server.

getDataSetGenerators
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Collection<String> getDataSetGenerators() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of all dataset generators registered at the repository of this server.

getDataSets
^^^^^^^^^^^

.. java:method:: public Collection<String> getDataSets() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException: the remote exception
   :return: A collection with the names of all datasets contained in the repository of this server.

getOptimizationRunStatusForClientId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Pair<Pair<RUN_STATUS, Float>, Map<Pair<String, String>, Pair<Double, Map<String, Pair<Map<String, String>, String>>>>>> getOptimizationRunStatusForClientId(String clientId) throws RemoteException
   :outertype: IBackendServer

   :param clientId:
   :throws RemoteException:

getOptionsForDataRandomizer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Options getOptionsForDataRandomizer(String randomizerName) throws RemoteException
   :outertype: IBackendServer

   :param randomizerName: The simple name of the class of the data randomizer.
   :throws RemoteException:
   :return: A wrapper objects keeping all the options of the specified data randomizer.

getOptionsForDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Options getOptionsForDataSetGenerator(String generatorName) throws RemoteException
   :outertype: IBackendServer

   :param generatorName: The simple name of the class of the dataset generator.
   :throws RemoteException:
   :return: A wrapper objects keeping all the options of the specified dataset generator.

getPrograms
^^^^^^^^^^^

.. java:method:: public Collection<String> getPrograms() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of all programs contained in the repository of this server.

getQueue
^^^^^^^^

.. java:method:: public Collection<String> getQueue() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of all runs and run results that are currently enqueued but not yet running.

getRunResults
^^^^^^^^^^^^^

.. java:method:: public Map<Pair<String, String>, Map<String, Double>> getRunResults(String uniqueRunIdentifier) throws RemoteException
   :outertype: IBackendServer

   :param uniqueRunIdentifier: The unique run identifier of a run result stored in the corresponding directory of the repository.
   :throws RemoteException:
   :return: The run results for the given unique run identifier.

getRunResults
^^^^^^^^^^^^^

.. java:method:: public Collection<String> getRunResults() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of those run result directories contained in the repository of this server, that contain a clusters subfolder and at least one *.complete file containing results (can be slow if many run result folders are present).

getRunResumes
^^^^^^^^^^^^^

.. java:method:: public Collection<String> getRunResumes() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of all run result directories contained in the repository of this server. Those run result directories can be resumed, if they were terminated before.

getRunStatusForClientId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Pair<RUN_STATUS, Float>> getRunStatusForClientId(String clientId) throws RemoteException
   :outertype: IBackendServer

   This method returns the status and percentage of any run performed by the client with the given id.

   :param clientId: The client id for which this method returns the status of its runs.
   :throws RemoteException:
   :return: The status and percentage of all runs of this client.

getRuns
^^^^^^^

.. java:method:: public Collection<String> getRuns() throws RemoteException
   :outertype: IBackendServer

   :throws RemoteException:
   :return: A collection with the names of all runs contained in the repository of this server.

performRun
^^^^^^^^^^

.. java:method:: public boolean performRun(String clientId, String runId) throws RemoteException
   :outertype: IBackendServer

   This method tells the framework that a certain client wants to perform the run with the given name.

   :param clientId: The id of the client, that wants to perform the run.
   :param runId: The name of the run that should be performed.
   :throws RemoteException:
   :return: true, if successful

randomizeDataConfig
^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean randomizeDataConfig(String randomizerName, String[] args) throws RemoteException
   :outertype: IBackendServer

   :param randomizerName: The simple name of the class of the data randomizer to use to randomize the new dataset.
   :param args: The arguments to pass on to the data randomizer.
   :throws RemoteException:
   :return: True, if the data config has been randomized successfully.

resumeRun
^^^^^^^^^

.. java:method:: public boolean resumeRun(String clientId, String uniqueRunIdentifier) throws RemoteException
   :outertype: IBackendServer

   This method tells the framework that a certain client wants to resume the run result with the given unique identifier.

   :param clientId: The id of the client, that wants to perform the run.
   :param uniqueRunIdentifier: The unique identifier of the run result that should be resumed.
   :throws RemoteException:
   :return: true, if successful

setLogLevel
^^^^^^^^^^^

.. java:method:: public void setLogLevel(Level logLevel) throws RemoteException
   :outertype: IBackendServer

   This method allows to set the log level of this server.

   Possible values are

   ..

   * \ **0**\ : ALL
   * \ **1**\ : TRACE
   * \ **2**\ : DEBUG
   * \ **3**\ : INFO
   * \ **4**\ : WARN
   * \ **5**\ : ERROR
   * \ **6**\ : OFF

   See \ :java:ref:`Level`\  for explanations of the log levels.

   :param logLevel: The new log level of this server as an integer value.
   :throws RemoteException:

setThreadNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setThreadNumber(int threadNumber) throws RemoteException
   :outertype: IBackendServer

   Updates the maximal number of parallel iteration threads.

   :param threadNumber:
   :throws RemoteException:

shutdown
^^^^^^^^

.. java:method:: public void shutdown(String clientId, long timeOut) throws RemoteException
   :outertype: IBackendServer

   This method tells the framework to shutdown. The framework will terminate the supervisor thread, which then in turn terminates all other threads he is oversees.

   :param clientId: The id of the client, that wants to shutdown the framework.
   :param timeOut: The timeout how long the server will wait for threads until forcing the shutdown.
   :throws RemoteException:

terminateRun
^^^^^^^^^^^^

.. java:method:: public boolean terminateRun(String clientId, String runId) throws RemoteException
   :outertype: IBackendServer

   This method tells the framework that a certain client wants to terminate the run with the given name.

   This operation is only allowed if the client id is the same, as the one that performed the run before.

   :param clientId: The id of the client, that wants to perform the run.
   :param runId: The name of the run that should be terminated.
   :throws RemoteException:
   :return: true, if successful

