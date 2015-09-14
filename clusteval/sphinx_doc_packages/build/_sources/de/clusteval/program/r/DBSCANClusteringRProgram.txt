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

DBSCANClusteringRProgram
========================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: @RLibraryRequirement public class DBSCANClusteringRProgram extends RelativeDataRProgram

   This class is an implementation of DBSCAN using the R-framework implementation of the package \ **fpc**\  in method \ **dbscan**\ .

   :author: Christian Wiwie

Constructors
------------
DBSCANClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DBSCANClusteringRProgram(Repository repository) throws RegisterException
   :outertype: DBSCANClusteringRProgram

   :param repository:
   :throws RegisterException:

DBSCANClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DBSCANClusteringRProgram(DBSCANClusteringRProgram other) throws RegisterException
   :outertype: DBSCANClusteringRProgram

   The copy constructor of Spectral clustering.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: DBSCANClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: DBSCANClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: DBSCANClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: DBSCANClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: DBSCANClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: DBSCANClusteringRProgram

