.. java:import:: java.io File

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util Set

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.run.result.format RunResultFormat

Context
=======

.. java:package:: de.clusteval.context
   :noindex:

.. java:type:: public abstract class Context extends RepositoryObject

   :author: Christian Wiwie

Constructors
------------
Context
^^^^^^^

.. java:constructor:: public Context(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: Context

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

Context
^^^^^^^

.. java:constructor:: public Context(Context other) throws RegisterException
   :outertype: Context

   :param other:
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final RepositoryObject clone()
   :outertype: Context

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Context

getName
^^^^^^^

.. java:method:: public abstract String getName()
   :outertype: Context

   Contexts have a unique name.

   :return: The name of this context

getRequiredJavaClassFullNames
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract Set<String> getRequiredJavaClassFullNames()
   :outertype: Context

   :return: A set with all simple names of classes this context requires.

getStandardInputFormat
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract DataSetFormat getStandardInputFormat()
   :outertype: Context

   :return: The standard input format connected to this context. Every context has its own standard format, which is used during execution of runs.

getStandardOutputFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract RunResultFormat getStandardOutputFormat()
   :outertype: Context

   :return: The standard output format connected to this context. Every context has its own standard format, which is used during execution of runs.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Context

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static Context parseFromString(Repository repository, String contextName) throws UnknownContextException
   :outertype: Context

   :param repository:
   :param contextName:
   :throws UnknownContextException:
   :return: A context object of the class with the given simple name

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Context

