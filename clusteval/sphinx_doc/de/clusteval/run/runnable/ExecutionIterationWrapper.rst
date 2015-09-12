.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.run.result ClusteringRunResult

ExecutionIterationWrapper
=========================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class ExecutionIterationWrapper extends IterationWrapper

Fields
------
clusteringRunResult
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ClusteringRunResult clusteringRunResult
   :outertype: ExecutionIterationWrapper

convertedClusteringRunResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ClusteringRunResult convertedClusteringRunResult
   :outertype: ExecutionIterationWrapper

internalParams
^^^^^^^^^^^^^^

.. java:field:: protected final Map<String, String> internalParams
   :outertype: ExecutionIterationWrapper

   The internal parameters are parameters, that cannot be directly influenced by the user, e.g. the absolute input or output path.

invocation
^^^^^^^^^^

.. java:field:: protected String[] invocation
   :outertype: ExecutionIterationWrapper

parameterSet
^^^^^^^^^^^^

.. java:field:: protected ParameterSet parameterSet
   :outertype: ExecutionIterationWrapper

programConfig
^^^^^^^^^^^^^

.. java:field:: protected ProgramConfig programConfig
   :outertype: ExecutionIterationWrapper

Constructors
------------
ExecutionIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ExecutionIterationWrapper()
   :outertype: ExecutionIterationWrapper

Methods
-------
getClusteringResultFile
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected File getClusteringResultFile()
   :outertype: ExecutionIterationWrapper

getClusteringRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected ClusteringRunResult getClusteringRunResult()
   :outertype: ExecutionIterationWrapper

getConvertedClusteringRunResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected ClusteringRunResult getConvertedClusteringRunResult()
   :outertype: ExecutionIterationWrapper

getEffectiveParams
^^^^^^^^^^^^^^^^^^

.. java:method:: protected Map<String, String> getEffectiveParams()
   :outertype: ExecutionIterationWrapper

getInternalParams
^^^^^^^^^^^^^^^^^

.. java:method:: protected Map<String, String> getInternalParams()
   :outertype: ExecutionIterationWrapper

getInvocation
^^^^^^^^^^^^^

.. java:method:: public String[] getInvocation()
   :outertype: ExecutionIterationWrapper

getOptId
^^^^^^^^

.. java:method:: protected int getOptId()
   :outertype: ExecutionIterationWrapper

getParameterSet
^^^^^^^^^^^^^^^

.. java:method:: protected ParameterSet getParameterSet()
   :outertype: ExecutionIterationWrapper

getProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: protected ProgramConfig getProgramConfig()
   :outertype: ExecutionIterationWrapper

getResultQualityFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected File getResultQualityFile()
   :outertype: ExecutionIterationWrapper

setClusteringResultFile
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void setClusteringResultFile(File clusteringResultFile)
   :outertype: ExecutionIterationWrapper

setClusteringRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void setClusteringRunResult(ClusteringRunResult clusteringRunResult)
   :outertype: ExecutionIterationWrapper

setConvertedClusteringRunResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void setConvertedClusteringRunResult(ClusteringRunResult clusteringRunResult)
   :outertype: ExecutionIterationWrapper

setInvocation
^^^^^^^^^^^^^

.. java:method:: public void setInvocation(String[] invocation)
   :outertype: ExecutionIterationWrapper

setOptId
^^^^^^^^

.. java:method:: protected void setOptId(int optId)
   :outertype: ExecutionIterationWrapper

setParameterSet
^^^^^^^^^^^^^^^

.. java:method:: protected void setParameterSet(ParameterSet parameterSet)
   :outertype: ExecutionIterationWrapper

setProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: protected void setProgramConfig(ProgramConfig programConfig)
   :outertype: ExecutionIterationWrapper

setResultQualityFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void setResultQualityFile(File resultQualityFile)
   :outertype: ExecutionIterationWrapper

