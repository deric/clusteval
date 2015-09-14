.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

FuzzyCoefficientThresholdRunResultPostprocessor
===============================================

.. java:package:: de.clusteval.run.result.postprocessing
   :noindex:

.. java:type:: public class FuzzyCoefficientThresholdRunResultPostprocessor extends RunResultPostprocessor

   :author: Christian Wiwie

Constructors
------------
FuzzyCoefficientThresholdRunResultPostprocessor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FuzzyCoefficientThresholdRunResultPostprocessor(Repository repository, boolean register, long changeDate, File absPath, RunResultPostprocessorParameters parameters) throws RegisterException
   :outertype: FuzzyCoefficientThresholdRunResultPostprocessor

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param parameters:
   :throws RegisterException:

FuzzyCoefficientThresholdRunResultPostprocessor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FuzzyCoefficientThresholdRunResultPostprocessor(FuzzyCoefficientThresholdRunResultPostprocessor other) throws RegisterException
   :outertype: FuzzyCoefficientThresholdRunResultPostprocessor

   :param other:
   :throws RegisterException:

Methods
-------
postprocess
^^^^^^^^^^^

.. java:method:: @Override public Clustering postprocess(Clustering clustering)
   :outertype: FuzzyCoefficientThresholdRunResultPostprocessor

