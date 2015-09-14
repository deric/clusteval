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

   A data set generator MyDataSetGenerator can be added to ClustEval by

   1. extending this class with your own class MyDataSetGenerator. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your runresult format.

     * :java:ref:`DataSetGenerator(Repository, boolean, long, File)`: The constructor of your class. This constructor has to be implemented and public, otherwise the framework will not be able to load your runresult format.
     * :java:ref:`DataSetGenerator(DataSetGenerator)`: The copy constructor of your class taking another instance of your class. This constructor has to be implemented and public.
     * :java:ref:`generateDataSet()`: This method generates the data set, writes it to the file system and returns a DataSet wrapper object.
     * :java:ref:`generatesGoldStandard()`: Returns true, if this generator generates a gold standard together with each generated data set.
     * :java:ref:`generateGoldStandard()`: If :java:ref:`generatesGoldStandard()` returns true, this method generates a gold standard for the generated data set, writes it to the file system and returns a GoldStandard wrapper object.
     * :java:ref:`getOptions()`: This method returns an :java:ref:`Options` object that encapsulates all parameters that this generator has. These can be set by the user in the client.
     * :java:ref:`handleOptions(CommandLine)`: This method handles the values that the user set for the parameters specified in :java:ref:`getOptions()`.

   2. Creating a jar file named MyDataSetGenerator.jar containing the MyDataSetGenerator.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/data/dataset/generator/MyDataSetGenerator.class

   3. Putting the MyDataSetGenerator.jar into the corresponding folder of the repository:

     * <REPOSITORY ROOT>/supp/generators
     * The backend server will recognize and try to load the new class automatically the next time, the :java:ref:`DataSetGeneratorFinderThread` checks the filesystem.

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

