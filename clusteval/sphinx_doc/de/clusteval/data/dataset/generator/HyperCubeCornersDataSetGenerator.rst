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

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: file FileUtils

HyperCubeCornersDataSetGenerator
================================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type:: @RLibraryRequirement public class HyperCubeCornersDataSetGenerator extends DataSetGenerator

   :author: Christian Wiwie

Fields
------
numberDimensions
^^^^^^^^^^^^^^^^

.. java:field:: protected int numberDimensions
   :outertype: HyperCubeCornersDataSetGenerator

numberOfPoints
^^^^^^^^^^^^^^

.. java:field:: protected int numberOfPoints
   :outertype: HyperCubeCornersDataSetGenerator

standardDeviation
^^^^^^^^^^^^^^^^^

.. java:field:: protected double standardDeviation
   :outertype: HyperCubeCornersDataSetGenerator

Constructors
------------
HyperCubeCornersDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HyperCubeCornersDataSetGenerator(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: HyperCubeCornersDataSetGenerator

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

HyperCubeCornersDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HyperCubeCornersDataSetGenerator(DataSetGenerator other) throws RegisterException
   :outertype: HyperCubeCornersDataSetGenerator

   :param other:
   :throws RegisterException:

Methods
-------
generateDataSet
^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSet generateDataSet() throws DataSetGenerationException, InterruptedException
   :outertype: HyperCubeCornersDataSetGenerator

generateGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected GoldStandard generateGoldStandard() throws GoldStandardGenerationException
   :outertype: HyperCubeCornersDataSetGenerator

generatesGoldStandard
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean generatesGoldStandard()
   :outertype: HyperCubeCornersDataSetGenerator

getOptions
^^^^^^^^^^

.. java:method:: @Override protected Options getOptions()
   :outertype: HyperCubeCornersDataSetGenerator

handleOptions
^^^^^^^^^^^^^

.. java:method:: @Override protected void handleOptions(CommandLine cmd) throws ParseException
   :outertype: HyperCubeCornersDataSetGenerator

