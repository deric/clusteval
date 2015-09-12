.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.utils RNotAvailableException

Program
=======

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public abstract class Program extends RepositoryObject

   A wrapper class for programs used by this framework.

   A program object encapsulates a executable, that can be executed using the \ :java:ref:`exec(DataConfig,ProgramConfig,String[],Map,Map)`\  method. This method takes the data and its configuration, the program and its configuration, the complete invocation line and all parameters used for this invocation.

   :author: Christian Wiwie

Constructors
------------
Program
^^^^^^^

.. java:constructor:: public Program(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: Program

   Instantiates a new program.

   :param repository: the repository this program should be registered at.
   :param register: Whether this program should be registered in the repository.
   :param changeDate: The change date of this program is used for equality checks.
   :param absPath: The absolute path of this program.
   :throws RegisterException:

Program
^^^^^^^

.. java:constructor:: protected Program(Program program) throws RegisterException
   :outertype: Program

   The copy constructor for programs.

   :param program: The program to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract Program clone()
   :outertype: Program

exec
^^^^

.. java:method:: public abstract Process exec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws IOException, RNotAvailableException, RLibraryNotLoadedException, REngineException, REXPMismatchException, InterruptedException
   :outertype: Program

   This method executes this program on the data defined in the data configuration.

   The complete invocation line is also passed. It is taken from the program configuration used by the run. All parameter placeholders contained in this invocation line are already replaced by their actual values.

   Additionally all parameter values are passed in the two map parameters.

   :param dataConfig: This configuration encapsulates the data, this program should be applied to.
   :param programConfig: This parameter contains some additional configuration for this program.
   :param invocationLine: This is the complete invocation line, were all parameter placeholders are already replaced by their actual values.
   :param effectiveParams: This map contains only the program parameters defined in the program configuration together with their actual values.
   :param internalParams: This map contains parameters, that are not program specific, but related and necessary for the execution of the program, e.g. the path to the output or log files created by the program.
   :throws RLibraryNotLoadedException:
   :throws RNotAvailableException:
   :throws InterruptedException:
   :throws REXPMismatchException:
   :throws IOException:
   :throws REngineException:
   :return: A Process object which can be used to get the status of or to control the execution of this program.

getAlias
^^^^^^^^

.. java:method:: public abstract String getAlias()
   :outertype: Program

   This alias is used whenever this program is visually represented and a readable name is needed.

   :return: The alias of this program.

getContext
^^^^^^^^^^

.. java:method:: public abstract Context getContext() throws UnknownContextException
   :outertype: Program

   :throws UnknownContextException:
   :return: The context of this program. A run can only perform this program, if it has the same context.

getExecutable
^^^^^^^^^^^^^

.. java:method:: public String getExecutable()
   :outertype: Program

   Gets the absolute path of the executable.

   :return: the executable

getFullName
^^^^^^^^^^^

.. java:method:: public String getFullName()
   :outertype: Program

   This method returns the full name of this program. The full name corresponds to the concatenated major and minor name separated by a slash: MAJOR/MINOR

   :return: The full name.

getMajorName
^^^^^^^^^^^^

.. java:method:: public String getMajorName()
   :outertype: Program

   This method returns the major name of this program. The major name of the program is defined as the foldername its executable lies in.

   :return: The major name of this program.

getMinorName
^^^^^^^^^^^^

.. java:method:: public String getMinorName()
   :outertype: Program

   This method returns the minor name of this program. The minor name corresponds to the name of the executable of this program.

   :return: The minor name.

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: Program

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Program

