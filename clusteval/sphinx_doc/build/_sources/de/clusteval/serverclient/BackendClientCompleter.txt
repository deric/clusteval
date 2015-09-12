.. java:import:: java.rmi ConnectException

.. java:import:: java.rmi RemoteException

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util SortedSet

.. java:import:: java.util TreeSet

.. java:import:: jline.console.completer Completer

.. java:import:: org.apache.commons.cli ParseException

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: de.clusteval.run RUN_STATUS

BackendClientCompleter
======================

.. java:package:: de.clusteval.serverclient
   :noindex:

.. java:type:: public class BackendClientCompleter implements Completer

   This class is used by the backend client as a tab completer for the command line.

   Objects of this class communicate directly with the backend server to receive information, that then in turn are shown in the command line as tab completion candidates.

   :author: Christian Wiwie

Fields
------
client
^^^^^^

.. java:field:: protected BackendClient client
   :outertype: BackendClientCompleter

   The backend client that uses this completer.

clientId
^^^^^^^^

.. java:field:: protected String clientId
   :outertype: BackendClientCompleter

   The id of the client needed for communication between this completer and the server.

dataRandomizers
^^^^^^^^^^^^^^^

.. java:field:: protected TreeSet<String> dataRandomizers
   :outertype: BackendClientCompleter

   A temporary variable holding the data randomizers after they were retrieved from the server.

dataSetGenerators
^^^^^^^^^^^^^^^^^

.. java:field:: protected TreeSet<String> dataSetGenerators
   :outertype: BackendClientCompleter

   A temporary variable holding the dataset generators after they were retrieved from the server.

newArgs
^^^^^^^

.. java:field:: protected String[] newArgs
   :outertype: BackendClientCompleter

   The parameters of the client (e.g. server ip and port) for communication between this completer and the server.

runResults
^^^^^^^^^^

.. java:field:: protected TreeSet<String> runResults
   :outertype: BackendClientCompleter

   A temporary variable holding the run results after they were retrieved from the server.

runResumes
^^^^^^^^^^

.. java:field:: protected TreeSet<String> runResumes
   :outertype: BackendClientCompleter

   A temporary variable holding the run resumes after they were retrieved from the server.

runStatus
^^^^^^^^^

.. java:field:: protected Map<String, Pair<RUN_STATUS, Float>> runStatus
   :outertype: BackendClientCompleter

   A temporary variable holding the run status after they were retrieved from the server.

runningRuns
^^^^^^^^^^^

.. java:field:: protected TreeSet<String> runningRuns
   :outertype: BackendClientCompleter

   A temporary variable holding the active runs after they were retrieved from the server.

runs
^^^^

.. java:field:: protected TreeSet<String> runs
   :outertype: BackendClientCompleter

   A temporary variable holding the runs after they were retrieved from the server.

Constructors
------------
BackendClientCompleter
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BackendClientCompleter(String clientId, String[] args)
   :outertype: BackendClientCompleter

   :param clientId: The id of the client needed for communication between this completer and the server.
   :param args: The parameters of the client (e.g. server ip and port) for communication between this completer and the server.

Methods
-------
complete
^^^^^^^^

.. java:method:: @SuppressWarnings @Override public int complete(String buffer, int cursor, List<CharSequence> candidates)
   :outertype: BackendClientCompleter

updateDataRandomizers
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void updateDataRandomizers() throws RemoteException
   :outertype: BackendClientCompleter

   This method updates the \ :java:ref:`dataRandomizers`\  attribute by retrieving the availble data randomizers from the server.

   :throws RemoteException:

updateDataSetGenerators
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void updateDataSetGenerators() throws RemoteException
   :outertype: BackendClientCompleter

   This method updates the \ :java:ref:`dataSetGenerators`\  attribute by retrieving the availble dataset generators from the server.

   :throws RemoteException:

updateRunResults
^^^^^^^^^^^^^^^^

.. java:method:: protected void updateRunResults() throws RemoteException
   :outertype: BackendClientCompleter

   This method updates the \ :java:ref:`runResults`\  attribute by retrieving the available run results from the server.

updateRunResumes
^^^^^^^^^^^^^^^^

.. java:method:: protected void updateRunResumes() throws RemoteException
   :outertype: BackendClientCompleter

   This method updates the \ :java:ref:`runResumes`\  attribute by retrieving the available run resumes from the server.

updateRunningRuns
^^^^^^^^^^^^^^^^^

.. java:method:: protected void updateRunningRuns() throws RemoteException
   :outertype: BackendClientCompleter

   This method updates the \ :java:ref:`runningRuns`\  attribute by retrieving the currently executed runs from the server.

updateRuns
^^^^^^^^^^

.. java:method:: protected void updateRuns() throws RemoteException
   :outertype: BackendClientCompleter

   This method updates the \ :java:ref:`runs`\  attribute by retrieving the available runs from the server.

