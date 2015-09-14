.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils ArraysExt

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

CMeansClusteringRProgram
========================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: @RLibraryRequirement public class CMeansClusteringRProgram extends AbsoluteAndRelativeDataRProgram

   This class is an implementation of C-Means Clustering based on the R-framework implementation in the cmeans() method which is contained in the e1071 library.

   :author: Christian Wiwie

Constructors
------------
CMeansClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CMeansClusteringRProgram(Repository repository) throws RegisterException
   :outertype: CMeansClusteringRProgram

   :param repository:
   :throws RegisterException:

CMeansClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CMeansClusteringRProgram(CMeansClusteringRProgram other) throws RegisterException
   :outertype: CMeansClusteringRProgram

   The copy constructor of C-Means clustering.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: CMeansClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: CMeansClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: CMeansClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: CMeansClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: CMeansClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: CMeansClusteringRProgram

