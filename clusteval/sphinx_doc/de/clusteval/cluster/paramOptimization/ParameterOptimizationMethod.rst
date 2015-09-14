.. java:import:: java.io File

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map.Entry

.. java:import:: java.util SortedMap

.. java:import:: java.util TreeMap

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result ClusteringRunResult

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.run.runnable ExecutionRunRunnable

.. java:import:: de.clusteval.utils InternalAttributeException

ParameterOptimizationMethod
===========================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public abstract class ParameterOptimizationMethod extends RepositoryObject

   A parameter optimization method determines how a parameter optimization run is executed.

   One parameter optimization method is created for every pair of program and data configuration of the run in \ :java:ref:`Parser.parseFromFile(File)`\ , that means for every run runnable one method. The method objects are instantiated as soon as the run is parsed from the filesystem. That means, when the same run is executed several times, the same method object is used.

   The method determines the following aspects:

   ..

   * \ **the number of iterations of the optimization process**\
   * \ **the parameter sets evaluated**\
   * \ **the handling of diverging iterations**\
   * \ **the storage of the iteration results**\

   \ **Basic Usage**\

   The basic usage of this class is as follows:

   ..

   * Instantiate an object of the parameter optimization method
   * Invoke \ :java:ref:`reset(File)`\  and tell the method to initialize itself. Results will be written to the passed file.
   * As long as \ :java:ref:`hasNext()`\  returns true, there are more iterations to evaluate
   * Use \ :java:ref:`next()`\  to get the next parameter set.
   * Pass the assessed qualities of \ :java:ref:`ExecutionRunRunnable.assessQualities(ClusteringRunResult)`\  to \ :java:ref:`giveQualityFeedback(ClusteringQualitySet)`\ .
   * At the end use \ :java:ref:`getResult()`\  to get the results of the iterations

   \ **Writing Custom Parameter Optimization Methods**\

   A parameter optimization method MyParameterOptimizationMethod can be added to ClustEval by

   1. extending this class with your own class MyParameterOptimizationMethod . You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your parameter optimization method.

     * :java:ref:`ParameterOptimizationMethod(Repository, boolean, long, File, ParameterOptimizationRun, ProgramConfig, DataConfig, List, ClusteringQualityMeasure, int[], boolean)`: The constructor for your parameter optimization method. This constructor has to be implemented and public, otherwise the framework will not be able to load your parameter optimization method.
     * :java:ref:`ParameterOptimizationMethod(ParameterOptimizationMethod)`: The copy constructor for your parameter optimization method. This constructor has to be implemented and public, otherwise the framework will not be able to load your parameter optimization method.
     * :java:ref:`getCompatibleDataSetFormatBaseClasses()` : A list of dataset formats, this parameter optimization method can be used for. If the list is empty, all dataset formats are assumed to be compatible.
     * :java:ref:`getCompatibleProgramNames()` : A list of names of all programs that are compatible to this parameter optimization method. If the list is empty, all programs are assumed to be compatible.
     * :java:ref:`hasNext()` : This method indicates, whether their is another parameter set to evaluate. This method must not change the current parameter set, as it may be invoked several times before next() is invoked.
     * :java:ref:`getNextParameterSet(ParameterSet)` : Returns the next parameter set to evaluate. This method may change the internal status of the parameter optimization method, in that it stores the newly determined and returned parameter set as the current parameter set.
     * :java:ref:`getTotalIterationCount()` : This is the total iteration count this parameter optimization method will perform. The returned value might not correspond to the expected value, when the method is instantiated. Therefore always use the return value of this method, when trying to determine the finished percentage of the parameter optimization process.

   2. Creating a jar file named MyParameterOptimizationMethod.jar containing the MyParameterOptimizationMethod.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/cluster/paramOptimization/MyParameterOptimizationMethod.class

   3. Putting the MyParameterOptimizationMethod.jar into the parameter optimization methods folder of the repository:

     * <REPOSITORY ROOT>/supp/clustering/paramOptimization
     * The backend server will recognize and try to load the new parameter optimization method automatically the next time, the ParameterOptimizationMethodFinderThread checks the filesystem.

   :author: Christian Wiwie

Fields
------
currentCount
^^^^^^^^^^^^

.. java:field:: protected int currentCount
   :outertype: ParameterOptimizationMethod

   The number of iterations that has been performed so far.

dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: ParameterOptimizationMethod

   The data configuration this method was created for.

finishedCount
^^^^^^^^^^^^^

.. java:field:: protected int finishedCount
   :outertype: ParameterOptimizationMethod

   The number of iterations for which qualities have been returned.

isResume
^^^^^^^^

.. java:field:: protected boolean isResume
   :outertype: ParameterOptimizationMethod

   This boolean indicates, whether the run is a resumption of a previous run execution or a completely new execution.

optimizationCriterion
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ClusteringQualityMeasure optimizationCriterion
   :outertype: ParameterOptimizationMethod

   During a parameter optimization run for each calcuated clustering several quality measures are assessed. One of these quality measures is used, to rate the clusterings and to decide, which clusterings performed best. This quality measure is called the optimization criterion and is stored in this attribute.

params
^^^^^^

.. java:field:: protected List<ProgramParameter<?>> params
   :outertype: ParameterOptimizationMethod

   The parameters of the program encapsulated by the program configuration that are to be optimized.

programConfig
^^^^^^^^^^^^^

.. java:field:: protected ProgramConfig programConfig
   :outertype: ParameterOptimizationMethod

   The program configuration this method was created for.

run
^^^

.. java:field:: protected ParameterOptimizationRun run
   :outertype: ParameterOptimizationMethod

   The run this method belongs to.

totalIterationCount
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int totalIterationCount
   :outertype: ParameterOptimizationMethod

   This array holds the number of iterations that should be performed for each optimization parameter.

   However, this might not be exactly the number that is performed by the method and these numbers might be readjusted by the method after the constructor call. This is due to the fact, that every method handles the distribution of the iterations itself.

   The ordering of this list is assumed to be the same as the ordering of \ :java:ref:`params`\ .

Constructors
------------
ParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationMethod(Repository repository, boolean register, long changeDate, File absPath, ParameterOptimizationRun run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int totalIterationCount, boolean isResume) throws RegisterException
   :outertype: ParameterOptimizationMethod

   :param repository: The repository this object is registered in.
   :param register: Whether this object should be registered implicitely in the repository or if the user wants to register manually later.
   :param changeDate: The changedate of this object can be used for identification and equality checks of objects.
   :param absPath: The absolute path of this object is used for identification and equality checks of objects.
   :param run: The run this method belongs to.
   :param programConfig: The program configuration this method was created for.
   :param dataConfig: The data configuration this method was created for.
   :param params: This list holds the program parameters that are to be optimized by the parameter optimization run.
   :param optimizationCriterion: The quality measure used as the optimization criterion (see \ :java:ref:`optimizationCriterion`\ ).
   :param totalIterationCount: The total number of iterations to be performed by this parameter optimization.
   :param isResume: This boolean indiciates, whether the run is a resumption of a previous run execution or a completely new execution.
   :throws RegisterException:

ParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationMethod(ParameterOptimizationMethod method) throws RegisterException
   :outertype: ParameterOptimizationMethod

   The copy constructor of parameter optimization methods

   :param method: The method to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public ParameterOptimizationMethod clone()
   :outertype: ParameterOptimizationMethod

cloneOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<ParameterOptimizationMethod> cloneOptimizationMethods(List<ParameterOptimizationMethod> optimizationMethods)
   :outertype: ParameterOptimizationMethod

   A helper method for cloning a list of optimization methods.

   :param optimizationMethods: The optimization methods to clone.
   :return: The list of cloned optimization methods.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: ParameterOptimizationMethod

getCompatibleDataSetFormatBaseClasses
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract List<Class<? extends DataSetFormat>> getCompatibleDataSetFormatBaseClasses()
   :outertype: ParameterOptimizationMethod

   This method returns a list with the classes of all dataset formats this parameter optimization method supports. If the list is empty, all dataset formats are assumed to be compatible.

   Some methods only support certain input formats. If this is the case for your method, override this method and return the compatible formats.

   This compatibility is checked as soon as a parameter optimization run is parsed in \ :java:ref:`ParameterOptimizationRun.checkCompatibilityParameterOptimizationMethod`\ .

   :return: A list with all dataset format classes that are compatible to this parameter optimization method.

getCompatibleProgramNames
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract List<String> getCompatibleProgramNames()
   :outertype: ParameterOptimizationMethod

   This method returns a list with all programs this parameter optimization method supports. If the list is empty, all programs are assumed to be compatible.

   Some methods only support certain programs. If this is the case for your method, override this method and return the compatible programs.

   This compatibility is checked as soon as a parameter optimization run is parsed in \ :java:ref:`ParameterOptimizationRun.checkCompatibilityParameterOptimizationMethod`\ .

   :return: A list with all programs that are compatible to this parameter optimization method.

getDataConfig
^^^^^^^^^^^^^

.. java:method:: public DataConfig getDataConfig()
   :outertype: ParameterOptimizationMethod

   :return: The data configuration this method was created for.

getFinishedCount
^^^^^^^^^^^^^^^^

.. java:method:: public int getFinishedCount()
   :outertype: ParameterOptimizationMethod

   :return: The number of finished iterations, for which we have received qualities.

getIterationPerParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getIterationPerParameter()
   :outertype: ParameterOptimizationMethod

   :return: An array holding the number of iterations that should be performed for each optimization parameter. Keep in mind the hints in \ :java:ref:`totalIterationCount`\ .

   **See also:** :java:ref:`.totalIterationCount`

getNextParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected ParameterSet getNextParameterSet() throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException, ParameterSetAlreadyEvaluatedException
   :outertype: ParameterOptimizationMethod

getNextParameterSet
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract ParameterSet getNextParameterSet(ParameterSet forcedParameterSet) throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException, ParameterSetAlreadyEvaluatedException
   :outertype: ParameterOptimizationMethod

   This method purely determines and calculates the next parameter set that follows from the current state of the method.

   If the force parameter set is given != null, this parameter set is forced to be evaluated. This scenario is used during resumption of an older run, where the parameter sets are already fixed and we want to feed them to this method together with their results exactly as they were performed last time.

   This is a helper-method for \ :java:ref:`next()`\  and \ :java:ref:`next(ParameterSet)`\ .

   It might happen that this method puts the calling thread to sleep, in case the next parameter set requires older parameter sets to finish first.

   It might happen that this method puts the calling thread to sleep, in case the next parameter set requires older parameter sets to finish first.

   :param forcedParameterSet: If this parameter is set != null, this parameter set is forced to be evaluated in the next iteration.
   :throws InterruptedException:
   :throws ParameterSetAlreadyEvaluatedException:
   :throws NoParameterSetFoundException: This exception is thrown, if no parameter set was found that was not already evaluated before.
   :throws InternalAttributeException:
   :throws RegisterException:
   :return: The next parameter set.

getOptimizationCriterion
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public final ClusteringQualityMeasure getOptimizationCriterion()
   :outertype: ParameterOptimizationMethod

   :return: The quality measure used as the optimization criterion (see \ :java:ref:`optimizationCriterion`\ ).

getOptimizationParameter
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ProgramParameter<?>> getOptimizationParameter()
   :outertype: ParameterOptimizationMethod

   :return: This list holds the program parameters that are to be optimized by the parameter optimization run.

getPlotDensityParameter
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ProgramParameter<?> getPlotDensityParameter()
   :outertype: ParameterOptimizationMethod

   By default, we take the first parameter as density parameter for plots

   :return: The optimization parameter, that should be used as the axis variable to plot the results.

getProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: public ProgramConfig getProgramConfig()
   :outertype: ParameterOptimizationMethod

   :return: The program configuration this method was created for.

getResult
^^^^^^^^^

.. java:method:: public ParameterOptimizationResult getResult()
   :outertype: ParameterOptimizationMethod

   This method returns the results of this parameter optimization run. Keep in mind, that this method returns an incomplete object, before the run is finished.

   :return: An wrapper object holding all the results that are calculated throughout execution of the parameter optimization run.

getStartedCount
^^^^^^^^^^^^^^^

.. java:method:: public int getStartedCount()
   :outertype: ParameterOptimizationMethod

   :return: The number of iterations that has been performed so far.

getTotalIterationCount
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract int getTotalIterationCount()
   :outertype: ParameterOptimizationMethod

   :return: The total iteration count this method should perform.

giveQualityFeedback
^^^^^^^^^^^^^^^^^^^

.. java:method:: public synchronized void giveQualityFeedback(ParameterSet parameterSet, ClusteringQualitySet qualities)
   :outertype: ParameterOptimizationMethod

   This method has to be invoked after every iteration and invocation of \ :java:ref:`next()`\ , to pass the qualities of the last clustering to this parameter optimization method.

   If this method is not invoked after \ :java:ref:`next()`\ , before \ :java:ref:`next()`\  is invoked again, an \ :java:ref:`IllegalStateException`\  will be thrown.

   :param qualities: The clustering qualities for the clustering of the last iteration.

hasNext
^^^^^^^

.. java:method:: public abstract boolean hasNext()
   :outertype: ParameterOptimizationMethod

   :return: True, if there are more iterations together with parameter sets that have to be evaluated.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: ParameterOptimizationMethod

initParameterValues
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected void initParameterValues() throws ParameterOptimizationException, InternalAttributeException
   :outertype: ParameterOptimizationMethod

   This method initializes the parameter values of each optimization parameter that should be assessed during the process.

   :throws InternalAttributeException:

next
^^^^

.. java:method:: public final ParameterSet next() throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException, ParameterSetAlreadyEvaluatedException
   :outertype: ParameterOptimizationMethod

   This method tells the method that the next parameter set should be determined and that the invoker wants to start the evaluation of the next iteration.

   This is a convenience method of \ :java:ref:`next(ParameterSet,long)`\ , without enforcement of a passed parameter set.

   It might happen that this method puts the calling thread to sleep, in case the next parameter set requires older parameter sets to finish first.

   :throws InterruptedException:
   :throws ParameterSetAlreadyEvaluatedException:
   :throws NoParameterSetFoundException: This exception is thrown, if no parameter set was found that was not already evaluated before.
   :throws InternalAttributeException:
   :throws RegisterException:
   :return: The parameter set that is being evaluated in the next iteration.

next
^^^^

.. java:method:: public final ParameterSet next(ParameterSet forcedParameterSet, long iterationNumber) throws InternalAttributeException, RegisterException, NoParameterSetFoundException, InterruptedException, ParameterSetAlreadyEvaluatedException
   :outertype: ParameterOptimizationMethod

   This method tells the method that the next parameter set should be determined and that the invoker wants to start the evaluation of the next iteration.

   If the force parameter set is given != null, this parameter set is forced to be evaluated. This scenario is used during resumption of an older run, where the parameter sets are already fixed and we want to feed them to this method together with their results exactly as they were performed last time.

   If this method is invoked twice, without \ :java:ref:`giveQualityFeedback(ClusteringQualitySet)`\  being invoked in between, a \ :java:ref:`IllegalStateException`\  is thrown.

   It might happen that this method puts the calling thread to sleep, in case the next parameter set requires older parameter sets to finish first.

   :param forcedParameterSet: If this parameter is set != null, this parameter set is forced to be evaluated in the next iteration.
   :param iterationNumber: The original number of the iteration when it was previously performed.
   :throws InterruptedException:
   :throws ParameterSetAlreadyEvaluatedException:
   :throws NoParameterSetFoundException: This exception is thrown, if no parameter set was found that was not already evaluated before.
   :throws InternalAttributeException:
   :throws RegisterException:
   :return: The parameter set that is being evaluated in the next iteration.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static ParameterOptimizationMethod parseFromString(Repository repository, String parameterOptimizationMethod, Run run, ProgramConfig programConfig, DataConfig dataConfig, List<ProgramParameter<?>> params, ClusteringQualityMeasure optimizationCriterion, int totalIterationCount, boolean isResume) throws UnknownParameterOptimizationMethodException
   :outertype: ParameterOptimizationMethod

   This method takes a string and some additional parameters and parses from it a parameter optimization method.

   :param repository: The repository in which the method should look up the parameter optimization method class and where the new object should be registered.
   :param parameterOptimizationMethod: The name of the parameter optimization method class.
   :param run: The run the new parameter optimization method belongs to.
   :param programConfig: The program configuration the new parameter optimization method belongs to.
   :param dataConfig: The data configuration the new parameter optimization method belongs to.
   :param params: The parameters of the program encapsulated by the program configuration that are to be optimized.
   :param optimizationCriterion: The quality measure used as the optimization criterion (see \ :java:ref:`optimizationCriterion`\ ).
   :param totalIterationCount: This array holds the number of iterations that are to be performed for each optimization parameter.
   :param isResume: This boolean indiciates, whether the run is a resumption of a previous run execution or a completely new execution.
   :throws UnknownParameterOptimizationMethodException:
   :return: The parsed parameter optimization method.

reset
^^^^^

.. java:method:: public void reset(File absResultPath) throws ParameterOptimizationException, InternalAttributeException, RegisterException, RunResultParseException, InterruptedException
   :outertype: ParameterOptimizationMethod

   This method initializes this method by setting the parameter values to be evaluated during the process (\ :java:ref:`initParameterValues()`\ ) and by creating a wrapper object for the \ :java:ref:`result`\ .

   Furthermore if the run is a resumption of an old run execution, this method also reperforms all iterations that have been executed during the last execution of the run.

   This method has to be invoked before anything else is done ( \ :java:ref:`hasNext()`\  or \ :java:ref:`next()`\ ).

   :param absResultPath: The absolute path pointing to the result file.
   :throws RunResultParseException:
   :throws InterruptedException:
   :throws InternalAttributeException:
   :throws RegisterException:

setDataConfig
^^^^^^^^^^^^^

.. java:method:: public void setDataConfig(DataConfig dataConfig)
   :outertype: ParameterOptimizationMethod

   This method is used to set the data configuration of this run to another object. This is needed for example after cloning and conversion of the old data configuration during the run process.

   :param dataConfig: The new data configuration of this run.

setProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: public void setProgramConfig(ProgramConfig programConfig)
   :outertype: ParameterOptimizationMethod

   This method is used to set the program configuration of this run to another object. This is needed for example after cloning and conversion of the old program configuration during the run process.

   :param programConfig: The new program configuration of this run.

setResume
^^^^^^^^^

.. java:method:: public void setResume(boolean isResume)
   :outertype: ParameterOptimizationMethod

   :param isResume: A boolean indicating, whether the run is a resumption of a previous run execution or a completely new execution.

setRun
^^^^^^

.. java:method:: public void setRun(ParameterOptimizationRun run)
   :outertype: ParameterOptimizationMethod

   :param run: The new run of this method.

