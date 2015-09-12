.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: java.util.concurrent TimeUnit

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.slf4j LoggerFactory

.. java:import:: utils Pair

.. java:import:: utils StringExt

.. java:import:: utils Triple

.. java:import:: utils.parse TextFileParser

.. java:import:: utils.parse TextFileParser.OUTPUT_MODE

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization NoParameterSetFoundException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.data.dataset.format ConversionStandardToInputConfiguration

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format IncompatibleDataSetFormatException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard IncompleteGoldStandardException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.program.r RProcess

.. java:import:: de.clusteval.program.r RProgram

.. java:import:: de.clusteval.run ExecutionRun

.. java:import:: de.clusteval.run MissingParameterValueException

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result ClusteringRunResult

.. java:import:: de.clusteval.run.result NoRunResultFormatParserException

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format RunResultNotFoundException

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.utils FormatConversionException

.. java:import:: de.clusteval.utils InternalAttributeException

.. java:import:: de.clusteval.utils RNotAvailableException

.. java:import:: de.clusteval.utils.plot Plotter

.. java:import:: file FileUtils

.. java:import:: format Formatter

ExecutionRunRunnable
====================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public abstract class ExecutionRunRunnable extends RunRunnable<ExecutionIterationRunnable, ExecutionIterationWrapper>

   A type of a runnable, that corresponds to \ :java:ref:`ExecutionRun`\ s and is therefore responsible for performing program configurations and certain data configurations.

   :author: Christian Wiwie

Fields
------
completeQualityOutput
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String completeQualityOutput
   :outertype: ExecutionRunRunnable

   A temporary variable holding the absolute path to the current complete quality output file during execution of the runnable.

dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: ExecutionRunRunnable

   The data configuration this thread combines with a program configuration.

format
^^^^^^

.. java:field:: protected RunResultFormat format
   :outertype: ExecutionRunRunnable

   This is the run result format of the program that is being executed by this runnable.

programConfig
^^^^^^^^^^^^^

.. java:field:: protected ProgramConfig programConfig
   :outertype: ExecutionRunRunnable

   The program configuration this thread combines with a data configuration.

runParams
^^^^^^^^^

.. java:field:: protected Map<ProgramParameter<?>, String> runParams
   :outertype: ExecutionRunRunnable

   A map containing all the parameter values set in the run.

Constructors
------------
ExecutionRunRunnable
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ExecutionRunRunnable(Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: ExecutionRunRunnable

   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param programConfig: The program configuration encapsulating the program executed by this runnable.
   :param dataConfig: The data configuration used by this runnable.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: @Override protected void afterRun() throws InterruptedException
   :outertype: ExecutionRunRunnable

beforeRun
^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void beforeRun() throws UnknownDataSetFormatException, InvalidDataSetFormatVersionException, IllegalArgumentException, IOException, RegisterException, InternalAttributeException, IncompatibleDataSetFormatException, UnknownGoldStandardFormatException, IncompleteGoldStandardException, InterruptedException
   :outertype: ExecutionRunRunnable

checkCompatibilityDataSetGoldStandard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void checkCompatibilityDataSetGoldStandard(DataSetConfig dataSetConfig, GoldStandardConfig goldStandardConfig) throws UnknownGoldStandardFormatException, IncompleteGoldStandardException, IllegalArgumentException
   :outertype: ExecutionRunRunnable

   This method checks, whether the dataset is compatible to the goldstandard, by verifying, that all objects contained in the dataset have an entry in the goldstandard and vice versa.

   :param dataSetConfig: The dataset configuration encapsulating the dataset to be checked.
   :param goldStandardConfig: The goldstandard configuration encapsulating the goldstandardto be checked.
   :throws UnknownGoldStandardFormatException:
   :throws IllegalArgumentException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws IncompleteGoldStandardException:
   :throws InvalidDataSetFormatVersionException:

convertResult
^^^^^^^^^^^^^

.. java:method:: protected ClusteringRunResult convertResult(ClusteringRunResult result, Map<String, String> effectiveParams, Map<String, String> internalParams) throws NoRunResultFormatParserException, RunResultNotFoundException, RunResultConversionException
   :outertype: ExecutionRunRunnable

   A wrapper method for the conversion of the run result, which handles logging and adding the converted result to the results of the run.

   :throws RunResultNotFoundException:
   :throws RunResultConversionException:
   :throws SecurityException:
   :throws NoRunResultFormatParserException:
   :return: The result of the last iteration converted to the standard format.

createIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected ExecutionIterationRunnable createIterationRunnable(ExecutionIterationWrapper iterationWrapper)
   :outertype: ExecutionRunRunnable

createIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected ExecutionIterationWrapper createIterationWrapper()
   :outertype: ExecutionRunRunnable

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void decorateIterationWrapper(ExecutionIterationWrapper iterationWrapper, int currentPos) throws RunIterationException
   :outertype: ExecutionRunRunnable

doRunIteration
^^^^^^^^^^^^^^

.. java:method:: @Override protected void doRunIteration(ExecutionIterationWrapper iterationWrapper) throws RunIterationException
   :outertype: ExecutionRunRunnable

   Method invoked by \ :java:ref:`doRun()`\  which performs a single iteration of the run. If this runnable is of type parameter optimization, this method is invoked several times. In case of a clustering run, it is invoked only once.

   First this method initializes all files and folder structures in \ :java:ref:`initAndEnsureIterationFilesAndFolders()`\  such that the following computations can be performed smoothly.

   It initializes all attribute variables needed throughout the process itself and by invoking \ :java:ref:`parseInvocationLineAndEffectiveParameters()`\ .

   The clustering method is executed with the given parameter values and settings asynchronously. It waits until the second process finishes.

   The result file of the clustering method is converted to the standard result format by invoking \ :java:ref:`convertResult()`\ .

   Next the qualities of the converted result file are assessed in \ :java:ref:`assessQualities(ClusteringRunResult)`\ .

   Then it invokes \ :java:ref:`writeQualitiesToFile(List)`\ , which writes the assessed cluster qualities into files on the filesystem.

   In \ :java:ref:`afterClustering(ClusteringRunResult)`\  all actions are performed, that require the clustering process to be finished beforehand.

   Last the result is added to the list of run results of the corresponding run of this runnable.

   In case the run result is missing or cannot be parsed successfully, \ :java:ref:`handleMissingRunResult()`\  is responsible for performing actions ensuring, that the next iterations can be executed without problems.

getCompleteQualityOutput
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getCompleteQualityOutput()
   :outertype: ExecutionRunRunnable

getDataConfig
^^^^^^^^^^^^^

.. java:method:: public DataConfig getDataConfig()
   :outertype: ExecutionRunRunnable

   :return: The data configuration of this runnable.

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected String getInvocationFormat()
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters(String,String,Map,Map,Map,StringBuilder)`\

   Get the original invocation line format from the program configuration without replacing of any parameters.

   :return: The invocation line.

getProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: public ProgramConfig getProgramConfig()
   :outertype: ExecutionRunRunnable

   :return: The program configuration of this runnable.

getRun
^^^^^^

.. java:method:: @Override public ExecutionRun getRun()
   :outertype: ExecutionRunRunnable

handleMissingRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void handleMissingRunResult(ExecutionIterationWrapper iterationWrapper)
   :outertype: ExecutionRunRunnable

   Overwrite this method in your subclass, if you want to handle missing run results individually.

   This can comprise actions ensuring that further iterations can be executed smoothly.

initAndEnsureIterationFilesAndFolders
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void initAndEnsureIterationFilesAndFolders(ExecutionIterationWrapper iterationWrapper)
   :outertype: ExecutionRunRunnable

   This method is invoked by \ :java:ref:`doRunIteration()`\  before any calculations are done, to ensure, that all folders and files are created such that the remainder process can be performed without problems.

   This method also initializes the file object attribute variables that are used throughout the process: \ :java:ref:`logFile`\ , \ :java:ref:`clusteringResultFile`\  and \ :java:ref:`resultQualityFile`\ .

parseExecutable
^^^^^^^^^^^^^^^

.. java:method:: protected String[] parseExecutable(String[] invocation, Map<String, String> internalParams)
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters(String,String,Map,Map,Map,StringBuilder)`\

   Replace the executable parameter %e% in the invocation line by the absolute path to the executable.

   :param invocation: The invocation line without replaced executable parameter.
   :param internalParams: The map containing all internal parameters, e.g. the executable path.
   :return: The invocation line with replaced executable parameter.

parseGoldStandard
^^^^^^^^^^^^^^^^^

.. java:method:: protected String[] parseGoldStandard(String[] invocation, Map<String, String> internalParams)
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters(String,String,Map,Map,Map,StringBuilder)`\

   Replace the goldstandard parameter %gs% in the invocation line by the absolute path to the goldstandard.

   :param invocation: The invocation line without replaced goldstandard parameter.
   :param internalParams: The map containing all internal parameters, e.g. the goldstandard path.
   :return: The invocation line with replaced goldstandard parameter.

parseInput
^^^^^^^^^^

.. java:method:: protected String[] parseInput(String[] invocation, Map<String, String> internalParams)
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters(String,String,Map,Map,Map,StringBuilder)`\

   Replace the input parameter %i% in the invocation line by the absolute path to the input file.

   :param invocation: The invocation line without replaced input parameter.
   :param internalParams: The map containing all internal parameters, e.g. the input path.
   :return: The invocation line with replaced input parameter.

parseInvocationLineAndEffectiveParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected String[] parseInvocationLineAndEffectiveParameters(ExecutionIterationWrapper iterationWrapper) throws InternalAttributeException, RegisterException, NoParameterSetFoundException
   :outertype: ExecutionRunRunnable

   This method builds up the invocation line by replacing placeholders of internal parameters by their actual runtime values:

   ..

   * \ **%e%**\ : The absolute path to the executable
   * \ **%i%**\ : The absolute path to the input file
   * \ **%gs%**\ : The absolute path to the goldstandard file
   * \ **%o%**\ : The absolute path to the output file

   Afterwards, non-internal parameters are replaced, that means parameters, that are defined in the configuration files of the run or program in \ :java:ref:`replaceRunParameters(String[])`\ , e.g.:

   ..

   * \ **%T%**\  is replaced by 2.0

   All placeholders that are not replaced at this point are replaced by the default values of the corresponding parameters by invoking \ :java:ref:`replaceDefaultParameters(String[])`\ . If the invocation line contains placeholders that cannot be mapped to a parameter, an exception is thrown and the process is terminated.

   :throws NoParameterSetFoundException: This exception is thrown, if no parameter set was found that was not already evaluated before.
   :throws InternalAttributeException:
   :throws RegisterException:
   :return: The parsed invocation line.

parseOutput
^^^^^^^^^^^

.. java:method:: protected String[] parseOutput(String clusteringOutput, String qualityOutput, String[] invocation, Map<String, String> internalParams)
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters(String,String,Map,Map,Map,StringBuilder)`\

   Replace the output parameter %o% in the invocation line by the absolute path to the output file.

   :param invocation: The invocation line without replaced output parameter.
   :param internalParams: The map containing all internal parameters, e.g. the output file path.
   :return: The invocation line with replaced output parameter.

preprocessAndCheckCompatibleDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected boolean preprocessAndCheckCompatibleDataSetFormat() throws IOException, RegisterException, InterruptedException
   :outertype: ExecutionRunRunnable

   This method checks, whether the format of the data input is compatible to the input formats of the program configuration.

   :throws IOException:
   :throws InterruptedException:
   :throws RegisterException:
   :return: True, if compatible, false otherwise.

replaceDefaultParameters
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected String[] replaceDefaultParameters(String[] invocation, Map<String, String> effectiveParams) throws MissingParameterValueException, InternalAttributeException
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters()`\ .

   All remaining parameters in the invocation line, that are not set to an actual value in the run configuration will be set to the default values of the corresponding parameters defined in the program configuration. Throw an exception if no value is set for a certain parameter-string.

   :param invocation:
   :throws MissingParameterValueException:
   :throws InternalAttributeException:
   :return: The invocation line with all parameters replaced.

replaceRunParameters
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected String[] replaceRunParameters(String[] invocation, Map<String, String> effectiveParams) throws InternalAttributeException, RegisterException, NoParameterSetFoundException
   :outertype: ExecutionRunRunnable

   Helper method for \ :java:ref:`parseInvocationLineAndEffectiveParameters()`\ .

   Non-internal parameters are replaced, that means parameters, that are defined in the configuration files of the run or program in \ :java:ref:`replaceRunParameters(String)`\ .

   :param invocation:
   :throws NoParameterSetFoundException: This exception is thrown, if no parameter set was found that was not already evaluated before.
   :throws InternalAttributeException:
   :throws RegisterException:
   :return: The invocation line with replaced run parameters.

setInternalAttributes
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void setInternalAttributes() throws IllegalArgumentException
   :outertype: ExecutionRunRunnable

   Set the internal attributes of the framework, e.g. the meanSimilarity attribute which holds the mean similarity of the input dataset. These internal attributes are then used later on, to replace parameter placeholders in the invocation line in \ :java:ref:`parseInvocationLineAndEffectiveParameters()`\ .

   This method is invoked in \ :java:ref:`beforeRun()`\ , thus is only evaluated once.

   The dataset in standard format is assumed to be loaded before this method is invoked and to be unloaded after return of this method.

   :throws IllegalArgumentException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws InvalidDataSetFormatVersionException:

writeHeaderIntoCompleteFile
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void writeHeaderIntoCompleteFile(String completeQualityOutput)
   :outertype: ExecutionRunRunnable

   A helper method to write a header into the complete quality output in the beginning.

   If at all, then this method is invoked by \ :java:ref:`beginRun()`\  before anything has been executed by the runnable.

writeQualitiesToFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void writeQualitiesToFile(List<Triple<ParameterSet, ClusteringQualitySet, Long>> qualities)
   :outertype: ExecutionRunRunnable

   Helper method of \ :java:ref:`assessQualities(ClusteringRunResult)`\ , invoked to write the assessed clustering qualities into files.

   :param qualities: A list containing pairs of parameter sets and corresponding clustering qualities of different measures.

