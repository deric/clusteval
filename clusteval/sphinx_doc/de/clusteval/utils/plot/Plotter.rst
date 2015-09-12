.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils ArraysExt

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

Plotter
=======

.. java:package:: de.clusteval.utils.plot
   :noindex:

.. java:type:: public abstract class Plotter

   :author: Christian Wiwie

Methods
-------
assessAndWriteIsoMDSCoordinates
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static void assessAndWriteIsoMDSCoordinates(DataConfig dataConfig) throws UnknownDataSetFormatException, InvalidDataSetFormatVersionException, IllegalArgumentException, IOException, REngineException, InterruptedException
   :outertype: Plotter

   This method creates a file containing isoMDS coordinates using the similarity matrix file of the given data configuration.

   :param dataConfig:
   :throws IllegalArgumentException:
   :throws InterruptedException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws REngineException:
   :throws InvalidDataSetFormatVersionException:

assessAndWritePCACoordinates
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static void assessAndWritePCACoordinates(DataConfig dataConfig) throws InvalidDataSetFormatVersionException, IllegalArgumentException, IOException, REngineException, UnknownDataSetFormatException, InterruptedException
   :outertype: Plotter

   :param dataConfig:
   :throws IllegalArgumentException:
   :throws InterruptedException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws REngineException:
   :throws InvalidDataSetFormatVersionException:

plotParameterOptimizationResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static void plotParameterOptimizationResult(ParameterOptimizationResult result) throws InterruptedException
   :outertype: Plotter

   :param result:
   :throws InterruptedException:

