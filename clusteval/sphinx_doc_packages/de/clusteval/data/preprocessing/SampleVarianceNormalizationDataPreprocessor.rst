.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Arrays

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

SampleVarianceNormalizationDataPreprocessor
===========================================

.. java:package:: de.clusteval.data.preprocessing
   :noindex:

.. java:type:: public class SampleVarianceNormalizationDataPreprocessor extends DataPreprocessor

   Normalize every sample of the dataset (rows of the data matrix) to variances of 1.

   :author: Christian Wiwie

Constructors
------------
SampleVarianceNormalizationDataPreprocessor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SampleVarianceNormalizationDataPreprocessor(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: SampleVarianceNormalizationDataPreprocessor

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SampleVarianceNormalizationDataPreprocessor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SampleVarianceNormalizationDataPreprocessor(SampleVarianceNormalizationDataPreprocessor other) throws RegisterException
   :outertype: SampleVarianceNormalizationDataPreprocessor

   :param other:
   :throws RegisterException:

Methods
-------
getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<String> getCompatibleDataSetFormats()
   :outertype: SampleVarianceNormalizationDataPreprocessor

preprocess
^^^^^^^^^^

.. java:method:: @Override public DataSet preprocess(DataSet data) throws InterruptedException
   :outertype: SampleVarianceNormalizationDataPreprocessor

