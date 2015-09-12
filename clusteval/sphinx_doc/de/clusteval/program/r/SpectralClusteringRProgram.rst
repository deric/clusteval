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

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.utils RNotAvailableException

.. java:import:: file FileUtils

SpectralClusteringRProgram
==========================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: @RLibraryRequirement public class SpectralClusteringRProgram extends AbsoluteAndRelativeDataRProgram

   This class is an implementation of Spectral Clustering using the R-framework implementation of the package \ **kernlab**\  in method \ **specc**\ .

   :author: Christian Wiwie

Constructors
------------
SpectralClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SpectralClusteringRProgram(Repository repository) throws RegisterException
   :outertype: SpectralClusteringRProgram

   :param repository:
   :throws RegisterException:

SpectralClusteringRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SpectralClusteringRProgram(SpectralClusteringRProgram other) throws RegisterException
   :outertype: SpectralClusteringRProgram

   The copy constructor of Spectral clustering.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
beforeExec
^^^^^^^^^^

.. java:method:: @Override protected void beforeExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws RLibraryNotLoadedException, REngineException, RNotAvailableException, InterruptedException
   :outertype: SpectralClusteringRProgram

convertDistancesToAppropriateDatastructure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void convertDistancesToAppropriateDatastructure() throws RserveException, InterruptedException
   :outertype: SpectralClusteringRProgram

getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SpectralClusteringRProgram

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: SpectralClusteringRProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext() throws UnknownContextException
   :outertype: SpectralClusteringRProgram

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: SpectralClusteringRProgram

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getInvocationFormat()
   :outertype: SpectralClusteringRProgram

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: SpectralClusteringRProgram

