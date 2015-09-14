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

KMedoidsClusteringRProgram
==========================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: @RLibraryRequirement public class KMedoidsClusteringRProgram extends RelativeDataRProgram

   This class is an implementation of K-Medoids Clustering based on the R-framework function kmedoids() of the clue package.

   :author: Christian Wiwie

Constructors
------------
KMedoidsClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public KMedoidsClusteringRProgram(Repository repository) throws RegisterException
   :outertype: KMedoidsClusteringRProgram

   :param repository:
   :throws RegisterException:

KMedoidsClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public KMedoidsClusteringRProgram(KMedoidsClusteringRProgram other) throws RegisterException
   :outertype: KMedoidsClusteringRProgram

   The copy constructor of K-Medoids clustering.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: KMedoidsClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: KMedoidsClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: KMedoidsClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: KMedoidsClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: KMedoidsClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: KMedoidsClusteringRProgram

