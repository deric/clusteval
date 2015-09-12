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

Gaussian2DDataSetGenerator
==========================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type:: @RLibraryRequirement public class Gaussian2DDataSetGenerator extends DataSetGenerator

   :author: Christian Wiwie

Fields
------
numberOfGaussians
^^^^^^^^^^^^^^^^^

.. java:field:: protected int numberOfGaussians
   :outertype: Gaussian2DDataSetGenerator

numberOfPoints
^^^^^^^^^^^^^^

.. java:field:: protected int numberOfPoints
   :outertype: Gaussian2DDataSetGenerator

radius
^^^^^^

.. java:field:: protected double radius
   :outertype: Gaussian2DDataSetGenerator

standardDeviations
^^^^^^^^^^^^^^^^^^

.. java:field:: protected double standardDeviations
   :outertype: Gaussian2DDataSetGenerator

Constructors
------------
Gaussian2DDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public Gaussian2DDataSetGenerator(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: Gaussian2DDataSetGenerator

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

Gaussian2DDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public Gaussian2DDataSetGenerator(Gaussian2DDataSetGenerator other) throws RegisterException
   :outertype: Gaussian2DDataSetGenerator

   The copy constructor of this class.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
generateDataSet
^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSet generateDataSet() throws DataSetGenerationException, InterruptedException
   :outertype: Gaussian2DDataSetGenerator

generateGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected GoldStandard generateGoldStandard() throws GoldStandardGenerationException
   :outertype: Gaussian2DDataSetGenerator

generatesGoldStandard
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean generatesGoldStandard()
   :outertype: Gaussian2DDataSetGenerator

getOptions
^^^^^^^^^^

.. java:method:: @Override public Options getOptions()
   :outertype: Gaussian2DDataSetGenerator

handleOptions
^^^^^^^^^^^^^

.. java:method:: @Override protected void handleOptions(CommandLine cmd) throws ParseException
   :outertype: Gaussian2DDataSetGenerator

