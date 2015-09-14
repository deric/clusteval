.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: utils.text TextFileMapParser

.. java:import:: file FileUtils

APRunResultFormatParser
=======================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class APRunResultFormatParser extends RunResultFormatParser

   :author: Christian Wiwie

Fields
------
cluster
^^^^^^^

.. java:field:: protected Map<Integer, Set<Integer>> cluster
   :outertype: APRunResultFormatParser

idMapping
^^^^^^^^^

.. java:field:: protected Map<String, String> idMapping
   :outertype: APRunResultFormatParser

Constructors
------------
APRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APRunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: APRunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat() throws IOException
   :outertype: APRunResultFormatParser

finishProcess
^^^^^^^^^^^^^

.. java:method:: @Override public void finishProcess()
   :outertype: APRunResultFormatParser

getBurstOutput
^^^^^^^^^^^^^^

.. java:method:: @Override protected String getBurstOutput()
   :outertype: APRunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: APRunResultFormatParser

