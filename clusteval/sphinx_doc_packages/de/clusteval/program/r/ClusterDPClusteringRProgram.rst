.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.utils RNotAvailableException

.. java:import:: file FileUtils

ClusterDPClusteringRProgram
===========================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public class ClusterDPClusteringRProgram extends RelativeDataRProgram

   :author: Christian Wiwie

Constructors
------------
ClusterDPClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusterDPClusteringRProgram(Repository repository) throws RegisterException
   :outertype: ClusterDPClusteringRProgram

   :param repository:
   :throws RegisterException:

ClusterDPClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusterDPClusteringRProgram(ClusterDPClusteringRProgram rProgram) throws RegisterException
   :outertype: ClusterDPClusteringRProgram

   :param rProgram:
   :throws RegisterException:

Methods
-------
beforeExec
^^^^^^^^^^

.. java:method:: @Override protected void beforeExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws RLibraryNotLoadedException, REngineException, RNotAvailableException, InterruptedException
   :outertype: ClusterDPClusteringRProgram

getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ClusterDPClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: ClusterDPClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: ClusterDPClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: ClusterDPClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: ClusterDPClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: ClusterDPClusteringRProgram

