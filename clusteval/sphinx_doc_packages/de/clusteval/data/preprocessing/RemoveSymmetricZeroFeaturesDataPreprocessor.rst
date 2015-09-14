.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Arrays

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RemoveSymmetricZeroFeaturesDataPreprocessor
===========================================

.. java:package:: de.clusteval.data.preprocessing
   :noindex:

.. java:type:: public class RemoveSymmetricZeroFeaturesDataPreprocessor extends DataPreprocessor

   :author: Christian Wiwie

Constructors
------------
RemoveSymmetricZeroFeaturesDataPreprocessor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RemoveSymmetricZeroFeaturesDataPreprocessor(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RemoveSymmetricZeroFeaturesDataPreprocessor

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RemoveSymmetricZeroFeaturesDataPreprocessor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RemoveSymmetricZeroFeaturesDataPreprocessor(RemoveSymmetricZeroFeaturesDataPreprocessor other) throws RegisterException
   :outertype: RemoveSymmetricZeroFeaturesDataPreprocessor

   :param other:
   :throws RegisterException:

Methods
-------
getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<String> getCompatibleDataSetFormats()
   :outertype: RemoveSymmetricZeroFeaturesDataPreprocessor

preprocess
^^^^^^^^^^

.. java:method:: @Override public DataSet preprocess(DataSet data) throws InterruptedException
   :outertype: RemoveSymmetricZeroFeaturesDataPreprocessor

