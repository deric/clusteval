.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

RunResultFormat
===============

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public abstract class RunResultFormat extends RepositoryObject

   Run results (e.g. clusterings) can have different formats. For all kinds of operations the framework needs to know which format a runresult has and how it can be converted to an understandable (standard) format.

   Every runresult format comes together with a parser class (see \ :java:ref:`RunResultFormatParser`\ ).

   A runresult format MyRunResultFormat can be added to ClustEval by

   1. extending this class with your own class MyRunResultFormat. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your runresult format.

     * :java:ref:`RunResultFormat(Repository, boolean, long, File)`: The constructor of your runresult format class. This constructor has to be implemented and public, otherwise the framework will not be able to load your runresult format.
     * :java:ref:`RunResultFormat(RunResultFormat)`: The copy constructor of your class taking another instance of your class. This constructor has to be implemented and public.

   2. extending the class :java:ref:`RunResultFormatParser` with your own class MyRunResultFormatParser. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your class.

     * :java:ref:`convertToStandardFormat()`: This method converts the given runresult to the standard runresult format of the framework. The converted runresult has to be named exactly as the input file postfixed with the extension ".conv". The original runresult <REPOSITORY ROOT>/results/<runIdentifier>/clusters/TransClust sfld.1.result has to be converted to <REPOSITORY ROOT>/results/<runIdentifier>/clusters/TransClust sfld.1.result.conv by this method. A wrapper object for the converted runresult has be stored in the result attribute.

   3. Creating a jar file named MyRunResultFormat.jar containing the MyRunResultFormat.class and MyRunResultFormatParser.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/run/result/format/MyRunResultFormat.class
     * de/clusteval/run/result/format/MyRunResultFormatParser.class

   4. Putting the MyRunResultFormat.jar into the runresult formats folder of the repository:

     * <REPOSITORY ROOT>/supp/formats/runresult
     * The backend server will recognize and try to load the new runresult format automatically the next time, the :java:ref:`RunResultFormatFinderThread` checks the filesystem.

   :author: Christian Wiwie

Constructors
------------
RunResultFormat
^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RunResultFormat

   Instantiates a new runresult format.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RunResultFormat
^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormat(RunResultFormat other) throws RegisterException
   :outertype: RunResultFormat

   The copy constructor of runresult formats.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final RunResultFormat clone()
   :outertype: RunResultFormat

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: RunResultFormat

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: RunResultFormat

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static RunResultFormat parseFromString(Repository repository, String runResultFormat) throws UnknownRunResultFormatException
   :outertype: RunResultFormat

   This method parses a runresult format from the given string, containing a runresult format class name.

   :param repository: The repository where to look up the runresult format class.
   :param runResultFormat: The runresult format class name as string.
   :throws UnknownRunResultFormatException:
   :return: The parsed runresult format.

