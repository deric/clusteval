.. java:import:: java.io File

.. java:import:: utils ArraysExt

.. java:import:: utils StringExt

.. java:import:: cern.colt.matrix.tlong LongMatrix2D

.. java:import:: cern.colt.matrix.tlong.impl SparseLongMatrix2D

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

CooccurrenceRunStatistic
========================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: @RLibraryRequirement public class CooccurrenceRunStatistic extends RunStatistic

   :author: Christian Wiwie

Fields
------
cooccurrenceMatrix
^^^^^^^^^^^^^^^^^^

.. java:field:: protected LongMatrix2D cooccurrenceMatrix
   :outertype: CooccurrenceRunStatistic

ids
^^^

.. java:field:: protected String[] ids
   :outertype: CooccurrenceRunStatistic

Constructors
------------
CooccurrenceRunStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CooccurrenceRunStatistic(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: CooccurrenceRunStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

CooccurrenceRunStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CooccurrenceRunStatistic(Repository repo, boolean register, long changeDate, File absPath, String[] ids, LongMatrix2D cooccurrenceMatrix) throws RegisterException
   :outertype: CooccurrenceRunStatistic

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param ids:
   :param cooccurrenceMatrix:
   :throws RegisterException:

CooccurrenceRunStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CooccurrenceRunStatistic(CooccurrenceRunStatistic other) throws RegisterException
   :outertype: CooccurrenceRunStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: CooccurrenceRunStatistic

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: @Override public void parseFromString(String contents)
   :outertype: CooccurrenceRunStatistic

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: CooccurrenceRunStatistic

