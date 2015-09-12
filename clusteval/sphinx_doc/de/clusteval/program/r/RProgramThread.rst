.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.program ProgramConfig

RProgramThread
==============

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public class RProgramThread extends Thread

   :author: Christian Wiwie

Fields
------
dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: RProgramThread

effectiveParams
^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, String> effectiveParams
   :outertype: RProgramThread

ex
^^

.. java:field:: protected Exception ex
   :outertype: RProgramThread

internalParams
^^^^^^^^^^^^^^

.. java:field:: protected Map<String, String> internalParams
   :outertype: RProgramThread

invocationLine
^^^^^^^^^^^^^^

.. java:field:: protected String[] invocationLine
   :outertype: RProgramThread

poolThread
^^^^^^^^^^

.. java:field:: protected Thread poolThread
   :outertype: RProgramThread

programConfig
^^^^^^^^^^^^^

.. java:field:: protected ProgramConfig programConfig
   :outertype: RProgramThread

rProgram
^^^^^^^^

.. java:field:: protected RProgram rProgram
   :outertype: RProgramThread

Constructors
------------
RProgramThread
^^^^^^^^^^^^^^

.. java:constructor:: public RProgramThread(Thread t, RProgram rProgram, DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws RserveException
   :outertype: RProgramThread

   :param rProgram:
   :param dataConfig:
   :param programConfig:
   :param invocationLine:
   :param effectiveParams:
   :param internalParams:
   :throws RserveException:

Methods
-------
getException
^^^^^^^^^^^^

.. java:method:: public Exception getException()
   :outertype: RProgramThread

interrupt
^^^^^^^^^

.. java:method:: @Override public void interrupt()
   :outertype: RProgramThread

run
^^^

.. java:method:: @Override public void run()
   :outertype: RProgramThread

