.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: utils.parse TextFileParser

.. java:import:: de.clusteval.run.result ClusteringRunResult

RunResultFormatParser
=====================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public abstract class RunResultFormatParser extends TextFileParser

   :author: Christian Wiwie

Fields
------
internalParams
^^^^^^^^^^^^^^

.. java:field:: protected Map<String, String> internalParams
   :outertype: RunResultFormatParser

params
^^^^^^

.. java:field:: protected Map<String, String> params
   :outertype: RunResultFormatParser

   The params.

result
^^^^^^

.. java:field:: protected ClusteringRunResult result
   :outertype: RunResultFormatParser

   The result.

Constructors
------------
RunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: RunResultFormatParser

   Instantiates a new run result format parser.

   :param internalParams:
   :param params: the params
   :param absFilePath: the abs file path
   :throws IOException: Signals that an I/O exception has occurred.

RunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath, boolean splitLines, OUTPUT_MODE outputMode) throws IOException
   :outertype: RunResultFormatParser

   Instantiates a new run result format parser.

   :param internalParams:
   :param params: the params
   :param absFilePath: the abs file path
   :param splitLines: the split lines
   :param outputMode: the output mode
   :throws IOException: Signals that an I/O exception has occurred.

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract void convertToStandardFormat() throws IOException
   :outertype: RunResultFormatParser

   Convert to standard format.

   :throws IOException: Signals that an I/O exception has occurred.

getRunResult
^^^^^^^^^^^^

.. java:method:: public ClusteringRunResult getRunResult()
   :outertype: RunResultFormatParser

   Gets the run result.

   :return: the run result

