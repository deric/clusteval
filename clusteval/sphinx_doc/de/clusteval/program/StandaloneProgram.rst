.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

StandaloneProgram
=================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class StandaloneProgram extends Program

   A type of program that corresponds to executables on the filesystem.

   Standalone programs can be added to ClustEval by

   1. putting the executable file (together with all required shared libraries) into a respective folder in the repository programs directory

     * <REPOSITORY ROOT>/programs/<programFolder>/<executable>

   2. putting a program configuration file (see 4.9.7) into the repository program configuration directory

     * <REPOSITORY ROOT>/programs/configs

   3. if the program requires a new input format, follow the instructions under 11.3 for the new input format
   4. if the program has an unknown output format, follow the instructions under 11.4 for the new output format

   :author: Christian Wiwie

Fields
------
alias
^^^^^

.. java:field:: protected String alias
   :outertype: StandaloneProgram

context
^^^^^^^

.. java:field:: protected Context context
   :outertype: StandaloneProgram

envVars
^^^^^^^

.. java:field:: protected Map<String, String> envVars
   :outertype: StandaloneProgram

Constructors
------------
StandaloneProgram
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandaloneProgram(Repository repository, Context context, boolean register, long changeDate, File absPath, String alias, Map<String, String> envVars) throws RegisterException
   :outertype: StandaloneProgram

   :param repository: the repository this program should be registered at.
   :param context: The context of this program
   :param register:
   :param changeDate: The change date of this program is used for equality checks.
   :param absPath: The absolute path of this program.
   :param alias: The alias of this program.
   :param envVars: The environmental variables to set when this program is executed.
   :throws RegisterException:

StandaloneProgram
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandaloneProgram(StandaloneProgram program) throws RegisterException
   :outertype: StandaloneProgram

   The copy constructor of standalone programs.

   :param program: The standalone program to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public StandaloneProgram clone()
   :outertype: StandaloneProgram

exec
^^^^

.. java:method:: @SuppressWarnings @Override public Process exec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws IOException
   :outertype: StandaloneProgram

getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: StandaloneProgram

getContext
^^^^^^^^^^

.. java:method:: @Override public Context getContext()
   :outertype: StandaloneProgram

