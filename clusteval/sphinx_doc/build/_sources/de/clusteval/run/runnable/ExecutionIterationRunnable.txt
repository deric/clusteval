.. java:import:: de.clusteval.run ExecutionRun

.. java:import:: de.clusteval.run.result NoRunResultFormatParserException

ExecutionIterationRunnable
==========================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public abstract class ExecutionIterationRunnable extends IterationRunnable<ExecutionIterationWrapper>

   :author: Christian Wiwie

Fields
------
noRunResultException
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected NoRunResultFormatParserException noRunResultException
   :outertype: ExecutionIterationRunnable

proc
^^^^

.. java:field:: protected Process proc
   :outertype: ExecutionIterationRunnable

Constructors
------------
ExecutionIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ExecutionIterationRunnable(ExecutionIterationWrapper iterationWrapper)
   :outertype: ExecutionIterationRunnable

   :param iterationWrapper:

Methods
-------
getIterationNumber
^^^^^^^^^^^^^^^^^^

.. java:method:: public int getIterationNumber()
   :outertype: ExecutionIterationRunnable

getNoRunResultException
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public NoRunResultFormatParserException getNoRunResultException()
   :outertype: ExecutionIterationRunnable

   :return: the noRunResultException

getProcess
^^^^^^^^^^

.. java:method:: public Process getProcess()
   :outertype: ExecutionIterationRunnable

getRun
^^^^^^

.. java:method:: @Override public ExecutionRun getRun()
   :outertype: ExecutionIterationRunnable

