.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: org.apache.commons.cli CommandLine

.. java:import:: org.apache.commons.cli CommandLineParser

.. java:import:: org.apache.commons.cli Option

.. java:import:: org.apache.commons.cli OptionBuilder

.. java:import:: org.apache.commons.cli Options

.. java:import:: org.apache.commons.cli ParseException

.. java:import:: org.apache.commons.cli PosixParser

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.generator DataSetGenerationException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryObjectDumpException

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r RLibraryInferior

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: file FileUtils

DataRandomizer
==============

.. java:package:: de.clusteval.data.randomizer
   :noindex:

.. java:type:: public abstract class DataRandomizer extends RepositoryObject implements RLibraryInferior

   A data randomizer MyDataRandomizer can be added to ClustEval by

   1. extending this class with your own class MyDataRandomizer. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your runresult format.

     * :java:ref:`DataRandomizer(Repository, boolean, long, File)`: The constructor of your class. This constructor has to be implemented and public, otherwise the framework will not be able to load your runresult format.
     * :java:ref:`DataRandomizer(DataRandomizer)`: The copy constructor of your class taking another instance of your class. This constructor has to be implemented and public.
     * :java:ref:`getOptions()`: This method returns an :java:ref:`Options` object that encapsulates all parameters that this randomizer has. These can be set by the user in the client.
     * :java:ref:`handleOptions(CommandLine)`: This method handles the values that the user set for the parameters specified in :java:ref:`getOptions()`.
     * :java:ref:`getDataSetFileNamePostFix()`: This method makes sure, that randomized data sets of the same data configuration do not end up with the same file name and overwrite each other. A good advice is to integrate the randomizer parameter values or a timestamp.
     * :java:ref:`randomizeDataConfig()`: This is the core of your randomizer; In this method the #dataConfig attribute is randomized and a distorted data set and gold standard is returned.

   2. Creating a jar file named MyDataRandomizer.jar containing the MyDataRandomizer.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/data/randomizer/MyDataRandomizer.class

   3. Putting the MyDataRandomizer.jar into the corresponding folder of the repository:

     * <REPOSITORY ROOT>/supp/randomizers
     * The backend server will recognize and try to load the new class automatically the next time, the :java:ref:`DataRandomizerFinderThread` checks the filesystem.

   :author: Christian Wiwie

Fields
------
dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: DataRandomizer

   This attribute holds the name of the data configuration to randomize.

onlySimulate
^^^^^^^^^^^^

.. java:field:: protected boolean onlySimulate
   :outertype: DataRandomizer

uniqueId
^^^^^^^^

.. java:field:: protected String uniqueId
   :outertype: DataRandomizer

Constructors
------------
DataRandomizer
^^^^^^^^^^^^^^

.. java:constructor:: public DataRandomizer(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DataRandomizer

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DataRandomizer
^^^^^^^^^^^^^^

.. java:constructor:: public DataRandomizer(DataRandomizer other) throws RegisterException
   :outertype: DataRandomizer

   The copy constructor of dataset randomizer.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DataRandomizer clone()
   :outertype: DataRandomizer

getAllOptions
^^^^^^^^^^^^^

.. java:method:: public Options getAllOptions()
   :outertype: DataRandomizer

   :return: A wrapper object keeping all options of your dataset generator together with the default options of all dataset generators. The options returned by this method are going to be used and interpreted in your subclass implementation in \ :java:ref:`randomizeDataConfig()`\  .

getDataSetFileNamePostFix
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String getDataSetFileNamePostFix()
   :outertype: DataRandomizer

getOptions
^^^^^^^^^^

.. java:method:: protected abstract Options getOptions()
   :outertype: DataRandomizer

   :return: A wrapper object keeping the options of your dataset generator. The options returned by this method are going to be used and interpreted in your subclass implementation in \ :java:ref:`generateDataSet()`\  .

handleOptions
^^^^^^^^^^^^^

.. java:method:: protected abstract void handleOptions(CommandLine cmd) throws ParseException
   :outertype: DataRandomizer

   This method is reponsible for interpreting the arguments passed to this generator call and to initialize possibly needed member variables.

   If you want to react to certain options in your implementation of \ :java:ref:`generateDataSet()`\ , initialize member variables in this method.

   :param cmd: A wrapper object for the arguments passed to this generator.
   :throws ParseException:

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataRandomizer parseFromString(Repository repository, String dataRandomizer) throws UnknownDataRandomizerException
   :outertype: DataRandomizer

   Parses a dataconfig randomizer from string.

   :param repository: the repository
   :param dataRandomizer: The simple name of the dataset randomizer class.
   :throws UnknownDataRandomizerException:
   :return: the clustering quality measure

randomize
^^^^^^^^^

.. java:method:: public DataConfig randomize(String[] cliArguments) throws DataRandomizeException
   :outertype: DataRandomizer

randomize
^^^^^^^^^

.. java:method:: public DataConfig randomize(String[] cliArguments, boolean onlySimulate) throws DataRandomizeException
   :outertype: DataRandomizer

   This method has to be invoked with command line arguments for this generator. Valid arguments are defined by the options returned by \ :java:ref:`getOptions()`\ .

   :param cliArguments:
   :throws DataRandomizeException:
   :return: The generated \ :java:ref:`DataSet`\ .

randomizeDataConfig
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract Pair<DataSet, GoldStandard> randomizeDataConfig() throws InterruptedException
   :outertype: DataRandomizer

   This method needs to be implemented in subclasses and is a helper method for \ :java:ref:`randomize(String[])`\ . It provides the core of a dataset generator by generating the dataset file and creating a \ :java:ref:`DataSet`\  wrapper object for it.

   :throws InterruptedException:
   :throws DataSetGenerationException: If something goes wrong during the generation process, this exception is thrown.

writeConfigFiles
^^^^^^^^^^^^^^^^

.. java:method:: protected DataConfig writeConfigFiles(DataSet newDataSet, GoldStandard newGoldStandard) throws IOException, UnknownDataSetFormatException, GoldStandardNotFoundException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, NoDataSetException, DataConfigurationException, DataConfigNotFoundException, NumberFormatException, ConfigurationException, UnknownContextException, RegisterException, UnknownParameterType, NoRepositoryFoundException, UnknownClusteringQualityMeasureException, RunException, IncompatibleContextException, UnknownRunResultFormatException, InvalidOptimizationParameterException, UnknownProgramParameterException, UnknownProgramTypeException, UnknownRProgramException, UnknownDistanceMeasureException, UnknownDataSetTypeException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, IncompatibleParameterOptimizationMethodException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownDataStatisticException, UnknownRunStatisticException, UnknownRunDataStatisticException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException, RepositoryObjectDumpException
   :outertype: DataRandomizer

