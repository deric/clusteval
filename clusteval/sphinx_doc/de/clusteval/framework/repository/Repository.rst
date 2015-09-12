.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Collection

.. java:import:: java.util Collections

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: java.util.concurrent ConcurrentHashMap

.. java:import:: java.util.regex Pattern

.. java:import:: javax.script ScriptEngine

.. java:import:: javax.script ScriptEngineManager

.. java:import:: javax.script ScriptException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatParser

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.generator DataSetGenerator

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard.format GoldStandardFormat

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.data.randomizer DataRandomizer

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticCalculator

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository.config DefaultRepositoryConfig

.. java:import:: de.clusteval.framework.repository.config RepositoryConfig

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.db DefaultSQLCommunicator

.. java:import:: de.clusteval.framework.repository.db RunResultSQLCommunicator

.. java:import:: de.clusteval.framework.repository.db SQLCommunicator

.. java:import:: de.clusteval.framework.repository.db StubSQLCommunicator

.. java:import:: de.clusteval.framework.threading RepositorySupervisorThread

.. java:import:: de.clusteval.framework.threading RunResultRepositorySupervisorThread

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.program DoubleProgramParameter

.. java:import:: de.clusteval.program IntegerProgramParameter

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.program StringProgramParameter

.. java:import:: de.clusteval.program.r RProgram

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format RunResultFormatParser

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunDataStatisticCalculator

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics RunStatisticCalculator

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils InternalAttributeException

.. java:import:: de.clusteval.utils NamedDoubleAttribute

.. java:import:: de.clusteval.utils NamedIntegerAttribute

.. java:import:: de.clusteval.utils NamedStringAttribute

.. java:import:: file FileUtils

Repository
==========

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class Repository

   The repository is the central object of the backend, where objects are registered and centrally controlled. Objects can be registered and unregistered and get certain functions for free. For example duplication recognition, automatic detection of changes of objects and informing other objects (as listeners) about changes of other objects.

   General hint: This class contains a lot of hashmaps for performance reasons. All the hashmaps of this class are updated with current objects. The maps then contain old key objects and current value objects. Therefore you should never iterate over the result of keySet() of the maps, but instead use values().

   :author: Christian Wiwie

Fields
------
analysisResultsBasePath
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String analysisResultsBasePath
   :outertype: Repository

   The absolute path to the directory, where for a certain runresult (identified by its unique run identifier) all analysis results are stored.

basePath
^^^^^^^^

.. java:field:: protected String basePath
   :outertype: Repository

   The absolute path of the root of this repository.

dynamicRepositoryEntities
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected DynamicRepositoryEntityMap dynamicRepositoryEntities
   :outertype: Repository

finderClassLoaders
^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<URL, URLClassLoader> finderClassLoaders
   :outertype: Repository

   The class loaders used by the finders to load classes dynamically.

finderLoadedJarFileChangeDates
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Long> finderLoadedJarFileChangeDates
   :outertype: Repository

   The change dates of the jar files that were loaded dynamically by jar finder instances.

finderWaitingFiles
^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<File, List<File>> finderWaitingFiles
   :outertype: Repository

   A map containing dependencies between jar files that are loaded dynamically.

formatsBasePath
^^^^^^^^^^^^^^^

.. java:field:: protected String formatsBasePath
   :outertype: Repository

   The absolute path to the directory within this repository, where all format jars are stored, e.g. dataset formats.

generatorBasePath
^^^^^^^^^^^^^^^^^

.. java:field:: protected String generatorBasePath
   :outertype: Repository

   The absolute path to the directory within this repository, where all generators are stored.

goldStandardFormats
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<GoldStandardFormat, GoldStandardFormat> goldStandardFormats
   :outertype: Repository

   A map containing all goldstandard formats registered in this repository.

internalAttributePattern
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected static Pattern internalAttributePattern
   :outertype: Repository

   The pattern that is used to scan a string ofr internal attribute placeholders in \ :java:ref:`isInternalAttribute(String)`\ .

internalDoubleAttributes
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, NamedDoubleAttribute> internalDoubleAttributes
   :outertype: Repository

   This map holds all available internal float attributes, which can be used by any kind of configuration file as a option value, which is not available before starting of a run.

internalIntegerAttributes
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, NamedIntegerAttribute> internalIntegerAttributes
   :outertype: Repository

   This map holds all available internal integer attributes, which can be used by any kind of configuration file as a option value, which is not available before starting of a run.

internalStringAttributes
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, NamedStringAttribute> internalStringAttributes
   :outertype: Repository

   This map holds all available internal string attributes, which can be used by any kind of configuration file as a option value, which is not available before starting of a run.

knownFinderExceptions
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, List<Throwable>> knownFinderExceptions
   :outertype: Repository

   All exceptions thrown during parsing of finder instances are being inserted into this map. New exceptions with messages equal to messages of exceptions in this list will not be thrown again.

log
^^^

.. java:field:: protected Logger log
   :outertype: Repository

missingRLibraries
^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Set<RLibraryNotLoadedException>> missingRLibraries
   :outertype: Repository

   This attribute maps the names of a class to all exceptions of required R libraries that could not be loaded.

parent
^^^^^^

.. java:field:: protected Repository parent
   :outertype: Repository

   A repository can have a parent repository, which means, that the root folder of this repository is located inside the parent repository.

   As a consequence if a child repository cannot complete a lookup operation sucessfully, that means cannot find a certain object, it will also look for this object in the parent repository.

   This relationship is only allowed (located inside a subfolder), if the parental relationship is indicated by setting this parent repository attribute.

pathToRepositoryObject
^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<File, RepositoryObject> pathToRepositoryObject
   :outertype: Repository

   This map contains the absolute path of every repository object registered in this repository and maps it to the object itself.

randomizerBasePath
^^^^^^^^^^^^^^^^^^

.. java:field:: protected String randomizerBasePath
   :outertype: Repository

   The absolute path to the directory within this repository, where all randomizers are stored.

repositories
^^^^^^^^^^^^

.. java:field:: protected static Map<String, Repository> repositories
   :outertype: Repository

   A map containing all repository objects. This includes this repository but also all run result repositories or other child repositories, that are contained within this repository.

repositoryConfig
^^^^^^^^^^^^^^^^

.. java:field:: protected RepositoryConfig repositoryConfig
   :outertype: Repository

   The configuration of this repository holds options that can specify the behaviour of this repository. For example it can be specified, whether the repository should communicate and insert its information into a sql database.

sqlCommunicator
^^^^^^^^^^^^^^^

.. java:field:: protected SQLCommunicator sqlCommunicator
   :outertype: Repository

   In case the backend is connected to a mysql database in the frontend, this attribute is set to a sql communicator, which updates the database after changes of repository objects (removal, addition).

staticRepositoryEntities
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected StaticRepositoryEntityMap staticRepositoryEntities
   :outertype: Repository

supervisorThread
^^^^^^^^^^^^^^^^

.. java:field:: protected SupervisorThread supervisorThread
   :outertype: Repository

   The supervisor thread is responsible for starting and keeping alive all threads that check the repository on the filesystem for changes.

suppClusteringBasePath
^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String suppClusteringBasePath
   :outertype: Repository

   The absolute path to the directory within this repository, where all supplementary materials related to clustering are stored.

supplementaryBasePath
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String supplementaryBasePath
   :outertype: Repository

   The absolute path to the directory within this repository, where all supplementary materials are stored.

   Supplementary materials contain e.g. jar files of parameter optimization methods or clustering quality measures.

typesBasePath
^^^^^^^^^^^^^

.. java:field:: protected String typesBasePath
   :outertype: Repository

   The absolute path to the directory within this repository, where all type jars are stored.

Constructors
------------
Repository
^^^^^^^^^^

.. java:constructor:: public Repository(String basePath, Repository parent) throws FileNotFoundException, RepositoryAlreadyExistsException, InvalidRepositoryException, RepositoryConfigNotFoundException, RepositoryConfigurationException
   :outertype: Repository

   Instantiates a new repository.

   :param parent: Can be null, if this repository has no parent repository.
   :param basePath: The absolute path of the root of this repository.
   :throws InvalidRepositoryException:
   :throws RepositoryAlreadyExistsException:
   :throws RepositoryConfigNotFoundException:
   :throws RepositoryConfigurationException:
   :throws FileNotFoundException:

Repository
^^^^^^^^^^

.. java:constructor:: public Repository(String basePath, Repository parent, RepositoryConfig overrideConfig) throws FileNotFoundException, RepositoryAlreadyExistsException, InvalidRepositoryException, RepositoryConfigNotFoundException, RepositoryConfigurationException
   :outertype: Repository

   Instantiates a new repository.

   :param parent: Can be null, if this repository has no parent repository.
   :param basePath: The absolute path of the root of this repository.
   :param overrideConfig: Set this parameter != null, if you want to override the repository.config file.
   :throws InvalidRepositoryException:
   :throws RepositoryAlreadyExistsException:
   :throws RepositoryConfigNotFoundException:
   :throws RepositoryConfigurationException:
   :throws FileNotFoundException:

Methods
-------
addMissingRLibraryException
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean addMissingRLibraryException(RLibraryNotLoadedException e)
   :outertype: Repository

   :param e: The new exception to add.
   :return: A boolean indicating, whether the exception was new.

clearMissingRLibraries
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<RLibraryNotLoadedException> clearMissingRLibraries(String className)
   :outertype: Repository

   This method clears the existing exceptions for missing R libraries for the given class name.

   :param className: The class name for which we want to clear the missing libraries.
   :return: The old exceptions that were present for this class.

clearRengine
^^^^^^^^^^^^

.. java:method:: public void clearRengine(Thread thread)
   :outertype: Repository

clearRengineForCurrentThread
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void clearRengineForCurrentThread()
   :outertype: Repository

commitDB
^^^^^^^^

.. java:method:: public void commitDB()
   :outertype: Repository

   This method is a helper method for sql communication. The sql communicator usually does not commit after every change. Therefore we provide this method, to allow for commiting at certain points such that we can afterwards guarantee a certain state of the DB and operate on it.

createAndAddDynamicEntity
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected <T extends RepositoryObject> void createAndAddDynamicEntity(Class<T> c, String basePath)
   :outertype: Repository

createAndAddStaticEntity
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected <T extends RepositoryObject> void createAndAddStaticEntity(Class<T> c, String basePath)
   :outertype: Repository

createSQLCommunicator
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected SQLCommunicator createSQLCommunicator()
   :outertype: Repository

   This method creates a sql communicator for this repository depending on the fact, whether mysql should be used by this repository.

   Override this method in subclasses, if you want to change the type of sql communicator for your subtype. You can see an example in \ :java:ref:`RunResultRepository.createSQLCommunicator()`\ , where instead of \ :java:ref:`DefaultSQLCommunicator`\  a \ :java:ref:`RunResultSQLCommunicator`\  is created.

   :return: A new instance of sql communicator.

createSupervisorThread
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected SupervisorThread createSupervisorThread()
   :outertype: Repository

   This method creates the supervisor thread object for this repository.

   Override this method in subclasses, if you want to change the type of supervisor thread for your subtype. You can see an example in \ :java:ref:`RunResultRepository.createSupervisorThread()`\ , where instead of a \ :java:ref:`RepositorySupervisorThread`\  a \ :java:ref:`RunResultRepositorySupervisorThread`\  is created.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Repository

evaluateInternalAttributes
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String evaluateInternalAttributes(String old, DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: Repository

   This method evaluates all internal attribute placeholders contained in the passed string.

   :param old: The string which might contain internal attribute placeholders.
   :param dataConfig: The data configuration which might be needed to evaluate the placeholders.
   :param programConfig: The program configuration which might be needed to evaluate the placeholders.
   :throws InternalAttributeException:
   :return: The parameter value with evaluated placeholders.

evaluateJavaScript
^^^^^^^^^^^^^^^^^^

.. java:method:: public String evaluateJavaScript(String script) throws ScriptException
   :outertype: Repository

   This method is used to evaluate parameter values containing javascript arithmetic operations.

   A helper method of \ :java:ref:`ProgramParameter.evaluateDefaultValue(DataConfig,ProgramConfig)`\ , \ :java:ref:`ProgramParameter.evaluateMinValue(DataConfig,ProgramConfig)`\  and \ :java:ref:`ProgramParameter.evaluateMaxValue(DataConfig,ProgramConfig)`\ .

   :param script: The parameter value containing javascript arithmetic operations.
   :throws ScriptException:
   :return: The evaluated expression.

getAnalysisResultsBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getAnalysisResultsBasePath()
   :outertype: Repository

getBasePath
^^^^^^^^^^^

.. java:method:: public String getBasePath()
   :outertype: Repository

   :return: The absolute path to the root of this repository.

getBasePath
^^^^^^^^^^^

.. java:method:: public String getBasePath(Class<? extends RepositoryObject> c)
   :outertype: Repository

getClasses
^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> Collection<Class<? extends T>> getClasses(Class<T> c)
   :outertype: Repository

getClusterResultsBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getClusterResultsBasePath()
   :outertype: Repository

getClusterResultsQualityBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getClusterResultsQualityBasePath()
   :outertype: Repository

getCollectionStaticEntities
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> Collection<T> getCollectionStaticEntities(Class<T> c)
   :outertype: Repository

getCurrentDataSetFormatVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getCurrentDataSetFormatVersion(String formatClass) throws UnknownDataSetFormatException
   :outertype: Repository

   This method returns the latest and current version of the given format. It is used by default, if no other version for a format is specified. If the current version of a format changes, add a static block to that formats class and overwrite the format version.

   :param formatClass: The dataset format class for which we want to know the current version.
   :throws UnknownDataSetFormatException:
   :return: The current version for the given dataset format class.

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends DataSetFormatParser> getDataSetFormatParser(String dataSetFormatName)
   :outertype: Repository

   This method looks up and returns (if it exists) the class of the parser corresponding to the dataset format with the given name.

   :param dataSetFormatName: The name of the class of the dataset format.
   :return: The class of the dataset format parser with the given name or null, if it does not exist.

getDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends DataStatisticCalculator<? extends DataStatistic>> getDataStatisticCalculator(String dataStatisticClassName)
   :outertype: Repository

getFinderLoadedJarFileChangeDates
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Long> getFinderLoadedJarFileChangeDates()
   :outertype: Repository

   :return: The change dates of the jar files that were loaded dynamically by jar finder instances.

getInternalDoubleAttribute
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public NamedDoubleAttribute getInternalDoubleAttribute(String value)
   :outertype: Repository

   This method checks whether the given string is a valid and internal double attribute by invoking \ :java:ref:`isInternalAttribute(String)`\ . Then the internal double attribute is looked up and returned if it exists.

   :param value: The name of the internal double attribute.
   :return: The internal double attribute with the given name or null, if there is no attribute with the given name

getInternalIntegerAttribute
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public NamedIntegerAttribute getInternalIntegerAttribute(String value)
   :outertype: Repository

   This method checks whether the given string is a valid and internal integer attribute by invoking \ :java:ref:`isInternalAttribute(String)`\ . Then the internal integer attribute is looked up and returned if it exists.

   :param value: The name of the internal integer attribute.
   :return: The internal integer attribute with the given name or null, if there is no attribute with the given name

getInternalStringAttribute
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public NamedStringAttribute getInternalStringAttribute(String value)
   :outertype: Repository

   This method checks whether the given string is a valid and internal string attribute by invoking \ :java:ref:`isInternalAttribute(String)`\ . Then the internal string attribute is looked up and returned if it exists.

   :param value: The name of the internal string attribute.
   :return: The internal string attribute with the given name or null, if there is no attribute with the given name

getJARFinderClassLoaders
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<URL, URLClassLoader> getJARFinderClassLoaders()
   :outertype: Repository

   :return: The class loaders used by the finders to load classes dynamically.

getJARFinderWaitingFiles
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<File, List<File>> getJARFinderWaitingFiles()
   :outertype: Repository

   :return: A map containing dependencies between jar files that are loaded dynamically.

getKnownFinderExceptions
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, List<Throwable>> getKnownFinderExceptions()
   :outertype: Repository

   :return: The map containing all known finder exceptions.

getLogBasePath
^^^^^^^^^^^^^^

.. java:method:: public String getLogBasePath()
   :outertype: Repository

   :return: The absolute path to the directory, where for a certain runresult (identified by its unique run identifier) all log files are stored.

getParent
^^^^^^^^^

.. java:method:: public Repository getParent()
   :outertype: Repository

   :return: The parent repository of this repository, or null if this repository has no parent.

getRegisteredClass
^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> Class<? extends T> getRegisteredClass(Class<T> c, String className)
   :outertype: Repository

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> T getRegisteredObject(T object)
   :outertype: Repository

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> T getRegisteredObject(T object, boolean ignoreChangeDate)
   :outertype: Repository

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject, S extends T> S getRegisteredObject(Class<T> c, S object, boolean ignoreChangeDate)
   :outertype: Repository

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public RepositoryObject getRegisteredObject(File absFilePath)
   :outertype: Repository

   This method looks up and returns (if it exists) the repository object that belongs to the passed absolute path.

   :param absFilePath: The absolute path for which we want to find the repository object.
   :return: The repository object which has the given absolute path.

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public NamedDoubleAttribute getRegisteredObject(NamedDoubleAttribute object)
   :outertype: Repository

   This method checks, whether there is a named double attribute registered, that is equal to the passed object and returns it.

   Equality is checked in terms of

   ..

   * \ **object.hashCode == other.hashCode**\
   * \ **object.equals(other)**\

   since internally the repository uses hash datastructures.

   By default the \ :java:ref:`RepositoryObject.equals(Object)`\  method is only based on the absolute path of the repository object and the repositories of the two objects, this means two repository objects are considered the same if they are stored in the same repository and they have the same absolute path.

   :param object: The object for which we want to find an equal registered object.
   :return: The registered object equal to the passed object.

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public NamedIntegerAttribute getRegisteredObject(NamedIntegerAttribute object)
   :outertype: Repository

   This method checks, whether there is a named integer attribute registered, that is equal to the passed object and returns it.

   Equality is checked in terms of

   ..

   * \ **object.hashCode == other.hashCode**\
   * \ **object.equals(other)**\

   since internally the repository uses hash datastructures.

   By default the \ :java:ref:`RepositoryObject.equals(Object)`\  method is only based on the absolute path of the repository object and the repositories of the two objects, this means two repository objects are considered the same if they are stored in the same repository and they have the same absolute path.

   :param object: The object for which we want to find an equal registered object.
   :return: The registered object equal to the passed object.

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public NamedStringAttribute getRegisteredObject(NamedStringAttribute object)
   :outertype: Repository

   This method checks, whether there is a named string attribute registered, that is equal to the passed object and returns it.

   Equality is checked in terms of

   ..

   * \ **object.hashCode == other.hashCode**\
   * \ **object.equals(other)**\

   since internally the repository uses hash datastructures.

   By default the \ :java:ref:`RepositoryObject.equals(Object)`\  method is only based on the absolute path of the repository object and the repositories of the two objects, this means two repository objects are considered the same if they are stored in the same repository and they have the same absolute path.

   :param object: The object for which we want to find an equal registered object.
   :return: The registered object equal to the passed object.

getRegisteredRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public RunResult getRegisteredRunResult(String runIdentifier)
   :outertype: Repository

   This method looks up and returns (if it exists) the runresult with the given unique identifier.

   :param runIdentifier: The identifier of the runresult.
   :return: The runresult with the given identifier.

getRengine
^^^^^^^^^^

.. java:method:: public MyRengine getRengine(Thread thread) throws RserveException
   :outertype: Repository

getRengineForCurrentThread
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public MyRengine getRengineForCurrentThread() throws RserveException
   :outertype: Repository

   :throws RserveException:
   :return: The MyRengine object corresponding to the current thread.

getRepositoryConfig
^^^^^^^^^^^^^^^^^^^

.. java:method:: public RepositoryConfig getRepositoryConfig()
   :outertype: Repository

   :return: The configuration of this repository.

getRepositoryForExactPath
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Repository getRepositoryForExactPath(String absFilePath)
   :outertype: Repository

   This method returns a repository (if available) with the given root path.

   :param absFilePath: The absolute root path of the repository.
   :return: The repository with the given root path.

getRepositoryForPath
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Repository getRepositoryForPath(String absFilePath) throws NoRepositoryFoundException
   :outertype: Repository

   This method returns the lowest repository in repository-hierarchy, that contains the given path. That means, if there are several nested repositories for the given path, this method will return the lowest one of the hierarchy.

   :param absFilePath: The absolute file path we want to find the repository for.
   :throws NoRepositoryFoundException:
   :return: The repository for the given path, which is lowest in the repository-hierarchy.

getRunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> getRunDataStatisticCalculator(String runDataStatisticClassName)
   :outertype: Repository

getRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends RunResultFormatParser> getRunResultFormatParser(String runResultFormatName)
   :outertype: Repository

   This method looks up and returns (if it exists) the class of the runresult format parser corresponding to the runresult format with the given name.

   :param runResultFormatName: The runresult format name.
   :return: The runresult format parser for the given runresult format name, or null if it does not exist.

getRunResultIdentifier
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Collection<String> getRunResultIdentifier()
   :outertype: Repository

   :return: A collection with the names of those runresult directories contained in the repository of this server, that contain a clusters subfolder and at least one *.complete file containing results (can be slow if many run result folders are present).

getRunResumes
^^^^^^^^^^^^^

.. java:method:: public Collection<String> getRunResumes()
   :outertype: Repository

   :return: A collection with the names of all run result directories contained in the repository of this server. Those run result directories can be resumed, if they were terminated before.

getRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends RunStatisticCalculator<? extends RunStatistic>> getRunStatisticCalculator(String runStatisticClassName)
   :outertype: Repository

getSqlCommunicator
^^^^^^^^^^^^^^^^^^

.. java:method:: public SQLCommunicator getSqlCommunicator()
   :outertype: Repository

   :return: In case the backend is connected to a mysql database in the frontend, this returns an sql communicator, which updates the database after changes of repository objects (removal, addition), otherwise it returns a stub sql communicator.

getStaticObjectWithName
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> T getStaticObjectWithName(Class<T> c, String name)
   :outertype: Repository

getSupervisorThread
^^^^^^^^^^^^^^^^^^^

.. java:method:: public SupervisorThread getSupervisorThread()
   :outertype: Repository

   :return: The supervisor thread is responsible for starting and keeping alive all threads that check the repository on the filesystem for changes.

getSupplementaryBasePath
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupplementaryBasePath()
   :outertype: Repository

   :return: The absolute path to the directory within this repository, where all supplementary materials are stored.

getSupplementaryClusteringBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupplementaryClusteringBasePath()
   :outertype: Repository

   :return: The absolute path to the directory within this repository, where all supplementary materials related to clustering are stored.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Repository

info
^^^^

.. java:method:: protected void info(String message)
   :outertype: Repository

   A helper method for logging, which can overwritten to change the logger-level in subclasses of this class. For example in RunResultRepostories we do not want to log everything, therefore we change the log level to debug.

   :param The: message to log.

initAttributes
^^^^^^^^^^^^^^

.. java:method:: protected void initAttributes()
   :outertype: Repository

   This method initializes all attribute maps and all variables, that keep registered repository objects.

   A helper method for and invoked by \ :java:ref:`Repository(String,Repository,long,long,long,long,long,long,long)`\ .

initialize
^^^^^^^^^^

.. java:method:: public void initialize() throws InterruptedException
   :outertype: Repository

   Initializes this repository by creating a supervisor thread \ :java:ref:`createSupervisorThread()`\  and waiting until \ :java:ref:`isInitialized()`\  returns true.

   :throws InterruptedException: Is thrown, if the current thread is interrupted while waiting for finishing the initialization process.

initializePaths
^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected void initializePaths() throws InvalidRepositoryException
   :outertype: Repository

   This method sets all the absolute paths used by the repository to store any kinds of files and data on the filesystem.

   This method only initializes the attributes itself to valid paths, but does not create or ensure any folder structure.

   A helper method of \ :java:ref:`Repository(String,Repository,long,long,long,long,long,long,long)`\ .

   :throws InvalidRepositoryException:

isClassRegistered
^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean isClassRegistered(Class<T> c)
   :outertype: Repository

isClassRegistered
^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean isClassRegistered(String classFullName)
   :outertype: Repository

isClassRegistered
^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean isClassRegistered(Class<T> base, String classSimpleName)
   :outertype: Repository

isInitialized
^^^^^^^^^^^^^

.. java:method:: public boolean isInitialized(Class<? extends RepositoryObject> c)
   :outertype: Repository

isInitialized
^^^^^^^^^^^^^

.. java:method:: public boolean isInitialized()
   :outertype: Repository

   This method checks, whether this repository has been initialized. A repository is initialized, if the following invocations return true:

   ..

   * \ **getDataSetFormatsInitialized()**\
   * \ **getDataSetTypesInitialized()**\
   * \ **getDataStatisticsInitialized()**\
   * \ **getRunStatisticsInitialized()**\
   * \ **getRunDataStatisticsInitialized()**\
   * \ **getRunResultFormatsInitialized()**\
   * \ **getClusteringQualityMeasuresInitialized()**\
   * \ **getParameterOptimizationMethodsInitialized()**\
   * \ **getRunsInitialized()**\
   * \ **getRProgramsInitialized()**\
   * \ **getDataSetConfigsInitialized()**\
   * \ **getGoldStandardConfigsInitialized()**\
   * \ **getDataConfigsInitialized()**\
   * \ **getProgramConfigsInitialized()**\
   * \ **getDataSetGeneratorsInitialized()**\
   * \ **getDistanceMeasuresInitialized()**\

   :return: True, if this repository is initialized.

isInternalAttribute
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static boolean isInternalAttribute(String value)
   :outertype: Repository

   This method checks, whether the given string represents an internal attribute placeholder, that means it follows the format of {@value #internalAttributePattern}.

   :param value: The string to check whether it is a internal attribute.
   :return: True, if the given string is an internal attribute, false otherwise.

isRegisteredForDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isRegisteredForDataSetFormat(Class<? extends DataSetFormat> dsFormat)
   :outertype: Repository

   This method checks whether a parser has been registered for the given dataset format class.

   :param dsFormat: The class for which we want to know whether a parser has been registered.
   :return: True, if the parser has been registered.

isRegisteredForRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isRegisteredForRunResultFormat(Class<? extends RunResultFormat> runResultFormat)
   :outertype: Repository

   This method checks whether a parser has been registered for the given runresult format class.

   :param runResultFormat: The class for which we want to know whether a parser has been registered.
   :return: True, if the parser has been registered.

isRegisteredForRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isRegisteredForRunResultFormat(String runResultFormatName)
   :outertype: Repository

   This method checks whether a parser has been registered for the dataset format with the given class name.

   :param runResultFormatName: The class for which we want to know whether a parser has been registered.
   :return: True, if the parser has been registered.

putCurrentDataSetFormatVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void putCurrentDataSetFormatVersion(String formatClass, int version)
   :outertype: Repository

   :param formatClass: The dataset format class for which we want to set the current version.
   :param version: The new version of the dataset format class.

register
^^^^^^^^

.. java:method:: public static Repository register(Repository repository) throws RepositoryAlreadyExistsException, InvalidRepositoryException
   :outertype: Repository

   Register a new repository.

   :param repository: The new repository to register.
   :throws InvalidRepositoryException:
   :throws RepositoryAlreadyExistsException:
   :return: The old repository, if the new repository replaced an old one with equal root path. Null otherwise.

register
^^^^^^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject, S extends T> boolean register(S object) throws RegisterException
   :outertype: Repository

register
^^^^^^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject, S extends T> boolean register(Class<T> c, S object) throws RegisterException
   :outertype: Repository

register
^^^^^^^^

.. java:method:: public boolean register(NamedDoubleAttribute object)
   :outertype: Repository

   This method registers a new named double attribute. If an old object was already registered that equals the new object, the new object is not registered.

   :param object: The new object to register.
   :return: True, if the new object has been registered.

register
^^^^^^^^

.. java:method:: public boolean register(NamedIntegerAttribute object)
   :outertype: Repository

   This method registers a new named integer attribute. If an old object was already registered that equals the new object, the new object is not registered.

   :param object: The new object to register.
   :return: True, if the new object has been registered.

register
^^^^^^^^

.. java:method:: public boolean register(NamedStringAttribute object)
   :outertype: Repository

   This method registers a new named string attribute. If an old object was already registered that equals the new object, the new object is not registered.

   :param object: The new object to register.
   :return: True, if the new object has been registered.

registerClass
^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean registerClass(Class<T> c)
   :outertype: Repository

registerClass
^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject, S extends T> boolean registerClass(Class<T> base, Class<S> c)
   :outertype: Repository

registerDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerDataSetFormatParser(Class<? extends DataSetFormatParser> dsFormatParser)
   :outertype: Repository

   This method registers a dataset format parser.

   :param dsFormatParser: The dataset format parser to register.
   :return: True, if the dataset format parser replaced an old object.

registerDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerDataStatisticCalculator(Class<? extends DataStatisticCalculator<? extends DataStatistic>> dataStatisticCalculator)
   :outertype: Repository

registerRunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerRunDataStatisticCalculator(Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> runDataStatisticCalculator)
   :outertype: Repository

registerRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerRunResultFormatParser(Class<? extends RunResultFormatParser> runResultFormatParser)
   :outertype: Repository

   This method registers a new runresult format parser class.

   :param runResultFormatParser: The new class to register.
   :return: True, if the new class replaced an old one.

registerRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerRunStatisticCalculator(Class<? extends RunStatisticCalculator<? extends RunStatistic>> runStatisticCalculator)
   :outertype: Repository

setInitialized
^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> void setInitialized(Class<T> c)
   :outertype: Repository

setSQLCommunicator
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSQLCommunicator(SQLCommunicator comm)
   :outertype: Repository

   :param comm: The new sql communicator.

terminateSupervisorThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void terminateSupervisorThread() throws InterruptedException
   :outertype: Repository

   :throws InterruptedException:

terminateSupervisorThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void terminateSupervisorThread(boolean closeRengines) throws InterruptedException
   :outertype: Repository

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Repository

unregister
^^^^^^^^^^

.. java:method:: public static Repository unregister(Repository repository)
   :outertype: Repository

   Unregister the given repository.

   :param repository: The repository to remove.
   :return: The removed repository. If null, the given repository was not registered.

unregister
^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject, S extends T> boolean unregister(S object)
   :outertype: Repository

unregister
^^^^^^^^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject, S extends T> boolean unregister(Class<T> c, S object)
   :outertype: Repository

unregister
^^^^^^^^^^

.. java:method:: public boolean unregister(NamedDoubleAttribute object)
   :outertype: Repository

   This method unregisters the passed object.

   :param object: The object to be removed.
   :return: True, if the object was remved successfully

unregister
^^^^^^^^^^

.. java:method:: public boolean unregister(NamedIntegerAttribute object)
   :outertype: Repository

   This method unregisters the passed object.

   :param object: The object to be removed.
   :return: True, if the object was remved successfully

unregister
^^^^^^^^^^

.. java:method:: public boolean unregister(NamedStringAttribute object)
   :outertype: Repository

   This method unregisters the passed object.

   :param object: The object to be removed.
   :return: True, if the object was remved successfully

unregisterClass
^^^^^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean unregisterClass(Class<T> c)
   :outertype: Repository

unregisterClass
^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject, S extends T> boolean unregisterClass(Class<T> base, Class<S> c)
   :outertype: Repository

unregisterRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean unregisterRunResultFormatParser(Class<? extends RunResultFormatParser> object)
   :outertype: Repository

   This method unregisters the passed object.

   :param object: The object to be removed.
   :return: True, if the object was remved successfully

updateStatusOfRun
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean updateStatusOfRun(Run run, String newStatus)
   :outertype: Repository

   This method is invoked by \ :java:ref:`Run.setStatus(de.clusteval.run.RUN_STATUS)`\  and ensures that the new status is passed to the whole framework, e.g. the frontend database.

   :param run: The run which changed its status.
   :param newStatus: The new status of the run.
   :return: True, if the propagation of the new status was successful.

warn
^^^^

.. java:method:: protected void warn(String message)
   :outertype: Repository

   A helper method for logging, which can overwritten to change the logger-level in subclasses of this class. For example in RunResultRepostories we do not want to log everything, therefore we change the log level to debug.

   :param The: message to log.

