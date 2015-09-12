.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils Pair

.. java:import:: utils.parse TextFileParser

.. java:import:: utils.text TextFileMapParser

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureParameters

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ParameterSet

ClusteringParser
================

.. java:package:: de.clusteval.cluster
   :noindex:

.. java:type:: public class ClusteringParser extends TextFileParser

   A parser for files containing parameter sets and clusterings.

   :author: Christian Wiwie

Fields
------
params
^^^^^^

.. java:field:: protected List<String> params
   :outertype: ClusteringParser

   A temporary variable of no use after parsing.

parseQualities
^^^^^^^^^^^^^^

.. java:field:: protected boolean parseQualities
   :outertype: ClusteringParser

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: ClusteringParser

result
^^^^^^

.. java:field:: protected Pair<ParameterSet, Clustering> result
   :outertype: ClusteringParser

   This variable holds the results after parsing

Constructors
------------
ClusteringParser
^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringParser(Repository repository, String absFilePath, boolean parseQualities) throws IOException
   :outertype: ClusteringParser

   Instantiates a new clustering parser.

   :param repository:
   :param absFilePath: the abs file path
   :param parseQualities: True, if the qualities of the clusterings should also be parsed. Those will be taken from .qual-files.
   :throws IOException: Signals that an I/O exception has occurred.

Methods
-------
finishProcess
^^^^^^^^^^^^^

.. java:method:: @Override public void finishProcess()
   :outertype: ClusteringParser

getClusterings
^^^^^^^^^^^^^^

.. java:method:: public Pair<ParameterSet, Clustering> getClusterings()
   :outertype: ClusteringParser

   :return: A map containing parameter sets and corresponding clusterings.

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: ClusteringParser

