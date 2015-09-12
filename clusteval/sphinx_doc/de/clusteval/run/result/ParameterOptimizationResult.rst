.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

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

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: file FileUtils

ParameterOptimizationResult
===========================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class ParameterOptimizationResult extends ExecutionRunResult implements Iterable<Pair<ParameterSet, ClusteringQualitySet>>

   A wrapper class for parameter optimization runresults produced by parameter optimization runs.

   :author: Christian Wiwie

Fields
------
iterationNumbers
^^^^^^^^^^^^^^^^

.. java:field:: protected List<Long> iterationNumbers
   :outertype: ParameterOptimizationResult

method
^^^^^^

.. java:field:: protected ParameterOptimizationMethod method
   :outertype: ParameterOptimizationResult

optimalClustering
^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<ClusteringQualityMeasure, Clustering> optimalClustering
   :outertype: ParameterOptimizationResult

optimalCriterionValue
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ClusteringQualitySet optimalCriterionValue
   :outertype: ParameterOptimizationResult

optimalParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<ClusteringQualityMeasure, ParameterSet> optimalParameterSet
   :outertype: ParameterOptimizationResult

parameterSetToClustering
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<ParameterSet, Clustering> parameterSetToClustering
   :outertype: ParameterOptimizationResult

parameterSetToIterationNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<ParameterSet, Long> parameterSetToIterationNumber
   :outertype: ParameterOptimizationResult

parameterSetToQualities
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<ParameterSet, ClusteringQualitySet> parameterSetToQualities
   :outertype: ParameterOptimizationResult

parameterSets
^^^^^^^^^^^^^

.. java:field:: protected List<ParameterSet> parameterSets
   :outertype: ParameterOptimizationResult

parseClusterings
^^^^^^^^^^^^^^^^

.. java:field:: protected boolean parseClusterings
   :outertype: ParameterOptimizationResult

Constructors
------------
ParameterOptimizationResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationResult(Repository repository, long changeDate, File absPath, String runIdentString, Run run, ParameterOptimizationMethod method) throws RegisterException
   :outertype: ParameterOptimizationResult

   By default we do not parse clusterings.

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :param method:
   :throws RegisterException:

ParameterOptimizationResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationResult(Repository repository, boolean register, long changeDate, File absPath, String runIdentString, Run run, ParameterOptimizationMethod method, boolean parseClusterings, boolean storeClusterings) throws RegisterException
   :outertype: ParameterOptimizationResult

   Use this constructor if you want to parse clusterings as well. They will be stored in a map from parameter sets to the clusterings.

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :param method:
   :param parseClusterings: Whether to parse the clusterings from the file system.
   :param storeClusterings: Whether to store parsed clusterings in RAM.
   :throws RegisterException:

ParameterOptimizationResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationResult(ParameterOptimizationResult other) throws RegisterException
   :outertype: ParameterOptimizationResult

   The copy constructor of run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public ParameterOptimizationResult clone()
   :outertype: ParameterOptimizationResult

get
^^^

.. java:method:: public ClusteringQualitySet get(ParameterSet paramSet)
   :outertype: ParameterOptimizationResult

   :param paramSet: The parameter set for which we want the resulting clustering quality set.
   :return: The clustering quality set resulting from the given parameter set.

getClustering
^^^^^^^^^^^^^

.. java:method:: public Clustering getClustering(ParameterSet paramSet)
   :outertype: ParameterOptimizationResult

   :param paramSet: The parameter set for which we want to know the resulting clustering.
   :return: The clustering resulting from the given parameter set.

getIterationNumberForParameterSet
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public long getIterationNumberForParameterSet(ParameterSet parameterSet)
   :outertype: ParameterOptimizationResult

getIterationNumbers
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Long> getIterationNumbers()
   :outertype: ParameterOptimizationResult

   :return: A list with all evaluated parameter sets of this optimization process.

getMethod
^^^^^^^^^

.. java:method:: public ParameterOptimizationMethod getMethod()
   :outertype: ParameterOptimizationResult

   :return: The parameter optimization method which created this result.

getOptimalClustering
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Clustering getOptimalClustering()
   :outertype: ParameterOptimizationResult

   :return: The clustering corresponding to the highest achieved quality value for the optimization criterion (see \ :java:ref:`getOptimalCriterionValue()`\ ).

getOptimalClusterings
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<ClusteringQualityMeasure, Clustering> getOptimalClusterings()
   :outertype: ParameterOptimizationResult

   :return: A map with all clustering quality measures together with the clusterings which achieved the highest quality values for each of those.

getOptimalCriterionValue
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ClusteringQualitySet getOptimalCriterionValue()
   :outertype: ParameterOptimizationResult

   :return: The optimal quality value achieved for the optimization criterion.

getOptimalParameterSet
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ParameterSet getOptimalParameterSet()
   :outertype: ParameterOptimizationResult

   :return: The parameter set which lead to the highest clustering quality of the optimization criterion.

getOptimalParameterSets
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<ClusteringQualityMeasure, ParameterSet> getOptimalParameterSets()
   :outertype: ParameterOptimizationResult

   :return: A map with the optimal parameter sets for every clustering quality measure.

getOptimizationClusterings
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Pair<ParameterSet, Clustering>> getOptimizationClusterings()
   :outertype: ParameterOptimizationResult

   :return: A list of pairs containing all parameter sets evaluated during the optimization process together with the optimal resulting clusterings.

getOptimizationQualities
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Pair<ParameterSet, ClusteringQualitySet>> getOptimizationQualities()
   :outertype: ParameterOptimizationResult

   :return: A list of pairs containing all parameter sets evaluated during the optimization process together with the optimal resulting quality sets.

getParameterSets
^^^^^^^^^^^^^^^^

.. java:method:: public List<ParameterSet> getParameterSets()
   :outertype: ParameterOptimizationResult

   :return: A list with all evaluated parameter sets of this optimization process.

getRun
^^^^^^

.. java:method:: @Override public ParameterOptimizationRun getRun()
   :outertype: ParameterOptimizationResult

iterator
^^^^^^^^

.. java:method:: @Override public Iterator<Pair<ParameterSet, ClusteringQualitySet>> iterator()
   :outertype: ParameterOptimizationResult

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public void loadIntoMemory() throws RunResultParseException
   :outertype: ParameterOptimizationResult

parseFromRunResultCompleteFile
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static ParameterOptimizationResult parseFromRunResultCompleteFile(Repository repository, ParameterOptimizationRun run, ParameterOptimizationMethod method, File completeFile, boolean parseClusterings, boolean storeClusterings, boolean register) throws RegisterException, RunResultParseException
   :outertype: ParameterOptimizationResult

   :param repository:
   :param run:
   :param method:
   :param completeFile:
   :param parseClusterings:
   :param storeClusterings:
   :param register: A boolean indicating whether to register the parsed runresult.
   :throws RunResultParseException:
   :throws RegisterException:
   :return: The parameter optimization run result parsed from the given runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Run parseFromRunResultFolder(Repository parentRepository, File runResultFolder, List<ParameterOptimizationResult> result, boolean parseClusterings, boolean storeClusterings, boolean register) throws IOException, UnknownRunResultFormatException, UnknownDataSetFormatException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, UnknownGoldStandardFormatException, InvalidConfigurationFileException, RepositoryAlreadyExistsException, InvalidRepositoryException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, RepositoryConfigNotFoundException, RepositoryConfigurationException, ConfigurationException, RegisterException, UnknownDataSetTypeException, NumberFormatException, NoDataSetException, UnknownRunDataStatisticException, RunResultParseException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, UnknownContextException, IncompatibleContextException, UnknownParameterType, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: ParameterOptimizationResult

   :param parentRepository:
   :param runResultFolder:
   :param result:
   :param parseClusterings:
   :param storeClusterings:
   :param register: A boolean indicating whether to register the parsed runresult.
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
   :return: The parameter optimization run result parsed from the given runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Run parseFromRunResultFolder(ParameterOptimizationRun run, Repository repository, File runResultFolder, List<RunResult> result, boolean parseClusterings, boolean storeClusterings, boolean register) throws RegisterException, RunResultParseException
   :outertype: ParameterOptimizationResult

   :param run: The run corresponding to the runresult folder.
   :param repository: The repository in which we want to register the runresult.
   :param runResultFolder: A file object referencing the runresult folder.
   :param result: The list of runresults this method fills.
   :param parseClusterings: Whether to parse clusterings.
   :param storeClusterings: Whether to store clusterings, if they are parsed.
   :param register: A boolean indicating whether to register the parsed runresult.
   :throws RunResultParseException:
   :throws RegisterException:
   :return: The parameter optimization run parsed from the runresult folder.

put
^^^

.. java:method:: public ClusteringQualitySet put(long iterationNumber, ParameterSet last, ClusteringQualitySet qualities, Clustering clustering)
   :outertype: ParameterOptimizationResult

   This method adds the given qualities for the given parameter set and resulting clustering.

   :param iterationNumber: The number of the iteration.
   :param last: The parameter set for which we want to add clustering qualities.
   :param qualities: The qualities which we want to add for the parameter set.
   :param clustering: The clustering resulting the given parameter set.
   :return: The old value, if this operation replaced an old mapping,

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ParameterOptimizationResult

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void unloadFromMemory()
   :outertype: ParameterOptimizationResult

   This method clears all internal attributes that do not store the optimal results (those might be needed afterwards). This includes \ :java:ref:`parameterSets`\ , \ :java:ref:`parameterSetToClustering`\  and \ :java:ref:`parameterSetToQualities`\ .

