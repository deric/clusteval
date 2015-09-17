.. java:import:: java.io IOException

.. java:import:: java.net SocketException

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RConnection

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

MyRengine
=========

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class MyRengine

   This class is used throughout the framework to provide access to the R framework.

   This class is a wrapper class for \ :java:ref:`RConnection`\  which adds convenience functions.

   :author: Christian Wiwie

Fields
------
connection
^^^^^^^^^^

.. java:field:: protected RConnection connection
   :outertype: MyRengine

interrupted
^^^^^^^^^^^

.. java:field:: protected boolean interrupted
   :outertype: MyRengine

loadedLibraries
^^^^^^^^^^^^^^^

.. java:field:: protected Set<String> loadedLibraries
   :outertype: MyRengine

log
^^^

.. java:field:: protected Logger log
   :outertype: MyRengine

pid
^^^

.. java:field:: protected int pid
   :outertype: MyRengine

Constructors
------------
MyRengine
^^^^^^^^^

.. java:constructor:: public MyRengine(String string) throws RserveException
   :outertype: MyRengine

   :param string: The parameter string.
   :throws RserveException:

Methods
-------
assign
^^^^^^

.. java:method:: public void assign(String arg0, double[][] arg1) throws REngineException, InterruptedException
   :outertype: MyRengine

   This method allows to assign a two-dimensional double array.

   :param arg0: The variable name in R.
   :param arg1: A two-dimensional double array which is assigned to the new variable.
   :throws InterruptedException:
   :throws REngineException:

assign
^^^^^^

.. java:method:: public void assign(String arg0, int[][] arg1) throws REngineException, InterruptedException
   :outertype: MyRengine

   This method allows to assign a two-dimensional integer array.

   :param arg0: The variable name in R.
   :param arg1: A two-dimensional integer array which is assigned to the new variable.
   :throws InterruptedException:
   :throws REngineException:

assign
^^^^^^

.. java:method:: public void assign(String arg0, int[] arg1) throws REngineException, InterruptedException
   :outertype: MyRengine

assign
^^^^^^

.. java:method:: public void assign(String arg0, double[] arg1) throws REngineException, InterruptedException
   :outertype: MyRengine

assign
^^^^^^

.. java:method:: public void assign(String arg0, String[] arg1) throws REngineException, InterruptedException
   :outertype: MyRengine

clear
^^^^^

.. java:method:: public void clear() throws RserveException, InterruptedException
   :outertype: MyRengine

   This method clears all variables stored in the session corresponding to this rengine.

   :throws RserveException:
   :throws InterruptedException:

close
^^^^^

.. java:method:: protected boolean close()
   :outertype: MyRengine

eval
^^^^

.. java:method:: public REXP eval(String cmd) throws RserveException, InterruptedException
   :outertype: MyRengine

getLastError
^^^^^^^^^^^^

.. java:method:: public String getLastError() throws InterruptedException
   :outertype: MyRengine

interrupt
^^^^^^^^^

.. java:method:: public boolean interrupt()
   :outertype: MyRengine

loadLibrary
^^^^^^^^^^^

.. java:method:: public boolean loadLibrary(String name, String requiredByClass) throws RLibraryNotLoadedException, InterruptedException
   :outertype: MyRengine

   This method tries to load the library with the given name.

   If the library could not be loaded, this method throws a \ :java:ref:`RLibraryNotLoadedException`\ .

   :param name: The name of the library.
   :param requiredByClass: The name of the class that requires the library.
   :throws RLibraryNotLoadedException:
   :throws InterruptedException:
   :return: True, if the library was loaded successfully or was loaded before.

printLastError
^^^^^^^^^^^^^^

.. java:method:: public void printLastError() throws InterruptedException
   :outertype: MyRengine

   TODO: use this instead of printStackTrace() This method logs the last error.

   :throws InterruptedException:

shutdown
^^^^^^^^

.. java:method:: protected boolean shutdown()
   :outertype: MyRengine

