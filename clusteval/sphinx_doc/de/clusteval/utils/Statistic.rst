.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program.r RLibraryInferior

Statistic
=========

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class Statistic extends RepositoryObject implements RLibraryInferior

   An abstract class representing a property of some object, that can be assessed in analysis runs.

   :author: Christian Wiwie

Constructors
------------
Statistic
^^^^^^^^^

.. java:constructor:: public Statistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: Statistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

Statistic
^^^^^^^^^

.. java:constructor:: public Statistic(Statistic other) throws RegisterException
   :outertype: Statistic

   The copy constructor of statistics.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract Statistic clone()
   :outertype: Statistic

getAlias
^^^^^^^^

.. java:method:: public abstract String getAlias()
   :outertype: Statistic

   This alias is used whenever this statistic is visually represented and a readable name is needed.

   :return: The alias of this statistic.

getIdentifier
^^^^^^^^^^^^^

.. java:method:: public final String getIdentifier()
   :outertype: Statistic

   The string returned by this method is used to represent this type of statistic throughout the framework (e.g. in the configuration files)

   :return: A string representing this statistic class.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public abstract void parseFromString(String contents)
   :outertype: Statistic

   Parses the values of a statistic from a string and stores them in the local attributes of this object.

   :param contents: The string to parse the values from.

toString
^^^^^^^^

.. java:method:: @Override public abstract String toString()
   :outertype: Statistic

