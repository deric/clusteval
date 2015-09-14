.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils StringExt

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.utils RNotAvailableException

RProgram
========

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public abstract class RProgram extends Program implements RLibraryInferior

   A type of progam that encapsulates a program embedded in R.

   Note that the name of the method in R is not itself written in plaintext in the \ :java:ref:`exec(de.clusteval.data.DataConfig,de.clusteval.program.ProgramConfig,String[],java.util.Map,java.util.Map)`\  method of RPrograms, but instead it is defined in the corresponding program configuration in the invocation format parameter.

   R programs can be added to ClustEval by

   1. extending this class with your own class MyRProgram. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your class.

     * :java:ref:`RProgram(Repository)` : The constructor of your class taking a repository parameter. This constructor has to be implemented and public, otherwise the framework will not be able to load your class.
     * :java:ref:`RProgram(MyRProgram)` : The copy constructor of your class taking another instance of your class. This constructor has to be implemented and public.
     * :java:ref:`getAlias()` : See :java:ref:`Program.getAlias()`.
     * :java:ref:`getInvocationFormat()` : This is the invocation of the R method including potential parameters, that have to be defined in the program configuration.
     * :java:ref:`exec(DataConfig,ProgramConfig,String[],Map,Map)` : See :java:ref:`Program.exec(DataConfig,ProgramConfig,String[],Map,Map)` In this method the actual execution of the R Program happens. In here you have to implement the invocation of the R method via Rserve and any pre- and postcalculations necessary. The communications with R can be visualized by the following code snippet::

         try {
           // precalculations
           double[] input = ...;
           ...
           MyRengine rEngine = new MyRengine("");
           try {
             rEngine.assign("input",input);
             rEngine.eval("result <- yourMethodInvocation()");
             REXP result = rEngine.eval("result@.Data");
             // postcalculations
             ...
           } catch (RserveException e) {
             e.printStackTrace();
           } finally {
             rEngine.close();
           }
         } catch (Exception e) {
           e.printStackTrace();
         }
         // for return type compatibility reasons
         return null;

   2. Creating a jar file named MyRProgram.jar containing the MyRProgram.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/program/r/MyRProgram.class

   3. Putting the MyRProgram.jar into the programs folder of the repository:

     * <REPOSITORY ROOT>/programs
     * The backend server will recognize and try to load the new program automatically the next time, the `RProgramFinderThread` checks the filesystem.

   :author: Christian Wiwie

Fields
------
dataSetContent
^^^^^^^^^^^^^^

.. java:field:: protected Object dataSetContent
   :outertype: RProgram

   Attribute used to store the dataset content during execution of this program.

ids
^^^

.. java:field:: protected String[] ids
   :outertype: RProgram

   Attribute to store the data object ids during execution of this program.

rEngine
^^^^^^^

.. java:field:: protected MyRengine rEngine
   :outertype: RProgram

   Attribute used to store an rengine instance during execution of this program.

x
^

.. java:field:: protected double[][] x
   :outertype: RProgram

   Attribute to store the pairwise similarites or absolute coordinates of data objects during execution of this program.

Constructors
------------
RProgram
^^^^^^^^

.. java:constructor:: public RProgram(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: RProgram

   :param repository: the repository this program should be registered at.
   :param changeDate: The change date of this program is used for equality checks.
   :param absPath: The absolute path of this program.
   :throws RegisterException:

RProgram
^^^^^^^^

.. java:constructor:: public RProgram(RProgram rProgram) throws RegisterException
   :outertype: RProgram

   The copy constructor for rprograms.

   :param rProgram: The object to clone.
   :throws RegisterException:

Methods
-------
afterExec
^^^^^^^^^

.. java:method:: protected void afterExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws REXPMismatchException, REngineException, IOException, InterruptedException
   :outertype: RProgram

beforeExec
^^^^^^^^^^

.. java:method:: @SuppressWarnings protected void beforeExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws REngineException, RLibraryNotLoadedException, RNotAvailableException, InterruptedException
   :outertype: RProgram

clone
^^^^^

.. java:method:: @Override public final RProgram clone()
   :outertype: RProgram

doExec
^^^^^^

.. java:method:: @SuppressWarnings protected void doExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws RserveException, InterruptedException
   :outertype: RProgram

exec
^^^^

.. java:method:: @Override public final Process exec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws REngineException
   :outertype: RProgram

execResultToString
^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings protected String execResultToString(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws RserveException, REXPMismatchException, InterruptedException
   :outertype: RProgram

extractDataSetContent
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract Object extractDataSetContent(DataConfig dataConfig)
   :outertype: RProgram

   This method is required to initialize the attributes \ :java:ref:`dataSetContent`\ , \ :java:ref:`ids`\  and all other attributes of the data, which are needed in \ :java:ref:`doExec(DataConfig,ProgramConfig,String[],Map,Map)`\ .

   :param dataConfig:

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract Set<DataSetFormat> getCompatibleDataSetFormats() throws UnknownDataSetFormatException
   :outertype: RProgram

   :throws UnknownDataSetFormatException:
   :return: A set containing dataset formats, which this r program can take as input.

getFuzzyCoeffMatrixFromExecResult
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract float[][] getFuzzyCoeffMatrixFromExecResult() throws RserveException, REXPMismatchException, InterruptedException
   :outertype: RProgram

   This method extracts the results after executing \ :java:ref:`doExec(DataConfig,ProgramConfig,String[],Map,Map)`\ . By default the result is stored in the R variable "result".

   :throws RserveException:
   :throws InterruptedException:
   :throws REXPMismatchException:
   :return: A two dimensional float array, containing fuzzy coefficients for each object and cluster. Rows correspond to objects and columns correspond to clusters. The order of objects is the same as in \ :java:ref:`ids`\ .

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract String getInvocationFormat()
   :outertype: RProgram

   :return: The format of the invocation line of this RProgram.

getMajorName
^^^^^^^^^^^^

.. java:method:: @Override public String getMajorName()
   :outertype: RProgram

   The major name of a RProgram corresponds to the simple name of its class.

getRengine
^^^^^^^^^^

.. java:method:: public MyRengine getRengine()
   :outertype: RProgram

   :return: The r engine corresponding to this rprogram.

getRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract RunResultFormat getRunResultFormat() throws UnknownRunResultFormatException
   :outertype: RProgram

   :throws UnknownRunResultFormatException:
   :return: The runresult formats, the results of this r program will be generated in.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static RProgram parseFromString(Repository repository, String rProgram) throws UnknownRProgramException
   :outertype: RProgram

   This method parses the major name given as a string, looks up the corresponding RProgram in the repository and returns a new instance.

   :param repository: The repository to lookup the RProgram.
   :param rProgram: The major name (see \ :java:ref:`getMajorName()`\ ) of the RProgram to return.
   :throws UnknownRProgramException:
   :return: An instance of an RProgram corresponding to the passed string.

