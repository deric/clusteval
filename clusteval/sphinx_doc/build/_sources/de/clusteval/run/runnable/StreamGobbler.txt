.. java:import:: java.io BufferedReader

.. java:import:: java.io BufferedWriter

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.io InputStreamReader

.. java:import:: java.io PrintWriter

.. java:import:: java.io StringWriter

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.concurrent CancellationException

.. java:import:: java.util.concurrent ExecutionException

.. java:import:: java.util.concurrent Future

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils ProgressPrinter

.. java:import:: de.clusteval.data.dataset.format IncompatibleDataSetFormatException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard IncompleteGoldStandardException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run RUN_STATUS

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.utils InternalAttributeException

StreamGobbler
=============

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type::  class StreamGobbler extends Thread

   This class is responsible for reading and emptying the streams of the started thread. This has to be done in order to avoid overflowing streams and thus possible termination of the thread by the operating system.

Fields
------
bw
^^

.. java:field::  BufferedWriter bw
   :outertype: StreamGobbler

is
^^

.. java:field::  InputStream is
   :outertype: StreamGobbler

Constructors
------------
StreamGobbler
^^^^^^^^^^^^^

.. java:constructor:: public StreamGobbler(InputStream is, BufferedWriter bw)
   :outertype: StreamGobbler

Methods
-------
run
^^^

.. java:method:: @Override public void run()
   :outertype: StreamGobbler

