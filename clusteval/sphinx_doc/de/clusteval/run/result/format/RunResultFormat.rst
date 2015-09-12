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

