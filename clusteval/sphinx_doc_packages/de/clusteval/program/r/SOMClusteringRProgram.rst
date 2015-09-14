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

SOMClusteringRProgram
=====================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: @RLibraryRequirement public class SOMClusteringRProgram extends AbsoluteDataRProgram

   This class is an implementation of Self Organizing Maps using the R-framework implementation of the package \ **kohonen**\  in method \ **som**\ .

   :author: Christian Wiwie

Constructors
------------
SOMClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SOMClusteringRProgram(Repository repository) throws RegisterException
   :outertype: SOMClusteringRProgram

   :param repository:
   :throws RegisterException:

SOMClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SOMClusteringRProgram(SOMClusteringRProgram other) throws RegisterException
   :outertype: SOMClusteringRProgram

   The copy constructor of SOM.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SOMClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: SOMClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: SOMClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: SOMClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: SOMClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: SOMClusteringRProgram

