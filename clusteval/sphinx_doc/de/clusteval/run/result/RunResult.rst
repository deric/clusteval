.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util List

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.randomizer UnknownDataRandomizerException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.db DatabaseConnectException

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run ClusteringRun

.. java:import:: de.clusteval.run DataAnalysisRun

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.run RunDataAnalysisRun

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: file FileUtils

RunResult
=========

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public abstract class RunResult extends RepositoryObject

   A wrapper class for runresults produced by runs of the framework.

   :author: Christian Wiwie

Fields
------
changedSinceLastRegister
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected boolean changedSinceLastRegister
   :outertype: RunResult

run
^^^

.. java:field:: protected Run run
   :outertype: RunResult

runIdentString
^^^^^^^^^^^^^^

.. java:field:: protected String runIdentString
   :outertype: RunResult

   The run ident string.

Constructors
------------
RunResult
^^^^^^^^^

.. java:constructor:: public RunResult(Repository repository, long changeDate, File absPath, String runIdentString, Run run) throws RegisterException
   :outertype: RunResult

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :throws RegisterException:

RunResult
^^^^^^^^^

.. java:constructor:: public RunResult(RunResult other) throws RegisterException
   :outertype: RunResult

   The copy constructor of run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract RunResult clone()
   :outertype: RunResult

getIdentifier
^^^^^^^^^^^^^

.. java:method:: public String getIdentifier()
   :outertype: RunResult

   :return: The unique identifier of this runresult, equal to the name of the runresult folder.

getRun
^^^^^^

.. java:method:: public Run getRun()
   :outertype: RunResult

   :return: The run this runresult belongs to.

hasChangedSinceLastRegister
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean hasChangedSinceLastRegister()
   :outertype: RunResult

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: public abstract void loadIntoMemory() throws RunResultParseException
   :outertype: RunResult

   This method loads the contents of this run result into the memory by parsing the files on the filesystem.

   The run result might consume a lot of memory afterwards. Only invoke this method, if you really need access to the run results contents and afterwards free the contents by invoking \ :java:ref:`unloadFromMemory()`\ .

   :throws RunResultParseException:

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Run parseFromRunResultFolder(Repository parentRepository, File runResultFolder, List<RunResult> result, boolean parseClusterings, boolean storeClusterings, boolean register) throws IOException, UnknownRunResultFormatException, UnknownDataSetFormatException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, UnknownGoldStandardFormatException, InvalidConfigurationFileException, RepositoryAlreadyExistsException, InvalidRepositoryException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, RepositoryConfigNotFoundException, RepositoryConfigurationException, ConfigurationException, RegisterException, UnknownDataSetTypeException, NumberFormatException, NoDataSetException, UnknownRunDataStatisticException, RunResultParseException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, UnknownContextException, IncompatibleContextException, UnknownParameterType, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: RunResult

   :param parentRepository:
   :param runResultFolder:
   :param result:
   :param parseClusterings:
   :param storeClusterings:
   :throws UnknownDataStatisticException:
   :throws UnknownGoldStandardFormatException:
   :throws UnknownRunStatisticException:
   :throws DataSetConfigurationException:
   :throws RepositoryConfigurationException:
   :throws InterruptedException:
   :throws UnknownParameterType:
   :throws UnknownContextException:
   :throws UnknownRProgramException:
   :throws UnknownRunResultPostprocessorException:
   :throws RegisterException:
   :throws UnknownDistanceMeasureException:
   :throws IncompatibleParameterOptimizationMethodException:
   :throws UnknownProgramParameterException:
   :throws UnknownRunDataStatisticException:
   :throws UnknownDataPreprocessorException:
   :throws NoOptimizableProgramParameterException:
   :throws InvalidRepositoryException:
   :throws UnknownDataSetFormatException:
   :throws UnknownDataRandomizerException:
   :throws NumberFormatException:
   :throws DataConfigNotFoundException:
   :throws IncompatibleDataSetConfigPreprocessorException:
   :throws DataSetNotFoundException:
   :throws ConfigurationException:
   :throws GoldStandardConfigNotFoundException:
   :throws NoRepositoryFoundException:
   :throws UnknownParameterOptimizationMethodException:
   :throws UnknownDataSetTypeException:
   :throws RepositoryAlreadyExistsException:
   :throws InvalidOptimizationParameterException:
   :throws RunResultParseException:
   :throws IOException:
   :throws IncompatibleContextException:
   :throws UnknownRunResultFormatException:
   :throws UnknownClusteringQualityMeasureException:
   :throws UnknownProgramTypeException:
   :throws DataConfigurationException:
   :throws InvalidRunModeException:
   :throws GoldStandardConfigurationException:
   :throws RepositoryConfigNotFoundException:
   :throws NoDataSetException:
   :throws InvalidConfigurationFileException:
   :throws DataSetConfigNotFoundException:
   :throws RunException:
   :throws GoldStandardNotFoundException:
   :return: A runresult object for the given runresult folder.

register
^^^^^^^^

.. java:method:: @Override public boolean register() throws RegisterException
   :outertype: RunResult

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: public abstract void unloadFromMemory()
   :outertype: RunResult

   This method unloads the contents of this run result from the memory and releases the reserved memory. This can be helpful especially for large parameter optimization run results.

