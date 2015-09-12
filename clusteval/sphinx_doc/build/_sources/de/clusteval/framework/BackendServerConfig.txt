BackendServerConfig
===================

.. java:package:: de.clusteval.framework
   :noindex:

.. java:type:: public class BackendServerConfig

   :author: Christian Wiwie

Fields
------
checkForRunResults
^^^^^^^^^^^^^^^^^^

.. java:field:: protected boolean checkForRunResults
   :outertype: BackendServerConfig

noDatabase
^^^^^^^^^^

.. java:field:: protected boolean noDatabase
   :outertype: BackendServerConfig

numberOfThreads
^^^^^^^^^^^^^^^

.. java:field:: protected int numberOfThreads
   :outertype: BackendServerConfig

rServeHost
^^^^^^^^^^

.. java:field:: protected String rServeHost
   :outertype: BackendServerConfig

rServePort
^^^^^^^^^^

.. java:field:: protected int rServePort
   :outertype: BackendServerConfig

Constructors
------------
BackendServerConfig
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BackendServerConfig()
   :outertype: BackendServerConfig

Methods
-------
getCheckForRunResults
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean getCheckForRunResults()
   :outertype: BackendServerConfig

   :return: True, if this backend server should check for run results in its repository.

getNoDatabase
^^^^^^^^^^^^^

.. java:method:: public boolean getNoDatabase()
   :outertype: BackendServerConfig

getNumberOfThreads
^^^^^^^^^^^^^^^^^^

.. java:method:: public int getNumberOfThreads()
   :outertype: BackendServerConfig

   :return: The maximal number of threads.

getRserveHost
^^^^^^^^^^^^^

.. java:method:: public String getRserveHost()
   :outertype: BackendServerConfig

getRservePort
^^^^^^^^^^^^^

.. java:method:: public int getRservePort()
   :outertype: BackendServerConfig

setCheckForRunResults
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCheckForRunResults(boolean checkForRunResults)
   :outertype: BackendServerConfig

   :param checkForRunResults: True, if this backend server should check for run results in its repository.

setNoDatabase
^^^^^^^^^^^^^

.. java:method:: public void setNoDatabase(boolean noDatabase)
   :outertype: BackendServerConfig

   :param noDatabase: True, if this backend server should use a database.

setRserveHost
^^^^^^^^^^^^^

.. java:method:: public void setRserveHost(String host)
   :outertype: BackendServerConfig

setRservePort
^^^^^^^^^^^^^

.. java:method:: public void setRservePort(int port)
   :outertype: BackendServerConfig

