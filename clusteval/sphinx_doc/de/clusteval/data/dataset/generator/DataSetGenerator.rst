.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: org.apache.commons.cli CommandLine

.. java:import:: org.apache.commons.cli CommandLineParser

.. java:import:: org.apache.commons.cli Option

.. java:import:: org.apache.commons.cli OptionBuilder

.. java:import:: org.apache.commons.cli Options

.. java:import:: org.apache.commons.cli ParseException

.. java:import:: org.apache.commons.cli PosixParser

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program.r RLibraryInferior

.. java:import:: file FileUtils

DataSetGenerator
================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type:: public abstract class DataSetGenerator extends RepositoryObject implements RLibraryInferior

   :author: Christian Wiwie

Constructors
------------
DataSetGenerator
^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetGenerator(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DataSetGenerator

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DataSetGenerator
^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetGenerator(DataSetGenerator other) throws RegisterException
   :outertype: DataSetGenerator

   The copy constructor of dataset generators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RepositoryObject clone()
   :outertype: DataSetGenerator

generate
^^^^^^^^

.. java:method:: public DataSet generate(String[] cliArguments) throws ParseException, DataSetGenerationException, GoldStandardGenerationException, InterruptedException
   :outertype: DataSetGenerator

   This method has to be invoked with command line arguments for this generator. Valid arguments are defined by the options returned by \ :java:ref:`getOptions()`\ .

   :param cliArguments:
   :throws InterruptedException:
   :throws GoldStandardGenerationException:
   :throws ParseException: This exception is thrown, if the passed arguments are not valid.
   :throws DataSetGenerationException:
   :return: The generated \ :java:ref:`DataSet`\ .

generateDataSet
^^^^^^^^^^^^^^^

.. java:method:: protected abstract DataSet generateDataSet() throws DataSetGenerationException, InterruptedException
   :outertype: DataSetGenerator

   This method needs to be implemented in subclasses and is a helper method for \ :java:ref:`generate(String[])`\ . It provides the core of a dataset generator by generating the dataset file and creating a \ :java:ref:`DataSet`\  wrapper object for it.

   :throws InterruptedException:
   :throws DataSetGenerationException: If something goes wrong during the generation process, this exception is thrown.
   :return: A \ :java:ref:`DataSet`\  wrapper object for the generated dataset file.

generateGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract GoldStandard generateGoldStandard() throws GoldStandardGenerationException
   :outertype: DataSetGenerator

   This method needs to be implemented in subclasses and is a helper method for \ :java:ref:`generate(String[])`\ . It provides the functionality to generate the goldstandard file and creating a \ :java:ref:`GoldStandard`\  wrapper object for it.

   :throws GoldStandardGenerationException: If something goes wrong during the generation process, this exception is thrown.
   :return: A \ :java:ref:`GoldStandard`\  wrapper object for the generated goldstandard file.

generatesGoldStandard
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean generatesGoldStandard()
   :outertype: DataSetGenerator

   If your dataset generator also creates a goldstandard for the generated dataset, this method has to return true.

   If a goldstandard is to be created, it is going to be stored under the same \ :java:ref:`folderName`\  and with the same \ :java:ref:`fileName`\  as the dataset, but within the goldstandard directory of the repository.

   :return: A boolean indicating, whether your dataset generator also generates a corresponding goldstandard for the created dataset.

getAlias
^^^^^^^^

.. java:method:: protected String getAlias()
   :outertype: DataSetGenerator

getAllOptions
^^^^^^^^^^^^^

.. java:method:: public Options getAllOptions()
   :outertype: DataSetGenerator

   :return: A wrapper object keeping all options of your dataset generator together with the default options of all dataset generators. The options returned by this method are going to be used and interpreted in your subclass implementation in \ :java:ref:`generateDataSet()`\  .

getFileName
^^^^^^^^^^^

.. java:method:: protected String getFileName()
   :outertype: DataSetGenerator

getFolderName
^^^^^^^^^^^^^

.. java:method:: protected String getFolderName()
   :outertype: DataSetGenerator

getOptions
^^^^^^^^^^

.. java:method:: protected abstract Options getOptions()
   :outertype: DataSetGenerator

   :return: A wrapper object keeping the options of your dataset generator. The options returned by this method are going to be used and interpreted in your subclass implementation in \ :java:ref:`generateDataSet()`\  .

handleOptions
^^^^^^^^^^^^^

.. java:method:: protected abstract void handleOptions(CommandLine cmd) throws ParseException
   :outertype: DataSetGenerator

   This method is reponsible for interpreting the arguments passed to this generator call and to initialize possibly needed member variables.

   If you want to react to certain options in your implementation of \ :java:ref:`generateDataSet()`\ , initialize member variables in this method.

   :param cmd: A wrapper object for the arguments passed to this generator.
   :throws ParseException:

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataSetGenerator parseFromString(Repository repository, String dataSetGenerator) throws UnknownDataSetGeneratorException
   :outertype: DataSetGenerator

   Parses a dataset generator from string.

   :param repository: the repository
   :param dataSetGenerator: The simple name of the dataset generator class.
   :throws UnknownDataSetGeneratorException:
   :return: the clustering quality measure

