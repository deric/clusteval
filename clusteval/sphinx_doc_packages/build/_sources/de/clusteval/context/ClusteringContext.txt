.. java:import:: java.io File

.. java:import:: java.util Arrays

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

ClusteringContext
=================

.. java:package:: de.clusteval.context
   :noindex:

.. java:type:: public class ClusteringContext extends Context

   This is the default context of the framework, concerning clustering tasks.

   :author: Christian Wiwie

Constructors
------------
ClusteringContext
^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringContext(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ClusteringContext

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ClusteringContext
^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringContext(ClusteringContext other) throws RegisterException
   :outertype: ClusteringContext

   :param other:
   :throws RegisterException:

Methods
-------
getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: ClusteringContext

getRequiredJavaClassFullNames
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<String> getRequiredJavaClassFullNames()
   :outertype: ClusteringContext

getStandardInputFormat
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public DataSetFormat getStandardInputFormat()
   :outertype: ClusteringContext

getStandardOutputFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public RunResultFormat getStandardOutputFormat()
   :outertype: ClusteringContext

