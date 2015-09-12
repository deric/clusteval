.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: file FileUtils

HierarchicalClusteringRProgram
==============================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: @RLibraryRequirement public class HierarchicalClusteringRProgram extends RelativeDataRProgram

   This class is an implementation of Hierarchical Clustering using the R-framework implementation of the package \ **stats**\  in method \ **cutree**\ .

   :author: Christian Wiwie

Constructors
------------
HierarchicalClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HierarchicalClusteringRProgram(Repository repository) throws RegisterException
   :outertype: HierarchicalClusteringRProgram

   :param repository:
   :throws RegisterException:

HierarchicalClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HierarchicalClusteringRProgram(HierarchicalClusteringRProgram other) throws RegisterException
   :outertype: HierarchicalClusteringRProgram

   The copy constructor of Hierarchical clustering.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: HierarchicalClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: HierarchicalClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: HierarchicalClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: HierarchicalClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: HierarchicalClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: HierarchicalClusteringRProgram

