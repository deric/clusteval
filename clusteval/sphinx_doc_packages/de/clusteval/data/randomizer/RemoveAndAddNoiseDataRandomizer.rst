.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.util Arrays

.. java:import:: org.apache.commons.cli CommandLine

.. java:import:: org.apache.commons.cli Option

.. java:import:: org.apache.commons.cli OptionBuilder

.. java:import:: org.apache.commons.cli Options

.. java:import:: org.apache.commons.cli ParseException

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils Pair

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: file FileUtils

RemoveAndAddNoiseDataRandomizer
===============================

.. java:package:: de.clusteval.data.randomizer
   :noindex:

.. java:type:: public class RemoveAndAddNoiseDataRandomizer extends DataRandomizer

   :author: Christian Wiwie

Fields
------
addPercentage
^^^^^^^^^^^^^

.. java:field:: protected double addPercentage
   :outertype: RemoveAndAddNoiseDataRandomizer

removePercentage
^^^^^^^^^^^^^^^^

.. java:field:: protected double removePercentage
   :outertype: RemoveAndAddNoiseDataRandomizer

Constructors
------------
RemoveAndAddNoiseDataRandomizer
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RemoveAndAddNoiseDataRandomizer(RemoveAndAddNoiseDataRandomizer other) throws RegisterException
   :outertype: RemoveAndAddNoiseDataRandomizer

   :param other:
   :throws RegisterException:

RemoveAndAddNoiseDataRandomizer
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RemoveAndAddNoiseDataRandomizer(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RemoveAndAddNoiseDataRandomizer

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

Methods
-------
getDataSetFileNamePostFix
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getDataSetFileNamePostFix()
   :outertype: RemoveAndAddNoiseDataRandomizer

getOptions
^^^^^^^^^^

.. java:method:: @Override protected Options getOptions()
   :outertype: RemoveAndAddNoiseDataRandomizer

handleOptions
^^^^^^^^^^^^^

.. java:method:: @Override protected void handleOptions(CommandLine cmd) throws ParseException
   :outertype: RemoveAndAddNoiseDataRandomizer

randomizeDataConfig
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected Pair<DataSet, GoldStandard> randomizeDataConfig() throws InterruptedException
   :outertype: RemoveAndAddNoiseDataRandomizer

