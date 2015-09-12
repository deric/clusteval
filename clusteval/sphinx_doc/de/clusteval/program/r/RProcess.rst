.. java:import:: java.io InputStream

.. java:import:: java.io OutputStream

.. java:import:: java.util.concurrent TimeUnit

RProcess
========

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public class RProcess extends Process

   :author: Christian Wiwie

Fields
------
rProgramThread
^^^^^^^^^^^^^^

.. java:field:: protected RProgramThread rProgramThread
   :outertype: RProcess

Constructors
------------
RProcess
^^^^^^^^

.. java:constructor:: public RProcess(RProgramThread rProgramThread)
   :outertype: RProcess

Methods
-------
destroy
^^^^^^^

.. java:method:: @Override public void destroy()
   :outertype: RProcess

destroyForcibly
^^^^^^^^^^^^^^^

.. java:method:: @Override public Process destroyForcibly()
   :outertype: RProcess

exitValue
^^^^^^^^^

.. java:method:: @Override public int exitValue()
   :outertype: RProcess

getErrorStream
^^^^^^^^^^^^^^

.. java:method:: @Override public InputStream getErrorStream()
   :outertype: RProcess

getInputStream
^^^^^^^^^^^^^^

.. java:method:: @Override public InputStream getInputStream()
   :outertype: RProcess

getOutputStream
^^^^^^^^^^^^^^^

.. java:method:: @Override public OutputStream getOutputStream()
   :outertype: RProcess

waitFor
^^^^^^^

.. java:method:: @Override public int waitFor() throws InterruptedException
   :outertype: RProcess

waitFor
^^^^^^^

.. java:method:: @Override public boolean waitFor(long timeout, TimeUnit unit) throws InterruptedException
   :outertype: RProcess

