.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run.result.format RunResultFormat

ProgramConfig
=============

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class ProgramConfig extends RepositoryObject

   A program configuration encapsulates a program together with options and settings.

   A program configuration corresponds to and is parsed from a file on the filesystem in the corresponding folder of the repository (see \ :java:ref:`Repository.programConfigBasePath`\  and \ :java:ref:`ProgramConfigFinder`\ ).

   There are several options, that can be specified in the program configuration file (see \ :java:ref:`parseFromFile(File)`\ ).

   :author: Christian Wiwie

Fields
------
compatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<DataSetFormat> compatibleDataSetFormats
   :outertype: ProgramConfig

   This list holds all dataset formats that are compatible with the encapsulated program, i.e. input formats this program is able to read.

expectsNormalizedDataSet
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected boolean expectsNormalizedDataSet
   :outertype: ProgramConfig

   This boolean indicates, whether the encapsulated program requires a normalized dataset, i.e. similarities between 0 and 1. This is then handled before the data is passed to the clustering method.

invocationFormat
^^^^^^^^^^^^^^^^

.. java:field:: protected String invocationFormat
   :outertype: ProgramConfig

   This is the default invocation line used to invoke the program, when this program configuration is used together with some data configuration.

   This invocation line is used, if

   ..

   * there is a goldstandard in the data configuration
   * the run is not of type parameter optimization

invocationFormatParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String invocationFormatParameterOptimization
   :outertype: ProgramConfig

   This invocation line is used, if

   ..

   * there is a goldstandard in the data configuration
   * and the run is of type parameter optimization

invocationFormatParameterOptimizationWithoutGoldStandard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String invocationFormatParameterOptimizationWithoutGoldStandard
   :outertype: ProgramConfig

   This invocation line is used, if

   ..

   * there is no goldstandard in the data configuration
   * and the run is of type parameter optimization

invocationFormatWithoutGoldStandard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String invocationFormatWithoutGoldStandard
   :outertype: ProgramConfig

   This invocation line is used, if

   ..

   * there is no goldstandard in the data configuration
   * and the run is not of type parameter optimization

maxExecutionTimeMinutes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int maxExecutionTimeMinutes
   :outertype: ProgramConfig

   The maximal time this program config should be executed. The execution is terminated when this time is reached.

optimizableParameters
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<ProgramParameter<?>> optimizableParameters
   :outertype: ProgramConfig

   A list holding all optimizable parameter of the program. Optimizable parameters are those parameters, that can in principle be optimized in parameter optimization runs (see \ :java:ref:`ParameterOptimizationRun`\ ).

outputFormat
^^^^^^^^^^^^

.. java:field:: protected RunResultFormat outputFormat
   :outertype: ProgramConfig

   The output format of the program

params
^^^^^^

.. java:field:: protected List<ProgramParameter<?>> params
   :outertype: ProgramConfig

   A list holding all parameters of the program.

program
^^^^^^^

.. java:field:: protected Program program
   :outertype: ProgramConfig

   The program this configuration belongs to.

Constructors
------------
ProgramConfig
^^^^^^^^^^^^^

.. java:constructor:: public ProgramConfig(Repository repository, boolean register, long changeDate, File absPath, Program program, RunResultFormat outputFormat, List<DataSetFormat> compatibleDataSetFormats, String invocationFormat, String invocationFormatWithoutGoldStandard, String invocationFormatParameterOptimization, String invocationFormatParameterOptimizationWithoutGoldStandard, List<ProgramParameter<?>> params, List<ProgramParameter<?>> optimizableParameters, boolean expectsNormalizedDataSet, int maxExecutionTimeMinutes) throws RegisterException
   :outertype: ProgramConfig

   Instantiates a new program config.

   :param repository: The repository this program configuration should be registered at.
   :param register: A boolean indicating whether to register this program configuration at the repository.
   :param changeDate: The change date of this program configuration is used for equality checks.
   :param absPath: The absolute path of this program configuration.
   :param program: The program this program configuration belongs to.
   :param outputFormat: The output format of the program.
   :param compatibleDataSetFormats: A list of compatible dataset formats of the encapsulated program.
   :param invocationFormat: The invocation line for runs with goldstandard and without parameter optimization
   :param invocationFormatWithoutGoldStandard: The invocation line for runs without goldstandard and without parameter optimization
   :param invocationFormatParameterOptimization: The invocation line for runs with goldstandard and with parameter optimization
   :param invocationFormatParameterOptimizationWithoutGoldStandard: The invocation line for runs without goldstandard and with parameter optimization
   :param params: The parameters of the program.
   :param optimizableParameters: The parameters of the program, that can be optimized.
   :param expectsNormalizedDataSet: Whether the encapsulated program requires normalized input.
   :throws RegisterException:

ProgramConfig
^^^^^^^^^^^^^

.. java:constructor:: public ProgramConfig(ProgramConfig programConfig) throws RegisterException
   :outertype: ProgramConfig

   The copy constructor of program configurations.

   :param programConfig: The program configuration to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public ProgramConfig clone()
   :outertype: ProgramConfig

cloneProgramConfigurations
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<ProgramConfig> cloneProgramConfigurations(List<ProgramConfig> programConfigs)
   :outertype: ProgramConfig

   A helper method for cloning a list of program configurations.

   :param programConfigs: The list of program configurations to clone.
   :return: The list containing the cloned program configurations of the input list.

expectsNormalizedDataSet
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean expectsNormalizedDataSet()
   :outertype: ProgramConfig

   :return: True, if the encapsulated program requires normalized input data, false otherwise.

   **See also:** :java:ref:`.expectsNormalizedDataSet`

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<DataSetFormat> getCompatibleDataSetFormats()
   :outertype: ProgramConfig

   :return: The compatible dataset input formats of the encapsulated program.

   **See also:** :java:ref:`.compatibleDataSetFormats`

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInvocationFormat(boolean withoutGoldStandard)
   :outertype: ProgramConfig

   This method returns the invocation line format for non parameter-optimization runs.

   :param withoutGoldStandard: This boolean indicates, whether this method returns the invocation format for the case with- or without goldstandard.
   :return: The invocation line format

getInvocationFormatParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInvocationFormatParameterOptimization(boolean withoutGoldStandard)
   :outertype: ProgramConfig

   This method returns the invocation line format for parameter-optimization runs.

   :param withoutGoldStandard: This boolean indicates, whether this method returns the invocation format for the case with- or without goldstandard.
   :return: The invocation line format

getMaxExecutionTimeMinutes
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getMaxExecutionTimeMinutes()
   :outertype: ProgramConfig

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: ProgramConfig

   :return: The name of the program configuration is the name of the file without extension.

getOptimizableParams
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ProgramParameter<?>> getOptimizableParams()
   :outertype: ProgramConfig

   :return: The list of optimizable parameters of the encapsulated program.

   **See also:** :java:ref:`.optimizableParameters`

getOutputFormat
^^^^^^^^^^^^^^^

.. java:method:: public RunResultFormat getOutputFormat()
   :outertype: ProgramConfig

   :return: The output format of the encapsulated program.

   **See also:** :java:ref:`.outputFormat`

getParamWithId
^^^^^^^^^^^^^^

.. java:method:: public ProgramParameter<?> getParamWithId(String id) throws UnknownProgramParameterException
   :outertype: ProgramConfig

   This method returns the program parameter with the given id and throws an exception, of none such parameter exists.

   :param id: The name the parameter should have.
   :throws UnknownProgramParameterException:
   :return: The program parameter with the appropriate name

getParameterForName
^^^^^^^^^^^^^^^^^^^

.. java:method:: public ProgramParameter<?> getParameterForName(String name)
   :outertype: ProgramConfig

   TODO: merge this and \ :java:ref:`getParamWithId(String)`\

   :param name: the name
   :return: the parameter for name

getParams
^^^^^^^^^

.. java:method:: public List<ProgramParameter<?>> getParams()
   :outertype: ProgramConfig

   :return: The list of parameters of the encapsulated program.

   **See also:** :java:ref:`.params`

getProgram
^^^^^^^^^^

.. java:method:: public Program getProgram()
   :outertype: ProgramConfig

   :return: The encapsulated program.

   **See also:** :java:ref:`.program`

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: ProgramConfig

setMaxExecutionTimeMinutes
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxExecutionTimeMinutes(int maxExecutionTimeMinutes)
   :outertype: ProgramConfig

supportsInternalParameterOptimization
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean supportsInternalParameterOptimization()
   :outertype: ProgramConfig

   Internal Parameter Optimization is an alternative for parameter optimization, in that the program handles the parameter optimization itself. In this case, the framework invokes the program only once.

   :return: True, if the encapsulated program supports internal parameter optimization, false otherwise.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ProgramConfig

