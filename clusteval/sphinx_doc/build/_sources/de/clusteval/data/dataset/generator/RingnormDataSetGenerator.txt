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

RingnormDataSetGenerator
========================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type:: @RLibraryRequirement public class RingnormDataSetGenerator extends DataSetGenerator

   :author: Christian Wiwie

Fields
------
numberDimensions
^^^^^^^^^^^^^^^^

.. java:field:: protected int numberDimensions
   :outertype: RingnormDataSetGenerator

numberOfPoints
^^^^^^^^^^^^^^

.. java:field:: protected int numberOfPoints
   :outertype: RingnormDataSetGenerator

Constructors
------------
RingnormDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RingnormDataSetGenerator(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RingnormDataSetGenerator

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RingnormDataSetGenerator
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RingnormDataSetGenerator(DataSetGenerator other) throws RegisterException
   :outertype: RingnormDataSetGenerator

   :param other:
   :throws RegisterException:

Methods
-------
generateDataSet
^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSet generateDataSet() throws DataSetGenerationException, InterruptedException
   :outertype: RingnormDataSetGenerator

generateGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected GoldStandard generateGoldStandard() throws GoldStandardGenerationException
   :outertype: RingnormDataSetGenerator

generatesGoldStandard
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean generatesGoldStandard()
   :outertype: RingnormDataSetGenerator

getOptions
^^^^^^^^^^

.. java:method:: @Override protected Options getOptions()
   :outertype: RingnormDataSetGenerator

handleOptions
^^^^^^^^^^^^^

.. java:method:: @Override protected void handleOptions(CommandLine cmd) throws ParseException
   :outertype: RingnormDataSetGenerator

